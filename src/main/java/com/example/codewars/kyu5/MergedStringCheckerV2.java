package com.example.codewars.kyu5;

//https://www.codewars.com/kata/54c9fcad28ec4c6e680011aa/train/java
//https://www.codewars.com/kata/54c9fcad28ec4c6e680011aa/solutions/java
public class MergedStringCheckerV2 {

    public static void main(String[] args) {
        System.out.println(
                isMerge("Can we merge it? Yes, we can!", "Cne mret? Ys n!", "a weg ie, weca"));
    }

    public static boolean isMerge(String s, String part1, String part2) {

        if (s.equals("")) {
            return part1.equals("") && part2.equals("");
        } else {
            boolean b1 = false, b2 = false;
            if (part1.length() > 0 && s.charAt(0) == part1.charAt(0)) {
                b1 = isMerge(s.substring(1), part1.substring(1), part2);
            }
            if (part2.length() > 0 && s.charAt(0) == part2.charAt(0)) {
                b2 = isMerge(s.substring(1), part1, part2.substring(1));
            }

            return b1 || b2;
        }
    }

}
