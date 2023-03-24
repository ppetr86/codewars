package com.example.designpatterns.flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Flyweight3 {

    public static void main(String[] args) {
        Sentence myUserLog = new Sentence("my user log");
        myUserLog.getWord(2).capitalize = true;
        System.out.println(myUserLog);
    }

    private static class Sentence {

        private String[] words;
        private Map<Integer, WordToken> tokens = new HashMap<>();

        public Sentence(String plainText) {

            var str = plainText.intern();
            this.words = plainText.split(" ");
        }

        public WordToken getWord(int index) {
            var token = new WordToken();
            tokens.put(index, token);
            return tokens.get(index);
        }

        @Override
        public String toString() {
            ArrayList<String> ws = new ArrayList<>();

            for (int i = 0; i < words.length; i++) {
                var w = words[i];
                if (tokens.containsKey(i) && tokens.get(i).capitalize) {
                    w = w.toUpperCase();
                }
                ws.add(w);
            }
            return String.join(" ", ws);
        }

        private static class WordToken {
            public boolean capitalize;
        }

    }
}
