package com.example.hackerRank;

public class LinkedListsMergePoint {

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int data) {
            this.data = data;
        }

        public SinglyLinkedListNode() {
        }
    }

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        int result = Integer.MIN_VALUE;

        SinglyLinkedListNode outerNode = head1;
        SinglyLinkedListNode innerNode = head2;

        //do outer and inner loop?
        while (outerNode != null) {
            while (innerNode != null) {
                if (outerNode == innerNode) {
                    result = outerNode.data;
                    break;
                }
                innerNode = innerNode.next;
            }
            if (result > Integer.MIN_VALUE)
                break;
            outerNode = outerNode.next;
            innerNode = head2;
        }

        return result;
    }

    public static void main(String[] args) {
        SinglyLinkedListNode head11 = new SinglyLinkedListNode(1);
        SinglyLinkedListNode head12 = new SinglyLinkedListNode(2);
        SinglyLinkedListNode head13 = new SinglyLinkedListNode(3);

        head11.next = head12;
        head12.next = head13;


        SinglyLinkedListNode head21 = new SinglyLinkedListNode(1);
        SinglyLinkedListNode head22 = new SinglyLinkedListNode(3);
        SinglyLinkedListNode head23 = new SinglyLinkedListNode(4);

        head21.next = head22;
        head22.next = head23;


        SinglyLinkedListNode head34 = new SinglyLinkedListNode(5);
        SinglyLinkedListNode head35 = new SinglyLinkedListNode(6);

        //merge from 3 to 5
        head13.next = head34;
        //merge from 4 to 5
        head23.next = head34;

        head34.next = head35;
        //head35.next = head13;


        System.out.println(findMergeNode(head11, head21));
    }
}
