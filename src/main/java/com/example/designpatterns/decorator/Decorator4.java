package com.example.designpatterns.decorator;

public class Decorator4 {

    public static void main(String[] args) {

    }

    private static class Bird {
        public int age;

        public String fly() {
            return age < 10 ? "flying" : "too old";
        }
    }

    private static class Lizard {
        public int age;

        public String crawl() {
            return (age > 1) ? "crawling" : "too young";
        }
    }

    private static class Dragon<T extends Bird, TT extends Lizard> {

        private Bird bird = new Bird();
        private Lizard lizard = new Lizard();
        private int age;

        public String crawl() {
            return lizard.crawl();
        }

        public String fly() {
            return bird.fly();
        }

        public void setAge(int age) {
            this.age = bird.age = lizard.age = age;
        }
    }
}
