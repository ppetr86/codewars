package com.example.codewars.kyu5;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ResistorsColorCodes {

    public static void main(String[] args) {
        System.out.println(encodeResistorColors("1k ohms"));
    }

    public static String encodeResistorColors(String ohmsString) {
        Map<Integer, String> colors = new HashMap<>();
        colors.put(0, "black");
        colors.put(1, "brown");
        colors.put(2, "red");
        colors.put(3, "orange");
        colors.put(4, "yellow");
        colors.put(5, "green");
        colors.put(6, "blue");
        colors.put(7, "violet");
        colors.put(8, "gray");
        colors.put(9, "white");

        Map<String, Integer> letters = new HashMap<>();
        letters.put("k", 3);
        letters.put("M", 6);

        ohmsString = ohmsString.substring(0, ohmsString.indexOf(" "));
        System.out.println(ohmsString);
        String result = "";
        //not a digit at the end
        if (!Character.isDigit(ohmsString.charAt(ohmsString.length() - 1))) {
            if (ohmsString.endsWith("k")) {
                ohmsString = ohmsString + "000";
            } else {
                ohmsString = ohmsString + "000000";
            }

            result = ohmsString.substring(0, ohmsString.length() - 1).chars().mapToObj(c -> colors.get(Character.getNumericValue(c))).collect(Collectors.joining(" "));

        } else {
            if (Integer.parseInt(ohmsString) < 100) {
                result = ohmsString.chars().mapToObj(c -> colors.get(Character.getNumericValue(c))).collect(Collectors.joining(" ")) + " black";
            } else {
                result = ohmsString.substring(0, 2).chars().mapToObj(c -> colors.get(Character.getNumericValue(c))).collect(Collectors.joining(" ")) + " brown";
            }
        }
        return result + " gold";
    }
}
