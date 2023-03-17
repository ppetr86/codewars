package com.example.codewars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrizeDraw {
    public static String nthRank(String st, Integer[] we, int n) {
        if (st.isEmpty()) return "No participants";

        String[] originalTableOfNames = st.split(",");
        String[] tableOfNames = st.split(",");

        if (n > originalTableOfNames.length || n > we.length) return "Not enough participants";
        if (!st.contains(",")) return st;

        HashMap<String, Integer> lettersValues = assignValuesToLetters();
        List<WeightsAndNames> listOfWeightsAndNames = new ArrayList<>();

        calculateWordWeight(we, tableOfNames, lettersValues, listOfWeightsAndNames);
        sortTheListOfNames(listOfWeightsAndNames);
        return determineAWinner(n, originalTableOfNames, tableOfNames, listOfWeightsAndNames);
    }

    private static HashMap<String, Integer> assignValuesToLetters() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        HashMap<String, Integer> lettersValues = new HashMap<>();
        for (int i = 0; i < alphabet.length(); i++) {
            lettersValues.put(alphabet.substring(i, (i + 1)), (i + 1));
        }
        return lettersValues;
    }

    private static void calculateWordWeight(Integer[] we, String[] tableOfNames, HashMap<String, Integer> lettersValues, List<WeightsAndNames> listOfWeightsAndNames) {
        for (int i = 0; i < tableOfNames.length; i++) {
            int wordWeigth = tableOfNames[i].length();
            for (int j = 0; j < tableOfNames[i].length(); j++) {
                wordWeigth += lettersValues.get(tableOfNames[i].substring(j, (j + 1)));
            }
            wordWeigth *= we[i];
            listOfWeightsAndNames.add(new WeightsAndNames(tableOfNames[i], wordWeigth));
        }
    }

    private static void sortTheListOfNames(List<WeightsAndNames> listOfWeightsAndNames) {
        listOfWeightsAndNames.sort((o1, o2) -> {
            if (o1.weight != o2.weight) {
                return o2.weight - o1.weight;
            } else {
                return o1.name.compareTo(o2.name);
            }
        });
    }

    private static String determineAWinner(int n, String[] originalTableOfNames, String[] tableOfNames, List<WeightsAndNames> listOfWeightsAndNames) {
        String winner = listOfWeightsAndNames.get(n - 1).name;
        for (int i = 0; i < tableOfNames.length; i++) {
            if (winner.equals(tableOfNames[i])) {
                winner = originalTableOfNames[i];
            }
        }
        return winner;
    }

    public static class WeightsAndNames {
        private String name;
        private int weight;

        public WeightsAndNames(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WeightsAndNames that = (WeightsAndNames) o;

            if (weight != that.weight) return false;
            return name != null ? name.equals(that.name) : that.name == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + weight;
            return result;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer(name);
            return sb.toString();
        }
    }
}