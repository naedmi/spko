// HtmlNotenspiegel.java
package uebung6;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

import java.util.Arrays;

public final class HtmlAufgabe6 {
    private HtmlAufgabe6() { }

    public static void main(String[] args) throws Exception {
        Class<?>[] classes = new Class[] {
            Class.forName("java.lang.String"),
            Class.forName("java.util.Iterator"),
            Class.forName("java.time.Month")
        };

        String filename = "C:\\repos\\spko\\src\\uebung6\\aufgabe6.stg";
        ST templ = new STGroupFile(filename).getInstanceOf("overview");
        templ.add("c", Arrays.stream(classes).map(ClassProperties::new).toArray(ClassProperties[]::new));
        String result = templ.render();
        System.out.println(result);
    }
}

