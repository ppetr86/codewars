package com.example.codewars3.hackerRank;

public class Caesar {

    public static void main(String[] args) {
        System.out.println(caesarCipher("middle-Outz", 2));
    }

    static String caesarCipher(String s, int k) {
        char[] charArr = s.toCharArray();

        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.toCharArray()[i];
            if (!Character.isLetter(c)) continue;
            if (Character.isLowerCase(c)) {
                cypherCharacter(charArr, true, k, c, i);
            } else {
                cypherCharacter(charArr, false, k, c, i);
            }
        }
        return new String(charArr);
    }

    private static void cypherCharacter(char[] charArr, boolean isLowercase, int rotator, char currentChar, int index) {
        char ch;
        if (isLowercase) {
            ch = (char) (((int) currentChar + rotator - 97) % 26 + 97);
        } else {
            ch = (char) (((int) currentChar + rotator - 65) % 26 + 65);
        }
        charArr[index] = ch;
    }
}
