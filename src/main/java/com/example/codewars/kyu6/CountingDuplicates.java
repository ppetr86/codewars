package com.example.codewars.kyu6;

import java.util.Arrays;

//https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1/train/java
//https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1/solutions/java
public class CountingDuplicates {

    public static void main(String[] args) {
        System.out.println(duplicateCount("aA11.."));
    }

    public static int duplicateCount(String text) {
        int[] charCounter = new int[128];
        char[] textCharArr = text.toLowerCase().toCharArray();
        for (int i = 0; i < text.toCharArray().length; i++) {

            charCounter[textCharArr[i]]++;
        }

        return (int) Arrays.stream(charCounter).filter(x -> x > 1).count();
    }
}
