package com.example.designpatterns.facade;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class Facade {

    public static void main(String[] args) {
        var b = new Buffer(30,20);
        var vp = new Viewport(b, 30,20,0,0);
        var console = new Console(30,20);
        console.addViewPort(vp);
        console.render();
        //all those above will be hidden behind a facade
    }

    private static class Buffer {
        private char[] characters;
        private int lineWidth;

        public Buffer(int lineHeight, int lineWidth) {
            this.lineWidth = lineWidth;
            characters = new char[lineHeight * lineWidth];
        }

        public char charAt(int x, int y) {
            return characters[y * lineWidth + x];
        }
    }

    @AllArgsConstructor
    private static class Viewport {
        private final Buffer buffer;
        private final int width;
        private final int height;
        private final int offsetX;
        private final int offsetY;

        public char charAt(int x, int y) {
            return buffer.charAt(x + offsetX, y + offsetY);
        }
    }

    private static class Console {
        int width, height;
        private List<Viewport> viewports = new ArrayList<>();

        public Console(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public void addViewPort(Viewport viewport) {
            viewports.add(viewport);
        }

        public void render() {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    for (var vp : viewports) {
                        System.out.println(vp);
                    }
                }
            }
        }
    }
}
