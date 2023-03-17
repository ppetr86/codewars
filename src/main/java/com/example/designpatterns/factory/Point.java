package com.example.designpatterns.factory;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class Point {

    AtomicInteger i = new AtomicInteger(0);

    private double x, y;

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static class Factory {
        public static Point newCartesianPoint(double x, double y) {
            return new Point(x, y);
        }

        public static Point newPolarPoint(double rho, double theta) {
            return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
        }
    }
}

class Demo {
    public static void main(String[] args) {
        var point = Point.Factory.newCartesianPoint(10, 20);
    }
}