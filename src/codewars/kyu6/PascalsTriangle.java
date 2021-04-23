package codewars.kyu6;
//https://www.codewars.com/kata/5226eb40316b56c8d500030f/solutions/java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(generate(4)));
  }

  public static long[] generate(int level) {
    List<List<Long>> outer = new ArrayList<>(level);
    outer.add(List.of(1L));

    for (int i = 2; i <= level; i++) {
      List<Long> inner = new ArrayList<>(i);
      for (int j = 0; j < i; j++) {
        if (j == 0 || j == i - 1) {
          inner.add(1L);
        }
        else {
          long left = outer.get(outer.size() - 1).get(j - 1);
          long right = +outer.get(outer.size() - 1).get(j);
          inner.add(left + right);
        }
      }
      outer.add(inner);
    }

    return outer.stream().flatMap(List::stream).mapToLong(Long::longValue).toArray();
  }
}
