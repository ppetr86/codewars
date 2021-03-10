package codewars.kyu5;

import java.util.Arrays;

public class MaxSubArrSum {
  public static void main(String[] args) {
    System.out.println(sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 55}));
  }

  public static int sequence(int[] arr) {
    int countPositive = (int) Arrays.stream(arr).filter(x -> x > -1).count();
    if (arr.length == 0 || countPositive == 0) return 0;
    int maxSoFar = arr[0];

    for (int i = 0; i < arr.length-1; i++) {
      for (int j = i+1; j < arr.length; j++) {
        int holder = Arrays.stream(Arrays.copyOfRange(arr,i,j+1)).sum();
        if (holder > maxSoFar) maxSoFar = holder;
      }
    }
    return maxSoFar;
  }
}
