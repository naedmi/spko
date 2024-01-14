package uebung6;

import java.util.Arrays;

public class ClassProperties {
    public final String name;
    public final boolean hasInterfaces;
    public final InterfaceProperties[] interfaces;
    public final boolean hasMethods;
    public final String[] methods;

    public ClassProperties(Class<?> c) {
        this.name = c.isInterface() ? "interface " + c.getName() : "class " + c.getName();
        this.hasInterfaces = c.getInterfaces().length > 0;
        this.interfaces = Arrays.stream(c.getInterfaces()).map(InterfaceProperties::new)
                .toArray(InterfaceProperties[]::new);
        this.hasMethods = c.getMethods().length > 0;
        this.methods = Arrays.stream(c.getMethods()).map(
                m -> m.getReturnType().getName() + " " + m.getName()
                        + "(" + Arrays.toString(Arrays.stream(m.getParameterTypes()).map(Class::getName).toArray())
                        .replace("[", "")
                        .replace("]", "") + ")")
                .toArray(String[]::new);
    }
}
