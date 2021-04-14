import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {
  public static void main(String[] args) {
    String[] fruitBasket = new String[]{"zulu", "apple", "banana", "coconut", "durian",
            "banana", "elderberry", "fig", "grapefruit"};

    System.out.println(Arrays.toString(fruitBasket));
    Arrays.sort(fruitBasket);
    System.out.println(Arrays.toString(fruitBasket));
    countTheWords("Boci, boci tarka, se füle, se farka. boCi!");
  }

  public static void countTheWords(String crazyLongString) {
    Map<String, Integer> wordFrequencies = new HashMap<>();
    String[] strArr = crazyLongString.split(" ");
    for (int i = 0; i < strArr.length; i++) {
      String current = strArr[i].toLowerCase().replaceAll("[.,!?]", "");
      wordFrequencies.putIfAbsent(current, 0);
      wordFrequencies.put(current, wordFrequencies.get(current) + 1);
    }

    for(Map.Entry each : wordFrequencies.entrySet()){
      System.out.println(each.getKey() + ":" + each.getValue());
    }
  }
}
