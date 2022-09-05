package com.example.codewars3.entwicklerheld.insurance;

import java.math.BigDecimal;

public class Test {

    public static void main(String[] args) {
        //System.out.println(InsuranceMatcher.getBestMatch(EXAMPLE_INSURANCE_DATABASE, FALLING_SATELLITES, null));
        //System.out.println(InsuranceMatcher.getBestMatch(EXAMPLE_INSURANCE_DATABASE2, MULTIPLE_BIRTH_INSURANCE, new InsurancePreference(BigDecimal.valueOf(27), BigDecimal.valueOf(19), BigDecimal.valueOf(2.7))));
        //System.out.println(InsuranceMatcher.getBestMatch(EXAMPLE_INSURANCE_DATABASE2, MULTIPLE_BIRTH_INSURANCE, new InsurancePreference(BigDecimal.valueOf(15), BigDecimal.valueOf(20), BigDecimal.valueOf(1.5))));
        System.out.println(InsuranceMatcher.getBestMatch(EXAMPLE_INSURANCE_DATABASE2, InsuranceType.MULTIPLE_BIRTH_INSURANCE, new InsurancePreference(BigDecimal.valueOf(30), BigDecimal.valueOf(20), BigDecimal.valueOf(3))));

        //System.out.println(InsuranceMatcher.getBestMatch(EXAMPLE_INSURANCE_DATABASE3, ALIEAN_ABDUCTION_INSURANCE, new InsurancePreference(BigDecimal.valueOf(27), BigDecimal.valueOf(22), BigDecimal.valueOf(2.7))));
        //System.out.println(InsuranceMatcher.getBestMatch(EXAMPLE_INSURANCE_DATABASE2, ALIEAN_ABDUCTION_INSURANCE, new InsurancePreference(BigDecimal.valueOf(26.990000), BigDecimal.valueOf(20), BigDecimal.valueOf(3))));

        System.out.println(InsuranceMatcher.getBestMatch(EXAMPLE_INSURANCE_DATABASE4, InsuranceType.FORTNITE_ACCOUNT, new InsurancePreference(BigDecimal.valueOf(10), BigDecimal.valueOf(10), BigDecimal.valueOf(10))));
        System.out.println(InsuranceMatcher.getBestMatch(EXAMPLE_INSURANCE_DATABASE4, InsuranceType.FORTNITE_ACCOUNT, new InsurancePreference(BigDecimal.valueOf(9), BigDecimal.valueOf(20), BigDecimal.valueOf(20))));
    }

    public static final Insurance[] EXAMPLE_INSURANCE_DATABASE4 = new Insurance[]{
            new Insurance("PlayAnd!Stop", InsuranceType.FORTNITE_ACCOUNT, new BigDecimal("2.46"), new InsurancePreference(new BigDecimal("9.00"), new BigDecimal("1.00"), new BigDecimal("9.00"))),
            new Insurance("G4A.it", InsuranceType.FORTNITE_ACCOUNT, new BigDecimal("1.56"), new InsurancePreference(new BigDecimal("20.00"), new BigDecimal("20.00"), new BigDecimal("9.00"))),
            new Insurance("FarmersInc", InsuranceType.FORTNITE_ACCOUNT, new BigDecimal("1.46"), new InsurancePreference(new BigDecimal("9.00"), new BigDecimal("20.00"), new BigDecimal("20.00"))),
    };


    public static final Insurance[] EXAMPLE_INSURANCE_DATABASE = new Insurance[]{
            new Insurance("One is None", InsuranceType.FALLING_SATELLITES, new BigDecimal("5.00"), null),
            new Insurance("Race & space", InsuranceType.FALLING_SATELLITES, new BigDecimal("5.00"), null),
            new Insurance("Kalanta", InsuranceType.FALLING_SATELLITES, new BigDecimal("45.24"), null),
            new Insurance("42ers", InsuranceType.FALLING_SATELLITES, new BigDecimal("19.24"), null),
            new Insurance("21ers", InsuranceType.FALLING_SATELLITES, new BigDecimal("34.24"), null),
            new Insurance("The broken ones", InsuranceType.WEDDING_INSURANCE, new BigDecimal("22.00"), null),
            new Insurance("Ice & Fire", InsuranceType.WEDDING_INSURANCE, new BigDecimal("10.11"), null),
            new Insurance("Umbrella", InsuranceType.WEDDING_INSURANCE, new BigDecimal("19.21"), null),
            new Insurance("Cold feet", InsuranceType.WEDDING_INSURANCE, new BigDecimal("50.25"), null),
            new Insurance("Bring it back", InsuranceType.WEDDING_INSURANCE, new BigDecimal("12.02"), null),
            new Insurance("SH", InsuranceType.FORTNITE_ACCOUNT, new BigDecimal("16.56"), null),
            new Insurance("G4A.it", InsuranceType.FORTNITE_ACCOUNT, new BigDecimal("16.45"), null),
            new Insurance("PlayAnd!Stop", InsuranceType.FORTNITE_ACCOUNT, new BigDecimal("16.23"), null),
            new Insurance("FarmersInc", InsuranceType.FORTNITE_ACCOUNT, new BigDecimal("16.29"), null),
    };

    public static final Insurance[] EXAMPLE_INSURANCE_DATABASE2 = new Insurance[]{
            new Insurance("One is None", InsuranceType.MULTIPLE_BIRTH_INSURANCE, new BigDecimal("5.00"), new InsurancePreference(new BigDecimal("15.00"), new BigDecimal("20.00"), new BigDecimal("1.50"))),
            new Insurance("1 & 2 & 3", InsuranceType.MULTIPLE_BIRTH_INSURANCE, new BigDecimal("45.24"), new InsurancePreference(new BigDecimal("20.00"), new BigDecimal("19.00"), new BigDecimal("1.00"))),
            new Insurance("Copy & Paste Insurances", InsuranceType.MULTIPLE_BIRTH_INSURANCE, new BigDecimal("19.24"), new InsurancePreference(new BigDecimal("27.00"), new BigDecimal("19.00"), new BigDecimal("2.70"))),
            new Insurance("None or null", InsuranceType.MULTIPLE_BIRTH_INSURANCE, new BigDecimal("34.24"), new InsurancePreference(new BigDecimal("29.00"), new BigDecimal("19.00"), new BigDecimal("2.80")))
    };

    public static final Insurance[] EXAMPLE_INSURANCE_DATABASE3 = new Insurance[]{
            new Insurance("Poor Pluto", InsuranceType.ALIEAN_ABDUCTION_INSURANCE, new BigDecimal("34.23"), new InsurancePreference(new BigDecimal("27.00"), new BigDecimal("22.00"), new BigDecimal("2.70"))),
            new Insurance("FantaSia", InsuranceType.ALIEAN_ABDUCTION_INSURANCE, new BigDecimal("1.00"), new InsurancePreference(new BigDecimal("26.99"), new BigDecimal("20.00"), new BigDecimal("3.00"))),
            new Insurance("Lombamtz", InsuranceType.ALIEAN_ABDUCTION_INSURANCE, new BigDecimal("2.24"), new InsurancePreference(new BigDecimal("30.00"), new BigDecimal("20.00"), new BigDecimal("2.69"))),
            new Insurance("Mars vs. Snickers", InsuranceType.ALIEAN_ABDUCTION_INSURANCE, new BigDecimal("3.24"), new InsurancePreference(new BigDecimal("30.00"), new BigDecimal("40.01"), new BigDecimal("3.00"))),
            new Insurance("Poor Pluto (Premium)", InsuranceType.ALIEAN_ABDUCTION_INSURANCE, new BigDecimal("34.24"), new InsurancePreference(new BigDecimal("27.00"), new BigDecimal("22.00"), new BigDecimal("2.70"))),
    };


}
