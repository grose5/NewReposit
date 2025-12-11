package org.example;

public class IncludeStringFilter implements IFilter{
    private final String example;

    public IncludeStringFilter(String example){
        this.example = example;
    }

    public boolean apply(String string) {
        return (string != null && string.contains(example));
    }
}
