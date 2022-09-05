package com.example.codewars3.hackerRank;

import java.math.BigInteger;

public class ExtraLongFactorial {
    public static void main(String[] args) {
        extraLongFactorials(25);
    }

    static void extraLongFactorials(int n) {
        BigInteger result = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {

            result = result.multiply(BigInteger.valueOf(i));
        }
        System.out.println(result);
    }
}
