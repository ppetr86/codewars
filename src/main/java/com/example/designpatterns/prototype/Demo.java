package com.example.designpatterns.prototype;

import lombok.AllArgsConstructor;
import lombok.ToString;

//about cloning of objects/making deep copies
//copy constructor works for small objects...
//alternatively one can serialize and then deserialize an object...
public class Demo {

    @AllArgsConstructor
    @ToString
    static class Address {
        public String streetName, city, country;

        private Address(Address other) {
            this(other.streetName, other.city, other.country);
        }

        public Address deepCopy() {
            return new Address(this);
        }
    }

    @AllArgsConstructor
    @ToString
    static class Employee {
        public String name;
        public Address address;

        private Employee(Employee other) {
            this.name = other.name;
            this.address = new Address(other.address);

        }

        public Employee deepCopy() {
            return new Employee(this);
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        var p = new Employee("John", new Address("London Road", "London", "UK"));
        var copy = new Employee(p);
        System.out.println(p);
        System.out.println(copy);

    }
}
