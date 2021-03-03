package hackerRank;

import java.util.Arrays;

public class Strings {
  public static void main(String[] args) {
    System.out.println(repeatedString("epsxyyflvrrrxzvnoenvpegvuonodjoxfwdmcvwctmekpsnamchznsoxaklzjgrqruyzavshfbmuhdwwmpbkwcuomqhiyvuztwvq", 549382313570l));
    //epsxyyflvrrrxzvnoenvpegvuonodjoxfwdmcvwctmekpsnamchznsoxaklzjgrqruyzavshfbmuhdwwmpbkwcuomqhiyvuztwvq
    //549382313570
  }

  private static long repeatedString(String str, long l) {
    if (str.equals("a")) return l;
    // počet a ve stringu
    long aCountInStr = Arrays.stream(str.split("")).filter(x -> x.equals("a")).count();
    // zbytek dělení
    int modulo = (int) (l % str.length());
    // počet aček ve zbytku dělení
    long countInModulo = Arrays.stream(str.substring(0, modulo).split("")).filter(x -> x.equals("a")).count();
    // počet a ve stringu * l/string delka
    return (int) (l/str.length()) * aCountInStr + (int) countInModulo;

  }
}
