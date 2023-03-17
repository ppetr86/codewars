package com.example.entwicklerheld.space;

public class AccessControll {

    public static void main(String[] args) {
        System.out.println(isValidShipId("4700000130"));
        //4 + 1 +4 +8 + 2 +7 =26 / 11 = 2
        System.out.println("--------------");
        System.out.println(isValidShipId("3036959580"));
    }


    public static boolean isValidShipId(String shipId) {
        int lastDigitChecksum = 0;
        String[] arr = shipId.split("");
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = (i + 1) * Integer.parseInt(arr[i]);
            lastDigitChecksum += temp / 10 + temp % 10;
        }
        System.out.println(lastDigitChecksum);
        lastDigitChecksum = lastDigitChecksum / 11;
        System.out.println(lastDigitChecksum);
        String toCompare = lastDigitChecksum == 10 ? "X" : "" + lastDigitChecksum;
        return shipId.substring(shipId.length() - 1).equals(toCompare);
    }
}
