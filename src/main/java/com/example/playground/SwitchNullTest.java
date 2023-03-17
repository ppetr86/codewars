package com.example.playground;

import java.io.Serializable;

public class SwitchNullTest {

    public enum DiscountLevelDefault implements Serializable {
        SALE,
        SPECIAL_OFFER_SCRIPT,
        RECEIPT
    }

    public static void main(String[] args) {

        System.out.println(convertDiscountLevel(DiscountLevelDefault.RECEIPT));
        System.out.println(convertDiscountLevel(null));

    }

    private static int convertDiscountLevel(DiscountLevelDefault levelDefault) {
        return switch (levelDefault) {
            case SALE -> 0;
            case RECEIPT -> 1;
            case SPECIAL_OFFER_SCRIPT -> 2;
            default -> -1;
        };
    }
}
