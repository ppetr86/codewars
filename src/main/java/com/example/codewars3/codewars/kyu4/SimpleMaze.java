package com.example.codewars3.codewars.kyu4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class SimpleMaze {

    static class Coordinate {

        int row;
        int col;
        Set<Coordinate> neighbours = new HashSet<>();
        boolean isKate;
        boolean isExit;

        public Coordinate(int row, int col, boolean isKate, boolean isExit, Set<Coordinate> addToNeighbours) {
            this.row = row;
            this.col = col;
            neighbours.addAll(addToNeighbours);
            this.isKate = isKate;
            this.isExit = isExit;
        }

        public Coordinate(int i, int j, boolean isKate, boolean exit) {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return row == that.row && col == that.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        @Override
        public String toString() {
            return "Row " + row + ". Col " + col + " isKate: " + isKate + " isExit: " + isExit + "\n";
        }
    }

    static class CoordinateComparator implements Comparator<Coordinate> {
        int row;
        int col;

        public int compare(Coordinate c1, Coordinate c2) {
            double maxDist1 = locationDistanceToXY(c1, this.row, this.col);
            double maxDist2 = locationDistanceToXY(c2, this.row, this.col);

            if (maxDist1 > maxDist2) {
                return 1;
            } else if (maxDist1 < maxDist2) {
                return -1;
            }
            return 0;
        }

        private int locationDistanceToXY(Coordinate c, int row, int col) {
            return Math.abs(c.col - col) + Math.abs(c.row - row);
        }
    }

    public static void main(String[] args) {

        String[] arr1 = new String[]{"k"};
        String[] arr2 = new String[]{
                "###",
                "#k#",
                "###"};
        String[] arr3 = new String[]{
                "###",
                "#k ",
                "###"};
        String[] arr4 = new String[]{
                "k ",
                "kk"};
        String[] arr5 = new String[]{
                //"########",
                "# # ####",
                "# #k#   ",
                "# # # ##",
                "# # # ##",
                "#      #",
                "########"};
        String[] arr6 = new String[]{
                "########",
                "# # ## #",
                "# #k#  #",
                "# # # ##",
                "# # #  #",
                "#     ##",
                "########"};

        System.out.println(hasExit(arr5));
    }

    public static boolean hasExit(String[] maze) {
        List<Coordinate> walkables = new ArrayList<>();
        int kateCount = 0;
        int kateIndex = -1;
        Coordinate kate = null;

        for (int i = 0; i < maze.length; i++) {
            String row = maze[i];
            String[] inRow = row.split("");

            for (int j = 0; j < inRow.length; j++) {
                if (inRow[j].equals(" ") || inRow[j].equals("k")) {
                    if (kate == null) kateIndex++;


                    if (inRow[j].equals("k")) {
                        kateCount++;

                        kate = new Coordinate(i, j, true, isExit(inRow, maze, i, j));
                        if (kateCount > 1) return false;
                        continue;
                    }
                    walkables.add(new Coordinate(i, j, false, isExit(inRow, maze, i, j)));
                }
            }
        }

        if (kate == null || walkables.isEmpty())
            return false;


        Set<Coordinate> neighours = new HashSet<>();
        walkables.forEach(walkable -> walkable.neighbours.addAll(findNeighbours(walkable, walkables)));

        Set<Coordinate> exits = walkables.stream().filter(coord -> coord.isExit).collect(Collectors.toSet());

        System.out.println(kateIndex);
        System.out.println(walkables);

        Coordinate finalKate = kate;

        return exits.stream().anyMatch(exit -> isKateReachable(exit, finalKate, walkables));
    }

    private static Set<Coordinate> findNeighbours(Coordinate walkable, List<Coordinate> walkables) {
        Set<Coordinate> neighbours = new HashSet<>();
        Coordinate c1, c2, c3, c4;
   /* c1 = new Coordinate();
    c2 = new Coordinate();
    c3 = new Coordinate();
    c4= new Coordinate();*/

        return neighbours;
    }

    private static boolean isKateReachable(Coordinate exit, Coordinate kate, List<Coordinate> walkables) {
        return false;
    }

    private static boolean isExit(String[] inRow, String[] maze, int i, int j) {
        return j == inRow.length - 1 || i == 0 || i == maze.length - 1 || j == 0;
    }

}
