package hackerRank;

import java.util.Arrays;

public class NewYearChaos {

  public static void main(String[] args) {
    minimumBribes(new int[]{5, 1, 2, 3, 7, 8, 6, 4});
  }

  static void minimumBribes(int[] arr) {

    int skipped = 0;
    boolean tooChaotic = false;
    int[] sorted = arr;
    Arrays.sort(sorted);
    for (int i = 0; i < arr.length; i++) {
      if (Math.abs(arr[i] - sorted[i]) > 2) {
        skipped = Math.abs(arr[i] - sorted[i]);
        tooChaotic = true;
        break;
      } else {
        skipped += Math.abs(arr[i] - sorted[i]);
      }
    }
    System.out.println(skipped > 2 ? skipped : "Too chaotic");
  }
}
