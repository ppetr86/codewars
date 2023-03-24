package com.example.designpatterns.decorator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class Decorator1 {

    public static void main(String[] args) {
        var circle = new Circle(10);
        System.out.println(circle.info());

        var colored = new ColoredShape(new Square(20), "blue");
        System.out.println(colored.info());

        var transparent = new TransparentShape(colored, 50);
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

    @AllArgsConstructor
    private static class ColoredShape implements Shape {
        private Shape shape;
        private String color;

        @Override
        public String info() {
            return shape.info() + " has the color " + color;
        }
    }

    @AllArgsConstructor
    private static class TransparentShape implements Shape {
        private Shape shape;
        private int transparency;

        @Override
        public String info() {
            return shape.info() + " has " + transparency + "% transparancy";
        }
    }
}
