package com.example.hackerRank;

public class BiggerIsGreater {
    public static void main(String[] args) {
        System.out.println(biggerIsGreater("fedcbabcd"));
    }

    static String biggerIsGreater(String w) {
        if (w.length() == 2 && w.charAt(0) != w.charAt(1)) {
            StringBuilder sb = new StringBuilder(w).reverse();
            return sb.toString();
        }
        if (w.length() == 2 && w.charAt(0) == w.charAt(1)) {
            return "no answer";
        }

        char swap1 = ' ';
        char swap2 = ' ';
        char[] sorted = w.toCharArray();
        for (int i = sorted.length - 1; i > 0; i--) {
            if (sorted[i] > sorted[i - 1] + 1) {
                swap1 = sorted[i];
                swap2 = sorted[i - 1];
                sorted[i] = swap2;
                sorted[i - 1] = swap1;
                break;
            }
        }
        return String.valueOf(sorted);
    }
}
