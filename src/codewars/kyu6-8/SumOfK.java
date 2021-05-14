/*
import java.text.ParseException;
import java.util.ArrayList;
import java.util.MyArrays;
import java.util.List;

public class SumOfK {

  public static void main(String[] args) throws ParseException {
    System.out.println(chooseBestSum(163, 3, new ArrayList<>(MyArrays.asList(50, 55, 56, 57, 58))));
  }

  public static Integer chooseBestSum(int target, int countTowns, List<Integer> ls) {
    // t=mileage, k = countTowns, ls = distances
    if (target < 0 || countTowns == 0) return null;
    if (target == 0 && !ls.contains(0)) return null;


    printCombination(ls, ls.size(), countTowns, target);

    return 0;
  }

  private static void printCombination(List<Integer> ls, int size, int countTowns, int sum) {
    List<Integer> data = new ArrayList<>(size);

    combinationUtil(ls, ls.size(), k, 0, data, 0);
  }

  static void combinationUtil(int arr[], int n, int r,
                              int index, int data[], int i) {
    // Current combination is ready to be printed,
    // print it
    if (index == r) {
      for (int j = 0; j < r; j++)
        System.out.print(data[j] + " ");
      System.out.println("");
      return;
    }

    if (i >= n)
      return;

    data[index] = arr[i];
    combinationUtil(arr, n, r, index + 1,
            data, i + 1);

    combinationUtil(arr, n, r, index, data, i + 1);
  }
}*/
