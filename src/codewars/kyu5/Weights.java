package codewars.kyu5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Weights {
  public static void main(String[] args) {
    System.out.println(orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
  }

  public static String orderWeight(String strng) {
    int[] arr = Arrays.stream(strng.split(" ")).map(x -> x.replaceAll(" ", "")).mapToInt(Integer::valueOf).toArray();
    List<Weight> list = Arrays.stream(arr).mapToObj(Weight::new).collect(Collectors.toList());
    System.out.println(list);

    list.sort(Comparator.comparingInt(Weight::getRecalculated).thenComparing(Weight::getRecalStr));

    return list.stream().map(Weight::getOriginalWeight).map(String::valueOf).collect(Collectors.joining(" "));
  }

  static class Weight {
    public int originalWeight;
    public int recalculated;
    public String recalStr;

    public Weight(int nr) {
      this.originalWeight = nr;
      this.recalculated = Arrays.stream(String.valueOf(nr).split("")).mapToInt(Integer::valueOf).sum();
      this.recalStr = String.valueOf(recalculated);
    }

    public int getOriginalWeight() {
      return originalWeight;
    }

    public String getRecalStr() {
      return recalStr;
    }

    public int getRecalculated() {
      return recalculated;
    }

    @Override
    public String toString() {
      return "originalWeight=" + originalWeight +
              ", recalculated=" + recalculated;
    }
  }

  /*statsList.sort(Comparator.comparingInt(TeamStats::getPoints).reversed()
            .thenComparingInt(TeamStats::getAgainstScore).reversed()
            .thenComparingInt(TeamStats::getBalance).reversed());*/

  /*private static void compareResultsAndOrderTeams(List<Team> teamList) {
    teamList.sort((o1, o2) -> {
      if (o1.getPoints() != o2.getPoints()) {
        return o2.getPoints() - o1.getPoints();
      } else if (o1.plusMinus() != o2.plusMinus()) {
        return o2.plusMinus() - o1.plusMinus();
      } else if (o1.getScored() != o2.getScored()) {
        return o2.getScored() - o1.getScored();
      } else {
        return o1.getName().compareToIgnoreCase(o2.getName());
      }
    });
  }*/
}
