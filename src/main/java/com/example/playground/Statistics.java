package com.example.playground;

public class Statistics {
    double min, max, mean, count, sum;

    public static Statistics createObject(Statistics current, Integer number) {
        var stat = new Statistics();
        stat.min = Math.min(current.min, number);
        stat.max = Math.max(current.max, number);
        stat.count = current.count++;
        stat.sum = current.sum + number;
        stat.mean = stat.sum / stat.count;
        return stat;
    }
}
