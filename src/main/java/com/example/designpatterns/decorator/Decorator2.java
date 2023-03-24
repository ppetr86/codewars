package com.example.designpatterns.decorator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.function.Supplier;

public class Decorator2 {

    public static void main(String[] args) {
        var circle = new Circle(10);
        System.out.println(circle.info());

        var colored = new ColoredShape(() -> new Square(20), "blue");
        System.out.println(colored.info());

        var transparent = new TransparentShape<>(() -> new ColoredShape<>(() -> new Circle(5), "green"), 50);
        System.out.println(transparent.info());
    }

    private interface Shape {
        String info();
    }

    @AllArgsConstructor
    @NoArgsConstructor
    private static class Circle implements Shape {
        private float radius;

        @Override
        public String info() {
            return null;
        }

        void resize(float factor) {
            this.radius = factor * radius;
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    private static class Square implements Shape {
        private float side;

        @Override
        public String info() {
            return null;
        }

        void resize(float factor) {
            this.side = factor * side;
        }
    }

    private static class ColoredShape<T extends Shape> implements Shape {
        private T shape;
        private String color;

        public ColoredShape(Supplier<? extends T> ctor, String color) {
            shape = ctor.get();
            this.color = color;
        }

        @Override
        public String info() {
            return shape.info() + " has the color " + color;
        }
    }

    private static class TransparentShape<T extends Shape> implements Shape {
        private Shape shape;
        private int transparency;

        public TransparentShape(Supplier<? extends T> ctor, int transparency) {
            shape = ctor.get();
            this.transparency = transparency;
        }

        @Override
        public String info() {
            return shape.info() + " has " + transparency + "% transparancy";
        }
    }
}
