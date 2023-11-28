import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.Stack;
import java.util.regex.Pattern;

public class BashBuilder extends SimpleBashParserBaseListener {
    private final Stack<Bash> stack = new Stack<>();
    private final boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");

    public Bash build(ParseTree tree) {
        new ParseTreeWalker().walk(this, tree);
        return this.stack.pop();
    }

    @Override
    public void exitStart(SimpleBashParser.StartContext ctx) {
        BashScript script = new BashScript();
        while (!this.stack.isEmpty()) {
            script.addCommand((Command) this.stack.pop());
        }
        this.stack.push(script);
    }

    @Override
    public void exitCompleteCommand(SimpleBashParser.CompleteCommandContext ctx) {
        Command command = (Command) this.stack.pop();
        if (ctx.FILENAME() != null) {
            verifyPath(ctx.FILENAME().getText());
            command.setOutput(new Output(ctx.FILENAME().getText()));
            this.stack.push(command);
        } else {
            this.stack.push(command);
        }
    }

    @Override
    public void exitCommandName(SimpleBashParser.CommandNameContext ctx) {
        if (ctx.getChildCount() > 1) {
            Parameter[] parameters = new Parameter[ctx.getChildCount() - 1];
            for (int i = 1; i < ctx.getChildCount(); i++) {
                parameters[i - 1] = new Parameter(ctx.getChild(i).getText());
            }
            this.stack.push(new Command(ctx.getChild(0).getText(), parameters, null));
        } else {
            this.stack.push(new Command(ctx.getChild(0).getText(), new Parameter[0], null));
        }

    }

    private void verifyPath(String filename) {
        // check drive letter
        if (filename.contains(":")) {
            Pattern pattern = Pattern.compile("[a-zA-Z]:\\\\.*");
            if (!pattern.matcher(filename).matches() || !isWindows) {
                System.err.printf("Invalid drive letter: %s%n", filename);
                System.exit(1);
            }
        }
        // check path separator
        if (filename.contains("/") && isWindows || filename.contains("\\") && !isWindows) {
            System.err.printf("Invalid path separator: %s%n", filename);
            System.exit(1);
        }
    }

}