package codewars.kyu4;
//https://www.codewars.com/kata/5629db57620258aa9d000014/train/java

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringsMixDuplicate {
  public static void main(String[] args) {
    System.out.println(mix("Are they here", "yes, they are here"));
  }

  public static String mix(String s1, String s2) {
    Map<String, Long> mapS1 = getMapFromStirngAndKeepValuesBiggerThan1(s1);
    Map<String, Long> mapS2 = getMapFromStirngAndKeepValuesBiggerThan1(s2);

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

  private static Map<String, Long> getMapFromStirngAndKeepValuesBiggerThan1(String s1) {
    Map<String, Long> mapS1 = Arrays.stream(s1.replaceAll("[^a-zA-Z]", "").split(""))
            .filter(x -> Character.isLetter(x.charAt(0)))
            .filter(x -> Character.isLowerCase(x.charAt(0)))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    return mapS1.entrySet().stream().filter(e -> e.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  // I have a hashmap with comparison which letter has bigger frequency and where its original position was
  private static HashMap<KeyAndMapNr, Long> createMyObjMap(Map<String, Long> mapS1, Map<String, Long> mapS2) {

    Set<String> mergedKeys = new HashSet<>(mapS1.keySet());
    mergedKeys.addAll(mapS2.keySet());
    HashMap<KeyAndMapNr, Long> result = new HashMap<>();

    for (String each : mergedKeys) {
      Long map1Val = mapS1.get(each);
      Long map2Val = mapS2.get(each);
      if (map1Val == null) map1Val = 0L;
      if (map2Val == null) map2Val = 0L;
      if (map1Val.equals(map2Val)) {
        String repeated = IntStream.range(0, Math.toIntExact(map1Val)).mapToObj(x -> each).collect(Collectors.joining());
        result.put(new KeyAndMapNr(repeated, "=:"), map1Val);
      }
      if (map1Val > map2Val) {
        String repeated = IntStream.range(0, Math.toIntExact(map1Val)).mapToObj(x -> each).collect(Collectors.joining());
        result.put(new KeyAndMapNr(repeated, "1:"), map1Val);
      }
      if (map1Val < map2Val) {
        String repeated = IntStream.range(0, Math.toIntExact(map2Val)).mapToObj(x -> each).collect(Collectors.joining());
        result.put(new KeyAndMapNr(repeated, "2:"), map2Val);
      }
    }
    return result;
  }

  private static String getStringByValue(Long value, HashMap<KeyAndMapNr, Long> map1) {
    StringBuilder result = new StringBuilder();
    // THE PROBLEM IS HERE. IF EQUAL, MAP 2 SHOULD GO FIRST
    for (Map.Entry entry : map1.entrySet()) {
      if (entry.getValue().equals(value)) {
        
        KeyAndMapNr key = (KeyAndMapNr) entry.getKey();
        String fromChar = key.getCharacter();
        String mapNr = key.mapNr;
        result.append(mapNr).append(fromChar).append("/");
      }
    }
    return result.toString();
  }

  private static boolean map2GoesFirst(HashMap<KeyAndMapNr, Long> map1, Long value) {
    for (Map.Entry entry : map1.entrySet()) {
      KeyAndMapNr key = (KeyAndMapNr) entry.getKey();
      if (key.getCharacter().startsWith("2")) return true;
    }
    return false;
  }


  static class KeyAndMapNr {
    public String character;
    public String mapNr;

    public KeyAndMapNr(String character, String mapNr) {
      this.character = character;
      this.mapNr = mapNr;
    }

    public String getCharacter() {
      return character;
    }

    @Override
    public String toString() {
      return mapNr + character;
    }
  }
}
