package com.example.hackerRank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
public class RansomNote {

    private static final Scanner scanner = new Scanner(System.in);


    static void checkMagazine(String[] magazine, String[] note) {
        if (magazine.length < note.length) System.out.println("No");
        if (magazine.length > 30000 || note.length > 6) System.out.println("No");

        HashMap<String, Integer> magazineMap = new HashMap<>();
        HashMap<String, Integer> noteMap = new HashMap<>();

        Arrays.stream(magazine)
                .forEach(each -> {
                    if (magazineMap.containsKey(each)) magazineMap.put(each, magazineMap.get(each) + 1);
                    else magazineMap.put(each, 1);
                });

        Arrays.stream(note)
                .forEach(each -> {
                    if (noteMap.containsKey(each)) noteMap.put(each, noteMap.get(each) + 1);
                    else noteMap.put(each, 1);
                });

        magazineMap.keySet().retainAll(noteMap.keySet());

        int count = 0;

        for (Map.Entry<String, Integer> each : noteMap.entrySet()) {
            // magazine contains same key as note
            // note value of the key is higher than magazine value of the key
            if (magazineMap.containsKey(each.getKey()) && each.getValue() > magazineMap.get(each.getKey())) {
                count = 1;
                break;
            }
            // magazine map does not contain key from note map
            if (!magazineMap.containsKey(each.getKey())) {
                count = 1;
                break;
            }
        }
        System.out.println(count == 0 ? "Yes" : "No");
    }

    public static void main(String[] args) {
        checkMagazine(new String[]{"give", "me", "one", "grand", "today", "night"}, new String[]{"give", "me", "one", "grand", "today"});
    }
}
