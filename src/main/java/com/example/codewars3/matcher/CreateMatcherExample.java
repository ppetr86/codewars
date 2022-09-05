package com.example.codewars3.matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateMatcherExample {

    public static void main(String[] args) {

        String text =
                "This is the text to be searched " +
                        "for occurrences of the http:// pattern.";

        String patternString = ".*http://.*";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);

        System.out.println(matcher.matches());

        String patternString2 = "This is the";
        Pattern pattern2 = Pattern.compile(patternString2, Pattern.CASE_INSENSITIVE);
        Matcher matcher2 = pattern2.matcher(text);

        System.out.println("lookingAt = " + matcher2.lookingAt());
        System.out.println("matches   = " + matcher2.matches());

        String patternString3 = "is";

        Pattern pattern3 = Pattern.compile(patternString3);
        Matcher matcher3 = pattern3.matcher(text);

        int count = 0;
        while (matcher3.find()) {
            count++;
            System.out.println("found: " + count + " : "
                    + matcher3.start() + " - " + matcher3.end());
        }

        String text4 =
                "John writes about this, and John writes about that," +
                        " and John writes about everything. ";

        String patternString1 = "(John)";

        pattern = Pattern.compile(patternString1);
        matcher = pattern.matcher(text4);

        while (matcher.find()) {
            System.out.println("found: " + matcher.group(1));
        }

        patternString1 = "(John) (.+?) ";

        pattern = Pattern.compile(patternString1);
        matcher = pattern.matcher(text4);

        while (matcher.find()) {
            System.out.println("found: " + matcher.group(1) +
                    " " + matcher.group(2));
        }

        patternString1 = "((John) (.+?)) ";

        pattern = Pattern.compile(patternString1);
        matcher = pattern.matcher(text4);

        while (matcher.find()) {
            System.out.println("found: <" + matcher.group(1) +
                    "> <" + matcher.group(2) +
                    "> <" + matcher.group(3) + ">");
        }

        pattern = Pattern.compile(patternString1);
        matcher = pattern.matcher(text4);

        String replaceAll = matcher.replaceAll("Joe Blocks ");
        System.out.println("replaceAll   = " + replaceAll);

        String replaceFirst = matcher.replaceFirst("Joe Blocks ");
        System.out.println("replaceFirst = " + replaceFirst);

        pattern = Pattern.compile(patternString1);
        matcher = pattern.matcher(text4);
        StringBuilder sb = new StringBuilder();

        while (matcher.find()) {
            matcher.appendReplacement(sb, "Joe Blocks ");
            System.out.println(sb.toString());
        }
        matcher.appendTail(sb);

        System.out.println(sb);
    }
}
