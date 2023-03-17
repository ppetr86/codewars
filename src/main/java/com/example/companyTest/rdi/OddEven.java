package com.example.companyTest.rdi;

public class OddEven {
    public static void main(String[] args) {
        System.out.println(isEven(1));
        System.out.println(isEven(2));
    }

    private static boolean isEven(int input) {
        if (String.valueOf(input).endsWith("0")) return true;
        if (String.valueOf(input).endsWith("2")) return true;
        if (String.valueOf(input).endsWith("4")) return true;
        if (String.valueOf(input).endsWith("6")) return true;
        if (String.valueOf(input).endsWith("8")) return true;
        return false;
    }
}
