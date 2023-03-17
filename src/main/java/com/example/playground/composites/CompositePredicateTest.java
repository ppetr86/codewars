package com.example.playground.composites;

import java.util.function.Predicate;

public class CompositePredicateTest {
    public static void main(String[] args) {
        Predicate<Integer> pred1 = n -> n < 20;
        Predicate<Integer> pred2 = n -> n % 2 == 0;
        Predicate<Integer> pred3 = n -> n % 3 == 0;
// First: use AndPredicate and OrPredicate objects
        Predicate<Integer> pred4 = new OrPredicate<>(pred2, pred3);
        Predicate<Integer> pred5 = new AndPredicate<>(pred1, pred4);
        printUsing(pred5);
// Second: use the 'or' and 'and' methods separately
        Predicate<Integer> pred6 = pred2.or(pred3);
        Predicate<Integer> pred7 = pred1.and(pred6);
        printUsing(pred7);
// Third: compose the 'or' and 'and' methods
        Predicate<Integer> pred8 = pred1.and(pred2.or(pred3));
        printUsing(pred8);
    }

    private static void printUsing(Predicate<Integer> p) {
        for (int i = 1; i < 100; i++)
            if (p.test(i))
                System.out.print(i + " ");
        System.out.println();
    }
}
