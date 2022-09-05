package com.example.codewars3.playground.composites;

import java.util.function.Predicate;

public class OrPredicate<T> extends CompositePredicate<T> {
    public OrPredicate(Predicate<T> p1, Predicate<T> p2) {
        super(p1, p2);
    }

    @Override
    public boolean test(T t) {
        return p1.test(t) || p2.test(t);
    }
}
