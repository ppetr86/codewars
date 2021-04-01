package hackerRank;

public class MaxArraySum {

  public static void main(String[] args) {
    System.out.println(maxSubsetSum(new int[]{3, 5, -7, 8, 10}));
  }

  private static int maxSubsetSum(int[] ints) {
    int result = 0;
    int current = 0;
    int skip = 2;
    while (skip< ints.length) {
      for (int i = 0; i < ints.length - skip; i++) {
        current += ints[i];
        for (int j = i + skip; j < ints.length; j += skip) {
          current += ints[j];
          result = Math.max(current, result);
        }
        current = 0;
      }
      skip++;
    }
    return Math.max(result,0);
  }
}