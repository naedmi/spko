import requests

def get_feiertage():
    jahr = input('Jahr: ')
    try:
        jahr = int(jahr)
    except ValueError:
        print('Kein gültiges Jahr.')
        exit()
    url = f'https://feiertage-api.de/api/?jahr={jahr}'
    res = requests.get(url)
    if res.ok:
        bw = res.json()['BW']
        for feiertag in bw:
            #print(f'{
            print(f'{feiertag["datum"]}: {feiertag["hinweis"]}')
        # print(res.json())
    else:
        print(res.status_code)

if __name__ == '__main__':
    get_feiertage()