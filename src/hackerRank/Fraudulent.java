package hackerRank;

import java.util.Arrays;
import java.util.Collections;

public class Fraudulent {
  public static void main(String[] args) {
    System.out.println(activityNotifications(new int[]{1, 2, 3, 4, 4}, 4));
  }

  static int activityNotifications(int[] expenditure, int d) {

    int result = 0;
    for (int i = d + 1; i < expenditure.length; i++) {
      int[] ints2 = Arrays.copyOfRange(expenditure, i - d, i);
      Arrays.sort(ints2);
      double median = ints2[ints2.length / 2];
      if (median * 2 > expenditure[i]) result++;
    }
    return result;
  }
}
