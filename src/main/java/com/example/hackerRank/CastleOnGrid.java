package com.example.hackerRank;/*
package hackerRank;

import java.util.*;

public class CastleOnGrid {
  public static void main(String[] args) {
    String[] input = new String[]
            {"...",
                    ".X.",
                    ".X."};
    System.out.println(minimumMoves(input, 2, 0, 0, 2));
  }

  static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
    // walkable = 0, notwalkable = 1, start = 2, end = 3
    int[][] maze = new int[grid[0].length()][grid.length];
    populateMaze(maze, grid, startX, startY, goalX, goalY);
    int result = 0;
    Queue<MyNode> queue = new PriorityQueue<>();
    queue.add(new MyNode(startX, startY));

    while (!queue.isEmpty()) {
      MyNode current = queue.poll();
      current.visited = true;
      while (true) {
        //add all "neighbours" to Q
        List<MyNode> neighbours = addNeighbours(maze,current);
      }


    }


    for (int i = 0; i < maze.length; i++) {
      System.out.println(MyArrays.toString(maze[i]));
    }
    return result;
  }

  private static List<MyNode> addNeighbours(int[][] maze, MyNode current) {
    List<MyNode> result = new ArrayList<>();
    //add all up
    Collection<MyNode> add =
    result.addAll()
  }

  private static void populateMaze(int[][] maze, String[] grid, int startX, int startY, int goalX, int goalY) {
    for (int i = 0; i < maze.length; i++) {
      for (int j = 0; j < maze[i].length; j++) {
        if (i == startY && j == startX) {
          maze[i][j] = 2;
          continue;
        }
        if (i == goalY && j == goalX) {
          maze[i][j] = 3;
          continue;
        }
        if (grid[i].charAt(j) == 'X') {
          maze[i][j] = 1;
        }
      }
    }
  }

  static class MyNode {
    public int x;
    public int y;
    public MyNode previous;
    public boolean visited;

    public MyNode(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}*/
