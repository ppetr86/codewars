package hackerRank;

import java.util.*;

public class FrequencyQueries {
  public static void main(String[] args) {
    List<List<Integer>> input = new ArrayList<>();
    input.add(List.of(3, 4));
    input.add(List.of(2, 1003));
    input.add(List.of(1, 16));
    input.add(List.of(3, 1));

    System.out.println(freqQuery(input));
  }

  static List<Integer> freqQuery(List<List<Integer>> queries) {
    List<Integer> result = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();

    for (List<Integer> query : queries) {
      if (query.get(0) == 1) {
        insert(query.get(1), map);
        continue;
      }
      if (query.get(0) == 2) {
        delete(query.get(1), map);
        continue;
      }
      if (query.get(0) == 3) {
        checkIfPresentWithFrequency(query.get(1), map, result);
      }
    }
    return result;
  }

  private static void checkIfPresentWithFrequency(Integer integer, Map<Integer, Integer> map, List<Integer> result) {
    if (map.containsValue(integer)) {
      System.out.println(1);
      result.add(1);
      return;
    }
    result.add(0);
    System.out.println(0);

  }

  private static void delete(Integer integer, Map<Integer, Integer> map) {
    if (map.containsKey(integer)) map.replace(integer, Math.max(map.get(integer) - 1, 0));
  }

  private static void insert(Integer integer, Map<Integer, Integer> map) {
    if (map.containsKey(integer)) {
      map.replace(integer, map.get(integer) + 1);
      return;
    }
    map.put(integer, 1);
  }
}
