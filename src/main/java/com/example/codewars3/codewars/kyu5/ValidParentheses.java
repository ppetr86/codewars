package com.example.codewars3.codewars.kyu5;

//https://www.codewars.com/kata/52774a314c2333f0a7000688/train/java
//https://www.codewars.com/kata/52774a314c2333f0a7000688/solutions/java

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(validParentheses(")((t(8)))](Oy][418F"));
    }

    public static boolean validParentheses(String parens) {
        Stack<String> stack = new Stack<>();
        parens = parens.replaceAll("[^()]", "");
        if (parens.length() == 0) return true;
        if (parens.length() == 1 || parens.startsWith(")")) return false;

        stack.push(parens.substring(0, 1));

        for (int i = 1; i < parens.length(); i++) {
            String current = parens.substring(i, i + 1);
            String reverseCurrent = "";
            if (stack.size() == 0) {
                stack.push(current);
                continue;
            }
            if (stack.size() == 1 && stack.get(0).equals(")")) return false;
            if (current.equals(")")) reverseCurrent = "(";
            if (current.equals("(")) reverseCurrent = ")";
            if (stack.contains(reverseCurrent)) stack.remove(reverseCurrent);
            else stack.push(current);
        }
        return stack.size() == 0;
    }

  /*public static boolean validParentheses(String str) {

    int count = 0;

    for(int i = 0; i < str.length(); i++) {

      if(str.charAt(i) == '(') count++;
      else if(str.charAt(i) == ')') count--;
      if(count < 0) return false;
    }
    if(count == 0) return true;
    else return false;
  }*/

  /*public static boolean validParentheses(String parens) {
    Stack<Character> stack = new Stack<>();
    for (char ch : new StringBuilder(parens).reverse().toString().toCharArray()) {
      if (ch == ')') stack.push(ch);
      if (ch == '(') {
        if (!stack.isEmpty() && stack.peek() == ')') {
          stack.pop();
        } else {
          stack.push(ch);
        }
      }
    }

    return stack.isEmpty();
  }*/
}
