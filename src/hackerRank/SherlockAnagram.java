package hackerRank;

import java.util.HashMap;

public class SherlockAnagram {
  public static void main(String[] args) {
    System.out.println(sherlockAndAnagrams("abba"));
  }

  private static int sherlockAndAnagrams(String str) {
    int result = str.length();
    HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i < str.length()-1; i++) {
      for (int j = i; j < str.length(); j++) {
        String sub = str.substring(i,j);
        if (map.containsKey(sub)) map.put(sub, map.get(sub)+1);
        else map.put(sub,1);
      }
    }
    return 0;
  }
}
