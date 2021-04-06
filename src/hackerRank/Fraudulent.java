package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Fraudulent {
  public static void main(String[] args) {
    System.out.println(activityNotifications(new int[]{1,2,3,4,4}, 4));
  }

  static int activityNotifications(int[] expenditure, int d) {
    int result = 0;
    double median = 0.00;
    if (expenditure.length == d) return 0;

    List<Integer> current = new ArrayList<>(d);
    current.addAll(Arrays.stream(expenditure).limit(d).boxed().collect(Collectors.toList()));

    for (int i = d; i < expenditure.length; i++) {
      List<Integer> sorted = current;
      sorted.addAll(current.stream().sorted().collect(Collectors.toList()));

      if (d % 2 != 0) {
        median = sorted.get(current.size() / 2);
      }
      if (d % 2 == 0) {
        median = (double) (sorted.get(sorted.size()/2) + sorted.get(sorted.size()/2 - 1)) / 2;
      }
      if (expenditure[i] >= median * 2) result++;
      current.remove(0);
      current.add(expenditure[i]);
    }
    return result;
  }
}
