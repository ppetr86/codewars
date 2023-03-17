package com.example.entwicklerheld;

import java.util.Arrays;
import java.util.List;

public class Insurance {
    private List<Feature> features;
    private double price;
    private String name;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Insurance(List<Feature> features) {
        this.features = features;
    }

    public Insurance(Feature... features) {
        this.features = Arrays.asList(features);
    }

    public List<Feature> getFeatures() {
        return features;
    }

    @Override
    public String toString() {
        if (this.name != null) {
            return "Insurance{" +
                    " name='" + name + '\'' +
                    ", features=" + features +
                    '}';
        }
        return "Insurance{" +
                "" + features +
                '}';

    }
}
