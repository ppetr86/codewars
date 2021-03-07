package hackerRank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

  public static void main(String[] args) {
    System.out.println(countTriplets(List.of(1L,3L,9L,9L,27L,81L), 3));
  }

  static long countTriplets(List<Long> arr, long r) {

    // map with triplets and their indices
    Map<List<Long>,List<Integer>> map = new HashMap<>();

    for (int i = 0; i < arr.size()-3; i++) {
      List<Long> keys = Arrays.asList(arr.get(i), arr.get(i+1), arr.get(i+2));
      List<Integer> values = Arrays.asList(i,i+1,i+2);
    }

    return map.size();
  }
}
