package com.example.entwicklerheld.reindeer;

import java.util.ArrayList;

public abstract class AbstractRoute {
    private ArrayList<Location> locations = new ArrayList<>();

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public abstract double getTotalLength();

}
