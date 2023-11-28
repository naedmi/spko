import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class BashToAst {
    private BashToAst() {
    }

    public static void main(String[] args) throws IOException {
        SimpleBashLexer lexer = new SimpleBashLexer(CharStreams.fromFileName("src/uebung2/simpleBash/samples_correct.txt"));
        SimpleBashParser parser = new SimpleBashParser(new CommonTokenStream(lexer));

        ParseTree tree = parser.start();
        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.err.printf("%d error(s) detected%n", parser.getNumberOfSyntaxErrors());
            System.exit(1);
        }

        Bash ast = new BashBuilder().build(tree);
        System.out.printf("Bash.toString() = \n%s%n", ast);
    }
}
