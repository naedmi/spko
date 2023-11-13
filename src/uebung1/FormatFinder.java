package uebung1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatFinder {
    private static final String format_basic = "%([1-9]+\\$)?[-+#0,(\\s]?\\d*(\\.\\d)?[bBhHsScCdoxXeEfgGaA%n]";
    private static final String format_time = "%([1-9]\\d*\\$)?[-+#0,(\\s]?\\d*[tT][HIklLMSpQZzsBbhAaCYyjmdeRTrDFc]";
    private static final String format_noarg = "%[-+#0,(\\s]?\\d*\\D";
    private final String format_text = "[a-zA-Z0-9:\\s]+";

    private final Pattern pattern = Pattern.compile(format_basic + "|" + format_time + "|" + format_noarg + "|" + format_text);

    private void find(String input) {
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            if (matcher.group().startsWith("%")) {
                System.out.printf("FORMAT(\"%s\")", matcher.group());
            } else {
                System.out.printf("TEXT(\"%s\")", matcher.group());
            }
        }
    }

    public static void main(String[] args) {
        FormatFinder ff = new FormatFinder();
        ff.find("xxx %d yyy%n"); // TEXT("xxx ")FORMAT("%d")TEXT(" yyy")FORMAT("%n")
        System.out.println();
        ff.find("xxx% 012d yyy%%"); // TEXT("xxx")FORMAT("% 012d")TEXT(" yyy")FORMAT("%%")
        System.out.println();
        ff.find("xxx%1$d yyy"); // TEXT("xxx")FORMAT("%1$d")TEXT(" yyy")
        System.out.println();
        ff.find("%1$0+(32.10fyyy"); // FORMAT("%1$0+(32.10f")TEXT("yyy")
        System.out.println();
        ff.find("Wochentag: %tA Uhrzeit: %tT"); // TEXT("Wochentag: ")FORMAT("%tA")TEXT(" Uhrzeit: ")FORMAT("%tT")
    }
}