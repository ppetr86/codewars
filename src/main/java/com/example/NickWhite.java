package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class NickWhite {

    static class BinarySearch {

        public static int search(int[] nums, int target) {
            if (nums.length == 0)
                return -1;

            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int midpoint = left + (right - left) / 2;
                if (nums[midpoint] == target) {
                    return midpoint;
                } else if (nums[midpoint] > target) {
                    right = midpoint - 1;
                } else {
                    left = midpoint + 1;
                }
            }
            return -1;
        }
    }

    static class ContainsDuplicate {

        //lower time complexity
        public static boolean containsDuplicate(int[] nums) {
            var numbers = new HashSet<Integer>();

            for (int num : nums) {

                if (numbers.contains(num)) return true;
                numbers.add(num);

            }
            return false;
        }

        //lower space complexity
        public static boolean containsDuplicate2(int[] nums) {
            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == nums[i + 1]) return true;
            }
            return false;
        }

        public static void main(String[] args) {
            System.out.println(containsDuplicate(new int[]{1, 2, 3, 4, 8, 9, 8}));
        }
    }

    static class Islands {
        public static void main(String[] args) {
            char[][] arr = new char[][]{{'1', '0', '1', '0', '0'}, {'0', '0', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
            System.out.println(numOfIslands(arr));
        }

        private static void callBFS(char[][] grid, int i, int j) {

            if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') return;

            grid[i][j] = '0';
            callBFS(grid, i + 1, j);
            callBFS(grid, i - 1, j);
            callBFS(grid, i, j - 1);
            callBFS(grid, i, j + 1);
        }

        private static int numOfIslands(char[][] grid) {
            int count = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '1') count += 1;
                    callBFS(grid, i, j);
                }
            }
            return count;
        }
    }

    static class LeetCodeTest {
        public static void main(String[] args) {
            System.out.println(eraser("ABC#DD#E"));
            System.out.println(eraser("A##BB#E##F"));

            System.out.println(eraserExtended("A#@BB#E#F"));
        }

        private static String eraser(String input) {
            Stack<String> lettersStack = new Stack<>();
            lettersStack.addAll(Arrays.asList(input.split("")));

            StringBuilder result = new StringBuilder();
            int deleteCounter = 0;

            while (!lettersStack.isEmpty()) {
                String popped = lettersStack.pop();
                if (!popped.equalsIgnoreCase("#") && deleteCounter == 0)
                    result.append(popped);
                else if (!popped.equalsIgnoreCase("#") && deleteCounter > 0) {
                    deleteCounter--;
                } else {
                    deleteCounter++;
                }
            }

            return result.reverse().toString();
        }

        private static String eraserExtended(String input) {
            Stack<String> lettersStack = new Stack<>();
            lettersStack.addAll(Arrays.asList(input.split("")));

            StringBuilder result = new StringBuilder();
            int deleteCounter = 0;

            while (!lettersStack.isEmpty()) {
                String popped = lettersStack.pop();
                if (!popped.equalsIgnoreCase("#") && deleteCounter == 0 && !popped.equalsIgnoreCase("@"))
                    result.append(popped);
                else if ((!popped.equalsIgnoreCase("#") && deleteCounter > 0) || popped.equalsIgnoreCase("@")) {
                    deleteCounter--;
                } else {
                    deleteCounter++;
                }
            }

            return result.reverse().toString();
        }
    }

    static class LinkedListCycle {
        public static boolean hasCycle(ListNode head) {
            if (head == null)
                return false;

            var slow = head;
            var fast = head.next;

            while (slow != fast) {

                if (fast == null || fast.next == null)
                    return false;
                slow = slow.next;
                fast = fast.next.next;
            }

            return true;
        }

        public static void main(String[] args) {
            var node1 = new ListNode(1);
            var node2 = new ListNode(2);
            var node3 = new ListNode(3);
            var node4 = new ListNode(2);
            var node5 = new ListNode(1);

            node1.next = node2;
            node2.next = node3;
            node3.next = node4;
            node4.next = node5;
            node5.next = node1;

            var node11 = new ListNode(1);
            var node21 = new ListNode(2);
            var node31 = new ListNode(3);
            var node41 = new ListNode(4);
            var node51 = new ListNode(5);

            node11.next = node21;
            node21.next = node31;
            node31.next = node41;
            node41.next = node51;

            System.out.println(hasCycle(node1));
            System.out.println(hasCycle(node11));
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        ListNode(int x) {
            this.val = x;
        }

        @Override
        public String toString() {

            return String.valueOf(this.val);
        }
    }

    static class MergeTwoSortedLists {
        public static void main(String[] args) {
            var node1 = new ListNode(1);
            var node2 = new ListNode(3);
            var node3 = new ListNode(5);
            var node4 = new ListNode(7);
            var node5 = new ListNode(9);

            node1.next = node2;
            node2.next = node3;
            node3.next = node4;
            node4.next = node5;

            var node11 = new ListNode(2);
            var node21 = new ListNode(4);
            var node31 = new ListNode(16);
            var node41 = new ListNode(31);
            var node51 = new ListNode(33);

            node11.next = node21;
            node21.next = node31;
            node31.next = node41;
            node41.next = node51;

            System.out.println(mergeTwoLists(node1, node11));

        }

        public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {


            var tempNode = new ListNode(0);
            var currentNode = tempNode;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    currentNode.next = l1;
                    l1 = l1.next;
                } else {
                    currentNode.next = l2;
                    l2 = l2.next;
                }

                currentNode = currentNode.next;
            }

            if (l1 != null) {
                currentNode.next = l1;
                l1 = l1.next;
            }
            if (l2 != null) {
                currentNode.next = l2;
                l2 = l2.next;
            }

            return tempNode.next;
        }
    }

    static class MiddleOfLinkedList {
        public static void main(String[] args) {
            var node1 = new ListNode(1);
            var node2 = new ListNode(3);
            var node3 = new ListNode(5);
            var node4 = new ListNode(7);
            var node5 = new ListNode(9);

            node1.next = node2;
            node2.next = node3;
            node3.next = node4;
            node4.next = node5;

            var node11 = new ListNode(2);
            var node21 = new ListNode(4);
            var node31 = new ListNode(16);
            var node41 = new ListNode(31);
            var node51 = new ListNode(33);
            var node61 = new ListNode(38);

            node11.next = node21;
            node21.next = node31;
            node31.next = node41;
            node41.next = node51;
            node51.next = node61;

            System.out.println(middleNode(node1));
            System.out.println(middleNode(node11));
        }

        static ListNode middleNode(ListNode head) {
            var apointer = head;
            var bpointer = head.next;

            while (bpointer != null && bpointer.next != null) {
                apointer = apointer.next;
                bpointer = bpointer.next.next;
            }

            return apointer;
        }
    }

    static class Node {
        int val;
        List<Node> children;

        public Node() {

        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    static class PalindromeLinkedList {
        public static boolean isPalindrome(ListNode head) {
            var slowPointer = head;
            var fastPointer = head;

            while (fastPointer != null && fastPointer.next != null) {
                fastPointer = fastPointer.next.next;
                slowPointer = slowPointer.next;
            }

            slowPointer = reversed(slowPointer);
            fastPointer = head;

            while (slowPointer != null) {
                if (slowPointer.val != fastPointer.val) return false;
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next;
            }

            return true;
        }

        public static boolean isPalindrome2(ListNode head) {

            StringBuilder sb = new StringBuilder();
            while (head != null) {
                sb.append(head.val);
                head = head.next;
            }

            var reversed = new StringBuilder(sb).reverse();
            return sb.toString().equals(reversed.toString());
        }

        public static void main(String[] args) {

            var node1 = new ListNode(1);
            var node2 = new ListNode(2);
            var node3 = new ListNode(3);
            var node4 = new ListNode(2);
            var node5 = new ListNode(1);

            node1.next = node2;
            node2.next = node3;
            node3.next = node4;
            node4.next = node5;

            node2.prev = node1;
            node3.prev = node2;
            node4.prev = node3;
            node5.prev = node4;

            /*System.out.println(isPalindrome(node1));
            System.out.println(isPalindrome(node2));
            System.out.println(isPalindrome(node5));
            System.out.println(isPalindrome(node3));*/

            System.out.println(isPalindrome2(node1));
            System.out.println(isPalindrome2(node2));
        }

        private static ListNode reversed(ListNode head) {

            ListNode previous = null;

            while (head != null) {
                var next = head.next;
                head.next = previous;
                previous = head;
                head = next;
            }
            return previous;
        }
    }

    static class PalindromeNumber {
        public static boolean isPalindrome(int x) {
            if (x == 0)
                return true;
            if (x < 0 || x % 10 == 0)
                return false;

            int reversedInt = 0;
            while (x > reversedInt) {
                int pop = x % 10;
                x /= 10;
                reversedInt = (reversedInt * 10) + pop;
            }

            return x == reversedInt || x == reversedInt / 10;
        }

        public static void main(String[] args) {
            System.out.println(isPalindrome(123));
            System.out.println(isPalindrome(121));
        }
    }

    static class PascalTriangle {
        public static List<List<Integer>> generate(int numRows) {

            List<List<Integer>> triangle = new ArrayList<>(numRows);
            if (numRows == 0) return triangle;

            List<Integer> firstRow = List.of(1);
            triangle.add(firstRow);

            for (int i = 1; i < numRows; i++) {
                var previousRow = triangle.get(i - 1);
                var currentRow = new ArrayList<Integer>();
                currentRow.add(1);
                for (int j = 1; j < i; j++) {
                    currentRow.add(previousRow.get(j - 1) + previousRow.get(j));
                }
                currentRow.add(1);
                triangle.add(currentRow);

            }

            return triangle;
        }

        public static void main(String[] args) {
            generate(10).forEach(System.out::println);
        }
    }

    static class PostOrderTree {

        public static void main(String[] args) {

            var root = new Node(1);
            var childrow1col1 = new Node(3);
            var childrow1col2 = new Node(2);
            var childrow1col3 = new Node(4);

            root.children = List.of(childrow1col1, childrow1col2, childrow1col3);

            var childrow2col1 = new Node(5);
            var childrow2col2 = new Node(6);

            childrow1col1.children = List.of(childrow2col1, childrow2col2);

            System.out.println(postOrderTree(root));
        }

        public static List<Integer> postOrderTree(Node root) {
            LinkedList<Node> stack = new LinkedList<>();
            LinkedList<Integer> output = new LinkedList<>();

            if (root == null)
                return output;

            stack.add(root);

            while (!stack.isEmpty()) {
                var node = stack.pollLast();
                output.addFirst(node.val);
                if (node.children != null)
                    stack.addAll(node.children);
            }
            //5,6,3,2,4,1
            return output;
        }
    }

    static class ReverseLinkList {


        public static void main(String[] args) {
            var node1 = new ListNode(1);
            var node2 = new ListNode(2);
            var node3 = new ListNode(3);
            var node4 = new ListNode(4);
            var node5 = new ListNode(5);

            node1.next = node2;
            node2.next = node3;
            node3.next = node4;
            node4.next = node5;

            node2.prev = node1;
            node3.prev = node2;
            node4.prev = node3;
            node5.prev = node4;

            var reversed = reverseList(node1);
        }

        public static ListNode reverseList(ListNode head) {

            //1 -> 2 -> 3 -> 4 -> 5 -> null
            //5 -> 4 -> 3 -> 2 -> 1 -> null
            ListNode previous = null;

            while (head != null) {
                var next = head.next;
                head.next = previous;
                previous = head;
                head = next;
            }

            return previous;
        }
    }

    static class RobotReturnToOrigin {
        public static boolean judgeCircle(String moves) {
            int[] moveCounter = new int[]{0, 0, 0, 0};
            char[] moveChars = moves.toCharArray();

            for (char move : moveChars) {
                if (move == 'L')
                    moveCounter[0]++;
                else if (move == 'R')
                    moveCounter[1]++;
                else if (move == 'U')
                    moveCounter[2]++;
                else if (move == 'D')
                    moveCounter[3]++;
            }

            return moveCounter[0] == moveCounter[1] && moveCounter[2] == moveCounter[3];
        }

        public static void main(String[] args) {
            System.out.println(judgeCircle("UD"));
            System.out.println(judgeCircle("LL"));
            System.out.println(judgeCircle("UPLRLLLRUP"));
        }
    }

    static class TowSumII {

        public static void main(String[] args) {
            System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9))); //output [1,2]
            System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 16))); //output [1,2]

            System.out.println(Arrays.toString(twoSum2(new int[]{2, 7, 11, 15}, 9))); //output [1,2]
            System.out.println(Arrays.toString(twoSum2(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 16))); //output [1,2]

        }

        public static int[] twoSum(int[] numbers, int target) {
            var seenSoFarMap = new HashMap<Integer, Integer>();
            var resultArr = new int[2];

            for (int i = 0; i < numbers.length; i++) {
                int number = numbers[i];
                if (number > target) break;

                var differenceBetweenNumAndTarget = target - number;
                if (seenSoFarMap.containsKey(differenceBetweenNumAndTarget)) {
                    resultArr = new int[]{seenSoFarMap.get(differenceBetweenNumAndTarget), i};
                    break;
                }

                seenSoFarMap.put(number, i);

            }

            return resultArr;
        }

        public static int[] twoSum2(int[] numbers, int target) {
            int aPointer = 0;
            int bPointer = numbers.length - 1;

            while (aPointer <= bPointer) {
                int sum = numbers[aPointer] + numbers[bPointer];

                if (sum > target) bPointer--;
                else if (sum < target) {
                    aPointer++;
                } else return new int[]{++aPointer, ++bPointer};

            }

            return new int[]{++aPointer, ++bPointer};
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    static class TreePathSum {
        public static boolean hasPathSum(TreeNode root, int sum) {
            if (root == null)
                return false;
            boolean answer = false;
            int subSum = sum - root.val;

            if (subSum == 0 && root.left == null && root.right == null)
                return true;

            if (root.left != null)
                answer = answer || hasPathSum(root.left, subSum); // answer || hasPathSum... has no utility if the answer is false

            if (root.right != null)
                answer = answer || hasPathSum(root.right, subSum); // But if it is true then we can avoid calling hasPathSum
            return (answer);
        }

        public static boolean hasPathSum2(TreeNode root, int sum) {
            if (root == null)
                return false;

            var nodeStack = new Stack<TreeNode>();
            var sumStack = new Stack<Integer>();

            nodeStack.add(root);
            sumStack.add(sum - root.val);

            int iteration = 0;
            while (!nodeStack.isEmpty()) {
                System.out.println("iteration number " + (++iteration));
                var currentNode = nodeStack.pop();
                int currentSum = sumStack.pop();

                if (currentNode.left == null && currentNode.right == null && currentSum == 0)
                    return true;

                if (currentNode.left != null /*&& currentSum > 0*/) {
                    nodeStack.add(currentNode.left);
                    sumStack.add(currentSum - currentNode.left.val);
                }

                if (currentNode.right != null) {
                    nodeStack.add(currentNode.right);
                    sumStack.add(currentSum - currentNode.right.val);
                }

            }
            return false;
        }


        public static void main(String[] args) {

            var tn5 = new TreeNode(5);
            var tn4_1 = new TreeNode(4);
            var tn8 = new TreeNode(8);
            var tn11 = new TreeNode(11);
            var tn13 = new TreeNode(13);
            var tn4_2 = new TreeNode(4);
            var tn7 = new TreeNode(7);
            var tn2 = new TreeNode(2);
            var tn1 = new TreeNode(1);
            var tn10 = new TreeNode(10);

            tn5.left = tn4_1;
            tn5.right = tn8;

            tn4_1.left = tn11;

            tn11.left = tn7;
            tn11.right = tn2;

            tn8.left = tn13;
            tn8.right = tn4_2;

            tn4_2.right = tn1;
            tn7.left = tn10;

            System.out.println(hasPathSum(tn5, 22));
            System.out.println(hasPathSum2(tn5, 22));
        }
    }
}


