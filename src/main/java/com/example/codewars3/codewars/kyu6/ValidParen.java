package com.example.codewars3.codewars.kyu6;

import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ValidParen {

    public static void main(String[] args) {
        System.out.println(validParentheses("c}(main.java.C(F)M(4f8Zs)-CX)"));
        System.out.println(validParenthesesV2("c}(main.java.C(F)M(4f8Zs)-CX)"));
        System.out.println(validParenthesesV3("c}(main.java.C(F)M(4f8Zs)-CX)"));
    }

    public static boolean validParenthesesV3(String parens) {
        if (parens.length() > 100) return false;
        return replaceRecursion(parens.replaceAll("[^()]", "")).isEmpty();
    }

    private static String replaceRecursion(String result) {
        if (!result.contains("()")) return result;
        return replaceRecursion(result.replaceAll(Pattern.quote("()"), ""));
    }

    public static boolean validParenthesesV2(String parens) {
        Stack<String> myStack = new Stack<>();

        Arrays.stream(parens.split("")).forEach(letter -> {
            if (letter.equals("("))
                myStack.push(letter);
            if (!myStack.isEmpty() && letter.equals(")"))
                myStack.pop();
        });
        return myStack.isEmpty();
    }

    public static boolean validParentheses(String parens) {
        if (parens.length() > 100) return false;
        String result = Arrays.stream(parens.split(""))
                .filter(each -> each.equals("(") || each.equals(")"))
                .collect(Collectors.joining(""));
        result = replaceRecursion(result);
        return result.isEmpty();
    }


}