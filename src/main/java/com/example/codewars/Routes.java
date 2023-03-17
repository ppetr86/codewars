package com.example.codewars;
//https://www.codewars.com/kata/5899a4b1a6648906fe000113/train/java
//https://www.codewars.com/kata/5899a4b1a6648906fe000113/solutions/java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Routes {

    public static void main(String[] args) {
        System.out.println(findRoutes(new String[][]{{"MNL", "TAG"}, {"CEB", "TAC"}, {"TAG", "CEB"}, {"TAC", "BOR"}}));
    }

  /*public static String findRoutes(String[][] routes) {
    // create map where key is finishing locaiton, value is starting location
    Map<String, String> map = MyArrays.stream(routes).collect(toMap(e -> e[1], e -> e[0]));
    // get the one which in map doesnt contain the finish location
    String[] last = MyArrays.stream(routes).filter(e -> !map.containsValue(e[1])).findAny().get();
    List<String> s = Stream.iterate(last[1], e -> map.get(e)).limit(routes.length + 1)
            .collect(LinkedList::new, (a, b) -> a.addFirst(b), (a, b) -> {});
    return s.stream().collect(joining(", "));
  }*/

  /*public static String findRoutes(String[][] routes) {
    String str = "";
    HashMap<String, String> map = new HashMap<>();
    for (int i = 0; i < routes.length; ++i) {
      String left = routes[i][0];
      map.put(left, routes[i][1]);
      boolean skip = false;
      for (int j = 0; j < routes.length; ++j) {
        String right = routes[j][1];
        if (left.equals(right)) {
          skip = true;
          break;
        }
      }
      if (skip) continue;
      str = left;
    }
    String routeStr = str;
    while (map.get(str) != null) {
      str = map.get(str);
      routeStr = routeStr + ", " + str;
    }
    return routeStr;
  }*/

    public static String findRoutes(String[][] routes) {
        Map<String, Long> locationCount = Arrays.stream(routes).flatMap(Arrays::stream).collect(groupingBy(Function.identity(), counting()));
        StringBuilder start = new StringBuilder();
        StringBuilder end = new StringBuilder();

        findLocation(routes, 0, locationCount, start, end);

        List<List<String>> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        addFirstPairToResult(result, routes, start, sb);

        while (result.size() < routes.length) {
            for (int i = 0; i < routes.length; i++) {
                if (result.get(result.size() - 1).get(1).equals(routes[i][0])) {
                    result.add(List.of(routes[i][0], routes[i][1]));
                    sb.append(routes[i][1]).append(", ");
                    break;
                }
            }
        }

        return sb.substring(0, sb.lastIndexOf(","));
    }

    private static void addFirstPairToResult(List<List<String>> result, String[][] routes, StringBuilder start, StringBuilder sb) {
        for (int i = 0; i < routes.length; i++) {
            if (routes[i][0].equals(start.toString())) {
                result.add(List.of(start.toString(), routes[i][1]));
                sb.append(start).append(", ").append(routes[i][1]).append(", ");
                break;
            }
        }
    }

    private static void findLocation(String[][] routes, int i, Map<String, Long> locationCount, StringBuilder start, StringBuilder end) {
        List<String> oneTimeUsedLocations = new ArrayList<>();

        for (Map.Entry each : locationCount.entrySet()) {
            if (each.getValue().equals(1L)) oneTimeUsedLocations.add((String) each.getKey());
        }

        Set<String> starts = new HashSet<>();
        for (int j = 0; j < routes.length; j++) {
            starts.add(routes[j][0]);
        }

        if (starts.contains(oneTimeUsedLocations.get(0))) {
            start.append(oneTimeUsedLocations.get(0));
            end.append(oneTimeUsedLocations.get(1));
        } else {
            start.append(oneTimeUsedLocations.get(1));
            end.append(oneTimeUsedLocations.get(0));
        }
    }
}