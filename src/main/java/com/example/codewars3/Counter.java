package com.example.codewars3;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Counter {


    //averageWordLength('The average length of these words is 4.25');
    //Create a function that takes a string(text) and tells the average length of words in it. Words are separated by spaces.
    //
    //Example case:
    //
    //averageWordLength('The average length of these words is 4.25');
    //Should return 4.25


    public static void main(String[] args) {
        System.out.println(averageWordLength("The average length of these words is 4.25"));
    }

    private static double averageWordLength(String input) {
        String[] words = input.split(" ");

        long sumOfLengths = Arrays.stream(words).mapToLong(String::length).sum();

        return (double) sumOfLengths / words.length;
    }

    private static double averageWordLengthV2(String input) {
        return Arrays.stream(input.split(" ")).collect(Collectors.summarizingDouble(String::length)).getAverage();
    }

}
