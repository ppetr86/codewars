package hackerRank;

import java.util.Arrays;

public class MinimumSwaps {

  public static void main(String[] args) {
    System.out.println(minimumSwaps(new int[]{2,1}));
  }

  static int minimumSwaps(int[] arr) {
    int result = 0;

    System.out.println(Arrays.toString(arr));

    for (int i = 0; i < arr.length; i++) {
      if(arr[i] != i+1){
        swapArrElements(arr, i, arr[1]);
      }
    }
    System.out.println(Arrays.toString(arr));
    return result;
  }

  private static void swapArrElements(int[] arr, int i, int next) {
    int swap = arr[i];
    arr[i] = arr[next];
    arr[next] = swap;

  }
}
