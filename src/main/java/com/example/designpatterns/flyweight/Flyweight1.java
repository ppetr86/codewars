package com.example.designpatterns.flyweight;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Flyweight1 {

    public static void main(String[] args) {
        var user = new User2("Petr Novotny");
        var user2 = new User2("Daniela Novotna");
        var user3 = new User2("Nina Novotna");

        System.out.println(User2.STRINGS);

        System.out.println(Arrays.toString(user.names));
        System.out.println(Arrays.toString(user2.names));
        System.out.println(Arrays.toString(user3.names));

    }

    @AllArgsConstructor
    private static class User {
        private String name;
    }

    private static class User2 {
        static List<String> STRINGS = new ArrayList<>();
        private int[] names;

        public User2(String fullName) {

            //create a function which will search each letter of name in the STRINGS and
            //if found add in names array
            Function<String, Integer> getOrAdd = (String s) -> {
                int index = STRINGS.indexOf(s);
                if (index != -1)
                    return index;
                else {
                    STRINGS.add(s);
                    return STRINGS.size() - 1;
                }
            };

            names = Arrays.stream(fullName.split(""))
                    .mapToInt(s -> getOrAdd.apply(s))
                    .toArray();
        }
    }
}
