package com.example.designpatterns.singleton;

import lombok.Getter;
import lombok.Setter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;

public class Demo {


    //not bullet proof because of
    // --reflection
    // --serialization/deserialization
    @Getter
    @Setter
    static class BasicSingleton implements Serializable {
        private String name;
        private static final BasicSingleton INSTANCE = new BasicSingleton();

        private BasicSingleton(String name) {
            this.name = name;
        }

        private BasicSingleton() {
            this.name = "name";
        }

        @Serial
        protected Object readResolve() {
            return INSTANCE;
        }
    }

    static void saveToFile(BasicSingleton singleton, String fileName) throws Exception {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(singleton);
        }
    }

    static BasicSingleton readFromFile(String fileName) throws Exception {
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (BasicSingleton) in.readObject();
        }
    }

    public static void main(String[] args) throws Exception {
        var singleton = BasicSingleton.INSTANCE;
        singleton.setName("111");

        String fileName = "singleton.bin";
        saveToFile(singleton, fileName);

        singleton.setName("222");

        var singleton2 = readFromFile(fileName);

        System.out.println(singleton == singleton2);
        System.out.println(singleton.getName().equals(singleton2.getName()));

    }
}

