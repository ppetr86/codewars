package com.example.playground.threadpool;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void run() {
        try {
            Long duration = (long) (Math.random() * 10) + 5;
            System.out.println("Executing : " + name + ". It will take " + duration + " seconds.");
            TimeUnit.SECONDS.sleep(duration);
            System.out.println(name + " executed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
