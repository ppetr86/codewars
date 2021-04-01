package hackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class TaleOfTwoStacks {

  public static void main(String[] args) {
    MyQueue<Integer> queue = new MyQueue<Integer>();
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

    for (int i = 0; i < n; i++) {
      int operation = scan.nextInt();
      if (operation == 1) { // enqueue
        queue.enqueue(scan.nextInt());
      } else if (operation == 2) { // dequeue
        queue.dequeue();
      } else if (operation == 3) { // print/peek
        System.out.println(queue.peek());
      }
    }
    scan.close();
  }

  //In this challenge, you must first implement a queue using two stacks.
  // Then process  queries, where each query is one of the following  types:
  static class MyQueue<E> extends Vector {

    List<Integer> myList = new ArrayList<>();

    public void enqueue(int input) {
      myList.add(input);
    }

    public Integer dequeue() {
      int last = myList.get(0);
      myList.remove(0);
      return last;
    }

    public Integer peek() {
      return myList.get(0);
    }
  }
}
