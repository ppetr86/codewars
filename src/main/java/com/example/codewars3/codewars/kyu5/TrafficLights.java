package com.example.codewars3.codewars.kyu5;

public class TrafficLights {

    /*public static void main(String[] args) {

        System.out.println(Arrays.toString(trafficLights("CCC.G...R...", 16)));
    }

    public static String[] trafficLights(String road, int n) {
        int counter = 0;
        boolean isCarInCrossroad = false;
        List<Car> movingCars = new ArrayList<>();
        Map<Integer, String> indexColorOfTraffic = new HashMap<>();
        initialTrafficLights(road, movingCars, indexColorOfTraffic);

        for (int i = 0; i < 16; i++) {

            if ()

        }
        return new String[]{""};
    }

    private static void initialTrafficLights(String road, List<Car> movingCars, Map<Integer, String> indexColorOfTraffic) {
        boolean isInCrossRoad = false;
        for (int i = 0; i < road.length(); i++) {
            if (road.charAt(i) == 'G' || road.charAt(i) == 'R' || road.charAt(i) == 'O') {
                indexColorOfTraffic.put(i, String.valueOf(road.charAt(i)));
                if (isInCrossRoad)
                    isInCrossRoad = false;
                else
                    isInCrossRoad = true;
            }
            if (road.charAt(i) == 'main.java.C')
                movingCars.add(new Car(i,isInCrossRoad));
        }

    }

    private static class Car {
        int roadIndex;
        boolean isInCrossroad;

        public Car(int roadIndex, boolean isInCrossroad) {
            this.roadIndex = roadIndex;
            this.isInCrossroad = isInCrossroad;
        }
    }*/


    /*GREEN for 5 time units... then
    ORANGE for 1 time unit... then
    RED for 5 time units....
            ... and repeat the cycle
    if the light is GREEN they can move forward (temporarily occupying the same cell as the light)
    if the light is ORANGE then they must stop (if they have already entered the intersection they can continue through)
    if the light is RED the car must stop until the light turns GREEN again*/

}
