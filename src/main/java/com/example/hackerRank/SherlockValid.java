package com.example.hackerRank;

import java.util.Arrays;

public class SherlockValid {

    public static void main(String[] args) {
        System.out.println(isValid("aaaaabc"));
    }

    static String isValid(String s) {

        int[] letters = new int[26];
        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }

        letters = Arrays.stream(letters).filter(x -> x > 0).toArray();
        if (letters.length == 1) return "YES";
        Arrays.sort(letters);


        System.out.println(Arrays.toString(letters));

        //first == last
        if (letters[0] == letters[letters.length - 1]) return "YES";
        //first == 1 and second == last
        if (letters[0] == 1 && letters[1] == letters[letters.length - 1]) return "YES";
        //first == second && second == but last && butlast = last-1
        if (letters[0] == letters[1] && letters[1] == letters[letters.length - 2] && letters[letters.length - 2] == (letters[letters.length - 1] - 1))
            return "YES";

        return "NO";
    }
}
