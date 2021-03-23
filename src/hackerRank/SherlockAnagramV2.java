package hackerRank;
//https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
//timeout on this approach

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SherlockAnagramV2 {
  public static void main(String[] args) {
    System.out.println(sherlockAndAnagrams("abba"));
  }

  private static int sherlockAndAnagrams(String str) {
    int result = 0;
    int strLen = 1;

    for (int i = 0; i < str.length() - strLen; i++) {
      String leftStr = str.substring(i, i + strLen);
      Map<String, Long> map1 = Arrays.stream(str.substring(i, i + strLen).split(""))
              .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

      for (int j = i + 1; j < str.length() - strLen + 1; j++) {
        String rightStr = str.substring(j, j + strLen);
        if (leftStr.length() == rightStr.length() && leftStr.contains(rightStr.substring(0, 1))) {
          Map<String, Long> map2 = Arrays.stream(str.substring(j, j + strLen).split(""))
                  .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

          if (map1.equals(map2)) result++;
        }
      }
      strLen++;
    }

    return result;
  }
}
