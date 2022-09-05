package com.example.codewars3.codewars.kyu4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

//https://www.codewars.com/kata/5765870e190b1472ec0022a2/train/java
//https://www.codewars.com/kata/5765870e190b1472ec0022a2/solutions/java
public class PathFinder1 {

    public static void main(String[] args) {
        String a = ".W.\n" + ".W.\n" + "...",
                b = ".W.\n" + ".W.\n" + "W..",
                c = "......\n" + "......\n" + "......\n" + "......\n" + "......\n" + "......",
                d = "......\n" + "......\n" + "......\n" + "......\n" + ".....W\n" + "....W.";

        System.out.println(pathFinder(a));
    }

    static boolean pathFinder(String maze) {

        String[] arrFromMaze = maze.split("\n");
        int arrLen = arrFromMaze.length;
        Stack<Vertex> stack = new Stack<>();
        Set<Vertex> visited = new HashSet<>();

        Vertex startingPoint = new Vertex(arrFromMaze[0].charAt(0), new int[]{0, 0}, false);
        stack.push(startingPoint);

        while (!stack.isEmpty()) {
            Vertex popped = stack.pop();

            if (visited.contains(popped)) continue;

            popped.visited = true;
            visited.add(popped);

            // find neighbours of popped
            List<Vertex> neighbours = new ArrayList<>(4);
            int i = popped.coordinates[0];
            int j = popped.coordinates[1];

            if (i == arrLen - 1 && j == arrLen - 1) return true;
            // up down left right
            if (i > 0) neighbours.add(new Vertex(arrFromMaze[i - 1].charAt(j), new int[]{i - 1, j}));
            if (i < arrLen - 1)
                neighbours.add(new Vertex(arrFromMaze[i + 1].charAt(j), new int[]{i + 1, j}));
            if (j > 0) neighbours.add(new Vertex(arrFromMaze[i].charAt(j - 1), new int[]{i, j - 1}));
            if (j < arrLen - 1)
                neighbours.add(new Vertex(arrFromMaze[i].charAt(j + 1), new int[]{i, j + 1}));

            for (Vertex neighbour : neighbours) {
                if (neighbour.walkable == '.')
                    stack.push(neighbour);
            }
        }
        System.out.println("hello");
        return false;
    }

    static class Vertex {
        char walkable;
        int[] coordinates;
        boolean visited;

        public Vertex(char walkable, int[] coordinates, boolean visited) {
            this.walkable = walkable;
            this.coordinates = coordinates;
            this.visited = visited;
        }

        public Vertex(char walkable, int[] coordinates) {
            this.walkable = walkable;
            this.coordinates = coordinates;
            this.visited = false;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return Objects.equals(walkable, vertex.walkable) && Arrays.equals(coordinates, vertex.coordinates);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(walkable);
            result = 31 * result + Arrays.hashCode(coordinates);
            return result;
        }
    }

}