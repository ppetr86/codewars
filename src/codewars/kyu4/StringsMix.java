package codewars.kyu4;
//https://www.codewars.com/kata/5629db57620258aa9d000014/train/java

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringsMix {
  public static void main(String[] args) {
    System.out.println(mix("Are they here", "yes, they are here"));
  }

  public static String mix(String s1, String s2) {
    Map<Character, Long> mapS1 = Arrays.stream(s1.replaceAll( "[^a-zA-Z]","").split(""))
            .filter(x -> Character.isLetter(x.charAt(0)))
            .filter(x -> Character.isLowerCase(x.charAt(0)))
            .map(x -> x.charAt(0))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    Map<Character, Long> mapS2 = Arrays.stream(s2.replaceAll( "[^a-zA-Z]","").split(""))
            .filter(x -> Character.isLetter(x.charAt(0)))
            .filter(x -> Character.isLowerCase(x.charAt(0)))
            .map(x -> x.charAt(0))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    mapS1 = mapS1.entrySet().stream().filter(e -> e.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    mapS2 = mapS2.entrySet().stream().filter(e -> e.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    Set<Long> values = new HashSet<>(mapS1.values());
    values.addAll(mapS2.values());
    List<Long> valuesList = values.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());

    HashMap<KeyAndMapNr, Long> myObjMap = createMyObjMap(mapS1, mapS2);

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < valuesList.size(); i++) {
      long value = valuesList.get(i);
      result.append(getStringByValue(value, myObjMap));
    }
    return result.toString();
  }

  // I have a hashmap with comparison which letter has bigger frequency and where its original position was
  private static HashMap<KeyAndMapNr, Long> createMyObjMap(Map<Character, Long> mapS1, Map<Character, Long> mapS2) {

    Set<Character> mergedKeys = new HashSet<>(mapS1.keySet());
    mergedKeys.addAll(mapS2.keySet());
    HashMap<KeyAndMapNr, Long> result = new HashMap<>();

    for (Character each : mergedKeys) {
      Long map1Val = mapS1.get(each);
      Long map2Val = mapS2.get(each);
      if (map1Val == null) map1Val = 0L;
      if (map2Val == null) map2Val = 0L;
      if (map1Val.equals(map2Val)) result.put(new KeyAndMapNr(each, "=:"), map1Val);
      if (map1Val > map2Val) result.put(new KeyAndMapNr(each, "1:"), map1Val);
      if (map1Val < map2Val) result.put(new KeyAndMapNr(each, "2:"), map2Val);
    }
    return result;
  }

  private static String getStringByValue(Long value, HashMap<KeyAndMapNr, Long> map1) {
    StringBuilder result = new StringBuilder();

    for (Map.Entry entry : map1.entrySet()) {
      if (entry.getValue().equals(value)) {
        KeyAndMapNr key = (KeyAndMapNr) entry.getKey();
        String fromChar = key.getCharacter().toString();
        String mapNr = key.mapNr;
        String repeated = IntStream.range(0, Math.toIntExact(value)).mapToObj(x -> fromChar).collect(Collectors.joining());
        result.append(mapNr).append(repeated).append("/");
      }
    }
    return result.toString();
  }

  static class KeyAndMapNr {
    public Character character;
    public String mapNr;

    public KeyAndMapNr(Character character, String mapNr) {
      this.character = character;
      this.mapNr = mapNr;
    }

    public Character getCharacter() {
      return character;
    }

    public String getMapNr() {
      return mapNr;
    }

    @Override
    public String toString() {
      return  character + " " + mapNr + "||";
    }
  }
}
