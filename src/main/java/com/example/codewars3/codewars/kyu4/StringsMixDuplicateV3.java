package com.example.codewars3.codewars.kyu4;
//https://www.codewars.com/kata/5629db57620258aa9d000014/train/java
//https://www.codewars.com/kata/5629db57620258aa9d000014/solutions/java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringsMixDuplicateV3 {
    public static void main(String[] args) {
        System.out.println(mix(" In many languages", " there's a pair of functions"));
    }

    public static String mix(String s1, String s2) {
        if (s1.equals(s2)) return "";
        Map<String, Long> mapS1 = getMapFromStirngAndKeepValuesBiggerThan1(s1);
        Map<String, Long> mapS2 = getMapFromStirngAndKeepValuesBiggerThan1(s2);

        List<KeyAndMapNr> list = createMyObjMap(mapS1, mapS2);

        list.sort(Comparator.comparing(KeyAndMapNr::getLettersCount).reversed()
                .thenComparing(x -> x.getMapNr() + x.getCharacter()));

        String result = list.stream().map(x -> x.mapNr + x.character + "/").collect(Collectors.joining());
        return result.substring(0, result.length() - 1);
    }

    private static Map<String, Long> getMapFromStirngAndKeepValuesBiggerThan1(String s1) {
        Map<String, Long> mapS1 = Arrays.stream(s1.replaceAll("[^a-zA-Z]", "").split(""))
                .filter(x -> Character.isLetter(x.charAt(0)))
                .filter(x -> Character.isLowerCase(x.charAt(0)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return mapS1.entrySet().stream().filter(e -> e.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    // I have a hashmap with comparison which letter has bigger frequency and where its original position was
    private static List<KeyAndMapNr> createMyObjMap(Map<String, Long> mapS1, Map<String, Long> mapS2) {

        Set<String> mergedKeys = new HashSet<>(mapS1.keySet());
        mergedKeys.addAll(mapS2.keySet());
        List<KeyAndMapNr> result = new ArrayList<>();

        for (String each : mergedKeys) {
            Long map1Val = mapS1.get(each);
            Long map2Val = mapS2.get(each);
            if (map1Val == null) map1Val = 0L;
            if (map2Val == null) map2Val = 0L;
            if (map1Val.equals(map2Val)) {
                String repeated = IntStream.range(0, Math.toIntExact(map1Val)).mapToObj(x -> each).collect(Collectors.joining());
                result.add(new KeyAndMapNr(repeated, "=:", 3, map1Val));
            }
            if (map1Val > map2Val) {
                String repeated = IntStream.range(0, Math.toIntExact(map1Val)).mapToObj(x -> each).collect(Collectors.joining());
                result.add(new KeyAndMapNr(repeated, "1:", 2, map1Val));
            }
            if (map1Val < map2Val) {
                String repeated = IntStream.range(0, Math.toIntExact(map2Val)).mapToObj(x -> each).collect(Collectors.joining());
                result.add(new KeyAndMapNr(repeated, "2:", 1, map2Val));
            }
        }
        return result;
    }

    static class KeyAndMapNr {
        // to have for example "eeee"
        public String character;
        // to have for example "2:" "1:" "=:"
        public String mapNr;
        public int order;
        public long lettersCount;

        public KeyAndMapNr(String character, String mapNr, int order, long lettersCount) {
            this.character = character;
            this.mapNr = mapNr;
            this.order = order;
            this.lettersCount = lettersCount;
        }

        public String getCharacter() {
            return character;
        }

        public String getMapNr() {
            return mapNr;
        }

        public long getLettersCount() {
            return lettersCount;
        }

        @Override
        public String toString() {
            return mapNr + character;
        }
    }

  /*public static String mix(String s1, String s2) {

    List<String> finalStr = new ArrayList();

    for (char c = 'a'; c <= 'z'; c++) {
      String s1_char = s1.replaceAll("[^"+c+"]+","");
      String s2_char = s2.replaceAll("[^"+c+"]+","");

      int s1_length = s1_char.length();
      int s2_length = s2_char.length();

      if(s1_length>1 || s2_length>1){
        if(s1_length == s2_length){
          finalStr.add("=:"+s1_char);
        }
        if(s1_length>s2_length){
          finalStr.add("1:"+s1_char);
        }
        if(s1_length<s2_length){
          finalStr.add("2:"+s2_char);
        }
      }
    }
    Comparator<String> length = (x,y) -> y.length()-x.length();
    Comparator<String> type_value = (x,y) -> Character.compare(x.charAt(0),y.charAt(0));

    return finalStr.stream().sorted(length.thenComparing(type_value)).collect(Collectors.joining("/"));
  }*/
}