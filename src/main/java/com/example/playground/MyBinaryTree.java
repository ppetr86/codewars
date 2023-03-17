package com.example.playground;

import java.util.LinkedList;
import java.util.Queue;

public class MyBinaryTree {

    MyNode root;

    public static void main(String[] args) {
        MyBinaryTree theTree = new MyBinaryTree();

        theTree.addNode(50, "Boss");
        theTree.addNode(25, "Vice President");
        theTree.addNode(15, "Office Manager");
        theTree.addNode(30, "Secretary");
        theTree.addNode(75, "Sales Manager");
        theTree.addNode(85, "Salesman 1");
        theTree.addNode(73, "Salesman 1.1");

        // Different ways to traverse binary trees
        // theTree.inOrderTraverseTree(theTree.root);
        // theTree.preorderTraverseTree(theTree.root);
        // theTree.postOrderTraverseTree(theTree.root);
        // Find the node with key 75

        System.out.println("\nNode with the key 75");
        System.out.println(theTree.findNode(75));

        System.out.println("Remove Key 25");
        theTree.remove(25);
        System.out.println(theTree.findNode(25));
        System.out.println("------------------in order traverse starts------------------");
        theTree.inOrderTraverseTree(theTree.root);

        System.out.println("------------------in level traverse starts------------------");
        theTree.traverseLevelOrder();
    }

    //recursive method for insertion
    private MyNode addRecursive(MyNode current, int key) {
        if (current == null) return new MyNode(key, "Key: " + key);
        if (key < current.key) current.leftChild = addRecursive(current.leftChild, key);
        else if (key > current.key) current.rightChild = addRecursive(current.rightChild, key);
        else return current;
        return current;
    }

    public void add(int key) {
        root = addRecursive(root, key);
    }

    //Breadth-First Search
    // visits all the nodes of a level before going to the next level.
    public void traverseLevelOrder() {
        if (root == null) return;
        Queue<MyNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            //retrieves and removes head of Q
            MyNode node = nodes.remove();
            System.out.println(" " + node.key);

            if (node.leftChild != null) nodes.add(node.leftChild);
            if (node.rightChild != null) nodes.add(node.rightChild);
        }
    }

    public int findSmallestValue(MyNode root) {
        return root.rightChild == null ? root.key : findSmallestValue(root.leftChild);
    }

    public boolean remove(int key) {
        // Start at the top of the tree
        MyNode focusNode = root;
        MyNode parent = root;

        // When searching for a Node this will
        // tell us whether to search to the
        // right or left

        boolean isItALeftChild = true;
        while (focusNode.key != key) {
            parent = focusNode;
            // If we should search to the left
            if (key < focusNode.key) {
                isItALeftChild = true;
                // Shift the focus Node to the left child
                focusNode = focusNode.leftChild;
            } else {
                // Greater than focus node so go to the right
                isItALeftChild = false;
                // Shift the focus Node to the right child
                focusNode = focusNode.rightChild;
            }
            // The node wasn't found
            if (focusNode == null) return false;
        }
        // If Node doesn't have children delete it
        if (focusNode.leftChild == null && focusNode.rightChild == null) {
            // If root delete it
            if (focusNode == null) root = null;
                // If it was marked as a left child
                // of the parent delete it in its parent
            else if (isItALeftChild) parent.leftChild = null;
                // Vice versa for the right child
            else parent.rightChild = null;

        }// If no right child
        else if (focusNode.rightChild == null) {
            if (focusNode == root) root = focusNode.leftChild;
                // If focus Node was on the left of parent
                // move the focus Nodes left child up to the
                // parent node
            else if (isItALeftChild) parent.leftChild = focusNode.leftChild;
                // Vice versa for the right child
            else parent.rightChild = focusNode.rightChild;
        }// If no left child
        else if (focusNode.leftChild == null) {
            if (focusNode == root) root = focusNode.rightChild;
                // If focus Node was on the left of parent
                // move the focus Nodes right child up to the
                // parent node
            else if (isItALeftChild) parent.leftChild = focusNode.rightChild;
                //vice versa for the left child
            else parent.rightChild = focusNode.rightChild;
        }
        // Two children so I need to find the deleted nodes
        // replacement

        else {
            MyNode replacement = getReplacementNode(focusNode);
            // If the focusNode is root replace root
            // with the replacement
            if (focusNode == root)
                root = replacement;

                // If the deleted node was a left child
                // make the replacement the left child

            else if (isItALeftChild)
                parent.leftChild = replacement;

                // Vice versa if it was a right child

            else
                parent.rightChild = replacement;

            replacement.leftChild = focusNode.leftChild;
        }
        return true;
    }

    public MyNode getReplacementNode(MyNode replacedNode) {
        MyNode replacementParent = replacedNode;
        MyNode replacement = replacedNode;
        MyNode focusNode = replacedNode.rightChild;
        //while there are no more left children
        while (focusNode != null) {
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.leftChild;
        }
        // If the replacement isn't the right child
        // move the replacement into the parents
        // leftChild slot and move the replaced nodes
        // right child into the replacements rightChild

        if (replacement != replacedNode.rightChild) {
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }
        return replacement;
    }

    public void addNode(int key, String name) {
        //create a new node and initialize it
        MyNode newNode = new MyNode(key, name);
        // if there is not root, this becomes root
        if (root == null) {
            root = newNode;
        } else {
            // Set root as the Node we will start
            // with as we traverse the tree
            MyNode focusNode = root;
            //future parent for our new MyNode
            MyNode parent;
            while (true) {
                //root is the top parent, so we start there
                parent = focusNode;
                if (key < focusNode.key) {
                    //switch focus to the left child
                    focusNode = focusNode.leftChild;
                    //if the left child has no children
                    if (focusNode == null) {
                        //then place the new node on the left of it
                        parent.leftChild = newNode;
                        return;//all done
                    }
                } else {
                    // if I get here put the node on the right
                    focusNode = focusNode.rightChild;
                    //if the right child has no children
                    if (focusNode == null) {
                        //then place the new node on the right of it
                        parent.rightChild = newNode;
                        return;//all done
                    }
                }
            }
        }
    }

    // All nodes are visited in ascending order
    // Recursion is used to go to one node and
    // then go to its child nodes and so forth
    // this is DFS , it goes as much inside as possible
    public void inOrderTraverseTree(MyNode focusNode) {
        if (focusNode != null) {
            //traverse the left node
            inOrderTraverseTree(focusNode.leftChild);
            //visit the currently focused on node
            System.out.println(focusNode);
            // traverse the right node
            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void preorderTraverseTree(MyNode focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);
            preorderTraverseTree(focusNode.leftChild);
            preorderTraverseTree(focusNode.rightChild);
        }
    }

    public void postOrderTraverseTree(MyNode focusNode) {
        if (focusNode != null) {
            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);
            System.out.println(focusNode);
        }
    }

    public MyNode findNode(int key) {
        //start at the top of the tree
        MyNode focusNode = root;

        // While we haven't found the Node
        // keep looking

        while (focusNode.key != key) {
            // if we should search to the left child
            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                //shift the focus node to the right chiild
                focusNode = focusNode.rightChild;
            }
            //the node wasnt found
            if (focusNode == null) return null;
        }

        return focusNode;
    }

    class MyNode {
        int key;
        String name;
        MyNode leftChild;
        MyNode rightChild;

        MyNode(int key, String name) {
            this.key = key;
            this.name = name;
        }

        public String toString() {
            return name + " has the key " + key;
            /*
             * return name + " has the key " + key + "\nLeft Child: " + leftChild +
             * "\nRight Child: " + rightChild + "\n";
             */
        }
    }
}
