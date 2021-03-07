package hackerRank;

import java.util.Arrays;

public class SherlockString {
  public static void main(String[] args) {
    System.out.println(isValid("aaaaabc"));
    /*ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd*/
    /*abcdefghhgfedecba*/
  }

  static String isValid(String s) {

    int[] letters = new int[26];
    for (char c : s.toCharArray()) {
      letters[c - 'a']++;
    }

    int max = Arrays.stream(letters).max().getAsInt();
    int min = Arrays.stream(letters).filter(each -> each > 0).min().getAsInt();
    int maxCount = (int) Arrays.stream(letters).filter(each -> each == max).count();
    int minCount = (int) Arrays.stream(letters).filter(each -> each == min).count();

    System.out.println(Arrays.toString(letters));
    int[] arr2 = Arrays.stream(letters).filter(x -> x > 0).sorted().toArray();
    int[] arr3 = Arrays.stream(letters).filter(x -> x > 0).distinct().sorted().toArray();
    System.out.println(Arrays.toString(arr2));
    System.out.println(max + " max");
    System.out.println(min + " min");
    System.out.println(maxCount + " maxcount");
    System.out.println(minCount + " mincount");

    if (max == min) return "YES";
    if ((maxCount == 1 || minCount == 1) && arr3.length == 2) return "YES";
    return "NO";

  }
}