package hackerRank;

public class SherlockAnagram {
  public static void main(String[] args) {
    System.out.println(sherlockAndAnagrams("abba"));
  }

  private static int sherlockAndAnagrams(String str) {
    int result = str.length();
    for (int i = 0; i < str.length(); i++) {
      for (int j = 0; j < str.length(); j++) {
        if (j==i) continue;
      }
    }
    return 0;
  }
}
