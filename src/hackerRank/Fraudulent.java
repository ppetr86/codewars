package hackerRank;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Fraudulent {
  public static void main(String[] args) {
    System.out.println(activityNotifications(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5}, 5));
  }

  static int activityNotifications(int[] expenditure, int d) {
    int result = 0;
    double median = 0.00;
    if (expenditure.length == d) return 0;

    LinkedList<Integer> current = Arrays.stream(expenditure).limit(d).boxed().collect(Collectors.toCollection(LinkedList::new));

    for (int i = d; i < expenditure.length; i++) {
      List<Integer> sorted = current.stream().sorted().collect(Collectors.toList());

      if (d % 2 != 0) {
        median = sorted.get(current.size() / 2);
      }
      if (d % 2 == 0) {
        median = (double) (sorted.get(sorted.size() / 2) + sorted.get(sorted.size() / 2 - 1)) / 2;
      }
      if (expenditure[i] >= median * 2) result++;
      current.removeFirst();
      current.addLast(expenditure[i]);
    }

    return result;
  }
}