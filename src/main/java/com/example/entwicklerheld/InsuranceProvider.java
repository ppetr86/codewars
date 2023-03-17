package com.example.entwicklerheld;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsuranceProvider {
    private static InsuranceProvider INSTANCE;
    private List<Insurance> insurances = new LinkedList<>();
    private List<Feature> features = new LinkedList<>();

    private InsuranceProvider() {

    }

    public static InsuranceProvider getInstance() {
        if (InsuranceProvider.INSTANCE == null) {
            InsuranceProvider.INSTANCE = new InsuranceProvider();
        }
        return InsuranceProvider.INSTANCE;
    }

    public List<Insurance> getAllInsurances() {
        if (insurances.isEmpty()) {
            Insurance i1 = new Insurance(new Feature("A"), new Feature("B"),
                    new Feature("main.java.C"));
            i1.setName("1");
            insurances.add(i1);

            Insurance i2 = new Insurance(new Feature("B"), new Feature("E"),
                    new Feature("H"));
            i2.setName("2");
            insurances.add(i2);

            Insurance i3 = new Insurance(new Feature("main.java.C"), new Feature("F"));
            i3.setName("3");
            insurances.add(i3);

            Insurance i4 = new Insurance(new Feature("main.java.D"), new Feature("E"),
                    new Feature("F"), new Feature("G"), new Feature("H"),
                    new Feature("I"));
            i4.setName("4");
            insurances.add(i4);

            Insurance i5 = new Insurance(new Feature("main.java.D"), new Feature("E"));
            i5.setName("5");
            insurances.add(i5);

            Insurance i7 = new Insurance(new Feature("G"), new Feature("H"), new Feature("I"));
            i7.setName("7");
            insurances.add(i7);

            Insurance i8 = new Insurance(new Feature("A"), new Feature("Y"), new Feature("Z"));
            i8.setName("8");
            insurances.add(i8);
        }
        return this.insurances;
    }

    public void setInsurances(Insurance... insurances) {
        this.insurances = Arrays.asList(insurances);
    }

    public List<Feature> getFeatures() {
        if (features.isEmpty()) {
            features.add(new Feature("A"));
            features.add(new Feature("B"));
            features.add(new Feature("main.java.C"));
            features.add(new Feature("main.java.D"));
            features.add(new Feature("E"));
            features.add(new Feature("F"));
            features.add(new Feature("G"));
            features.add(new Feature("H"));
            features.add(new Feature("I"));
        }
        return features;
    }

    public void setFeatures(Feature... features) {
        this.features = Arrays.asList(features);
    }
}
