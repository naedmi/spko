public class Command extends Bash {
    private final String name;
    private final Bash[] parameters;
    private Bash output;

    public Command(String value, Bash[] parameters, Bash output) {
        this.name = value;
        this.parameters = parameters;
        this.output = output;
    }

    public String getName() {
        return name;
    }

    public Bash[] getParameters() {
        return parameters;
    }

    public Bash getOutput() {
        return output;
    }

    public void setOutput(Bash output) {
        this.output = output;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(this.name);
        for (Bash parameter : this.parameters) {
            result.append(" ").append(parameter.toString());
        }
        if (this.output != null) {
            result.append(this.output);
        }
        return result.toString();
    }
}
