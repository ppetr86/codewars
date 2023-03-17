package com.example.playground.composites;

import java.util.function.Predicate;

public class AndPredicate<T> extends CompositePredicate<T> {
    public AndPredicate(Predicate<T> p1, Predicate<T> p2) {
        super(p1, p2);
    }

    @Override
    public boolean test(T t) {
        return p1.test(t) && p2.test(t);
    }
}
