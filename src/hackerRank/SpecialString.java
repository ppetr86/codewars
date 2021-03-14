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
    int counter = 1;

    for (int i = 0; i < s.length(); i++) {
      String subString = s.substring(i,i+counter);
    }
    return result;
  }
}
