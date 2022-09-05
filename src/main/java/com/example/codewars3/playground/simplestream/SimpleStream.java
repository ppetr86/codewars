package com.example.codewars3.playground.simplestream;


import com.example.codewars3.playground.iterator.FilterIterator;
import com.example.codewars3.playground.iterator.MapIterator;

import java.util.Iterator;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SimpleStream<T> {
    //simple stream wraps an iterator
    Iterator<T> iter;

    public SimpleStream(Iterator<T> iter) {
        this.iter = iter;
    }

    public SimpleStream<T> filter(Predicate<T> pred) {
        Iterator<T> newiter = new FilterIterator<T>(iter, pred);
        return new SimpleStream<T>(newiter);
    }

    public void forEach(Consumer<T> cons) {
        while (iter.hasNext()) {
            T t = iter.next();
            cons.accept(t);
        }
    }

    public <R> SimpleStream<R> map(Function<T, R> f) {
        Iterator<R> newiter = new MapIterator<T, R>(iter, f);
        return new SimpleStream<R>(newiter);
    }

    public T reduce(T identity, BinaryOperator<T> f) {
        T result = identity;
        while (iter.hasNext()) {
            T t = iter.next();
            result = f.apply(result, t);
        }
        return result;
    }
}