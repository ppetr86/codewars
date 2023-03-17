package com.example.hackerRank;

import java.util.HashMap;
import java.util.Map;

public class IceCream {

    public static void main(String[] args) {
        whatFlavors(new int[]{1, 4, 5, 3, 2}, 4);
    }

  /*static void whatFlavors(int[] cost, int money) {
    int first = -1, second = -1;

    for (int i = 0; i < cost.length - 1; i++) {
      if (cost[i] <= money){
        for (int j = i + 1; j < cost.length; j++) {
          if (i==j) continue;
          if (cost[i] + cost[j] == money) {
            first = i + 1;
            second = j + 1;
            break;
          }
        }
        if (first>-1 || second>-1) break;
      }
    }

    System.out.println(first + " " + second);
  }*/

    static void whatFlavors(int[] cost, int money) {
        int result[] = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cost.length; i++) {
            int x = cost[i];
            int y = money - x;
            Integer j = map.get(y);
            if (j != null) {
                result[0] = j + 1;
                result[1] = i + 1;
                break;
            }
            map.put(x, i);
        }
        System.out.println(result[0] + " " + result[1]);
    }
}