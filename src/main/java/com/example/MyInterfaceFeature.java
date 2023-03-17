package com.example;

import java.util.Random;

public interface MyInterfaceFeature {

    MyInterfaceFeature DEACTIVATED = new MyInterfaceFeature() {
        @Override
        public void printMyMoodToConsole() {
            System.out.println("NOT POSSIBLE WHEN DEACTIVATED");
        }

        @Override
        public String setActivated() {
            return "NOT POSSIBLE TO ACTIVATE DEACTIVATED VERSION";
        }

        @Override
        public String toString() {
            System.out.println("DEACTIVATED");
            return "DEACTIVATED";
        }
    };


    void printMyMoodToConsole();


    String setActivated();


    static MyInterfaceFeature create(String settings) {
        return "active".equalsIgnoreCase(settings) ? createActive("Activate me") : DEACTIVATED;
    }


    static MyInterfaceFeature createActive(String param1) {
        System.out.println("Accepting param1: " + param1);

        return new MyInterfaceFeature() {
            @Override
            public void printMyMoodToConsole() {
                var randomNumber = new Random().nextInt(3);

                switch (randomNumber) {
                    case 0 -> System.out.println("WE HAVE SEEN BETTER");
                    case 1 -> System.out.println("NOT GREAT NOT TERRIBLE");
                    case 2 -> System.out.println("EVERYTHING IS FINE WHEN THERE IS SUNSHINE");
                }
            }

            @Override
            public String setActivated() {
                return "ACTIVATED";
            }
        };
    }


    public static void main(String[] args) {
        final var myFeature = MyInterfaceFeature.create("active");
        myFeature.printMyMoodToConsole();
        System.out.println("------------");
        final var myFeature2 = MyInterfaceFeature.create("");
        myFeature2.printMyMoodToConsole();
    }
}
