package hackerRank;

//https://www.hackerrank.com/challenges/special-palindrome-again/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
//A string is said to be a special string if either is met:
//All of the characters are the same, e.g. aaa.
//All characters except the middle one are the same, e.g. aadaa.
//how many special substrings can be formed
public class SpecialString {
  public static void main(String[] args) {
    System.out.println(substrCount(7, "abcbaba"));
  }

  static long substrCount(int n, String s) {
    long result = n;

    for (int i = 0; i < s.length() - 2; i++) {
      // traverse substrings starting with length 2
      for (int j = i + 2; j < s.length() - 1; j++) {
        String str = s.substring(i, j);
        StringBuilder reversed = new StringBuilder(str).reverse();
        if (str.equals(reversed.toString())) result++;
        if (str.length() > 3 && str.length() % 2 != 0) {
          String str2 = str.substring(0, str.length() / 2 + 1) + str.substring(str.length() / 2 + 2);
          StringBuilder reversed2 = new StringBuilder(str).reverse();
          if (str2.equals(reversed2.toString())) result++;
        }
      }
    }
    return result;
  }
}
