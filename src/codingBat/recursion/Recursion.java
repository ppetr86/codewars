package codingBat.recursion;

public class Recursion {

  //Given a non-negative int n, compute recursively (no loops) the count of the occurrences of 8 as a digit,
  // except that an 8 with another 8 immediately to its left counts double, so 8818 yields 4. Note that mod (%) by
  // 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).

  public int count8(int n) {
    if (1 > n) return 0;
    if (n % 100 == 88) return 2 + count8(n / 10);
    if (n % 10 == 8) return 1 + count8(n / 10);
    else return count8(n / 10);
  }

  //Given base and n that are both 1 or more, compute recursively
  // (no loops) the value of base to the n power, so powerN(3, 2) is 9 (3 squared).

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

  //Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars have been changed to 'y' chars.
  public String changeXY(String str) {
    if (str.length() == 0) return "";
    if (str.charAt(0) == 'x') return "y" + changeXY(str.substring(1));
    return str.charAt(0) + changeXY(str.substring(1));
  }

  //Given a string, compute recursively (no loops) a new string where all appearances of "pi" have been replaced by "3.14".

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

  //Given an array of ints, compute recursively if the array contains a 6. We'll use the convention
  // of considering only the part of the array that begins at the given index. In this way,
  // a recursive call can pass index+1 to move down the array. The initial call will pass in
  // index as 0.
  public boolean array6(int[] nums, int index) {
    if (index == nums.length) return false;
    if (nums[index] == 6) return true;
    return array6(nums, index + 1);
  }

  //Given an array of ints, compute recursively the number of times that the value 11 appears
  // in the array. We'll use the convention of considering only the part of the array that
  // begins at the given index. In this way, a recursive call can pass index+1 to move down
  // the array. The initial call will pass in index as 0.

  public int array11(int[] nums, int index) {

    if (index == nums.length) return 0;
    if (nums[index] == 11) return 1 + array11(nums, index + 1);
    return array11(nums, index + 1);
  }

  //Given an array of ints, compute recursively if the array contains somewhere a
  // value followed in the array by that value times 10. We'll use
  // the convention of considering only the part of the array that begins
  // at the given index. In this way, a recursive call can pass index+1 to move
  // down the array. The initial call will pass in index as 0.

  public boolean array220(int[] nums, int index) {
    if (nums.length == 0) return false;
    if (index == nums.length - 1) return false;
    if (nums[index] * 10 == nums[index + 1]) return true;
    return array220(nums, index + 1);
  }

  //Given a string, compute recursively a new string where all the adjacent
  // chars are now separated by a "*".

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

}
