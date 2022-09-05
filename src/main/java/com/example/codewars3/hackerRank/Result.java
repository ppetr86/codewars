package com.example.codewars3.hackerRank;

import java.time.LocalDate;

public class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        return date.getDayOfWeek().toString();
    }

    public static String getSmallestAndLargest(String s, int k) {

        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);

        for (int i = 0; i <= s.length() - k; i++) {
            String s1 = s.substring(i, i + k);
            if (smallest.compareTo(s1) > 0) smallest = s1;
            if (largest.compareTo(s1) < 0) largest = s1;
        }

        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        System.out.println(findDay(2, 15, 2021));
        //Scanner scanner = new Scanner(System.in);
        //String inputString = scanner.nextLine();
        //String[] arr = inputString.split(" ");
        //System.out.println(findDay(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]),Integer.parseInt(arr[2])));
        //System.out.println(getSmallestAndLargest("welcometojava", 3));
        System.out.println(anagrams("anagram", "margana"));
    }

    private static boolean anagrams(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        if (a.length() != b.length()) return false;
        StringBuilder sb = new StringBuilder(b);

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < sb.length(); j++) {
                if (a.charAt(i) == sb.charAt(j)) {
                    sb.deleteCharAt(j);
                    break;
                }
            }
        }
        return sb.length() == 0;
    }

}