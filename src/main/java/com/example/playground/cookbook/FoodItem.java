package com.example.playground.cookbook;

import java.util.Iterator;

public interface FoodItem extends Iterable<FoodItem> {
    Iterator<FoodItem> childIterator();


    boolean isVegan();


    default Iterator<FoodItem> iterator() {
        return new FoodIterator(this);
    }


    String name();
}
