package org.example;

public class FilterEndsWith implements IFilter{
    private final String example;

    public FilterEndsWith(String example){
        this.example = example;
    }

    public boolean apply(String string) {
        return (string != null && string.endsWith(example));
    }
}
