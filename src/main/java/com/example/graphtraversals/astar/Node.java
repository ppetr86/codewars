package com.example.graphtraversals.astar;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Node extends JButton implements ActionListener {

    Node parent;
    int col;
    int row;
    int gCost; // distance between current and start
    int hCost; // distance between current and goal
    int fCost; // sum of gCost + hCost
    boolean start;
    boolean goal;
    boolean solid;
    boolean open;
    boolean checked;

    public Node(int col, int row) {
        this.col = col;
        this.row = row;
        setBackground(Color.white);
        setForeground(Color.black);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setBackground(Color.orange);
    }

    @Override
    public Node getParent() {
        return parent;
    }


    public void setAsChecked() {
        if (!start && !goal) {
            setBackground(Color.orange);
            setForeground(Color.black);
        }
        checked = true;
    }

    public void setAsGoal() {
        setBackground(Color.yellow);
        setForeground(Color.black);
        setText("GOAL");
        goal = true;
    }

    public void setAsOpen() {
        open = true;
    }

    public void setAsPath() {
        setBackground(Color.green);
        setForeground(Color.black);
    }

    public void setAsSolid() {
        setBackground(Color.black);
        setForeground(Color.black);
        solid = true;
    }

    public void setAsStart() {
        setBackground(Color.blue);
        setForeground(Color.white);
        setText("START");
        start = true;
    }


}
