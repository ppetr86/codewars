package com.example.codewars.kyu4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

//https://www.codewars.com/kata/57658bfa28ed87ecfa00058a/train/java

public class PathFinder2 {

    public static void main(String[] args) {
        String a = ".....\n" + ".....\n" + ".....\n" + ".....\n" + ".....\n",
                b = ".W.\n" + ".W.\n" + "W..",
                c = "......\n" + "......\n" + "......\n" + "......\n" + "......\n" + "......",
                d = "......\n" + "......\n" + "......\n" + "......\n" + ".....W\n" + "....W.";

        System.out.println(pathFinder(a));
    }

    static int pathFinder(String maze) {

        String[] arrFromMaze = maze.split("\n");
        int arrLen = arrFromMaze.length;

        Map<Vertex, List<Vertex>> graph = createGraph(arrFromMaze, arrLen);

        Stack<Vertex> stack = new Stack<>();
        Set<Vertex> visited = new HashSet<>();

        Vertex startingPoint = graph.keySet().stream().findFirst().get();
        stack.push(startingPoint);


        while (!stack.isEmpty()) {
            Vertex popped = stack.pop();
            List<Vertex> neighbours = graph.get(popped);

            neighbours.forEach(each -> {
                int distance = graph.get(each).stream().filter(walk -> walk.walkable == '.').map(cur -> cur.distance).max(Comparator.naturalOrder()).get();
                each.distance = distance;
            });

            graph.put(popped, neighbours);

            if (popped.coordinates[0] == arrLen && popped.coordinates[1] == arrLen) return popped.distance + 1;

        }

        return -1;
    }

    private static Map<Vertex, List<Vertex>> createGraph(String[] arrFromMaze, int arrLen) {
        Map<Vertex, List<Vertex>> graph = new HashMap<>();
        for (int i = 0; i < arrLen; i++) {
            for (int j = 0; j < arrLen; j++) {

                Vertex current = new Vertex(arrFromMaze[i].charAt(j), new int[]{i, j});
                List<Vertex> neighbours = new ArrayList<>();

                if (i > 0) {
                    Vertex up = new Vertex(arrFromMaze[i - 1].charAt(j), new int[]{i - 1, j});
                    neighbours.add(up);
                }
                if (i < arrLen - 1) {
                    Vertex down = new Vertex(arrFromMaze[i + 1].charAt(j), new int[]{i + 1, j});
                    neighbours.add(down);
                }
                if (j > 0) {
                    Vertex left = new Vertex(arrFromMaze[i].charAt(j - 1), new int[]{i, j - 1});
                    neighbours.add(left);
                }
                if (j < arrLen - 1) {
                    Vertex right = new Vertex(arrFromMaze[i].charAt(j + 1), new int[]{i, j + 1});
                    neighbours.add(right);
                }

                if (i == 0 && j == 0) current.distance = 0;

                graph.put(current, neighbours);

            }
        }

        return graph;
    }


    static class Vertex {
        char walkable;
        int[] coordinates;
        boolean visited;
        int distance;


        public Vertex(char walkable, int[] coordinates, boolean visited, int distance) {
            this.walkable = walkable;
            this.coordinates = coordinates;
            this.visited = visited;
            this.distance = distance;
        }

        public Vertex(char walkable, int[] coordinates, int distance) {
            this.walkable = walkable;
            this.coordinates = coordinates;
            this.distance = distance;
        }

        public Vertex(int[] ints) {
            this.coordinates = ints;
            this.distance = 0;
        }

        public Vertex(char charAt, int[] ints) {
            this.walkable = charAt;
            this.coordinates = ints;
            this.distance = Integer.MAX_VALUE;
            this.visited = false;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return Arrays.equals(coordinates, vertex.coordinates);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(coordinates);
        }
    }

}