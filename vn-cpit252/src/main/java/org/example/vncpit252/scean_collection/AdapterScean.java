package org.example.vncpit252.scean_collection;

public class AdapterScean implements DesignPatterns{
    private final String name;
    private final String description;
    private final String exampleCode;

    public AdapterScean(String name, String description, String exampleCode) {
        this.name = name;
        this.description = description;
        this.exampleCode = exampleCode;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getExampleCode() {
        return exampleCode;
    }
}
