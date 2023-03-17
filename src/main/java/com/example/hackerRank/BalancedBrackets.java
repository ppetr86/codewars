package com.example.hackerRank;

import java.util.Deque;
import java.util.LinkedList;

public class BalancedBrackets {

    public static void main(String[] args) {
        System.out.println(isBalanced("{{[[(())]]}}"));
    }

  /*static String isBalanced(String s) {
    if (null == s || ((s.length() % 2) != 0)) {
      return "NO";
    } else {
      char[] ch = s.toCharArray();
      for (char c : ch) {
        if (!(c == '{' || c == '[' || c == '(' || c == '}' || c == ']' || c == ')')) {
          return "NO";
        }
      }
    }
    while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
      s = s.replaceAll("\\(\\)", "")
              .replaceAll("\\[\\]", "")
              .replaceAll("\\{\\}", "");
    }
    return s.length() == 0 ? "YES" : "NO";
  }*/

    static String isBalanced(String s) {
        //Double end queue support removal and insertion at both ends
        Deque<Character> deque = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                deque.addFirst(ch);
            } else {
                if (!deque.isEmpty()
                        && ((deque.peekFirst() == '{' && ch == '}')
                        || (deque.peekFirst() == '[' && ch == ']')
                        || (deque.peekFirst() == '(' && ch == ')'))) {
                    deque.removeFirst();
                } else {
                    return "NO";
                }
            }
        }
        return "YES";
    }
}
