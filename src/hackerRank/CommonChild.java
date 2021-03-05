package hackerRank;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CommonChild {

  public static void main(String[] args) {
    System.out.println(commonChild("SHINCHAN", "NOHARAAA"));
    //AWHYFCCMQX, OUDFRMYMAW
  }

  static int commonChild(String s1, String s2) {

    Map<String, Long> map1 = Arrays.stream(s1.split(""))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    Set<String> set1 = Arrays.stream(s1.split("")).collect(Collectors.toSet());
    Set<String> set2 = Arrays.stream(s2.split("")).collect(Collectors.toSet());
    set1.retainAll(set2);
    set2.retainAll(set1);

    List<String> l1 = Arrays.stream(s1.split("")).collect(Collectors.toList());
    List<String> l2 = Arrays.stream(s2.split("")).collect(Collectors.toList());

    l1.retainAll(l2);
    l2.retainAll(l1);
    System.out.println(l1);
    System.out.println(l2);

    return 0;
  }

  static class EachLetter {
    private String letter;
    private int index;

    public EachLetter() {
    }

    public EachLetter(String letter, int index) {
      this.letter = letter;
      this.index = index;
    }

    public String getLetter() {
      return letter;
    }

    public void setLetter(String letter) {
      this.letter = letter;
    }

    public int getIndex() {
      return index;
    }

    public void setIndex(int index) {
      this.index = index;
    }
  }
}
