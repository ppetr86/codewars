package com.example.playground.cookbook;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

public class FoodIterator implements Iterator<FoodItem> {

    private final Stack<Iterator<FoodItem>> iteratorStack = new Stack<>();

    public FoodIterator(FoodItem f) {
        Collection<FoodItem> c = Collections.singleton(f);
        iteratorStack.push(c.iterator());
    }

    public boolean hasNext() {
        return !iteratorStack.isEmpty();
    }

    public FoodItem next() {
        //peek() Looks at the object at the top of this stack without removing it from the stack.
        FoodItem food = iteratorStack.peek().next(); // return this value
        if (!iteratorStack.peek().hasNext())
            //pop() Removes the object at the top of this stack and returns that object as the value of this function.
            iteratorStack.pop();// pop the iterator when it is empty
        Iterator<FoodItem> iter = food.childIterator();
        if (iter.hasNext())
            iteratorStack.push(iter); // push the child iterator if non-empty
        return food;
    }
}
