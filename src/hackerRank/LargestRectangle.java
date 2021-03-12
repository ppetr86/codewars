package hackerRank;

import java.util.PriorityQueue;

public class LargestRectangle {

  public static void main(String[] args) {
    System.out.println(largestRectangle(new int[]{5,2,4,3,6,8,6}));
  }

  static long largestRectangle(int[] h) {
    PriorityQueue<Long> largest = new PriorityQueue<>();
    largest.add((long) h[0]);
    for (int i = 1; i < h.length; i++) {
      long sumInQue = largest.stream().reduce(0L,Long::sum);
      long minInQue = largest.stream().mapToLong(x->x).min().getAsLong();
      long size = largest.size();
      if (sum < sum+(long))
    }

  }
}
