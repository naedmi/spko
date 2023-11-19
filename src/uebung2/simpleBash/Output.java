public class Output extends Bash {
    private final String file;

    public Output(String file) {
        this.file = file;
    }

    public String getFile() {
        return this.file;
    }

    @Override
    public String toString() {
        return " > " + this.file;
    }
}
