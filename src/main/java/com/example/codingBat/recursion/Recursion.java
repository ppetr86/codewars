package com.example.codingBat.recursion;

public class Recursion {

    //Given a non-negative int n, compute recursively (no loops) the count of the occurrences of 8 as a digit,
    // except that an 8 with another 8 immediately to its left counts double, so 8818 yields 4. Note that mod (%) by
    // 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).

    public static void main(String[] args) {
        System.out.println(groupSum(0, new int[]{4, 2, 8}, 10));
    }

    //Given an array of ints, is it possible to choose a group of some of the ints,
    // such that the group sums to the given target? This is a classic backtracking
    // recursion problem. Once you understand the recursive backtracking strategy in
    // this problem, you can use the same pattern for many problems to search a space
    // of choices. Rather than looking at the whole array, our convention is to consider
    // the part of the array starting at index start and continuing to the end of the array.
    // The caller can specify the whole array simply by passing start as 0. No loops are needed
    // -- the recursive calls progress down the array.
    public static boolean groupSum(int start, int[] nums, int target) {
        if (start >= nums.length)
            return target == 0;
        // use the int we are on, if the statement inside is true we return true, otherwise it goes to next if
        boolean holder = groupSum(start + 1, nums, target - nums[start]);
        if (holder)
            return true;
        //dont use the int we are on
        boolean holder2 = groupSum(start + 1, nums, target);
        if (holder2)
            return true;

        return false;
    }

    //Given base and n that are both 1 or more, compute recursively
    // (no loops) the value of base to the n power, so powerN(3, 2) is 9 (3 squared).

    public int count8(int n) {
        if (1 > n) return 0;
        if (n % 100 == 88) return 2 + count8(n / 10);
        if (n % 10 == 8) return 1 + count8(n / 10);
        else return count8(n / 10);
    }

    public int powerN(int base, int n) {
        if (n == 1) return base;
        return base * powerN(base, n - 1);
    }

    //Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.
    public int countX(String str) {
        if (str.length() == 0) return 0;
        int count = 0;
        if (str.charAt(0) == 'x') count = 1;
        return count + countX(str.substring(1));
    }

    //Given a string, compute recursively (no loops) the number of times lowercase "hi" appears in the string.
    public int countHi(String str) {
        if (str.length() <= 1) return 0;
        int count = 0;
        if (str.startsWith("hi")) count = 1;
        return count + countHi(str.substring(1));
    }

    //Given a string, compute recursively (no loops) a new string where all appearances of "pi" have been replaced by "3.14".

    //Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars have been changed to 'y' chars.
    public String changeXY(String str) {
        if (str.length() == 0) return "";
        if (str.charAt(0) == 'x') return "y" + changeXY(str.substring(1));
        return str.charAt(0) + changeXY(str.substring(1));
    }

    public String changePi(String str) {
        if (str.length() < 1) return "";
        if (str.startsWith("pi")) return "3.14" + changePi(str.substring(2));
        return str.substring(0, 1) + changePi(str.substring(1));
    }

    //Given a string, compute recursively a new string where all the 'x' chars have been removed.
    public String noX(String str) {
        if (str.length() == 0) return "";
        if (str.charAt(0) == 'x') return noX(str.substring(1));
        return str.charAt(0) + noX(str.substring(1));
    }

    //Given an array of ints, compute recursively the number of times that the value 11 appears
    // in the array. We'll use the convention of considering only the part of the array that
    // begins at the given index. In this way, a recursive call can pass index+1 to move down
    // the array. The initial call will pass in index as 0.

    //Given an array of ints, compute recursively if the array contains a 6. We'll use the convention
    // of considering only the part of the array that begins at the given index. In this way,
    // a recursive call can pass index+1 to move down the array. The initial call will pass in
    // index as 0.
    public boolean array6(int[] nums, int index) {
        if (index == nums.length) return false;
        if (nums[index] == 6) return true;
        return array6(nums, index + 1);
    }

    //Given an array of ints, compute recursively if the array contains somewhere a
    // value followed in the array by that value times 10. We'll use
    // the convention of considering only the part of the array that begins
    // at the given index. In this way, a recursive call can pass index+1 to move
    // down the array. The initial call will pass in index as 0.

    public int array11(int[] nums, int index) {

        if (index == nums.length) return 0;
        if (nums[index] == 11) return 1 + array11(nums, index + 1);
        return array11(nums, index + 1);
    }

    //Given a string, compute recursively a new string where all the adjacent
    // chars are now separated by a "*".

    public boolean array220(int[] nums, int index) {
        if (nums.length == 0) return false;
        if (index == nums.length - 1) return false;
        if (nums[index] * 10 == nums[index + 1]) return true;
        return array220(nums, index + 1);
    }

    public String allStar(String str) {
        if (str.length() == 0) return "";
        if (str.length() == 1) return str;
        return str.charAt(0) + "*" + allStar(str.substring(1));
    }

    //Given a string, compute recursively a new string where identical chars that
    // are adjacent in the original string are separated from each other by a "*".
    public String pairStar(String str) {
        if (str.length() <= 1) return str;
        if (str.charAt(0) == str.charAt(1))
            return str.charAt(0) + "*" + pairStar(str.substring(1));
        return str.charAt(0) + pairStar(str.substring(1));
    }

    //Given a string, compute recursively a new string where all the lowercase 'x'
    // chars have been moved to the end of the string.
    public String endX(String str) {
        if (str.length() == 0) return "";
        if (str.charAt(0) == 'x') return endX(str.substring(1)) + 'x';
        return str.charAt(0) + endX(str.substring(1));
    }

    //We'll say that a "pair" in a string is two instances of a char separated by a char.
    // So "AxA" the A's make a pair. Pair's can overlap, so "AxAxA" contains 3 pairs --
    // 2 for A and 1 for x. Recursively compute the number of pairs in the given string.
    public int countPairs(String str) {
        if (str.length() < 3) return 0;
        int counter = 0;
        if (str.charAt(0) == str.charAt(2)) {
            counter = 1;
            return counter + countPairs(str.substring(1));
        }
        return counter + countPairs(str.substring(1));
    }

    //Count recursively the total number of "abc" and "aba" substrings that appear in the given string.
    public int countAbc(String str) {
        if (str.length() < 3) return 0;
        int counter = 0;
        if (str.startsWith("abc") || str.startsWith("aba")) {
            counter++;
            return counter + countAbc(str.substring(1));
        }
        return counter + countAbc(str.substring(1));
    }

    //Given an array of ints, is it possible to choose a group of some of the ints, beginning at the start index, such
    // that the group sums to the given target? However, with the additional constraint that all 6's must be chosen. (No loops needed.)

    public boolean groupSum6(int start, int[] nums, int target) {
        //start is equal to arr len,there is nowhere to go, return based on target
        if (start >= nums.length) return target == 0;
        // always use 6, move start index 1 up, decrease target
        if (nums[start] == 6) return groupSum6(start + 1, nums, target - 6);
        // calling the method and decreasing the target by value at start index
        if (groupSum6(start + 1, nums, target - nums[start]))
            return true;
        if (groupSum6(start + 1, nums, target))
            return true;
        return false;
    }

    //Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to
    // the given target with this additional constraint: If a value in the array is chosen to be in the group,
    // the value immediately following it in the array must not be chosen. (No loops needed.)
    public boolean groupNoAdj(int start, int[] nums, int target) {
        if (start >= nums.length)
            return target == 0;

        boolean holder = groupNoAdj(start + 1, nums, target);
        if (holder) return true;

        boolean holder2 = groupNoAdj(start + 2, nums, target - nums[start]);
        if (holder2) return true;

        return false;
    }

    //  Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to
    //  the given target with these additional constraints: all multiples of 5 in the array must be included in the
    //  group. If the value immediately following a multiple of 5 is 1, it must not be chosen. (No loops needed.)

    public boolean groupSum5(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;

        boolean holder2 = groupSum5(start + 1, nums, target - nums[start]);
        boolean startsWith5 = nums[start] % 5 == 0;
        if (startsWith5) {
            if (start <= nums.length - 2 && nums[start + 1] == 1)
                return groupSum5(start + 2, nums, target - nums[start]);
            else
                return groupSum5(start + 1, nums, target - nums[start]);

        }

        boolean holder3 = groupSum5(start + 1, nums, target - nums[start]);
        if (holder3) return true;

        boolean holder = groupSum5(start + 1, nums, target);
        if (holder) return true;

        return false;
    }

    //Given an array of ints, is it possible to choose a group of some of the ints, such that the group
    // sums to the given target, with this additional constraint: if there are numbers in the array that
    // are adjacent and the identical value, they must either all be chosen, or none of them chosen. For
    // example, with the array {1, 2, 2, 2, 5, 2}, either all three 2's in the middle must be chosen or
    // not, all as a group. (one loop can be used to find the extent of the identical values).
    public boolean groupSumClump(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;

        int i = start;
        int sum = 0;

        while (i < nums.length && nums[start] == nums[i]) {
            sum += nums[i];
            i++;
        }

        if (groupSumClump(i, nums, target - sum))
            return true;

        if (groupSumClump(i, nums, target))
            return true;

        return false;
    }


}
