package com.example.codewars3.codewars.kyu5;
//https://www.codewars.com/kata/58e18c5434a3022d270000f2/train/java

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RoadKill {

    public static void main(String[] args) {
        System.out.println(roadKill("==========h===yyyyyy===eeee=n==a========"));
    }

    static String roadKill(final String photo) {

        // Your code here!
        List<String> animals = Arrays.asList("aardvark", "alligator", "armadillo", "antelope", "baboon", "bear", "bobcat", "butterfly",
                "cat", "camel", "cow", "chameleon", "dog", "dolphin", "duck", "dragonfly", "eagle", "elephant", "emu", "echidna",
                "fish", "frog", "flamingo", "fox", "goat", "giraffe", "gibbon", "gecko", "hyena", "hippopotamus", "horse", "hamster", "insect", "impala",
                "iguana", "ibis", "jackal", "jaguar", "jellyfish", "kangaroo", "kiwi", "koala", "killerwhale", "lemur", "leopard", "llama", "lion", "monkey",
                "mouse", "moose", "meercat", "numbat", "newt", "ostrich", "otter", "octopus", "orangutan", "penguin", "panther", "parrot", "pig", "quail",
                "quokka", "quoll", "rat", "rhinoceros", "racoon", "reindeer", "rabbit", "snake", "squirrel", "sheep", "seal", "turtle", "tiger", "turkey",
                "tapir", "unicorn", "vampirebat", "vulture", "wombat", "walrus", "wildebeast", "wallaby", "yak", "zebra");

        String input = photo.replaceAll("=", "");
        String inputreversed = new StringBuilder(input).reverse().toString();

        String inputDisct = Arrays.stream(input.split("")).distinct().collect(Collectors.joining());
        String inputReversedDisct = Arrays.stream(inputreversed.split("")).distinct().collect(Collectors.joining());

        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).length() > input.length()) continue;

            if (inputDisct.equals(animals.get(i)) || inputReversedDisct.equals(animals.get(i))) return animals.get(i);
        }

        return "??";
    }

}