package com.example.codewars3.codewars.kyu5;/*
package codewars.kyu5;

import java.util.ArrayList;
import java.util.MyArrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ClosesWeight {

  public static void main(String[] args) {
    System.out.println(MyArrays.deepToString(closest("456899 50 11992 176 272293 163 389128 96 290193 85 52")));
  }

  private static int[][] closest(String strng) {

    if (strng.isEmpty() || strng.isBlank()) return new int[0][0];
    List<String> strList = MyArrays.stream(strng.split(" ")).collect(Collectors.toList());
    List<Integer> intList = MyArrays.stream(strng.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    List<Integer> weights = new ArrayList<>();

    for (int i = 0; i < strList.size(); i++) {
      char[] charArr = strList.get(i).toCharArray();
      int toIntList = 0;
      for (int j = 0; j < charArr.length; j++) {
        toIntList += Integer.parseInt(String.valueOf(charArr[j]));
      }
      weights.add(toIntList);
    }

    List<Integer> sortedWeights = weights.stream().sorted().collect(Collectors.toList());
    int smallestWeightDiff = Integer.MAX_VALUE;
    for (int i = 0; i < sortedWeights.size()-1; i++) {
      int current = sortedWeights.get(i);
      int next = sortedWeights.get(i+1);
     if (next - current < smallestWeightDiff) smallestWeightDiff = next - current;
    }

    List<Integer> weightsAssociatedWithSmallestDiff = new ArrayList<>();
    for (int i = 0; i < sortedWeights.size()-1; i++) {
      if (sortedWeights.get(i+1) - sortedWeights.get(i) == smallestWeightDiff)
        weightsAssociatedWithSmallestDiff.add(sortedWeights)
    }


    System.out.println("input " + strList);
    System.out.println("weights "+weights);
    System.out.println("sortedweights " + sortedWeights);
    System.out.println("smallestWeightDiff " + smallestWeightDiff);
    return new int[][]{{}};
  }

  public static class ArrayObj{

  }
}
*/
