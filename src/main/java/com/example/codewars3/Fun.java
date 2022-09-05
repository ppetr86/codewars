package com.example.codewars3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Fun {

    static String thirdText = " now!";

    public static void main(String[] args) throws FileNotFoundException {

        List<String> strings = List.of("a", "bb", "cc", "ddd");

        Map<Integer, List<String>> result = strings.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.filtering(s -> !s.contains("c"), Collectors.toList())));

        Map<Integer, Double> result2 = strings.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.averagingInt(String::hashCode)));

        List<String> items =
                Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

        Map<String, Long> result3 =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()));

        System.out.println(result3);

        System.out.println(result); // {1=[a], 2=[b, b, c, c], 3=[d, d, d]}

        System.out.println(result);
        System.out.println(result2);

        Map<String, Integer> stringLength = new HashMap<>();

        System.out.println(stringLength.put("John", 3) + " PUT ");
        System.out.println(stringLength.putIfAbsent("John", 5) + " putIfAbsent ");
        System.out.println(stringLength.computeIfAbsent("John", String::length));
        System.out.println(stringLength.get("John") + " GET ");
        System.out.println(stringLength.put("John", 3) + " PUT ");
        System.out.println(stringLength.computeIfAbsent("John", String::length));

        System.out.println(Period.of(1, 1, 1));

        System.out.println(fiboMemo(1, new HashMap<>()));
        System.out.println(fiboMemo(3, new HashMap<>()));
        System.out.println(fiboMemo(7, new HashMap<>()));
        System.out.println(fiboMemo(50, new HashMap<>()));

        System.out.println(gridTraveler(18, 18, new HashMap<>()));

        System.out.println(canSum(1, new int[]{2, 3, 4}, new HashMap<>()));
        System.out.println(canSum(300, new int[]{7, 14, 29}, new HashMap<>()));
        List<String> stringList = new ArrayList<>();
        for (String str : stringList) {
            System.out.println(str);
        }

        System.out.println(bestSum(8, new int[]{1, 4, 5}, new HashMap<>()));
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();

        System.out.println(Arrays.toString(bestSum2(8, new int[]{1, 4, 5}, map)));
        System.out.println(bestSum(7, new int[]{5, 3, 4, 7}, new HashMap<>()));
        System.out.println(bestSum(100, new int[]{1, 2, 5, 25}, new HashMap<>()));

        System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<>()));
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "eeee", "eeeeeeeeee", "eeeeeeeeeeeee", "eeeeeeeeeeeeeeeeeeeeeeeeeeee"}, new HashMap<>()));

        System.out.println(countConstruct("abcdefabcdefabcdefabcdefabcdefabcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef", "abcdef"}, new HashMap<>()));
        System.out.println((allConstruct("abcdef", new String[]{"ab", "cd", "ef", "def", "abcd", "ef", "abcdef"}, new HashMap<>())));

        System.out.println(fibTabulation(6));
        System.out.println(fibTabulation(7));

        System.out.println(gridTravelerTabulation(1, 1));
        System.out.println(gridTravelerTabulation(2, 3));
        System.out.println(gridTravelerTabulation(3, 2));
        System.out.println(gridTravelerTabulation(3, 3));
        System.out.println(gridTravelerTabulation(18, 18));

        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.substring(o1.length() - 1).compareTo(o2.substring(o2.length() - 1));
            }
        };

        Comparator<String> stringComparator1 = (s1, s2) -> s1.compareTo(s2);
        //java lambda can implement interfaces with
        //a single unimplemented (abstract) method
        // and or many default or static methods
        MyFunction myFunction = (text, text2) -> {
            System.out.println("hello " + text + text2);
            return text + text2;
        };
        myFunction.apply("world", " welcome");

        MyFunction myFunction1 = myFunction;
        myFunction1.apply("Petr ", "N");
        myFunction1.printUtf8To("hello file", new FileOutputStream("data.txt"));
        MyFunction.printToSystemsOut("static");

        //System.out.println(stringComparator.compare("hello", "hallm"));

        //text 2 must be effectively final. Cant change after it was set
        String text2 = "java lambda";
        MyInterface myInterface = text -> System.out.println(text + text2 + thirdText);
        myInterface.printIt("learn ");
        // static variables may change value when used in lambda
        thirdText = " now or never!";
        myInterface.printIt("learn ");
    }

    private static boolean canSum(int sum, int[] arr, HashMap<Integer, Boolean> cache) {
        if (cache.containsKey(sum)) return cache.get(sum);
        if (sum == 0) return true;
        if (sum < 0) return false;

        int remainder;
        for (int j : arr) {
            remainder = sum - j;
            if (canSum(remainder, arr, cache)) {
                cache.put(j, true);
                return true;
            }
        }
        cache.put(sum, false);
        return false;
    }

    private static long gridTraveler(int rows, int cols, HashMap<String, Long> cache) {
        if (cache.containsKey(rows + "," + cols)) return cache.get(rows + "," + cols);
        if (rows == 1 && cols == 1) return 1;
        if (rows == 0 || cols == 0) return 0;
        cache.putIfAbsent(rows + "," + cols, gridTraveler(rows - 1, cols, cache) + gridTraveler(rows, cols - 1, cache));
        return cache.get(rows + "," + cols);
    }

    public static long fiboMemo(int nth, HashMap<Integer, Long> cache) {
        if (cache.containsKey(nth)) {
            System.out.println();
            return cache.get(nth);
        }
        if (nth <= 2) return 1;
        cache.putIfAbsent(nth, fiboMemo(nth - 1, cache) + fiboMemo(nth - 2, cache));
        return cache.get(nth);
    }

    public static int[] bestSum2(int n, int[] arr, Map<Integer, int[]> cache) {
        if (cache.containsKey(n)) return cache.get(n);
        if (n == 0) return new int[0];
        if (n < 0) return null;

        int[] minn = null;

        for (int j : arr) {
            int[] temp = bestSum2(n - j, arr, cache);
            if (temp != null) {
                int[] ttemp = new int[temp.length + 1];
                System.arraycopy(temp, 0, ttemp, 0, temp.length);
                ttemp[temp.length] = j;
                temp = ttemp;
                if (minn == null || temp.length < minn.length) {
                    minn = temp;
                }
            }
        }
        cache.put(n, minn);
        return minn;
    }

    public static ArrayList<Integer> bestSum(int target, int nums[], HashMap<Integer, ArrayList<Integer>> cache) {
        if (cache.containsKey(target)) return cache.get(target);
        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;

        ArrayList<Integer> shortestCombination = null;

        for (int num : nums) {
            int rest = target - num;
            ArrayList<Integer> currentCombination = bestSum(rest, nums, cache);
            if (currentCombination != null) {
                ArrayList<Integer> combination = (ArrayList) currentCombination.clone();
                combination.add(num);
                if (shortestCombination == null || combination.size() < shortestCombination.size()) {
                    shortestCombination = new ArrayList<>();
                    shortestCombination = (ArrayList) combination.clone();
                }
            }
        }

        cache.put(target, shortestCombination);
        return shortestCombination;
    }

    public static boolean canConstruct(String target, String[] wordBank, Map<String, Boolean> cache) {
        if (cache.containsKey(target)) return cache.get(target);
        if (target.isEmpty()) return true;

        for (String str : wordBank) {
            if (target.startsWith(str))
                if (canConstruct(target.substring(str.length()), wordBank, cache)) {
                    cache.put(str, true);
                    return true;
                }
        }
        return false;
    }

    public static int countConstruct(String target, String[] wordBank, Map<String, Integer> cache) {
        if (cache.containsKey(target)) return cache.get(target);
        if (target.isEmpty()) return 1;

        int result = 0;
        for (String str : wordBank)
            if (target.startsWith(str)) {
                int temp = countConstruct(target.substring(str.length()), wordBank, cache);
                result += temp;
            }
        return result;
    }

    public static List<List<String>> allConstruct(String target, String[] wordBank, Map<String, List<List<String>>> cache) {
        if (cache.containsKey(target)) return cache.get(target);
        if (target.isEmpty()) return new ArrayList<>();

        List<List<String>> result = new ArrayList<>();
        for (String str : wordBank) {
            if (target.startsWith(str)) {
                String suffix = target.substring(str.length());
                List<List<String>> suffixWays = allConstruct(suffix, wordBank, cache);
                List<List<String>> targetWays = new ArrayList<>();
                for (List<String> suffixWay : suffixWays) {
                    List<String> tmp = new ArrayList<>(suffixWay);
                    tmp.add(0, str);
                    targetWays.add(tmp);
                }

                for (List<String> targetWay : targetWays)
                    result.add(new ArrayList<>(targetWay));
            }
        }

        cache.put(target, result);
        return result;
    }

    public static int fibTabulation(int indexInFib) {
        int[] table = new int[indexInFib + 1];
        table[1] = 1;
        //Arrays.fill(table,0);
        for (int i = 0; i < table.length; i++) {
            if (i < table.length - 1)
                table[i + 1] += table[i];
            if (i < table.length - 2)
                table[i + 2] += table[i];
        }
        return table[indexInFib];
    }

    public static long gridTravelerTabulation(int rows, int cols) {
        long[][] table = new long[rows + 1][cols + 1];
        table[1][1] = 1;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (i < table.length - 1)
                    table[i + 1][j] += table[i][j];
                if (j < table[i].length - 1)
                    table[i][j + 1] += table[i][j];
            }
        }
        return table[rows][cols];
    }


}
