package com.chocksaway.domain;

/**
 * Author milesd on 28/04/2019.
 */
public class Name {
    private String name;

    protected Name() {}

    public Name(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    /**
     * Used for JSon return message from endpoint
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append("\"hello\": ");
        builder.append("\"");
        builder.append(name);
        builder.append("\"");
        builder.append("}");
        return builder.toString();
    }
}

