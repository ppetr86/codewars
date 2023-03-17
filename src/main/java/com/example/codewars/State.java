package com.example.codewars;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//https://www.codewars.com/kata/59d0ee709f0cbcf65400003b/train/java
public class State {

  /*public static void main(String[] args) throws ParseException {
    System.out.println(byState("John Daggett, 341 King Road, Plymouth MA\n" +
            "Alice Ford, 22 East Broadway, Richmond VA\n" +
            "Orville Thomas, 11345 Oak Bridge Road, Tulsa OK\n" +
            "Terry Kalkas, 402 Lans Road, Beaver Falls PA\n" +
            "Eric Adams, 20 Post Road, Sudbury MA\n" +
            "Hubert Sims, 328A Brook Road, Roanoke VA\n" +
            "Amy Wilde, 334 Bayshore Pkwy, Mountain View CA\n" +
            "Sal Carpenter, 73 6th Street, Boston MA"));
  }*/

    public static void main(String[] args) throws ParseException {
        System.out.println(byState("John Daggett, 341 King Road, Plymouth MA\n" +
                "Alice Ford, 22 East Broadway, Richmond VA\n" +
                "Sal Carpenter, 73 6th Street, Boston MA"));
    }

    public static String byState(String str) {

        List<String> strings = Arrays.asList(str.trim().split("\n"));

        HashMap<String, String> abbreviations = new HashMap<>();
        abbreviations.put("AZ", "Arizona");
        abbreviations.put("CA", "California");
        abbreviations.put("ID", "Idaho");
        abbreviations.put("IN", "Indiana");
        abbreviations.put("MA", "Massachusetts");
        abbreviations.put("OK", "Oklahoma");
        abbreviations.put("PA", "Pennsylvania");
        abbreviations.put("VA", "Virginia");

        strings = replaceAbbreviationsWithStateNames(strings, abbreviations);

        List<Address> addresses = strings.stream()
                .map(i -> new Address(i.substring(i.lastIndexOf(" ") + 1),
                        i.substring(0, i.indexOf(",")),
                        i.substring(i.indexOf(",") + 2, i.lastIndexOf(" "))))
                .collect(Collectors.toList());

        Map<String, List<Address>> result = addresses.stream().collect(Collectors.groupingBy(Address::getState));
        List<String> keys = result.keySet().stream().sorted().collect(Collectors.toList());
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < keys.size(); i++) {
            if (i > 0) stringBuilder.append("\r\n ");
            stringBuilder.append(keys.get(i));
            List<Address> addresses1 = result.get(keys.get(i))
                    .stream()
                    .sorted(Comparator.comparing(Address::getName))
                    .collect(Collectors.toList());
            addresses1.stream().forEach(item -> stringBuilder.append("\n..... ").append(item.toString()));
        }

        return stringBuilder.toString();
    }

    private static List<String> replaceAbbreviationsWithStateNames(List<String> strings, HashMap<String, String> abbreviations) {
        return strings.stream()
                .map(element -> element.replace(element.substring(element.lastIndexOf(" ") + 1),
                        findReplacement(element.substring(element.lastIndexOf(" ") + 1), abbreviations)))
                .collect(Collectors.toList());
    }

    private static String findReplacement(String substring, HashMap<String, String> abbreviations) {
        return abbreviations.entrySet().stream().filter(x -> x.getKey().equals(substring)).map(Map.Entry::getValue).collect(Collectors.joining());
    }

    public static class Address {
        private String state;
        private String name;
        private String address;

        public Address(String state, String name, String address) {
            this.state = state;
            this.name = name;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public String getState() {
            return state;
        }

        @Override
        public String toString() {
            return name + " " + address.replace(",", "") + " " + state;
        }
    }
}