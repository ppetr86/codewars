package hackerRank;

import java.util.Arrays;

public class SherlockString {
  public static void main(String[] args) {
    System.out.println(isValid("aabbccddeefghi"));
  }

  static String isValid(String s) {

    int[] letters = new int[26];
    for (char c : s.toCharArray()) {
      letters[c - 'a']++;
    }

    int max = Arrays.stream(letters).max().getAsInt();
    int min = Arrays.stream(letters).filter(each -> each > 0).min().getAsInt();
    int maxCount = (int) Arrays.stream(letters).filter(each -> each == max).count();
    int minCount = (int) Arrays.stream(letters).filter(each -> each == min).count();

    System.out.println(Arrays.toString(letters));

    if (max == min) {
      return "YES";
    } else if (max - min > 1) {
      return "NO";
    } else if (maxCount == 1 || minCount == 1) {
      return "YES";
    }
    return "NO";
  }
}

/*
if (max == min) {
        return "YES";
        } else {
        if (max - min > 1) {
        return "NO";
        } else if (maxCount == 1 || minCount == 1) {
        return "YES";
        }
        }
        return "NO";
        }*/
