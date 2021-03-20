package hackerRank;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleV2 {

  public static void main(String[] args) {
    System.out.println(largestRectangle(new int[]{1,2,3,4,5}));
  }

  static long largestRectangle(int[] h) {

    ArrayDeque<Integer> deque = new ArrayDeque<>();
    long result = areaOfArr(deque);



    for (int i = 0; i < deque.size(); i++) {
      //long holderResult = areaOfArr(deque.)
    }
    return result;
  }

  private static long areaOfArr(ArrayDeque<Integer> deque) {
    return (long) deque.stream().min(Integer::compare).get() * deque.size();
  }

  private static long qmin(Deque<Integer> deque) {
    return (long) deque.stream().min(Integer::compare).get();
  }

  private static long area(Deque<Integer> deque) {
    return (long) deque.stream().min(Integer::compare).get() * deque.size();
  }
}

  /*
  Stack:
        pop(): this method removes an element from the top of the stack and returns it.
        push(): this method adds an element to the top of the stack.

  Queue
        enqueue(): this method adds an element to the end/rear of the queue
        dequeue(): this method removes an element from the front of the queue
        top(): returns the first element in the queue
        initialize(): creates an empty queue
        From there we can apply all sorts of methods for more functionality and information retrieval:

        top(): returns the element most recently added to the stack
        intStack.peek(): returns the top of the stack without removing an element
        poll(): removes the head of a queue and returns it
        size(): returns the size of the queue as number of elements
        isEmpty(): returns true if the stack/queue is full
        isFull(): returns true if the stack/queue is full*/
