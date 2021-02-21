package hackerRank;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//https://www.hackerrank.com/challenges/alternating-characters/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
public class AlternatingCharacters {
  // Complete the alternatingCharacters function below.


  static int alternatingCharacters(String s) {
    int result = 0;
    if (s.isEmpty()) return 0;
    if (Pattern.matches("[A]*", s) || Pattern.matches("[B]*", s)) return s.length() - 1;

    for (int i = 0; i < s.length() - 1; i++) {
      if (s.charAt(i) == s.charAt(i + 1)) {
        s = s.substring(0,i) + s.substring(i+1);
        i--;
        result++;
      }
      if (s.equals("AB") || s.equals("BA")) break;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(alternatingCharacters("AAABBB"));
  }
}