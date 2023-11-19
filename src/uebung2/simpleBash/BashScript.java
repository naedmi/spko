import java.util.ArrayList;
import java.util.List;

public class BashScript extends Bash {
    private List<Command> commands;

    public BashScript() {
        this.commands = new ArrayList<>();
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    public void addCommand(Command command) {
        this.commands.add(command);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Bash command : this.commands) {
            result.append(command.toString()).append("\n");
        }
        return result.toString();
    }
}
