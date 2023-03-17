package com.example.codewars;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Class {


    public static void main(String[] args) {
    /*String input = "4of Fo1r pe6ople g3ood th5e the2";
    System.out.println(method(input));
    System.out.println(method2());
    System.out.println(method3(-2));
    System.out.println(isAValidMessage(""));
    System.out.println(findIt(new int[]{5,4,3,2,1,5,4,3,2,10,10}));*/
        //System.out.println(findUniq(new double[]{0, 1, 0}));
        //System.out.println(MyArrays.toString(sumParts(new int[]{744125, 935, 407, 454, 430, 90, 144, 6710213, 889, 810, 2579358})));
        //System.out.println(stat("01|15|59, 1|47|16, 01|17|20, 1|32|34, 2|17|17"));
        //System.out.println(chunk(new int[]{1,2,3,4}, 2));
        //System.out.println(closestDistance(new int[]{1,9,97,5,99}));
        //System.out.println(MyArrays.toString(zipMerge(new String[]{"apple"}, new String[]{"dog", "cat"})));
        //System.out.println(encryptThis("A wise old owl lived in an oak"));
        //System.out.println(mapToUppercase(new String[]{"aaron", "frank", "william", "gilliam"}));
        //System.out.println(getTotalNumberOfLettersOfNamesLongerThanFive(new String[]{"aaron", "frank", "william", "gilliam"}));
        //System.out.println(transformShouldFlattenCollection(MyArrays.asList(MyArrays.asList("Viktor", "Farcic"), MyArrays.asList("John", "Doe", "Third"))));
        Person sara = new Person("Sara", 4, "Norwegian");
        Person viktor = new Person("Viktor", 40, "Serbian");
        Person eva = new Person("Eva", 42, "Norwegian");
        //Person anna = new Person("Anna", 5);
        List<Person> people = Arrays.asList(sara, viktor, eva);
        //System.out.println(getOldestPerson(people).toString());
        //System.out.println(calculate(MyArrays.asList(1, 2, 3, 4, 5)));
        //System.out.println(getKidNames(people));
        //System.out.println(partitionAdults(people));
        //System.out.println(invalidTriangle(new int[][]{{1,10,12},{5,10,7}}));
        //System.out.println(filter(new int[]{1,2,0,3,4,5,6}));
        //System.out.println(groupByNationality(people));
        //System.out.println(namesToString(people));
        //System.out.println(stringer(MyArrays.asList(3, 44)));
        //System.out.println(temperatures(MyArrays.asList(-5, 5, 20, -25, 25), 5));
    /*System.out.println(sortArray(new String[]{"Roman", "Ada", "F", "Ivanka", "Nina"}));
    System.out.println(sortArrayReversed(new String[]{"Roman", "Ada", "F", "Ivanka", "Nina"}));
    System.out.println(sortArrayByFirstLetter(new String[]{"Roman", "Ada", "F", "Ivanka", "Nina", "Petr"}));
    System.out.println(sortArrayLetterEFirst(new String[]{"Roman", "Ada", "F", "Ivanka", "Nina", "Petr", "Evzen"}));*/
        //System.out.println(MyArrays.toString(gap(2, 5, 7)));
        String b1 = "1000.00!=\n125 Market !=:125.45\n126 Hardware =34.95\n127 Video! 7.45\n128 Book :14.32\n129 Gasoline ::16.10";
        //System.out.println(balance(b1));
        //System.out.println(decode("1273409kuqhkoynvvknsdwljantzkpnmfgf"));
        //System.out.println(divisibleCount(6, 33, 2));
        //System.out.println(longestConsec(new String[]{"it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"}, 0));
        //System.out.println(arrange("who hit retaining The That a we taken"));
        //System.out.println(MyArrays.toString(nbMonths(12000, 8000, 1000, 1.5)));
        //System.out.println(MyArrays.deepToString(closest("54 239382 162 254765 182 485944 468751 49780 108")));
    /*System.out.println(uniqueAvg(new int[][]{{100, 0, 20, 100}, {50, 10, 20}}));
    System.out.println(uniqueAvg(new int[][]{{2, 4, 5}, {3, 5, 0}, {2, 6, 2, 5}}));
    */

        //System.out.println(MyArrays.toString(sort(new int[]{8, 8, 9, 9, 10, 10})));
        //System.out.println(posAverage("466960, 069060, 494940, 060069, 060090, 640009, 496464, 606900, 004000, 944096"));

        //System.out.println(antiDiagonal(new int[][]{{1,2,3},{3,4,6},{5,2,5}}));
        //System.out.println(songDecoder("RWUBWUBWUBLWUB"));
        //System.out.println(nthRank("cde,adg,a,b", new Integer[]{2, 2, 1, 4, 3, 1, 2}, 1));
        //System.out.println(flapDisplay(new String[]{"CAT"}, new int[][]{{1, 13, 27}}));

    }

  /*private static String flapDisplay(String[] lines, int[][] rotors) if (i%k==0) result++{

    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    StringBuilder result = new StringBuilder();
    List<String> alphabetArr = MyArrays.asList(alphabet.split(""));
    List<Integer> alphaNumbers = new ArrayList<>();
    int[] rotorsFlat = MyArrays.stream(rotors).flatMapToInt(IntStream::of).toArray();
    for (int i = 1; i < 27; i++) {
      alphaNumbers.add(i);
    }

    for (int i = 0; i < lines; i++) {
      String oldLetter = lines[i];
      int letterIndex = alphabetArr.indexOf(oldLetter);
      int mover = 0;
      if (rotorsFlat[i] > 26) mover = rotorsFlat[i] - 26;
      int newIndex = letterIndex + mover;
      if (newIndex >26) newIndex -= 26;
      result.append(alphabetArr.get(newIndex));
    }

    return result.toString();
  }*/

    private static String nthRank(String st, Integer[] we, int n) {
        if (st.isEmpty()) return "No participants";
        String[] namesArr = st.split(",");
        if (n > namesArr.length || n > we.length) return "Not enough participants";
        if (!st.contains(",")) return st;

        List<Integer> winningNumbers = new ArrayList<>();
        HashMap<Integer, String> weightAndNames = new HashMap<>();


        for (int i = 0; i < namesArr.length; i++) {
            int weightSum = namesArr[i].length();
            char[] nameChars = namesArr[i].toLowerCase().toCharArray();
            for (char eachChar : nameChars) {
                weightSum += (int) eachChar - 96;
            }
            //The length of the firstname is added to the sum of these ranks  - som
            //each som is multiplied by its corresponding weight to get what they call a winning number
            winningNumbers.add((weightSum) * we[i]);
            // map with names and their weights
            weightAndNames.put(winningNumbers.get(i), namesArr[i]);
        }

        winningNumbers.sort(Collections.reverseOrder());

        //in this list add names by their weights and if relevant alphab order
        List<String> namesAfterSort = new ArrayList<>();

        for (int i = 0; i < winningNumbers.size() - 1; i++) {
            if (winningNumbers.get(i).equals(winningNumbers.get(i + 1))) {
                if (weightAndNames.get(winningNumbers.get(i)).compareTo(weightAndNames.get(winningNumbers.get(i + 1))) < 0) {
                    namesAfterSort.add(weightAndNames.get(winningNumbers.get(i)));
                } else if (weightAndNames.get(winningNumbers.get(i)).compareTo(weightAndNames.get(winningNumbers.get(i + 1))) > 0) {
                    namesAfterSort.add(weightAndNames.get(winningNumbers.get(i + 1)));
                } else {
                    namesAfterSort.add(weightAndNames.get(winningNumbers.get(i)));
                }
                if (i < winningNumbers.size() - 2) i++;
            } else {
                namesAfterSort.add(weightAndNames.get(winningNumbers.get(i)));
            }
        }

        return namesAfterSort.get(n - 1);
    }

    private static String songDecoder(String song) {
        if (song.length() > 200) return "";
        return song.replaceAll("WUB", " ").replaceAll("  ", " ").replaceAll("  ", " ").trim();
    }

    private static double antiDiagonal(int[][] ints) {
        double sum = 0.00;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                if (i + j == ints.length - 1) {
                    sum += ints[i][j];
                }
            }
        }
        return sum / ints.length;
    }

    private static double posAverage(String s) {
        String[] arr = s.split(", ");
        double counter = 0;
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1; i++) {
            char[] charArr1 = arr[i].toCharArray();
            for (int j = 0; j < arr.length; j++) {
                if (i == j) continue;
                char[] charArr2 = arr[j].toCharArray();
                for (int k = 0; k < charArr1.length; k++) {
                    if (charArr1[k] == charArr2[k]) counter++;
                }
            }
        }

        long len = Arrays.stream(arr).collect(Collectors.joining()).length();
        System.out.println(len);
        System.out.println(counter);

        return counter / len;
    }


    private static int[] computeRanks(int i, int[][] ints) {
        if (Arrays.deepToString(ints).isEmpty()) return new int[0];

        List<Team> allTeams = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            allTeams.add(new Team(j));
        }

        return new int[0];
    }

    private static double uniqueAvg(int[][] ints) {
        if (Arrays.deepToString(ints).isEmpty()) return 0.00;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                list.add(ints[i][j]);
            }
        }
        int[] arr = Arrays.stream(ints).flatMapToInt(IntStream::of).toArray();
        System.out.println(Arrays.toString(arr));
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int counter = 0;
            for (int j = 0; j < list.size(); j++) {
                if (i == j) continue;
                if (list.get(i).equals(list.get(j))) counter++;
            }
            if (counter == 0) list2.add(list.get(i));
        }
        double size = list2.size();
        double total = list2.stream().reduce(0, Integer::sum);
        return total / size;
    }

    private static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
        double lossIncrease = 0.5;
        int months = 0;
        double moneyLeft = 0;
        double priceOld = startPriceOld;
        double priceNew = startPriceNew;
        double savings = 0;

        while ((priceOld + savings) < priceNew) {
            months++;

            if (months % 2 == 0) percentLossByMonth += lossIncrease;

            priceOld = priceOld - priceOld * (percentLossByMonth / 100);
            priceNew = priceNew - priceNew * (percentLossByMonth / 100);
            savings = savings + savingperMonth;
        }

        moneyLeft = (savings + priceOld) - priceNew;

        return new int[]{months, (int) Math.round(moneyLeft)};
    }

    private static String arrange(String strng) {
        String[] arr = strng.split(" ");

        if (arr[0].length() > arr[1].length()) {
            String hold1 = arr[0];
            String hold2 = arr[1];
            arr[0] = hold2;
            arr[1] = hold1;
        }

        if (arr[1].length() < arr[2].length()) {
            String hold1 = arr[1];
            String hold2 = arr[2];
            arr[1] = hold2;
            arr[2] = hold1;
        }

        for (int i = 2; i < arr.length - 1; i++) {
            if (i % 2 == 0) {
                String hold1 = arr[i];
                String hold2 = arr[i + 1];
                arr[i] = hold2;
                arr[i + 1] = hold1;
            }
            if (i % 2 != 0) {
                String hold1 = arr[i];
                String hold2 = arr[i + 1];
                arr[i] = hold2;
                arr[i + 1] = hold1;
            }
        }

        return String.join(" ", arr).trim();
    }

    private static String longestConsec(String[] strings, int i) {
        if (strings.length == 0 || i > strings.length || i <= 0) return "";
        if (strings.length == i) return String.join("", strings);

        StringBuilder result = new StringBuilder();

        for (int j = 0; j <= strings.length - i; j++) {
            StringBuilder interim = new StringBuilder();
            for (int k = j; k < j + i; k++) {
                interim.append(strings[k]);
                if (interim.length() > result.length()) result = interim;
            }
        }
        return result.toString();
    }

    //https://www.codewars.com/kata/55a5c82cd8e9baa49000004c/train/java
    private static long divisibleCount(long x, long y, long k) {
        if (x % k == 0) return (y / k - x / k + 1);
        else return (y / k - x / k);
    }

    private static String balance(String b1) {
        DecimalFormat df2 = new DecimalFormat("#.##");
        String str2 = b1.replaceAll("\n", "  ").replaceAll("[^. a-zA-Z0-9]", "");
        System.out.println(str2);
        String[] arr = str2.split("  ");
        System.out.println(Arrays.toString(arr));
        double spent = Math.round((Arrays.stream(arr).skip(1).map(each -> each.substring(each.lastIndexOf(" "))).map(Double::valueOf).reduce(0.0, Double::sum) * 100) / 100);
        double start = Double.parseDouble(arr[0].substring(0));
        double averageExpense = Math.round((spent / (arr.length - 1) * 100) / 100);
        double currentBalance = start;

        StringBuilder result = new StringBuilder();
        result.append(arr[0]).append("\r\n");
        for (int i = 1; i < arr.length; i++) {
            double currentSpent = Double.parseDouble(arr[i].substring(arr[i].lastIndexOf(" ")));
            currentBalance -= currentSpent;
            result.append(arr[i]).append(" ").append(currentBalance).append("\r\n");
        }
        result.append("Total expense ").append(spent).append("\r\n");
        result.append("Average expense ").append(averageExpense);
        return result.toString();
    }

  /*private static String decode(String str) {
    StringBuilder result = new StringBuilder();

    long digitCount = MyArrays.stream(str.split("")).filter(each -> Character.isDigit(each.charAt(0))).count();

    int numberFromStr = Integer.parseInt(str.substring(0, 7));
    String core = str.substring(7);
    char[] arr = core.toCharArray();

    if (numberFromStr < 26) return "Impossible to decode";

    for (int i = numberFromStr; i < arr.length; i++) {
      int var1 = (int) (arr[i] - 41);
      int var2 = numberFromStr % 26;
      result.append();
    }

    return result.toString();
  }*/

    private static long[] gap(int g, int m, int n) {
        BigInteger f = new BigInteger("" + m);
        BigInteger l = f.nextProbablePrime();
        if (!f.isProbablePrime(1))
            f = l;
        long i = 0, j = 0;
        while (j <= n) {
            j = l.longValue();
            i = f.longValue();
            if (j - i == g)
                return new long[]{i, j};
            f = l;
            l = f.nextProbablePrime();
        }
        return null;
    }

    private static List<String> sortArrayLetterEFirst(String[] strings) {
        return Arrays.stream(strings).sorted(Comparator.comparingInt(a -> (a.contains("E") || a.contains("e") ? 0 : 1))).collect(Collectors.toList());
    }

    private static List<String> sortArrayByFirstLetter(String[] strings) {
        return Arrays.stream(strings).sorted(Comparator.comparing(each -> each.charAt(0))).collect(Collectors.toList());
    }

    private static List<String> sortArrayReversed(String[] strings) {
        return Arrays.stream(strings).sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
    }

    private static List<String> sortArray(String[] strings) {
        return Arrays.stream(strings).sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
    }

    private static String temperatures(List<Integer> asList, int n) {
        List<Integer> result = new ArrayList();
        if (n == 0) return String.valueOf(0);

        for (int i = 0; i < n; i++) {
            if (asList.get(i) > 5526 || asList.get(i) < -273) continue;
            if (result.contains(asList.get(i))) continue;
            if (result.isEmpty()) {
                result.add(asList.get(i));
            } else {
                if (Math.abs(result.get(0)) > Math.abs(asList.get(i))) {
                    result.set(0, asList.get(i));
                } else if ((Math.abs(result.get(0)) == Math.abs(asList.get(i))) && (result.get(0) > 0 && asList.get(i) < 0)) {
                    result.add(asList.get(i));
                } else if ((Math.abs(result.get(0)) == Math.abs(asList.get(i))) && (result.get(0) < 0 && asList.get(i) > 0)) {
                    result.add(asList.get(i));
                }
            }
        }
        return String.valueOf(Collections.max(result));
    }

    private static String stringer(List<Integer> asList) {
        return asList.stream().map(each -> each % 2 == 0 ? "e" + each : "o" + each).collect(Collectors.joining(",")).trim();
    }

    private static String namesToString(List<Person> people) {
        return "Names: " + people.stream().map(Person::getName).collect(Collectors.joining(",")).trim() + ".";
    }

    private static Map<String, List<Person>> groupByNationality(List<Person> people) {
        return people.stream().collect(Collectors.groupingBy(Person::getNationality));
    }

    private static List<Integer> filter(int[] ints) {
        List<Integer> result = new ArrayList<>();
        int zeroCounter = 0;
        for (int each : ints) {
            if (each != 0 && zeroCounter == 0) result.add(each);
            if (each == 0 && (zeroCounter == 0 || zeroCounter == 1)) zeroCounter++;
            if (each == 0 && zeroCounter == 2) zeroCounter = 0;
        }
        return result;
    }

    private static List<List<Integer>> invalidTriangle(int[][] ints) {

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            if (ints[i].length != 3) continue;
            int max = Arrays.stream(ints[i]).max().orElse(0);
            int sum = Arrays.stream(ints[i]).sum();
            if (sum - max > max) {
                result.add(Arrays.stream(ints[i]).boxed().collect(Collectors.toList()));
            }
        }
        return result;
    }

    private static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
        return people.stream().collect(Collectors.partitioningBy(s -> s.getAge() > 18));
    }

    private static Set<String> getKidNames(List<Person> people) {
        return people.stream().filter(each -> each.getAge() < 18).map(Person::getName).collect(Collectors.toSet());
    }

    private static int calculate(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    private static Person getOldestPerson(List<Person> people) {
        return people.stream().max(Comparator.comparing(Person::getAge)).orElse(null);
    }

    private static List<String> transformShouldFlattenCollection(List<List<String>> collection) {
        return collection.stream().flatMap(Collection::stream).collect(Collectors.toList());

    }

    private static int getTotalNumberOfLettersOfNamesLongerThanFive(String[] names) {
        return Arrays.stream(names).filter(each -> each.length() > 5).mapToInt(String::length).sum();
    }

    private static Collection<String> mapToUppercase(String[] names) {
        return Arrays.stream(names).map(String::toUpperCase).collect(Collectors.toList());
    }

    private static String encryptThis(String hello) {
        if (hello.isEmpty()) return "";
        String[] arr = hello.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            StringBuilder word = new StringBuilder();
            if (arr[i].length() > 2) {
                word.append((int) arr[i].charAt(0));
                word.append(arr[i].substring(arr[i].length() - 1));
                word.append(arr[i], 2, arr[i].length() - 1);
                word.append(arr[i].charAt(1));
            } else {
                String secondLetter = arr[i].substring(1);
                word.append((int) arr[i].charAt(0));
                word.append(secondLetter);
            }
            word.append(" ");
            result.append(word);
        }

        return result.substring(0, result.length() - 1);
    }

    private static String[] zipMerge(String[] strings, String[] strings1) {
        String[] result = new String[strings.length + strings1.length];
        int longer = 0;
        int shorter = 0;

        List<String> longerArr = new ArrayList<>();
        if (strings.length > strings1.length) {
            longer = strings.length;
            shorter = strings1.length;
            longerArr = Arrays.asList(strings);
        }
        if (strings.length <= strings1.length) {
            longer = strings1.length;
            shorter = strings.length;
            longerArr = Arrays.asList(strings1);
        }

        int resultIndex = 0;
        for (int i = 0; i < longer; i++) {
            if (i < shorter) {
                result[resultIndex] = strings[i];
                result[resultIndex + 1] = strings1[i];
                resultIndex += 2;
            } else {
                result[resultIndex] = longerArr.get(i);
                resultIndex++;
            }
        }
        return result;
    }

    private static int closestDistance(int[] ints) {

        if (ints.length < 2) return -1;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < ints.length - 1; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                int interim = ints[i] - ints[j];
                if (interim < 0) interim *= (-1);
                if (interim < result) result = interim;
            }
        }
        return result;
    }



  /*Zip array merge
  mergeElements(["apple", "pear"], ["dog", "cat"]);
  Should return:
          ["apple", "dog", "pear", "cat"]
  Example 2:
  mergeElements(["apple", "pear", "banana", "orange"], ["dog", "cat"]);
  Should return:
          ["apple", "dog", "pear", "cat", "banana", "orange"]*/

    private static int[][] chunk(int[] array, int chunkSize) {
        //decide number of rows
        int rows;
        if (array.length % chunkSize != 0) {
            rows = array.length / chunkSize + 1;
        } else {
            rows = array.length / chunkSize;
        }

        int[][] result = new int[rows][chunkSize];
        //decide the size of the last array
        int baseIndex = 0;
        for (int i = 0; i < rows; i++) {
            int col = 0;
            if (baseIndex > array.length - baseIndex && array.length % chunkSize != 0) {
                result[i] = new int[array.length % chunkSize];
                for (int j = baseIndex; j < baseIndex + array.length % chunkSize; j++) {
                    result[i][col] = array[j];
                    col++;
                }
            } else {
                for (int j = baseIndex; j < baseIndex + chunkSize; j++) {
                    result[i][col] = array[j];
                    col++;
                }
            }
            baseIndex += chunkSize;
        }

        return result;
    }

    private static int[] sumParts(int[] ints) {
        int[] result = new int[ints.length + 1];
        int sum = Arrays.stream(ints).sum();
        result[0] = sum;
        for (int i = 1; i < ints.length + 1; i++) {
            sum -= ints[i - 1];
            result[i] = sum;
        }
        return result;
    }

  /*public static String stat(String str) {
    String result = "";
    LocalDateTime range;
    LocalDateTime average;
    LocalDateTime median;

    str = str.replaceAll("|", ":");
    List<String> strings = MyArrays.asList(str.split(","));
    DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");

    List<LocalDateTime> list = strings.stream().map(each -> LocalDateTime.parse(each, format)).collect(Collectors.toList());

    LocalDateTime min = list.stream().min(LocalDateTime::compareTo).orElse(null);
    LocalDateTime max = list.stream().max(LocalDateTime::compareTo).orElse(null);
    Clock sum =
    for (int i = 0; i < list.size(); i++) {
      sum+= list.get(i);
    }

    Duration duration = Duration.between(max,min);

    return result;
  }*/

    public static double findUniq(double arr[]) {
        Map<Double, Integer> map = new HashMap<>();
        for (double each : arr) {
            if (map.containsKey(each)) {
                map.put(each, map.get(each) + 1);
            } else {
                map.put(each, 1);
            }
        }

        for (Map.Entry keys : map.entrySet()) {
            if (keys.getValue().equals(1)) {
                return (double) keys.getKey();
            }
        }
        return -1;
    }

    public static int findIt(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int each : a) {
            if (map.containsKey(each)) {
                map.put(each, map.get(each) + 1);
            } else {
                map.put(each, 1);
            }
        }

        for (Map.Entry each2 : map.entrySet()) {
            if ((int) each2.getValue() % 2 != 0) return (int) each2.getKey();
        }

        return 0;
    }

    public static boolean isAValidMessage(String message) {

        if (message.isEmpty()) return true;
        if (message.length() == 1 && !Character.isDigit(message.charAt(0))) return false;
        if (message.length() == 1 && Character.isDigit(message.charAt(0))) return true;
        if (!Character.isDigit(message.charAt(0))) return false;


        List<String> l3 = Stream.of(message.replaceAll("\\D", " ").split(" ")).collect(Collectors.toList());
        List<String> l4 = Stream.of(message.split("[0-9]")).collect(Collectors.toList());
        List<String> l5 = new ArrayList<>();
        List<String> l6 = new ArrayList<>();

        for (String each : l4) {
            each.replaceAll(" ", "");
            if (!each.equals("")) l5.add(each);
        }

        for (String each : l3) {
            each.replaceAll(" ", "");
            if (!each.equals("")) l6.add(each);
        }

        System.out.println(l5);
        System.out.println(l6);

        if (l5.size() != l6.size()) return false;

        for (int i = 0; i < l5.size(); i++) {
            if (Integer.parseInt(l6.get(i)) != l5.get(i).length()) return false;

        }
        return true;
    }

    public static HashMap<String, Integer> method3(int cent) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Pennies", 0);
        map.put("Nickels", 0);
        map.put("Dimes", 0);
        map.put("Quarters", 0);

        int remainder = cent;
        List<Integer> numbers = Arrays.asList(25, 10, 5, 1);
        List<String> names = Arrays.asList("Quarters", "Dimes", "Nickels", "Pennies");

        if (cent <= 0) {
            return map;
        } else {
            for (int i = 0; i < numbers.size(); i++) {
                if (remainder / numbers.get(i) >= 1) {
                    map.put(names.get(i), remainder / numbers.get(i));
                    remainder = remainder % numbers.get(i);
                }
                if (remainder == 0) break;
            }
        }
        return map;
    }

    public static String method2() {
        String regex = "He12345llo";
        //return regex.replaceAll("\\main.java.D", "");
        //return regex.replaceAll("[^a-zA-Z]", "");
        //return regex.replaceAll("[a-zA-Z]", "");
        //return regex.replaceAll("[a-lA-L]", "");
        //return regex.replaceAll("\\main.java.D", ""); //Any non-digit, short for [^0-9]
        //return regex.replaceAll("\\d", ""); //Any digits, short of [0-9]
        return regex.replaceAll("\\s", ""); //Any whitespace character, short for [\t\n\x0B\f\r]

    }

    public static String method(String input) {
        if (input.length() == 0) return input;

        List<String> list = Arrays.asList(input.split(" ").clone());
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return extractInt(o1) - extractInt(o2);
            }

            int extractInt(String s) {
                String num = s.replaceAll("\\D", "");
                // return 0 if no digits found
                return num.isEmpty() ? 0 : Integer.parseInt(num);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) + " ");
        }

        return sb.toString().trim();
    }

    static class Team {
        private int team;
        private int gave;
        private int received;
        private int gd;
        private int points;

        public Team(int team) {
            this.team = team;
        }

        public Team(int team, int gave, int received, int gd, int points) {
            this.team = team;
            this.gave = gave;
            this.received = received;
            this.gd = gd;
            this.points = points;
        }

        public int getTeam() {
            return team;
        }

        public void setTeam(int team) {
            this.team = team;
        }

        public int getGave() {
            return gave;
        }

        public void setGave(int gave) {
            this.gave = gave;
        }

        public int getReceived() {
            return received;
        }

        public void setReceived(int received) {
            this.received = received;
        }

        public int getGd() {
            return gd;
        }

        public void setGd(int gd) {
            this.gd = gd;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }
    }

    /*public static void main(String[] args) {
     *//*"coffee", "eecoff" => 2
    "eecoff", "coffee" => 4
    "moose", "Moose" => -1
    "isn't", "'tisn" => 2
    "Esham", "Esham" => 0
    "dog", "god" => -1*//*

    String str1 = "coffee";
    String str2 = "eecoff";
    str1 = str1.replaceAll(
            "[^a-zA-Z]", "");
    str2 = str2.replaceAll(
            "[^a-zA-Z]", "");
    int result = 0;

    if (str1.length() != str2.length()) {
      result = -1;
    }
    if (str1.length() == str2.length()) {

      char[] arr1 = str1.toCharArray();
      char[] arr2 = str2.toCharArray();

      for (int i = 0; i < arr1.length; i++) {
        if (arr1[i] != arr2[i]) {
          result++;
        }
      }
    }

    System.out.println(result);
  }*/

  /*public static void main(String[] args) {
    //[(ARNO, ANN)(BELL, JOHN)(CORNWELL, ALEX)(DORNY, ABBA)(KERN, LEWIS)(KORN, ALEX)(META, GRACE)(SCHWARZ, VICTORIA)(STAN, MADISON)(STAN, MEGAN)(WAHL, ALEXIS)]
    String start = "Alexis:Wahl;John:Bell;Victoria:Schwarz;Abba:Dorny;Grace:Meta;Ann:Arno;Madison:STAN;Alex:Cornwell;Lewis:Kern;Megan:Stan;Alex:Korn";
    String[] arr = start.toUpperCase().replaceAll(":", " ").split(";");

    for (int i = 0; i < arr.length; i++) {
      String str = arr[i];
      arr[i] = "(" + str.substring(str.indexOf(" ") + 1) + ", " + str.substring(0, str.indexOf(" ")) + ")";
    }
    MyArrays.sort(arr);
    String result2 = "";
    for (String each: arr){
      result2 += each;
    }
    System.out.println(result2);
  }*/

  /*public static void main(String[] args) {
    String s = "<prod><name>drill</name><prx>99</prx><qty>5</qty></prod>\n\n" +
            "<prod><name>hammer</name><prx>10</prx><qty>50</qty></prod>\n\n" +
            "<prod><name>screwdriver</name><prx>5</prx><qty>51</qty></prod>\n\n" +
            "<prod><name>table saw</name><prx>1099.99</prx><qty>5</qty></prod>\n\n" +
            "<prod><name>saw</name><prx>9</prx><qty>10</qty></prod>\n\n" +
            "<prod><name>chair</name><prx>100</prx><qty>20</qty></prod>\n\n" +
            "<prod><name>fan</name><prx>50</prx><qty>8</qty></prod>\n\n" +
            "<prod><name>wire</name><prx>10.8</prx><qty>15</qty></prod>\n\n" +
            "<prod><name>battery</name><prx>150</prx><qty>12</qty></prod>\n\n" +
            "<prod><name>pallet</name><prx>10</prx><qty>50</qty></prod>\n\n" +
            "<prod><name>wheel</name><prx>8.80</prx><qty>32</qty></prod>\n\n" +
            "<prod><name>extractor</name><prx>105</prx><qty>17</qty></prod>\n\n" +
            "<prod><name>bumper</name><prx>150</prx><qty>3</qty></prod>\n\n" +
            "<prod><name>ladder</name><prx>112</prx><qty>12</qty></prod>\n\n" +
            "<prod><name>hoist</name><prx>13.80</prx><qty>32</qty></prod>\n\n" +
            "<prod><name>platform</name><prx>65</prx><qty>21</qty></prod>\n\n" +
            "<prod><name>car wheel</name><prx>505</prx><qty>7</qty></prod>\n\n" +
            "<prod><name>bicycle wheel</name><prx>150</prx><qty>11</qty></prod>\n\n" +
            "<prod><name>big hammer</name><prx>18</prx><qty>12</qty></prod>\n\n" +
            "<prod><name>saw for metal</name><prx>13.80</prx><qty>32</qty></prod>\n\n" +
            "<prod><name>wood pallet</name><prx>65</prx><qty>21</qty></prod>\n\n" +
            "<prod><name>circular fan</name><prx>80</prx><qty>8</qty></prod>\n\n" +
            "<prod><name>exhaust fan</name><prx>62</prx><qty>8</qty></prod>\n\n" +
            "<prod><name>cattle prod</name><prx>990</prx><qty>2</qty></prod>\n\n" +
            "<prod><name>window fan</name><prx>62</prx><qty>8</qty></prod>";
    String[] arr = s.replaceAll("<prod><name>", "").replaceAll("(</qty></prod>)", "").split("\n\n");
    String article = "saw";
    String result = "";
    int counter = 1;
    for (String each : arr){
      if (each.contains(article)) {
        if (counter > 1){
          result += "\n";
        }
        result += each.substring(0, each.indexOf("</name>")) +
                " > prx: $" + each.substring(each.indexOf("<prx>") + 5, each.indexOf("</prx>")) +
                " qty: " + each.substring(each.indexOf("<qty>") + 5);
        counter++;
      }
    }
    if (result.equals("")) result = "Nothing";
    System.out.println(result);
  }*/
}
