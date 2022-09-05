package com.example.codewars3.hackerRank;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Fraudulent {

    public static void main(String[] args) {
        System.out.println(activityNotifications(List.of(10, 20, 30, 40, 50), 3));
        System.out.println(activityNotifications(List.of(2, 3, 4, 2, 3, 6, 8, 4, 5), 5));
        System.out.println(activityNotifications(List.of(1, 2, 3, 4, 4), 4));


    }

    //https://stackoverflow.com/questions/61432827/what-affects-the-speed-of-the-following-java-code-fraudulent-activity-notifica
    //https://www.youtube.com/watch?v=VmogG01IjYc
    //find the running median using Queues
    public static int activityNotifications(List<Integer> expenditure, int d) {
        int numOfNotif = 0;
        double median;
        PriorityQueue<Integer> max = new PriorityQueue<>();
        PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());

        if (expenditure.get(0) < expenditure.get(1)) {
            min.add(expenditure.get(0));
            max.add(expenditure.get(1));
        } else {
            max.add(expenditure.get(0));
            min.add(expenditure.get(1));
        }
        for (int i = 2; i < expenditure.size() - 1; i++) {
            if (expenditure.get(i) < max.peek())
                min.add(expenditure.get(i));
            else
                max.add(expenditure.get(i));

            balance(min, max);
            if (max.size() + min.size() == d) {
                if (min.size() == max.size())
                    median = ((double) min.peek() + (double) max.peek()) / 2;
                else if (min.size() > max.size())
                    median = min.peek();
                else
                    median = max.peek();
                if (expenditure.get(i + 1) >= 2 * median)
                    numOfNotif++;

                //remove previous
                if (max.contains(expenditure.get(i - d + 1)))
                    max.remove(expenditure.get(i - d + 1));
                else
                    min.remove(expenditure.get(i - d + 1));
            }
        }
        return numOfNotif;
    }

    public static void balance(PriorityQueue<Integer> min, PriorityQueue<Integer> max) {
        // peek: the head of the Q
        if (max.size() - min.size() > 1) {
            min.add(max.peek());
            max.remove(max.peek());
        }
        if (min.size() - max.size() > 1) {
            max.add(min.peek());
            min.remove(min.peek());
        }
    }


}