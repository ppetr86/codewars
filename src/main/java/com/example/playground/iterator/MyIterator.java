package com.example.playground.iterator;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MyIterator {

    public static void main(String[] args) {
        Collection<String> c = Arrays.asList("a", "bb", "ccc", "dddd");
// Print the strings whose length is between 2 and 3
// in uppercase.
        Iterator<String> i1, i2, i3, i4;
        i1 = c.iterator();
        i2 = new FilterIterator<String>(i1, s -> s.length() > 1);
        i3 = new FilterIterator<String>(i2, s -> s.length() < 4);
        i4 = new MapIterator<String, String>(i3, String::toUpperCase);
        while (i4.hasNext()) {
            String s = i4.next();
            System.out.println(s);
        }
        // Print the maximum length of those strings.
        Iterator<String> j1, j2, j3;
        Iterator<Integer> j4;
        j1 = c.iterator();
        j2 = new FilterIterator<String>(j1, s -> s.length() > 1);
        j3 = new FilterIterator<String>(j2, s -> s.length() < 4);
        j4 = new MapIterator<String, Integer>(j3, String::length);
        int max = -1;
        while (j4.hasNext()) {
            Integer n = j4.next();
            if (n > max)
                max = n;
        }
        System.out.println("The max length is " + max);
    }
}

