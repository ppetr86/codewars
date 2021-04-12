package hackerRank;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Fraudulent {
  public static void main(String[] args) {
    System.out.println(activityNotifications(new int[]{10,20,30,40,50}, 3));
  }

  static int activityNotifications(int[] expenditure, int d) {

    if (expenditure.length == d) return 0;
    int result = calculate(d, expenditure);
    return result;
  }

  private static int calculate(int d, int[] expenditure) {
    int result = 0;
    LinkedList<Integer> current = Arrays.stream(expenditure).limit(d).boxed().collect(Collectors.toCollection(LinkedList::new));
    if (d % 2 == 0) {
      for (int i = d; i < expenditure.length; i++) {
        List<Integer> sorted = current.stream().sorted().collect(Collectors.toList());
        double median = (double) (sorted.get(sorted.size() / 2) + sorted.get(sorted.size() / 2 - 1)) / 2;
        if (expenditure[i] >= median * 2) result++;
        current.removeFirst();
        current.addLast(expenditure[i]);
      }
    } else {
      for (int i = d; i < expenditure.length; i++) {
        List<Integer> sorted = current.stream().sorted().collect(Collectors.toList());
        double median = sorted.get(current.size() / 2);
        if (expenditure[i] >= median * 2) result++;
        current.removeFirst();
        current.addLast(expenditure[i]);
      }
    }
    return result;
  }

  /*static int activityNotifications(int[] expenditure, int d) {

    int result = 0;
    for (int i = d + 1; i < expenditure.length; i++) {
      int[] ints2 = Arrays.stream(expenditure).skip(i - d).limit(d).sorted().toArray();
      double median = ints2[ints2.length / 2];
      if (median * 2 > expenditure[i]) result++;
    }
    return result;
  }*/
}