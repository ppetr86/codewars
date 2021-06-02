import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Test {
  public static void main(String[] args) {
    String[] fruitBasket = new String[]{"zulu", "apple", "banana", "coconut", "durian",
            "banana", "elderberry", "fig", "grapefruit"};

    System.out.println(Arrays.toString(fruitBasket));
    Arrays.sort(fruitBasket);
    System.out.println(Arrays.toString(fruitBasket));
    countTheWords("Boci, boci tarka, se füle, se farka. boCi!");

    List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");

    Map<Integer, Set<String>> collectorsGroupingBy = givenList.stream()
            .collect(groupingBy(String::length, toSet()));

    System.out.println("------------------");
    System.out.println(collectorsGroupingBy);

    Map<Integer, List<String>> partionByLength = givenList.stream()
            .collect(groupingBy(String::length, toList()));

    System.out.println("------------------partionByLength");
    System.out.println(partionByLength);

    Map<Boolean, List<String>> partionBy = givenList.stream()
            .collect(partitioningBy(s -> s.length() > 2));

    System.out.println("------------------");
    System.out.println(partionBy);

    List<Integer> numbers = Arrays.asList(42, 4, 2, 24);

    Integer min = numbers.stream().collect(minBy(Integer::compareTo)).get();

    System.out.println("----------------------------");

    Stream.of("cat", "dog", "elephant", "fox", "rabbit", "duck")
            .takeWhile(n -> n.length() % 2 != 0)
            .forEach(System.out::println);

  }

  public static void countTheWords(String crazyLongString) {
    Map<String, Integer> wordFrequencies = new HashMap<>();
    String[] strArr = crazyLongString.split(" ");
    for (int i = 0; i < strArr.length; i++) {
      String current = strArr[i].toLowerCase().replaceAll("[.,!?]", "");
      wordFrequencies.putIfAbsent(current, 0);
      wordFrequencies.put(current, wordFrequencies.get(current) + 1);
    }

    for (Map.Entry each : wordFrequencies.entrySet()) {
      System.out.println(each.getKey() + ":" + each.getValue());
    }

    String testString = "String";
    IntStream intStream = testString.chars();

    Stream<Character> characterStream = testString.chars()
            .mapToObj(c -> (char) c);

    IntStream intStream1 = testString.codePoints();

    Stream<Character> characterStream2
            = testString.codePoints().mapToObj(c -> (char) c);

    Stream<String> stringStream = testString.codePoints()
            .mapToObj(c -> String.valueOf((char) c));

    int start = 11;
    int end = 15;
    int rangeC = IntStream.range(start, end).sum();

    System.out.println("---------------");
    IntStream.rangeClosed(start, end).forEach(System.out::println);

    Map<String, Integer> someMap = new HashMap<>();

    someMap.put("Ivana", 1972);
    someMap.put("Petr", 1986);
    someMap.put("Olga", 2004);
    someMap.put("Daniela", 2013);
    someMap.put("Nina", 2015);

    Collection<Integer> values = someMap.values();
    Set<String> keySet = someMap.keySet();

    Set<Map.Entry<String, Integer>> entries = someMap.entrySet();
    Stream<Map.Entry<String, Integer>> entriesStream = entries.stream();
    Stream<Integer> valuesStream = values.stream();
    Stream<String> keysStream = keySet.stream();

    Map<String, String> books = new HashMap<>();
    books.put("978-0201633610", "Design patterns : elements of reusable object-oriented software");
    books.put("978-1617291999", "Java 8 in Action: Lambdas, Streams, and functional-style programming");
    books.put("978-0134685991", "Effective Java");

    Optional<String> optionalIsbn = books.entrySet().stream()
            .filter(e -> "Effective Java".equals(e.getValue()))
            .map(Map.Entry::getKey)
            .findFirst();

    List<String> titles = books.entrySet().stream()
            .filter(e -> e.getKey().startsWith("978-0"))
            .map(Map.Entry::getValue)
            .collect(Collectors.toList());

    List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
    Integer sum = integers.stream()
            .collect(Collectors.summingInt(Integer::intValue));


    List<Integer> integerz = Arrays.asList(1, 2, 3, 4, 5);
    Integer zum = integers.stream()
            .mapToInt(Integer::intValue)
            .sum();

    String string = "Item1 10 Item2 25 Item3 30 Item4 45";

    Integer stringSum = Arrays.stream(string.split(" "))
            .map((s) -> s.replaceAll("[^\\d.]",""))
            .mapToInt(Integer::valueOf)
            .sum();

    System.out.println("--------------------------");
    System.out.println("stringSum " + stringSum);
    System.out.println("--------------------------");

    LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    System.out.println(linkedList.poll());
    System.out.println(linkedList.pop());
    System.out.println(linkedList.pollLast());
    System.out.println(linkedList.size());

    List<Long> list = new ArrayList<>(Arrays.asList(1L, 2L, 3L));
    LongStream.range(4, 10).boxed()
            .collect(collectingAndThen(toCollection(ArrayList::new), ys -> list.addAll(0, ys)));


  }

}
