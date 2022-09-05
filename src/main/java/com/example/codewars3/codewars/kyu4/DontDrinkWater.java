package com.example.codewars3.codewars.kyu4;
//https://www.codewars.com/kata/562e6df5cf2d3908ad00019e/train/javascript

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class DontDrinkWater {

    public static void main(String[] args) {

        Map<String, Double> map = new HashMap<>();
        map.put("H", 1.36);
        map.put("W", 1.00);
        map.put("A", 0.87);
        map.put("O", 0.80);

        String[][] arr = new String[][]{
                {"H", "H", "W", "O"},
                {"W", "W", "O", "W"},
                {"H", "H", "O", "O"}};

        String[][] arr2 = new String[][]{
                {"A", "A", "O", "H"},
                {"A", "H", "W", "O"},
                {"W", "W", "A", "W"},
                {"H", "H", "O", "O"}};

        System.out.println(Arrays.deepToString(dontDrink(arr2, map)));
    }

    private static String[][] dontDrink(String[][] arr, Map<String, Double> map) {
        String[][] result = new String[arr.length][arr[0].length];

        Queue<Density> queue = new PriorityQueue<>(Comparator.comparing(Density::getDensity));

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                String current = arr[i][j];
                queue.add(new Density(map.get(current), current));
            }
        }

        int row = 0;
        int col = 0;
        while (!queue.isEmpty()) {
            result[row][col++] = queue.poll().abbreviation;
            if (col == arr[0].length) {
                col = 0;
                row++;
            }
        }

        return result;
    }

    static class Density {
        private double density;
        private String abbreviation;

        public Density(double density, String abbreviation) {
            this.density = density;
            this.abbreviation = abbreviation;
        }

        public double getDensity() {
            return density;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Density that = (Density) o;
            return Double.compare(that.density, density) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(density);
        }
    }
}