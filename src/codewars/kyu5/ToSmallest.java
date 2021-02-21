package codewars.kyu5;

import java.text.ParseException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ToSmallest {

  public static void main(String[] args) throws ParseException {
    System.out.println(Arrays.toString(smallest(261235)));
  }

  public static long[] smallest(long n) {

    String input = String.valueOf(n);

    String sorted = Arrays.stream(String.valueOf(n).split(""))
            .map(Long::parseLong)
            .sorted()
            .map(String::valueOf)
            .collect(Collectors.joining());

    long fromIndex = 0;
    long toIndex = 0;
    long number = n;

    for (int i = 0; i < input.length(); i++) {
      String dummy = "";
      if (input.charAt(i) == sorted.charAt(i)) continue;
      if (input.charAt(i) > sorted.charAt(i)) {
        int indexOfInput = i;//1 -> corresponds to 8
        int indexOfSortedAtIinInput = input.indexOf(sorted.charAt(i));//index 1 -> corresponds to 3

        System.out.println("indexOfInput " + indexOfInput);
        System.out.println("indexOfSortedAtIinInput " + indexOfSortedAtIinInput);

        String[] arr = input.split("");
        String holder1 = String.valueOf(input.charAt(i));
        String holder2 = String.valueOf(sorted.charAt(i));
        System.out.println("holder1 " + holder1);
        System.out.println("holder2 " + holder2);

        arr[i] = holder2;
        arr[indexOfSortedAtIinInput] = holder1;
        dummy = String.join("", arr);

        if (Long.parseLong(dummy) < number) {
          number = Long.parseLong(dummy);
          fromIndex = indexOfInput;
          toIndex = indexOfSortedAtIinInput;
        }
      }
    }
    return new long[]{number, fromIndex, toIndex};
  }
}
