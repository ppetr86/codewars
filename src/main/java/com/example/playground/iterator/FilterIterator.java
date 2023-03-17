package com.example.playground.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

//the interface is a decorator
public class FilterIterator<T> implements Iterator<T> {
    private final Iterator<T> iter;
    private final Predicate<T> pred;
    private T nextvalue;
    private boolean found = false;

    public FilterIterator(Iterator<T> iter, Predicate<T> pred) {
        this.iter = iter;
        this.pred = pred;
    }

    @Override
    public boolean hasNext() {
        while (!found && iter.hasNext()) {
            T t = iter.next();
            if (pred.test(t)) {
                nextvalue = t;
                found = true;
            }
        }
        return found;
    }

    @Override
    public T next() {
        hasNext();// just to be safe
        if (!found)
            throw new NoSuchElementException();
        found = false;
        return nextvalue;
    }
}
