package uebung6;

import java.util.Arrays;

public class InterfaceProperties {
    public final String name;
    public boolean hasMethods;
    public final String[] methods;

    public InterfaceProperties(Class<?> c) {
        this.name = c.getName();
        this.hasMethods = c.getMethods().length > 0;
        this.methods = Arrays.stream(c.getMethods()).map(
                m -> m.getReturnType().getName() + " " + m.getName()
                        + "(" + Arrays.toString(Arrays.stream(m.getParameterTypes()).map(Class::getName).toArray())
                        .replace("[", "")
                        .replace("]", "") + ")")
                .toArray(String[]::new);
    }
}
