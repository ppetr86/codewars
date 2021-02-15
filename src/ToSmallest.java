import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ToSmallest {

  public static void main(String[] args) throws ParseException {
    System.out.println(Arrays.toString(smallest(285365)));
  }

  public static long[] smallest(long n) {
    List<Character> list = String.valueOf(n)
            .chars()
            .mapToObj(e -> (char) e)
            .collect(Collectors.toList());

    char smallestDigit;
    long fromIndex = 0;
    long toIndex = 0;
    for (int i = 0; i < list.size(); i++) {
      smallestDigit = getSmallestDigit(list, i);
      int indexOfSmallest = list.indexOf(smallestDigit);
      char charOnI = list.get(i);
      if (list.get(i) > smallestDigit) {
        toIndex = i;
        fromIndex = indexOfSmallest;
        list.set(i, smallestDigit);
        list.set(indexOfSmallest, charOnI);
        break;
      }
    }

    long number = Long.parseLong(list.stream().map(String::valueOf).collect(Collectors.joining()));

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
}