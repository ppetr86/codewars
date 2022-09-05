package com.example.codewars3.playground.cookbook;

import java.util.Collections;
import java.util.Iterator;

public class BasicFood implements FoodItem {
    private final String name;
    private final boolean isvegan;

    public BasicFood(String name, boolean isvegan) {
        this.name = name;
        this.isvegan = isvegan;
    }

    public Iterator<FoodItem> childIterator() {
        return Collections.emptyIterator();
    }

    public boolean isVegan() {
        return isvegan;
    }

    public String name() {
        return name;
    }

    public String toString() {
        String veg = isvegan ? " (vegan)" : "";
        return name + veg;
    }
}
