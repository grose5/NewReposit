package org.example;

public class BeginStringFilter implements IFilter{
    private final String example;

    public BeginStringFilter(String example){
        this.example = example;
    }

    public boolean apply(String string) {
        return (string != null && string.startsWith(example));
    }
}
