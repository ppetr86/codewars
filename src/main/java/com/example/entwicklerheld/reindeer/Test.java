package com.example.entwicklerheld.reindeer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Point p = new Point(25, 66);
        List<Location> locationList = new ArrayList<>();
        Location rova = new Location("Rovaniemi", 0, p);
        System.out.println(ReindeerRoute.getNearestNeighbour(rova, locationList));
        p = new Point(0, 52);
        Location lond = new Location("London", 30, p);
        locationList.add(lond);

        System.out.println(ReindeerRoute.getNearestNeighbour(rova, locationList));
    }
}
