package com.example.entwicklerheld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InsuranceMatcher {
    public static List<Insurance> getInsurancesByFeature(Feature feature) {
        return InsuranceProvider.getInstance().getAllInsurances().stream()
                .filter(insurance -> insurance.getFeatures()
                        .stream().anyMatch(f -> f.getName().equals(feature.getName())))
                .collect(Collectors.toList());
    }

    public static List<Insurance> getMatchingInsurances(Feature... features) {

        return flatmapInsurances(features)
                .collect(Collectors.toList());
    }

    private static Stream<Insurance> flatmapInsurances(Feature[] features) {
        return Arrays.stream(features)
                .map(InsuranceMatcher::getInsurancesByFeature)
                .flatMap(Collection::stream);
    }

    public static List<Insurance> getPerfectMatchingInsurances(Feature... features) {
        List<String> featureStrings = Arrays.stream(features).map(Feature::getName).collect(Collectors.toList());
        List<Insurance> insurances = flatmapInsurances(features)
                .filter(insurance -> insurance.getFeatures().size() <= features.length)
                .filter(insurance -> !insuranceFeaturesHasAnElementWhichIsNotInFeatures(Arrays.asList(insurance), featureStrings))
                .distinct()
                .sorted((i1, i2) -> Integer.compare(i2.getFeatures().size(), i1.getFeatures().size()))
                .collect(Collectors.toList());

        List<Insurance> result;
        List<Insurance> temp;

        for (int i = 0; i < insurances.size(); i++) {
            result = new ArrayList<>();
            result.add(insurances.get(i));
            if (resultEqualsFeatures(result, featureStrings))
                return result;
            for (int j = i + 1; j < insurances.size(); j++) {
                if (result.size() + insurances.get(j).getFeatures().size() > featureStrings.size())
                    continue;
                temp = new ArrayList<>(result);
                temp.add(insurances.get(j));
                if (!isHasDuplicates(temp))
                    continue;
                if (resultEqualsFeatures(temp, featureStrings))
                    return temp;
                result.add(insurances.get(j));
            }
        }

        return new ArrayList<>();
    }

    private static boolean resultEqualsFeatures(List<Insurance> result, List<String> featureStrings) {
        List<String> resultCopy = getFlatStreamOfFeatureNames(result).collect(Collectors.toList());
        List<String> featCopy = new ArrayList<>(featureStrings);
        featCopy.removeAll(resultCopy);
        return featCopy.isEmpty();
    }

    private static boolean isHasDuplicates(List<Insurance> temp) {

        Stream<String> stream = getFlatStreamOfFeatureNames(temp);

        List<String> feats = stream
                .collect(Collectors.toList());

        List<String> distinctFeats = temp.stream()
                .map(Insurance::getFeatures)
                .flatMap(Collection::stream)
                .map(Feature::getName)
                .distinct()
                .collect(Collectors.toList());
        return feats.size() == distinctFeats.size();
    }

    private static Stream<String> getFlatStreamOfFeatureNames(List<Insurance> temp) {
        return temp.stream()
                .map(Insurance::getFeatures)
                .flatMap(Collection::stream)
                .map(Feature::getName);
    }

    private static boolean insuranceFeaturesHasAnElementWhichIsNotInFeatures(List<Insurance> insurances, List<String> featureStrings) {
        Predicate<String> missingInFeatures = object -> featureStrings.stream().noneMatch(object::equals);

        List<String> missingInFeaturesList = getFlatStreamOfFeatureNames(insurances)
                .filter(missingInFeatures)
                .collect(Collectors.toList());

        return !missingInFeaturesList.isEmpty();
    }

    public static void main(String[] args) {
        Feature[] features = new Feature[]{
                new Feature("A"),
                new Feature("B"),
                new Feature("main.java.C"),
                new Feature("main.java.D"),
                new Feature("E"),
                new Feature("F"),
                new Feature("G"),
                new Feature("H"),
                new Feature("I"),
        };

        //System.out.println(getInsurancesByFeature(new Feature("main.java.D")));
        //System.out.println(getInsurancesByFeature(new Feature("main.java.D")));
        System.out.println(getPerfectMatchingInsurances(features));

    }

}
