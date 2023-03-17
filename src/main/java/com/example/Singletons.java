package com.example;

// Singleton with public final field
public class Singletons {
    // Singleton with public final field
    static class Elvis {
        private static final Elvis INSTANCE = new Elvis();
        private String str;
        private int i;

        private Elvis() {
            this.str = "nothing";
            this.i = 0;
        }

        public void leaveTheBuilding() {
            System.out.println("leaveTheBuilding");
        }

        public static Elvis getInstance() {
            return INSTANCE;
        }
    }

    // Noninstantiable utility class
    static class UtilityClass {
        // Suppress default constructor for noninstantiability
        private UtilityClass() {
            throw new AssertionError();
        }
        // Remainder omitted
    }

    enum ElvisEnum implements Walkable {
        INSTANCE;

        public void leaveTheBuilding() {
            System.out.println("leaveTheBuilding");
        }

        @Override
        public void walk() {
            System.out.println("walking instance");
        }
    }

    interface Walkable {
        void walk();
    }

    public static void main(String[] args) {
        ElvisEnum.INSTANCE.walk();
    }
}