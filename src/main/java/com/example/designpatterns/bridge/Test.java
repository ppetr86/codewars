package com.example.designpatterns.bridge;

interface Renderer {
    public String whatToRenderAs();
}

abstract class Shape {
    public String name;
    private Renderer renderer;

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public String toString() {
        return String.format("Drawing %s as %s", name, renderer.whatToRenderAs());
    }
}

class Triangle extends Shape {
    public Triangle(Renderer renderer) {
        super(renderer);
        name = "Triangle";
    }
}

class Square extends Shape {
    public Square(Renderer renderer) {
        super(renderer);
        name = "Square";
    }
}

class RasterRenderer implements Renderer {

    @Override
    public String whatToRenderAs() {
        return "pixels";
    }
}

class VectorRenderer implements Renderer {
    @Override
    public String whatToRenderAs() {
        return "lines";
    }
}

public class Test {
    public static void main(String[] args) {
        System.out.println(new Square(new VectorRenderer()));
        System.out.println(new Square(new RasterRenderer()));

        System.out.println("+++++");
    }
}
