package com.example.codewars3;

import java.util.ArrayList;
import java.util.Iterator;

public class ConcurrentModiDemo extends Thread {

    private static ArrayList<String> list = new ArrayList<String>();

    public static void main(String[] args) {

        ConcurrentModiDemo tchild = new ConcurrentModiDemo();
        list.add("John");
        list.add("Rohn");
        list.add("Tom");
        list.add("Shiva");

        Iterator<String> itr = list.iterator();
        tchild.start();

        while (itr.hasNext()) {
            String name = (String) itr.next();
            System.out.println("Main thread iterating ->" + name);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void run() {
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        list.add("Ganesh");
    }
}

