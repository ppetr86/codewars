package com.example.codewars3.codewars;

import java.text.ParseException;

public class Indice {

    public static void main(String[] args) throws ParseException {
        System.out.println(solve("((1)23(45))(aB)", 11));
    }

    public static int solve(String str, int index) {
        String[] strings = str.split("");
        if (!strings[index].equals("(")) return -1;
        int counterOpening = 0;
        int counterClosing = 0;
        int result = -1;
        for (int i = index + 1; i < strings.length; i++) {
            if (strings[i].equals("(")) counterOpening++;
            if (counterClosing == counterOpening && strings[i].equals(")")) {
                result = i;
                break;
            }
            if (strings[i].equals(")")) counterClosing++;
        }
        return result;
    }
}