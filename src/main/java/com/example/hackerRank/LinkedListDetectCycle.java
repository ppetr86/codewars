package com.example.hackerRank;

public class LinkedListDetectCycle {

    static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
        }
    }


    static boolean hasCycle(Node head) {
        if (head == null)
            return false;

        //take two nodes and if there is a circle, eventually the faster node will catch up with the slower one
        Node fast = head.next;
        Node slow = head;

        while (fast != null && fast.next != null && slow != null) {
            if (fast == slow)
                return true;

            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }

    /*static boolean hasCycle(Node head) {
        if (head == null)
            return false;

        Set<Integer> visitedSoFar = new HashSet<>();
        Node node = head;

        while (node.next != null) {
            if (visitedSoFar.contains(node.data)) {
                return true;
            }
            visitedSoFar.add(node.data);
            node = node.next;
        }

        return false;
    }*/

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3;

        System.out.println(hasCycle(n1));
    }


}
