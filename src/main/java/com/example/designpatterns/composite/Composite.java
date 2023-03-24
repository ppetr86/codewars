package com.example.designpatterns.composite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Composite {

    public static void main(String[] args) {
        GraphicObject drawing = new GraphicObject();
        drawing.setName("My Drawing");
        drawing.children.add(new Square("Red"));
        drawing.children.add(new Circle("Yellow"));

        GraphicObject group = new GraphicObject();
        group.children.add(new Circle("Blue"));
        group.children.add(new Square("Blue"));
        drawing.children.add(group);

        System.out.println(drawing);
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class GraphicObject {
        public String color;
        public List<GraphicObject> children = new ArrayList<>();
        protected String name = "Group";

        private void print(StringBuilder stringBuilder, int depth) {
            stringBuilder.append(String.join("", Collections.nCopies(depth, "*")))
                    .append(depth > 0 ? " " : "")
                    .append((color == null || color.isEmpty()) ? "" : color + " ")
                    .append(getName())
                    .append(System.lineSeparator());
            for (GraphicObject child : children)
                child.print(stringBuilder, depth + 1);
        }

        @Override
        public String toString() {
            var sb = new StringBuilder();
            print(sb, 0);
            return sb.toString();
        }
    }

    private static class Circle extends GraphicObject {
        public Circle(String color) {
            name = "Circle";
            this.color = color;
        }
    }

    private static class Square extends GraphicObject {
        public Square(String color) {
            name = "Square";
            this.color = color;
        }
    }
}
