package com.example.codewars;

import java.util.HashMap;
import java.util.Map;

public class AlphabetWarAirstrike {

    public static void main(String[] args) {
        System.out.println(alphabetWar("qd**cs****"));
    }

    public static String alphabetWar(String fight) {
        Map<String, Integer> left = new HashMap<>();
        left.put("w", 4);
        left.put("p", 3);
        left.put("b", 2);
        left.put("s", 1);

        Map<String, Integer> right = new HashMap<>();
        right.put("m", 4);
        right.put("q", 3);
        right.put("d", 2);
        right.put("z", 1);
        int score = 0;

        if (fight.contains("*")) fight = removeAsterisk(fight);

        String[] arr = fight.split("");
        for (int i = 0; i < arr.length; i++) {
            if (left.containsKey(arr[i])) {
                score += left.get(arr[i]);
            } else if (right.containsKey(arr[i])) {
                score -= right.get(arr[i]);
            }
        }

        if (score > 0) return "Left side wins!";
        if (score < 0) return "Right side wins!";
        return "Let's fight again!";
    }

    private static String removeAsterisk(String fight) {
        //stars only
        if (fight.matches("^(.)\\1+$\n")) {
            return fight;
            // stars and other chars
        } else if (fight.startsWith("*")) {
            fight = fight.substring(2);
            return removeAsterisk(fight);
        } else if (fight.endsWith("*")) {
            fight = fight.substring(0, fight.lastIndexOf("*") - 2);
            return removeAsterisk(fight);
        } else if (fight.contains("*")) {
            fight = fight.substring(0, fight.indexOf("*") - 1) + fight.substring(fight.indexOf("*") + 1);
            return removeAsterisk(fight);
        }
        return fight;
    }

/*  private static String removeAsterisk(String fight) {
    if (fight.contains("*") && fight.indexOf("*") > 0) {
      fight = fight.substring(0, fight.indexOf("*") - 1) + fight.substring(fight.indexOf("*") + 2);
      return removeAsterisk(fight);
    } else if (fight.contains("*") && fight.endsWith("*")) {
      fight = fight.substring(0,fight.length()-1);
    } else if (fight.indexOf("*") == 0) {
      fight = fight.substring(2);
      return removeAsterisk(fight);
    }
    return fight;
  }*/
}

