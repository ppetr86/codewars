package com.example.codewars3.entwicklerheld;

public class Feature {
    private String name;

    public Feature(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

