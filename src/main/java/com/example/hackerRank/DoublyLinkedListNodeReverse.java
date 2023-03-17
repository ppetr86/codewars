package com.example.hackerRank;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedListNodeReverse {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }

        @Override
        public String toString() {
            return data + "";
        }
    }

    public static void main(String[] args) {
        DoublyLinkedListNode l1 = new DoublyLinkedListNode(1);
        DoublyLinkedListNode l2 = new DoublyLinkedListNode(2);
        DoublyLinkedListNode l3 = new DoublyLinkedListNode(3);
        DoublyLinkedListNode l4 = new DoublyLinkedListNode(4);
        l1.prev = null;
        l1.next = l2;
        l2.prev = l1;
        l2.next = l3;
        l3.prev = l2;
        l3.next = l4;
        l4.prev = l3;
        l4.next = null;
        reverse(l1);

        /*DoublyLinkedListNode l1 = new DoublyLinkedListNode(2);
        DoublyLinkedListNode l2 = new DoublyLinkedListNode(3);
        DoublyLinkedListNode l3 = new DoublyLinkedListNode(4);
        l1.prev = null;
        l1.next = l2;

        l2.prev = l1;
        l2.next = l3;

        l3.prev = l2;
        l3.next = null;
        reverse(l1);*/
    }


    public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {

        List<Integer> dataList = new ArrayList<>();
        DoublyLinkedListNode node = llist;

        if (llist == null)
            return null;

        boolean loop = true;
        while (loop) {
            dataList.add(node.data);
            if (node.next == null)
                loop = false;
            node = node.next;

        }

        DoublyLinkedListNode reversed = new DoublyLinkedListNode(dataList.get(dataList.size() - 1));
        DoublyLinkedListNode current = reversed;
        DoublyLinkedListNode previous = null;

        for (int i = dataList.size() - 1; i >= 0; i--) {

            current.prev = previous;

            // next will be defined only until the last but one
            if (i >= 1) {
                current.next = new DoublyLinkedListNode(dataList.get(i - 1));
            }
            //current.prev.next = reversed;
            previous = current;
            if (i > 0)
                current = current.next;
        }

        return reversed;
    }
}
