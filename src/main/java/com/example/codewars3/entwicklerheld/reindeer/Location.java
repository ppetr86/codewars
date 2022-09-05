package com.example.codewars3.entwicklerheld.reindeer;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Location {
    private String locationName;
    private int locationId;
    private Point coordinates;
    private LinkedList<Map<Object, List<String>>> tasks = new LinkedList<>();

    public Location(String locationName, int locationId, Point coordinates) {
        this.locationName = locationName;
        this.locationId = locationId;
        this.coordinates = coordinates;
    }

    public String getLocationName() {
        return locationName;
    }

    public int getLocationId() {
        return locationId;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public LinkedList<Map<Object, List<String>>> getTasks() {
        return tasks;
    }

    public void setTasks(LinkedList<Map<Object, List<String>>> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return this.getLocationName() + " (" + this.getCoordinates().x + "|" + this.getCoordinates().y + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || other.getClass() != this.getClass()) {
            return false;
        }

        Location otherLocation = (Location) other;

        return otherLocation.getCoordinates() == this.getCoordinates() && otherLocation.getLocationId() == this.getLocationId() && otherLocation.getLocationName().equals(this.getLocationName());
    }
}

