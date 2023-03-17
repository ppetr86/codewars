package com.example.graphtraversals.astar;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DemoPanel extends JPanel {

    //screen settings
    final int maxCol = 15;
    final int maxRow = 10;
    final int nodeSize = 70;
    final int screenWidth = nodeSize * maxCol;
    final int screenHeight = nodeSize * maxRow;

    // NODE
    Node[][] node = new Node[maxRow][maxCol];
    Node startNode, goalNode, currentNode;
    ArrayList<Node> openList = new ArrayList<>();
    ArrayList<Node> checkedList = new ArrayList<>();

    //others
    boolean goalReached = false;
    private int step;

    public DemoPanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setLayout(new GridLayout(maxRow, maxCol));

        this.addKeyListener(new KeyHandler(this));
        this.setFocusable(true);

        //place nodes
        int col = 0;
        int row = 0;

        while (col < maxCol && row < maxRow) {
            node[row][col] = new Node(col, row);
            this.add(node[row][col]);
            col++;
            if (col == maxCol) {
                col = 0;
                row++;
            }
        }

        //set start and goal node
        setStartNode(3, 6);
        setGoalNode(11, 3);

        //place solid nodes
        setSolidNode(10, 2);
        setSolidNode(10, 3);
        setSolidNode(10, 4);
        setSolidNode(10, 5);
        setSolidNode(10, 6);
        setSolidNode(10, 7);

        setSolidNode(6, 2);
        setSolidNode(7, 2);
        setSolidNode(8, 2);
        setSolidNode(9, 2);

        setSolidNode(11, 7);
        setSolidNode(12, 7);

        setSolidNode(6, 1);

        //set cost on nodes
        setCostOnNodes();


    }

    public void autoSearch() {
        while (!goalReached && step++ < 300) {
            int col = currentNode.col;
            int row = currentNode.row;

            currentNode.setAsChecked();
            checkedList.add(currentNode);
            openList.remove(currentNode);

            // open the up node
            if (row - 1 >= 0)
                openNode(node[row - 1][col]);

            if (row + 1 < maxRow)
                openNode(node[row + 1][col]);

            if (col + 1 < maxCol)
                openNode(node[row][col + 1]);

            if (col - 1 >= 0)
                openNode(node[row][col - 1]);

            //find the best node
            int bestNodeIndex = 0;
            int bestNodeFCost = Integer.MAX_VALUE;

            for (int i = 0; i < openList.size(); i++) {
                //check if the nodes fcost ist better
                if (openList.get(i).fCost < bestNodeFCost) {
                    bestNodeIndex = i;
                    bestNodeFCost = openList.get(i).fCost;
                }

                //if f cost is equal use g cost
                else if (openList.get(i).fCost == bestNodeFCost) {
                    if (openList.get(i).gCost < openList.get(bestNodeIndex).gCost) {
                        bestNodeIndex = i;

                    }
                }
            }

            // after the loop we get the best node which is our next step
            currentNode = openList.get(bestNodeIndex);
            if (currentNode == goalNode) {
                goalReached = true;
                trackThePath();
            }
        }
    }

    public void search() {
        if (!goalReached) {
            int col = currentNode.col;
            int row = currentNode.row;

            currentNode.setAsChecked();
            checkedList.add(currentNode);
            openList.remove(currentNode);

            // open the up node
            if (row - 1 >= 0) openNode(node[row - 1][col]);
            if (row + 1 < maxRow) openNode(node[row + 1][col]);
            if (col + 1 < maxCol) openNode(node[row][col + 1]);
            if (col - 1 >= 0) openNode(node[row][col - 1]);

            //find the best node
            int bestNodeIndex = 0;
            int bestNodeFCost = Integer.MAX_VALUE;

            for (int i = 0; i < openList.size(); i++) {
                //check if the nodes fcost ist better
                if (openList.get(i).fCost < bestNodeFCost) {
                    bestNodeIndex = i;
                    bestNodeFCost = openList.get(i).fCost;
                }

                //if f cost is equal use g cost
                else if (openList.get(i).fCost == bestNodeFCost) {
                    if (openList.get(i).gCost < openList.get(bestNodeIndex).gCost) {
                        bestNodeIndex = i;

                    }
                }
            }

            // after the loop we get the best node which is our next step
            currentNode = openList.get(bestNodeIndex);
            if (currentNode == goalNode) goalReached = true;

        }
    }

    private void getCost(Node node) {

        //G Cost
        int xDistance = Math.abs(node.col - startNode.col);
        int yDistance = Math.abs(node.row - startNode.row);
        node.gCost = xDistance + yDistance;

        //H Cost
        xDistance = Math.abs(node.col - goalNode.col);
        yDistance = Math.abs(node.row - goalNode.row);
        node.hCost = xDistance + yDistance;

        node.fCost = node.gCost + node.hCost;

        if (node != startNode && node != goalNode) {
            node.setText("<html>F:" + node.fCost + "<br>G:" + node.gCost + "</html>");
        }

    }

    private void openNode(Node node) {
        if (!node.open && !node.checked && !node.solid) {
            node.setAsOpen();
            node.parent = currentNode;
            openList.add(node);
        }
    }

    private void setCostOnNodes() {
        int col = 0;
        int row = 0;
        while (col < maxCol && row < maxRow) {
            getCost(node[row][col]);
            col++;
            if (col == maxCol) {
                col = 0;
                row++;
            }
        }
    }

    private void setGoalNode(int col, int row) {
        node[row][col].setAsGoal();
        goalNode = node[row][col];
    }

    private void setSolidNode(int col, int row) {
        node[row][col].setAsSolid();
    }

    private void setStartNode(int col, int row) {
        node[row][col].setAsStart();
        startNode = node[row][col];
        currentNode = startNode;
    }

    private void trackThePath() {
        //backtrack and draw the best path
        Node current = goalNode;

        while (!current.equals(startNode)) {
            current = current.parent;
            if (!current.equals(startNode)) {
                current.setAsPath();
            }
        }
    }
}
