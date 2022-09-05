package com.example.codewars3.codewars;

//https://www.codewars.com/kata/55a5c82cd8e9baa49000004c/train/java
public class DivisibleCount {

    public static void main(String[] args) {
        System.out.println(divisibleCount(6, 20, 2));
    }

    public static long divisibleCount(long x, long y, long k) {
        if (x % k == 0)
            return (y / k) - (x / k) + 1;

        return (y / k) - (x / k);
    }
}