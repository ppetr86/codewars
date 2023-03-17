package com.example.hackerRank;

public class DoublyLinkedListNode {

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public int data;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
        this.prev = null;
    }

    /*@Override
    public String toString() {
        String str = "";
        DoublyLinkedListNode node = this;
        while (node != null) {
            str += node.data + "\n";
            if (node.next == null)
                break;
            node = node.next;
        }

        return str;
    }*/

    public static void main(String[] args) {
        DoublyLinkedListNode l1 = new DoublyLinkedListNode(1);
        DoublyLinkedListNode l2 = new DoublyLinkedListNode(3);
        DoublyLinkedListNode l3 = new DoublyLinkedListNode(4);
        DoublyLinkedListNode l4 = new DoublyLinkedListNode(10);
        l1.prev = null;
        l1.next = l2;
        l2.prev = l1;
        l2.next = l3;
        l3.prev = l2;
        l3.next = l4;
        l4.prev = l3;
        l4.next = null;
        sortedInsert(l1, 0);

        /*DoublyLinkedListNode l1 = new DoublyLinkedListNode(2);
        DoublyLinkedListNode l2 = new DoublyLinkedListNode(3);
        DoublyLinkedListNode l3 = new DoublyLinkedListNode(4);
        l1.prev = null;
        l1.next = l2;

        l2.prev = l1;
        l2.next = l3;

        l3.prev = l2;
        l3.next = null;
        sortedInsert(l1, 1);*/
    }

    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {

        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        if (llist == null)
            return newNode;

        DoublyLinkedListNode current = llist;
        DoublyLinkedListNode previous = null;

        if (data < current.data) {
            newNode.next = current;
            current.prev = newNode;
            return newNode;
        }

        while (current != null && data > current.data) {
            previous = current;
            current = current.next;
        }

        newNode.prev = previous;

        if (current == null) {
            previous.next = newNode;
        } else {
            newNode.next = previous.next;
            previous.next = newNode;
            newNode.next.prev = newNode;
        }

        return llist;
    }
}
