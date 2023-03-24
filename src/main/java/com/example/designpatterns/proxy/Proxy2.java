package com.example.designpatterns.proxy;

public class Proxy2 {

    private static class Person {
        private int age;

        public Person(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String drink() {
            return "drinking";
        }

        public String drive() {
            return "driving";
        }

        public String drinkAndDrive() {
            return "driving while drunk";
        }
    }

    private static class ResponsiblePerson {
        private Person person;

        public ResponsiblePerson(Person person) {
            this.person = person;
        }

        public void setAge(int age) {
            this.person.setAge(age);
        }

        public String drink() {
            if (this.person.getAge() < 18)
                return "too young";
            return this.person.drink();
        }

        public String drive() {
            if (this.person.getAge() <= 16)
                return "too young";
            return this.person.drive();
        }

        public String drinkAndDrive() {
            return "dead";
        }
    }
}
