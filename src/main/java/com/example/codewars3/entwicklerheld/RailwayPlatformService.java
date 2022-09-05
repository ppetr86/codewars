package com.example.codewars3.entwicklerheld;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class RailwayPlatformService {

    // Set this to true to skip the slow tests for faster test runs. To finish the challenge you must set this to false.
    public static boolean skipSlowTests = false;

    public static void main(String[] args) {
        //String name, String type, String boardId, String stopId, String dateTime, String origin, String track, String detailsId
        List<Board> a1 = Arrays.asList(
                new Board("ICE 698", "xxx", "8000170", "8000170", "2021-01-01T22:17", "8000170", "1",
                        "123"),
                new Board("ICE 699", "xxx", "8000170", "8000170", "2021-01-01T23:16", "8000170", "1",
                        "456"));
        List<Board> a2 = Arrays.asList(
                new Board("ICE 698", "xxx", "8000170", "8000170", "2021-01-01T23:15", "8000170", "1",
                        "123"),
                new Board("ICE 698", "xxx", "8000170", "8000170", "2021-01-01T23:16", "8000170", "1",
                        "123"),
                new Board("ICE 698", "xxx", "8000170", "8000170", "2021-01-01T23:18", "8000170", "1",
                        "123"),
                new Board("ICE 700", "xxx", "8000170", "8000170", "2021-01-02T00:16", "8000170", "1",
                        "123"));
        System.out.println(convertBoardsToTrainStops(a1, a2));
        List<TrainStop> stops = new ArrayList<>();

        LocalDateTime arrival = LocalDateTime.of(2021, 8, 1, 9, 0);
        LocalDateTime depart = arrival.plusMinutes(10);
        stops.add(new TrainStop("ICE 618", arrival, depart));

        arrival = LocalDateTime.of(2021, 8, 1, 9, 40);
        depart = arrival.plusMinutes(140);
        stops.add(new TrainStop("ICE 610", arrival, depart));

        arrival = LocalDateTime.of(2021, 8, 1, 9, 50);
        depart = arrival.plusMinutes(120);
        stops.add(new TrainStop("ICE 500", arrival, depart));

        arrival = LocalDateTime.of(2021, 8, 1, 11, 0);
        depart = arrival.plusMinutes(30);
        stops.add(new TrainStop("ICE 400", arrival, depart));

        arrival = LocalDateTime.of(2021, 8, 1, 15, 0);
        depart = arrival.plusMinutes(240);
        stops.add(new TrainStop("ICE 300", arrival, depart));

        arrival = LocalDateTime.of(2021, 8, 1, 18, 0);
        depart = arrival.plusMinutes(240);
        stops.add(new TrainStop("ICE 200", arrival, depart));

        //System.out.println(calculateMinimumNumberOfPlatforms(stops));
        stops = new ArrayList<>();

        //novy priklad
        arrival = LocalDateTime.of(2021, 8, 1, 9, 0);
        depart = arrival.plusMinutes(10);
        stops.add(new TrainStop("ICE 611", arrival, depart));

        arrival = LocalDateTime.of(2021, 8, 1, 9, 1);
        depart = arrival.plusMinutes(9);
        stops.add(new TrainStop("ICE 611", arrival, depart));

        arrival = LocalDateTime.of(2021, 8, 1, 9, 1);
        depart = arrival.plusMinutes(9);
        stops.add(new TrainStop("ICE 611", arrival, depart));

        arrival = LocalDateTime.of(2021, 8, 1, 9, 2);
        depart = arrival.plusMinutes(8);
        stops.add(new TrainStop("ICE 611", arrival, depart));

        arrival = LocalDateTime.of(2021, 8, 1, 9, 9);
        depart = arrival.plusMinutes(10);
        stops.add(new TrainStop("ICE 613", arrival, depart));

    /*arrival = LocalDateTime.of(2021, 8, 1, 9, 9);
    depart = arrival.plusMinutes(10);
    stops.add(new TrainStop("ICE 614", arrival, depart));*/

    /*//duplikat
    arrival = LocalDateTime.of(2021, 8, 1, 15, 9);
    depart = arrival.plusMinutes(0);
    stops.add(new TrainStop("ICE 611", arrival, depart));
    //duplikat
    arrival = LocalDateTime.of(2021, 8, 1, 15, 9);
    depart = arrival.plusMinutes(0);
    stops.add(new TrainStop("ICE 611", arrival, depart));*/

        //System.out.println(calculateMinimumNumberOfPlatforms(stops));

        stops.clear();
        stops.add(new TrainStop("ICE	990",
                LocalDateTime.of(2021, 12, 10, 0, 23),
                LocalDateTime.of(2021, 12, 10, 0, 31)));
        stops.add(new TrainStop("ICE	887",
                LocalDateTime.of(2021, 12, 10, 0, 24),
                LocalDateTime.of(2021, 12, 10, 0, 27)));
        stops.add(new TrainStop("NJ	40421",
                LocalDateTime.of(2021, 12, 10, 1, 0),
                LocalDateTime.of(2021, 12, 10, 1, 3)));
        stops.add(new TrainStop("NJ	421",
                LocalDateTime.of(2021, 12, 10, 1, 0),
                LocalDateTime.of(2021, 12, 10, 1, 3)));
        stops.add(new TrainStop("ICE	209",
                LocalDateTime.of(2021, 12, 10, 1, 59),
                LocalDateTime.of(2021, 12, 10, 2, 15)));
        stops.add(new TrainStop("ICE	698",
                LocalDateTime.of(2021, 12, 10, 2, 24),
                LocalDateTime.of(2021, 12, 10, 2, 30)));
        stops.add(new TrainStop("ICE	699",
                LocalDateTime.of(2021, 12, 10, 2, 38),
                LocalDateTime.of(2021, 12, 10, 2, 44)));
        stops.add(new TrainStop("ICE	208",
                LocalDateTime.of(2021, 12, 10, 3, 20),
                LocalDateTime.of(2021, 12, 10, 3, 23)));
        stops.add(new TrainStop("NJ	40490",
                LocalDateTime.of(2021, 12, 10, 3, 56),
                LocalDateTime.of(2021, 12, 10, 3, 59)));
        stops.add(new TrainStop("NJ	50490",
                LocalDateTime.of(2021, 12, 10, 3, 56),
                LocalDateTime.of(2021, 12, 10, 3, 59)));
        stops.add(new TrainStop("NJ	420",
                LocalDateTime.of(2021, 12, 10, 3, 56),
                LocalDateTime.of(2021, 12, 10, 3, 59)));
        stops.add(new TrainStop("ICE	827",
                LocalDateTime.of(2021, 12, 10, 4, 33),
                LocalDateTime.of(2021, 12, 10, 4, 36)));
        stops.add(new TrainStop("ICE	618",
                LocalDateTime.of(2021, 12, 10, 5, 12),
                LocalDateTime.of(2021, 12, 10, 6, 1)));
        stops.add(new TrainStop("ICE	521",
                LocalDateTime.of(2021, 12, 10, 5, 27),
                LocalDateTime.of(2021, 12, 10, 5, 30)));
        stops.add(new TrainStop("ICE	672",
                LocalDateTime.of(2021, 12, 10, 5, 30),
                LocalDateTime.of(2021, 12, 10, 5, 34)));
        stops.add(new TrainStop("IC	2026",
                LocalDateTime.of(2021, 12, 10, 5, 54),
                LocalDateTime.of(2021, 12, 10, 5, 57)));
        stops.add(new TrainStop("ICE	523",
                LocalDateTime.of(2021, 12, 10, 6, 33),
                LocalDateTime.of(2021, 12, 10, 6, 36)));
        stops.add(new TrainStop("ICE	774",
                LocalDateTime.of(2021, 12, 10, 6, 36),
                LocalDateTime.of(2021, 12, 10, 6, 42)));
        stops.add(new TrainStop("ICE	18",
                LocalDateTime.of(2021, 12, 10, 6, 40),
                LocalDateTime.of(2021, 12, 10, 7, 0)));
        stops.add(new TrainStop("ICE	250",
                LocalDateTime.of(2021, 12, 10, 6, 40),
                LocalDateTime.of(2021, 12, 10, 7, 0)));
        stops.add(new TrainStop("RJX	66",
                LocalDateTime.of(2021, 12, 11, 0, 23),
                LocalDateTime.of(2021, 12, 11, 0, 31)));
        stops.add(new TrainStop("ICE	887",
                LocalDateTime.of(2021, 12, 11, 0, 24),
                LocalDateTime.of(2021, 12, 11, 0, 27)));
        stops.add(new TrainStop("NJ	40421",
                LocalDateTime.of(2021, 12, 11, 1, 0),
                LocalDateTime.of(2021, 12, 11, 1, 3)));
        stops.add(new TrainStop("NJ	421",
                LocalDateTime.of(2021, 12, 11, 1, 0),
                LocalDateTime.of(2021, 12, 11, 1, 3)));
        stops.add(new TrainStop("NJ	425",
                LocalDateTime.of(2021, 12, 11, 1, 0),
                LocalDateTime.of(2021, 12, 11, 1, 3)));
        stops.add(new TrainStop("ICE	209",
                LocalDateTime.of(2021, 12, 11, 1, 59),
                LocalDateTime.of(2021, 12, 11, 2, 15)));
        stops.add(new TrainStop("ICE	698",
                LocalDateTime.of(2021, 12, 11, 2, 24),
                LocalDateTime.of(2021, 12, 11, 2, 30)));
        stops.add(new TrainStop("ICE	699",
                LocalDateTime.of(2021, 12, 11, 2, 38),
                LocalDateTime.of(2021, 12, 11, 2, 44)));
        stops.add(new TrainStop("ICE	208",
                LocalDateTime.of(2021, 12, 11, 3, 20),
                LocalDateTime.of(2021, 12, 11, 3, 23)));
        stops.add(new TrainStop("NJ	40490",
                LocalDateTime.of(2021, 12, 11, 3, 56),
                LocalDateTime.of(2021, 12, 11, 3, 59)));
        stops.add(new TrainStop("NJ	420",
                LocalDateTime.of(2021, 12, 11, 3, 56),
                LocalDateTime.of(2021, 12, 11, 3, 59)));
        stops.add(new TrainStop("ICE	827",
                LocalDateTime.of(2021, 12, 11, 4, 33),
                LocalDateTime.of(2021, 12, 11, 4, 36)));
        stops.add(new TrainStop("ICE	618",
                LocalDateTime.of(2021, 12, 11, 5, 12),
                LocalDateTime.of(2021, 12, 11, 6, 1)));
        stops.add(new TrainStop("ICE	521",
                LocalDateTime.of(2021, 12, 11, 5, 27),
                LocalDateTime.of(2021, 12, 11, 5, 30)));
        stops.add(new TrainStop("RJX	63",
                LocalDateTime.of(2021, 12, 11, 5, 28),
                LocalDateTime.of(2021, 12, 11, 5, 39)));
        stops.add(new TrainStop("ICE	672",
                LocalDateTime.of(2021, 12, 11, 5, 30),
                LocalDateTime.of(2021, 12, 11, 5, 34)));
        stops.add(new TrainStop("IC	2026",
                LocalDateTime.of(2021, 12, 11, 5, 54),
                LocalDateTime.of(2021, 12, 11, 5, 57)));
        stops.add(new TrainStop("ICE	523",
                LocalDateTime.of(2021, 12, 11, 6, 33),
                LocalDateTime.of(2021, 12, 11, 6, 36)));
        stops.add(new TrainStop("ICE	774",
                LocalDateTime.of(2021, 12, 11, 6, 36),
                LocalDateTime.of(2021, 12, 11, 6, 56)));
        stops.add(new TrainStop("ICE	18",
                LocalDateTime.of(2021, 12, 11, 6, 40),
                LocalDateTime.of(2021, 12, 11, 7, 0)));
        stops.add(new TrainStop("ICE	250",
                LocalDateTime.of(2021, 12, 11, 6, 40),
                LocalDateTime.of(2021, 12, 11, 7, 0)));
        stops.add(new TrainStop("IC	2027",
                LocalDateTime.of(2021, 12, 9, 23, 42),
                LocalDateTime.of(2021, 12, 10, 0, 2)));
        stops.add(new TrainStop("ICE	619",
                LocalDateTime.of(2021, 12, 10, 0, 7),
                LocalDateTime.of(2021, 12, 10, 0, 27)));
        stops.add(new TrainStop("IC	2027",
                LocalDateTime.of(2021, 12, 10, 23, 42),
                LocalDateTime.of(2021, 12, 11, 0, 2)));
        stops.add(new TrainStop("ICE	619",
                LocalDateTime.of(2021, 12, 11, 0, 7),
                LocalDateTime.of(2021, 12, 11, 0, 27)));

        System.out.println(calculateMinimumNumberOfPlatforms(stops));

    }

    public static List<TrainStop> convertBoardsToTrainStops(List<Board> arrivals,
                                                            List<Board> departures) {

        Map<String, List<Board>> nameDepartures = departures.stream()
                .sorted(Comparator.comparing(cur -> LocalDateTime.parse(cur.dateTime)))
                .collect(Collectors.groupingBy(s -> s.name));

        List<TrainStop> result = new ArrayList<>();
        LocalDateTime arrivalTime;

        for (Board arrival : arrivals) {
            arrivalTime = LocalDateTime.parse(arrival.dateTime);
            // iterace prijezdy, pokud odjezdy obsahuji cislo vlaku..
            if (nameDepartures.containsKey(arrival.name)) {

                LocalDateTime finalArrivalTime = arrivalTime;

                //odjezdy daneho cisla vlaku ve stejny cas do 60 minut po prijezdu
                Board matchDepart = nameDepartures.get(arrival.name).stream()
                        .filter(depart -> depart.dateTime.equals(arrival.dateTime)
                                || (LocalDateTime.parse(depart.dateTime).isAfter(finalArrivalTime)
                                && (LocalDateTime.parse(depart.dateTime).minusMinutes(61)
                                .isBefore(finalArrivalTime))))
                        .findFirst().orElse(null);

                if (matchDepart != null) {
                    result.add(
                            new TrainStop(arrival.name, arrivalTime, LocalDateTime.parse(matchDepart.dateTime)));
                    nameDepartures.get(arrival.name).remove(matchDepart);
                } else {
                    // pridavam prijezd bez odjezdu do dalsi zastavky
                    result.add(new TrainStop(arrival.name, arrivalTime, arrivalTime.plusMinutes(20L)));
                }
            } else {
                // pridavam prijezd bez odjezdu do dalsi zastavky
                result.add(new TrainStop(arrival.name, arrivalTime, arrivalTime.plusMinutes(20L)));
            }
        }

        Map<String, List<Board>> nameArrivals = arrivals.stream()
                .sorted(Comparator.comparing(cur -> LocalDateTime.parse(cur.dateTime)))
                .collect(Collectors.groupingBy(s -> s.name));

        for (Board dpt : departures) {
            if (!nameArrivals.containsKey(dpt.name)) {
                result.add(new TrainStop(dpt.name, LocalDateTime.parse(dpt.dateTime).minusMinutes(20),
                        LocalDateTime.parse(dpt.dateTime)));
            } else if (nameDepartures.containsKey(dpt.name)) {
                Board arrivalOfDpt = nameArrivals.get(dpt.name).stream()
                        .filter(arr -> arr.dateTime.equals(dpt.dateTime)
                                || (LocalDateTime.parse(dpt.dateTime).isAfter(LocalDateTime.parse(arr.dateTime))
                                && (LocalDateTime.parse(dpt.dateTime).minusMinutes(61)
                                .isBefore(LocalDateTime.parse(arr.dateTime)))))
                        .findFirst().orElse(null);
                if (arrivalOfDpt == null) {
                    result.add(new TrainStop(dpt.name, LocalDateTime.parse(dpt.dateTime).minusMinutes(20),
                            LocalDateTime.parse(dpt.dateTime)));
                }
            }
        }

        return result;
    }


    public static int calculateMinimumNumberOfPlatforms(List<TrainStop> trainStops) {

        List<LocalDateTime> arrivals = new ArrayList<>();
        List<LocalDateTime> departures = new ArrayList<>();
        for (TrainStop ts : trainStops) {
            arrivals.add(ts.arrival);
            departures.add(ts.departure);
        }
        arrivals = arrivals.stream().sorted().collect(Collectors.toList());
        departures = departures.stream().sorted().collect(Collectors.toList());

        int i = 0, j = 0;
        int count = 0, platforms = 0;

        while (i < arrivals.size() && j < arrivals.size()) {
            if (arrivals.get(i).isBefore(departures.get(j)) || arrivals.get(i)
                    .equals(departures.get(j))) {
                count++;
                platforms = Math.max(platforms, count);
                i++;
            } else {
                count--;
                j++;
            }
        }
        return platforms;
    }


    public record Board(String name, String type, String boardId, String stopId, String dateTime,
                        String origin, String track, String detailsId) {

    }

    public record TrainStop(String trainNumber, LocalDateTime arrival, LocalDateTime departure) {

        @Override
        public String toString() {
            return trainNumber + " " + arrival + " - " + departure + "\n";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            TrainStop trainStop = (TrainStop) o;
            return Objects.equals(trainNumber, trainStop.trainNumber) &&
                    Objects.equals(arrival, trainStop.arrival) &&
                    Objects.equals(departure, trainStop.departure);
        }

        @Override
        public int hashCode() {
            return Objects.hash(trainNumber, arrival, departure);
        }
    }

}
