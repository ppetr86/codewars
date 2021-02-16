/*
package codewars.kyu5;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ToSmallest {

  public static void main(String[] args) throws ParseException {
    System.out.println(Arrays.toString(smallest(285365)));
  }

  public static long[] smallest(long n) {

    List<Long> notSortedList = Arrays.stream(String.valueOf(n).split(""))
            .map(Long::parseLong)
            .collect(Collectors.toList());

    List<Long> sortedList = notSortedList.stream().sorted().collect(Collectors.toList());

    long fromIndex = 0;
    long toIndex = 0;
    long smallestNumber = Long.MAX_VALUE;
    String inputAsString = String.valueOf(n);

    for (int i = 0; i < sortedList.size(); i++) {
      if ((long) inputAsString.charAt(i) > (sortedList.get(i))){
        long holder = ;
        fromIndex = notSortedList.indexOf(sortedList.get(i));
        toIndex = i;
        smallestNumber
      }
    }

    long number = Long.parseLong(sortedList.stream().map(String::valueOf).collect(Collectors.joining()));

    return new long[]{number, fromIndex, toIndex};
  }

  private static Character getSmallestDigit(List<Character> list, int skipCount) {
    Character number = list
            .stream()
            .skip(skipCount)
            .sorted()
            .findFirst()
            .get();
    return number;
  }
}*/
