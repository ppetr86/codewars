package com.example.codewars3.codewars;

import java.text.ParseException;

public class RemoveParentheses {

    public static void main(String[] args) throws ParseException {
        System.out.println(removeParentheses("hello example (words(more words) here) something"));
    }
  /*public static String removeParentheses(final String str) {
    String updated = str.replaceAll("\\([^()]*\\)", "");
        if (updated.contains("(")) updated = removeParentheses(updated);
        return updated;
  }*/

    public static String removeParentheses(final String str) {
        StringBuilder sb = new StringBuilder();
        if (!str.contains(")")) return str;
        int parentCounter = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                parentCounter--;
                continue;
            }
            if (str.charAt(i) == '(') {
                parentCounter++;
                continue;
            }
            if (parentCounter == 0) sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}