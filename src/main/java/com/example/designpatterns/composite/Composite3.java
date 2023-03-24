package com.example.designpatterns.composite;

import java.util.*;

public class Composite3 {

    public static void main(String[] args) {
        var myList = new MyList(List.of(new SingleValue(10), new SingleValue(20)));
        System.out.println(myList.sum());
    }

    private static interface ValueContainer extends Iterable<Integer> {

    }

    private static class SingleValue implements ValueContainer {
        public int value;

        // please leave this constructor as-is
        public SingleValue(int value) {
            this.value = value;
        }

        @Override
        public Iterator<Integer> iterator() {
            return Collections.singleton(value).iterator();
        }
    }

    private static class ManyValues extends ArrayList<Integer> implements ValueContainer {
    }

    private static class MyList extends ArrayList<ValueContainer> {
        // please leave this constructor as-is
        public MyList(Collection<? extends ValueContainer> c) {
            super(c);
        }

        public int sum() {
            int result = 0;
            for (ValueContainer container : this) {
                for (int i : container) {
                    result += i;
                }
            }
            return result;
        }
    }
}
