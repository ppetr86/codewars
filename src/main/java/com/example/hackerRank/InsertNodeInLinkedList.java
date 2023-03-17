package com.example.hackerRank;

public class InsertNodeInLinkedList {

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
            this.data = data;
            this.next = next;
        }

        public SinglyLinkedListNode(int data) {
            this.data = data;
        }

        public SinglyLinkedListNode() {
        }
    }

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {

        SinglyLinkedListNode currentNode = llist;
        int index = 0;

        while (index++ < position - 1) {
            currentNode = currentNode.next;
        }

        SinglyLinkedListNode nextNode = new SinglyLinkedListNode(data);
        nextNode.next = currentNode.next;
        currentNode.next = nextNode;

        return llist;
    }

    public static void main(String[] args) {

        SinglyLinkedListNode node1 = new SinglyLinkedListNode(16);
        SinglyLinkedListNode node2 = new SinglyLinkedListNode(13);
        SinglyLinkedListNode node3 = new SinglyLinkedListNode(7);
        node1.next = node2;
        node2.next = node3;

        System.out.println(node1.next.next.data);
        System.out.println(node1.next.next.next == null);

        insertNodeAtPosition(node1, 1, 2);
    }
}
