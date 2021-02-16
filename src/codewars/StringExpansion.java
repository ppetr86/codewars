/*
public class StringExpansion {

  public static void main(String[] args) {
    System.out.println(solve("3(ab)"));
  }

  public static String solve(String s){

    String[] strings = s.split("");
    int digit = 0;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < strings.length; i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)){
        digit = c;
      }
      if (c=='(') {
        continue;
      }
      if (Character.isLetter(c)) {
        for (int j = 0; j < digit; j++) {
          sb.append(c);
        }
      }
    }
  }
}
*/
