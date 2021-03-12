package hackerRank;

import java.util.HashMap;

public class SherlockAnagram {
  public static void main(String[] args) {
    System.out.println(sherlockAndAnagrams("abbarotor"));
  }

  private static int sherlockAndAnagrams(String str) {
    int result = 0;

    // if I need pairs, then I can have longest pair as long as half size of the word
    // since each lenght between 2-half is needed I have to iterate this
    //I start at length 1, and check if current letter has a duplicate
    for (int i = 1; i < str.length()/2; i++) {
      for (int j = 1; j < 8; j++) {

      }
    }
    return 0;
  }
}
