package com.example.codewars3.codewars.kyu5;

//https://www.codewars.com/kata/59de1e2fe50813a046000124/solutions/java
//https://www.codewars.com/kata/59de1e2fe50813a046000124/train/java
public class MatchSubst {

    public static void main(String[] args) {
        System.out.println(change("PProgram title: Primes\n" +
                        "Author: Dorries\n" +
                        "Corporation: MS\n" +
                        "Phone: +2-503-555-0098\n" +
                        "Date: Tues March 10, 2004\n" +
                        "Version: 0.2\n" +
                        "Level: 7kyu\n" +
                        "prog: Hoist\n" +
                        "version: 1.32",
                "Ladder", "1.1"));
    }

    public static String change(String s, String prog, String version) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split("\n");
        sb.append(arr[0], 0, arr[0].indexOf(" ")).append(": ").append(prog).append(" ");
        sb.append(arr[1], 0, arr[0].indexOf(" ") + 1).append("g964 ");

        boolean isPhoneValid = isPhoneValid(arr[3].substring(arr[3].indexOf(" ") + 1));
        if (isPhoneValid) sb.append("Phone: +1-503-555-0090 ");
        if (!isPhoneValid) return "ERROR: VERSION or PHONE";
        //date
        sb.append("Date: 2019-01-01 ");

        //VERSION
        String versionSubStr = arr[5].substring(arr[5].lastIndexOf(" ") + 1);
        boolean isVersionValid = isVersionValid(versionSubStr);
        if (isVersionValid) {
            if (!versionSubStr.equals("2.0")) sb.append("Version: ").append(version);
            else sb.append("Version: 2.0");
        }
        if (!isVersionValid) return "ERROR: VERSION or PHONE";
        return sb.toString();
    }

    private static boolean isVersionValid(String substring) {
        //A valid version in the input string data is one or more digits followed by a dot,
        // followed by one or more digits. So 0.6, 5.4, 14.275 and 1.99 are all valid, but versions like .6, 5, 14.2.7 and 1.9.9 are invalid.
        return substring.matches("\\d+[.]\\d+");
    }

    private static boolean isPhoneValid(String str) {
        //Phone numbers and versions must be in valid formats.
        //If the phone or version format is not valid, return "ERROR: VERSION or PHONE"
        //A valid input phone format is +1-xxx-xxx-xxxx, where each x is a digit.
        return str.matches("[+][1][-]\\d{3}[-]\\d{3}[-]\\d{4}");
    }

  /*public static String change(String s, String prog, String version) {
    String[] splitData;
    String versionPatternRegex = "^\\d+(\\.\\d+)";
    String phonePatternRegex = "\\+1-\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d";
    boolean isValidProgramVersion;
    boolean isValidPhoneNumber;

    splitData = s.split("\n");
    isValidPhoneNumber = splitData[3].trim().replace("Phone: ","").matches(phonePatternRegex);
    isValidProgramVersion = splitData[5].trim().replace("Version: ","").matches(versionPatternRegex);
    if (!isValidProgramVersion||!isValidPhoneNumber) {
      return "ERROR: VERSION or PHONE";
    }
    if (splitData[5].trim().replace("Version: ", "").matches("2.0")) {
      version = "2.0";
    }
    return String.format("Program: %s Author: g964 Phone: +1-503-555-0090 Date: 2019-01-01 Version: %s", prog, version);
  }*/
}
