package com.example.codewars3.entwicklerheld.reindeer;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class ReindeerRoute {

    public static Location getNearestNeighbour(Location startLocation, List<Location> locationList) {
        if (locationList.size() == 0) return null;
        if (locationList.size() == 1 && startLocation.equals(locationList.get(0))) return locationList.get(0);
        return null;
    }

    public static void executeOnLocationTasks(Location location) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //second scenario
        throw new Error("No Implementation");
    }

    /*public static Route getShortestReindeerRoute(Location startLocation, List<Location> locationList) {
        //third scenario
        throw new Error("No Implementation");
    }*/
}
