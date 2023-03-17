package com.example.graphtraversals.astar;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private final DemoPanel dp;

    public KeyHandler(DemoPanel dp) {
        this.dp = dp;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
        if (code == KeyEvent.VK_ENTER) {
            //dp.search();
            dp.autoSearch();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
