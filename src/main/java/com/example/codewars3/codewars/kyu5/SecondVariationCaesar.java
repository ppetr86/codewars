package com.example.codewars3.codewars.kyu5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.codewars.com/kata/55084d3898b323f0aa000546/train/java
public class SecondVariationCaesar {

    public static void main(String[] args) {
        String u = "I should have known that you would have a perfect answer for me!!!";
        List<String> v = Arrays.asList("ijJ tipvme ibw", "f lopxo uibu z", "pv xpvme ibwf ", "b qfsgfdu botx", "fs gps nf!!!");
        String u2 = "O CAPTAIN! my Captain! our fearful trip is done;";
        List<String> v2 = Arrays.asList("opP DBQUBJ", "O! nz Dbqu", "bjo! pvs g", "fbsgvm usj", "q jt epof;");
        System.out.println(encodeStr(u, 1));
    }

    public static List<String> encodeStr(String s, int shift) {

        StringBuilder addInList = hashString(s, shift);
        List<String> result = splitHashed(addInList);
        System.out.println(addInList.toString().length());
        System.out.println(addInList.toString());

        return result;
    }

    private static List<String> splitHashed(StringBuilder addInList) {
        List<String> result = new ArrayList<>();
        int divideBy5 = 0;
        int startIndex = 0;
        int endIndex = 0;

        if (addInList.length() % 5 == 0) {
            divideBy5 = addInList.length() / 5;
            endIndex = addInList.length() / 5;
        } else {

        }

        for (int i = 0; i < 5; i++) {
            result.add(i, addInList.substring(startIndex, endIndex));
            startIndex += divideBy5;
            endIndex += divideBy5;
        }
        return result;
    }

    private static StringBuilder hashString(String s, int shift) {
        StringBuilder hash = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = shiftChar(s.charAt(i), shift);
            if (i == 0) {
                hash.append(s.substring(0, 1).toLowerCase()).append(String.valueOf(c).toLowerCase()).append(c);
            } else {
                hash.append(c);
            }
        }
        return hash;
    }


    private static char shiftChar(char alphabet, int shift) {

        if (!String.valueOf(alphabet).matches("[A-Za-z]"))
            return alphabet;
        if (alphabet >= 'a' && alphabet <= 'z') {
            alphabet = (char) (alphabet + shift);
            if (alphabet > 'z') {
                alphabet = (char) (alphabet + 'a' - 'z' - 1);
            }
            return alphabet;
        } else if (alphabet >= 'A' && alphabet <= 'Z') {
            alphabet = (char) (alphabet + shift);
            if (alphabet > 'Z') {
                alphabet = (char) (alphabet + 'A' - 'Z' - 1);
            }
            return alphabet;
        }
        return alphabet;
    }

    public static String decode(List<String> s) {
        // your code
        return "";
    }
}
