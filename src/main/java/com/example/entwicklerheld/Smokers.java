package com.example.entwicklerheld;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Smokers {

    private static final BigDecimal HANDLING_COSTS_IN_PERCENT = new BigDecimal("0.02");
    private static final BigDecimal NO_RISK = new BigDecimal(0);
    private static final BigDecimal SMOKING_SURCHARGE_IN_PERCENT = new BigDecimal("0.03");
    private static final BigDecimal RISKY_PROFESSIONAL_GROUP_SURCHARGE_IN_PERCENT = new BigDecimal("0.05");
    private static final BigDecimal EXTREME_ATHLETE_SURCHARGE_IN_PERCENT = new BigDecimal("0.08");

    private static final LocalDate firstDate = LocalDate.ofEpochDay(1);
    private static final LocalDate secondDate = LocalDate.of(2020, 6, 1);
    private static final LocalDate thirdDate = LocalDate.of(2022, 6, 1);


    public enum Risk {
        NOTHING, SMOKER, EXTREME_ATHLETE, PROFESSIONAL_GROUP
    }

    public class Costs {
        public BigDecimal smokingSurchargeInPercent;
        public BigDecimal riskyProfessionalGroupSurchargeInPercent;
        public BigDecimal extremeAthleteSurchargeInPercent;
        public BigDecimal handlingCostsInPercent;
    }

    public int getPayout(int monthlyPayment, int lifetimeInYears, boolean isSmoker) {
        BigDecimal monthlyFactor = (BigDecimal.valueOf(1).subtract(HANDLING_COSTS_IN_PERCENT));
        if (isSmoker)
            monthlyFactor = monthlyFactor.subtract(BigDecimal.valueOf(3));
        BigDecimal result = BigDecimal.valueOf((long) monthlyPayment * 12 * lifetimeInYears * monthlyFactor.intValue());
        return result.intValue();
    }

    public int getPayout(int monthlyPayment, int lifetimeInYears, List<Risk> risks) {

        BigDecimal monthlyFactor = (BigDecimal.valueOf(1).subtract(HANDLING_COSTS_IN_PERCENT));
        for (Risk risk : risks) {
            switch (risk) {
                case SMOKER -> monthlyFactor = monthlyFactor.subtract(SMOKING_SURCHARGE_IN_PERCENT);
                case NOTHING -> monthlyFactor = monthlyFactor.subtract(NO_RISK);
                case EXTREME_ATHLETE -> monthlyFactor = monthlyFactor.subtract(EXTREME_ATHLETE_SURCHARGE_IN_PERCENT);
                case PROFESSIONAL_GROUP ->
                        monthlyFactor = monthlyFactor.subtract(RISKY_PROFESSIONAL_GROUP_SURCHARGE_IN_PERCENT);
            }
        }
        BigDecimal result = BigDecimal.valueOf((long) monthlyPayment * 12 * lifetimeInYears).multiply(monthlyFactor);
        return result.intValue();
    }

    public int getPayout(int monthlyPayment, int lifetimeInYears, LocalDate policyStartDate, List<Risk> risks) {

        Map<LocalDate, Costs> costsMap = fillMapWithDateAndCosts();

        BigDecimal monthlyFactorTill20_05 = (BigDecimal.ONE.subtract(costsMap.get(firstDate).handlingCostsInPercent));
        BigDecimal monthlyFactorFrom20_06 = (BigDecimal.ONE.subtract(costsMap.get(secondDate).handlingCostsInPercent));
        BigDecimal monthlyFactorFrom22_06 = (BigDecimal.ONE.subtract(costsMap.get(thirdDate).handlingCostsInPercent));
        for (Risk risk : risks) {
            switch (risk) {
                case SMOKER -> {
                    monthlyFactorTill20_05 = monthlyFactorTill20_05.subtract(costsMap.get(firstDate).smokingSurchargeInPercent);
                    monthlyFactorFrom20_06 = monthlyFactorFrom20_06.subtract(costsMap.get(secondDate).smokingSurchargeInPercent);
                    monthlyFactorFrom22_06 = monthlyFactorFrom22_06.subtract(costsMap.get(thirdDate).smokingSurchargeInPercent);
                }
                case NOTHING -> {
                }
                case EXTREME_ATHLETE -> {
                    monthlyFactorTill20_05 = monthlyFactorTill20_05.subtract(costsMap.get(firstDate).extremeAthleteSurchargeInPercent);
                    monthlyFactorFrom20_06 = monthlyFactorFrom20_06.subtract(costsMap.get(secondDate).extremeAthleteSurchargeInPercent);
                    monthlyFactorFrom22_06 = monthlyFactorFrom22_06.subtract(costsMap.get(thirdDate).extremeAthleteSurchargeInPercent);
                }
                case PROFESSIONAL_GROUP -> {
                    monthlyFactorTill20_05 = monthlyFactorTill20_05.subtract(costsMap.get(firstDate).riskyProfessionalGroupSurchargeInPercent);
                    monthlyFactorFrom20_06 = monthlyFactorFrom20_06.subtract(costsMap.get(secondDate).riskyProfessionalGroupSurchargeInPercent);
                    monthlyFactorFrom22_06 = monthlyFactorFrom22_06.subtract(costsMap.get(thirdDate).riskyProfessionalGroupSurchargeInPercent);
                }
            }
        }

        BigDecimal result = BigDecimal.valueOf((long) monthlyPayment * 12 * lifetimeInYears);
        if (policyStartDate.isBefore(secondDate))
            result = result.multiply(monthlyFactorTill20_05);
        else if (policyStartDate.isAfter(secondDate) && policyStartDate.isBefore(thirdDate))
            result = result.multiply(monthlyFactorFrom20_06);
        else
            result = result.multiply(monthlyFactorFrom22_06);
        return result.intValue();
    }

    private Map<LocalDate, Costs> fillMapWithDateAndCosts() {
        Map<LocalDate, Costs> costsMap = new HashMap<>();

        Costs till20_05 = new Costs();
        till20_05.extremeAthleteSurchargeInPercent = new BigDecimal("0.08");
        till20_05.handlingCostsInPercent = new BigDecimal("0.02");
        till20_05.riskyProfessionalGroupSurchargeInPercent = new BigDecimal("0.05");
        till20_05.smokingSurchargeInPercent = new BigDecimal("0.03");

        Costs from20_06 = new Costs();
        from20_06.extremeAthleteSurchargeInPercent = till20_05.extremeAthleteSurchargeInPercent.subtract(new BigDecimal("0.005"));
        from20_06.handlingCostsInPercent = till20_05.handlingCostsInPercent.add(new BigDecimal("0.005"));
        from20_06.riskyProfessionalGroupSurchargeInPercent = till20_05.riskyProfessionalGroupSurchargeInPercent;
        from20_06.smokingSurchargeInPercent = till20_05.smokingSurchargeInPercent.add(new BigDecimal("0.01"));

        Costs from22_06 = new Costs();
        from22_06.extremeAthleteSurchargeInPercent = from20_06.extremeAthleteSurchargeInPercent;
        from22_06.handlingCostsInPercent = from20_06.handlingCostsInPercent.add(new BigDecimal("0.005"));
        from22_06.riskyProfessionalGroupSurchargeInPercent = from20_06.riskyProfessionalGroupSurchargeInPercent.add(new BigDecimal("0.015"));
        ;
        from22_06.smokingSurchargeInPercent = from20_06.smokingSurchargeInPercent;

        costsMap.put(firstDate, till20_05);
        costsMap.put(secondDate, from20_06);
        costsMap.put(thirdDate, from22_06);

        return costsMap;
    }

    /*LocalDate increaseDate = LocalDate.of(2020, 6, 1);
        BigDecimal result;

        long countMonthsTill20_05 = (policyStartDate.isBefore(increaseDate)
                && policyStartDate.plusYears(lifetimeInYears).isAfter(policyStartDate))
                ? ChronoUnit.MONTHS.between(policyStartDate, increaseDate) : 0;

        countMonthsTill20_05 = countMonthsTill20_05 > 12L * lifetimeInYears ? 12L * lifetimeInYears : countMonthsTill20_05;

        long countMonthsFrom20_06 = lifetimeInYears * 12L - countMonthsTill20_05;

        result = BigDecimal.valueOf(monthlyPayment * countMonthsTill20_05).multiply(monthlyFactorTill20_05);
        result = result.add(BigDecimal.valueOf(monthlyPayment * countMonthsFrom20_06).multiply(monthlyFactorFrom20_06));
        return result.intValue();*/
}
