package hackerRank;

import java.util.*;

public class LargestRectangle {

  public static void main(String[] args) {
    System.out.println(largestRectangle(new int[]{5,2,4,3,6,8,6}));
  }

  static long largestRectangle(int[] h) {
    /*Queue<Long> myQue = new PriorityQueue<>();
    long result = (long) Arrays.stream(h).min().getAsInt() *h.length;
    for (int i = 1; i < h.length; i++) {
      long sumInmyQue = myQue.stream().reduce(0L,Long::sum);
      long minInmyQue = Collections.min(myQue);
      long size = myQue.size();
      Queue<Long> holderQue = myQue;
      holderQue.poll();
    }*/
    PriorityQueue<Long> largest = new PriorityQueue<>();
    largest.add((long) h[0]);
    largest.add((long) h[1]);
    largest.add((long) h[2]);
    largest.add((long) h[3]);
    largest.add((long) h[4]);
    System.out.println(largest);
    //Retrieves and removes the head of this queue, or returns null if this queue is empty.
    largest.poll();
    System.out.println(largest);
    //Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
    System.out.println(largest.peek());

    Stack<Long> stack = new Stack<>();
    stack.push((long) h[0]);
    stack.push((long) h[1]);
    stack.push((long) h[2]);
    stack.push((long) h[3]);
    stack.push((long) h[4]);
    System.out.println("---------------");
    System.out.println(stack);
    System.out.println(stack.pop());
    System.out.println(stack);
    System.out.println(stack.peek());

    Queue<Long> queue = new PriorityQueue<>();
    queue.add((long) h[0]);
    queue.add((long) h[1]);
    queue.add((long) h[2]);
    queue.add((long) h[3]);
    queue.add((long) h[4]);
    System.out.println("---------------");
    System.out.println(queue);
    System.out.println(queue.poll());
    System.out.println(queue);
    System.out.println(queue.peek());
    System.out.println(queue);



    return 0L;
  }
}
