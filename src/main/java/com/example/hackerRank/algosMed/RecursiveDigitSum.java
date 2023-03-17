package com.example.hackerRank.algosMed;

public class RecursiveDigitSum {

    public static void main(String[] args) {
        System.out.println(superDigit("9875", 4));
        System.out.println(superDigitV2("9875", 4));
    }

    // simple digit sum
    static int superDigit(String n, int k) {

        if (n.length() == 0) return 0;
        return Integer.parseInt(n.substring(0, 1)) * k + superDigit(n.substring(1), k);
    }

    static int superDigitV2(String number, int k) {
        if (number.length() > 1) {
            long sum = 0;
            for (int i = 0; i < number.length(); i++) {
                sum += Character.getNumericValue(number.charAt(i));
            }
            return superDigitV2(Long.toString(sum * k), 1);
        } else
            return Character.getNumericValue(number.charAt(0));
    }
}