package com.example.codewars3.entwicklerheld.insurance;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Stream;

public class InsuranceMatcher {

    private static final BigDecimal zeroPointNine = new BigDecimal("0.9");
    private static final BigDecimal onePointOne = new BigDecimal("1.1");
    private static final BigDecimal onePointFive = new BigDecimal("1.5");
    private static final BigDecimal twoPointOne = new BigDecimal("2.1");

    public static InsuranceMatcherResult getBestMatch(Insurance[] insuranceDatabase, InsuranceType insuranceType,
                                                      InsurancePreference usersInsurancePreference) {
        HashMap<Insurance, BigDecimal> cache = new HashMap<>();

        Stream<Insurance> stream = Arrays.stream(insuranceDatabase)
                .filter(insurance -> insuranceType.equals(insurance.getType()));

        if (usersInsurancePreference != null)
            stream = stream

                    .filter(insurance -> isSmallerOrEqualAfterDeviation(insurance.getInsurancePreference().getInsuredSum(), usersInsurancePreference.getInsuredSum(), twoPointOne))
                    .filter(insurance -> isSmallerOrEqualAfterDeviation(insurance.getInsurancePreference().getSpecificInsuredSum(), usersInsurancePreference.getSpecificInsuredSum(), twoPointOne))
                    .filter(insurance -> isSmallerOrEqualAfterDeviation(insurance.getInsurancePreference().getDeductible(), usersInsurancePreference.getDeductible(), twoPointOne))

                    .filter(insurance -> isMoreOrEqualAfterDeviation(insurance.getInsurancePreference().getInsuredSum(), usersInsurancePreference.getInsuredSum()))
                    .filter(insurance -> isMoreOrEqualAfterDeviation(insurance.getInsurancePreference().getSpecificInsuredSum(), usersInsurancePreference.getSpecificInsuredSum()))
                    .filter(insurance -> isSmallerOrEqualAfterDeviation(insurance.getInsurancePreference().getDeductible(), usersInsurancePreference.getDeductible(), onePointFive))

                    .filter(insurance -> averageRelativeDeviation(usersInsurancePreference, insurance, cache).compareTo(BigDecimal.valueOf(90)) >= 0);

        Optional<Insurance> selected = stream
                .min(Comparator.comparing(Insurance::getMonthlyCosts));

        if (!selected.isPresent()) return null;
        if (usersInsurancePreference == null) return new InsuranceMatcherResult(selected.get());
        return new InsuranceMatcherResult(selected.get(), usersInsurancePreference, cache.get(selected.get()));
    }

    private static boolean isSmallerOrEqualAfterDeviation(BigDecimal insuranceParam, BigDecimal preference, BigDecimal limit) {
        BigDecimal higherBound = preference.multiply(limit);
        return insuranceParam.compareTo(higherBound) < 1;
    }

    private static boolean isMoreOrEqualAfterDeviation(BigDecimal insuranceParam, BigDecimal preference) {
        BigDecimal lowerBound = preference.multiply(zeroPointNine);
        return insuranceParam.compareTo(lowerBound) >= 0;
    }

    public static BigDecimal averageRelativeDeviation(InsurancePreference preference, Insurance insurance, HashMap<Insurance, BigDecimal> cache) {
        if (preference != null) {
            BigDecimal result = BigDecimal.ZERO;
            BigDecimal interim;
            int counter = 0;
            if (preference.getInsuredSum() != null) {
                interim = twoPointOne.min(insurance.getInsurancePreference().getInsuredSum().divide(preference.getInsuredSum(), 4, RoundingMode.HALF_UP));
                result = result.add(interim);
                ++counter;
            }
            if (preference.getDeductible() != null) {
                interim = onePointOne.min(preference.getDeductible().divide(insurance.getInsurancePreference().getDeductible(), 4, RoundingMode.HALF_UP));
                result = result.add(interim);
                ++counter;
            }
            if (preference.getSpecificInsuredSum() != null) {
                interim = twoPointOne.min(insurance.getInsurancePreference().getSpecificInsuredSum().divide(preference.getSpecificInsuredSum(), 4, RoundingMode.HALF_UP));
                result = result.add(interim);
                ++counter;
            }
            result = result.multiply(BigDecimal.valueOf(100));
            result = result.divide(BigDecimal.valueOf(counter), 4, RoundingMode.HALF_UP);
            cache.put(insurance, result);
            return result;
        }
        return BigDecimal.valueOf(100);
    }
}