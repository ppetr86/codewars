package com.example.companyTest.rdi;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Fibo {
    public static void main(String[] args) {
        fibo(100);
    }

    private static void fibo(int count) {
        List<BigInteger> fiboList = new ArrayList<>(100);
        fiboList.add(BigInteger.ZERO);
        fiboList.add(BigInteger.ONE);
        for (int i = 2; i < 100; i++) {
            fiboList.add(fiboList.get(i - 1).add(fiboList.get(i - 2)));
        }
        System.out.println(fiboList.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }
}
