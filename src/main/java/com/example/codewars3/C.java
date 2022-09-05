package com.example.codewars3;

import java.util.Arrays;

public class C {

    public static boolean isTwin(String a, String b) {
        if (a == null || b == null || a.length() != b.length())
            return false;

        final char[] charsFromA = a.toLowerCase().toCharArray();
        final char[] charsFromB = b.toLowerCase().toCharArray();
        Arrays.sort(charsFromA);
        Arrays.sort(charsFromB);

        for (int i = 0; i < charsFromA.length; i++) {
            if (charsFromA[i] != charsFromB[i])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isTwin("Silent", "Listen"));
        System.out.println(isTwin("madam", "madar"));

        System.out.println(isTwin("Hello", "world")); // false
        System.out.println(isTwin("acb", "bca")); // true
        System.out.println(isTwin("Lookout", "Outlook")); // true
    }
}
