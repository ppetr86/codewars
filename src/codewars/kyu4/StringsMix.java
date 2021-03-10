package codewars.kyu4;
//https://www.codewars.com/kata/5629db57620258aa9d000014/train/java

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringsMix {
  public static void main(String[] args) {
    System.out.println(mix("Are they here", "yes, they are here"));
  }

  public static String mix(String s1, String s2) {
    Map<Character,Long> mapS1= Arrays.stream(s1.split(""))
            .filter(x->Character.isLetter(x.charAt(0)))
            .filter(x->Character.isLowerCase(x.charAt(0)))
            .map(x->x.charAt(0))
            .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

    Map<Character,Long> mapS2= Arrays.stream(s2.split(""))
            .filter(x->Character.isLetter(x.charAt(0)))
            .filter(x->Character.isLowerCase(x.charAt(0)))
            .map(x->x.charAt(0))
            .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

    mapS1 = mapS1.entrySet().stream().filter(e->e.getValue()>1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    mapS2 = mapS2.entrySet().stream().filter(e->e.getValue()>1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


    System.out.println(mapS1);
    System.out.println(mapS2);


    return "";
  }
}
