package com.example.codewars3.graphtraversals.astar;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        DemoPanel comp = new DemoPanel();
        window.add(comp);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }
}
