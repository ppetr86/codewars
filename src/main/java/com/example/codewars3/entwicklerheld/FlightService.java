package com.example.codewars3.entwicklerheld;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FlightService {


    private static Airport dresden_international = new Airport("Dresden International");
    private static Airport barcelona = new Airport("Aeropuerto de Barcelona-El Prat");
    private static List<Flight> edges = new ArrayList<>();

    static {

        Airport london_heathrow_airport = new Airport("London Heathrow Airport");
        Airport istanbul_international = new Airport("Istanbul International");
        Airport frankfurt_am_main = new Airport("Frankfurt am Main");
        Airport leipzig = new Airport("Leipzig/Halle");
        Airport münchen = new Airport("München");

        Airport berlin_tegel = new Airport("Berlin Tegel");
        Airport mettmann_international_airport = new Airport("Mettmann International Airport");

        Airport cdg = new Airport("Aéroport Paris-Charles de Gaulle");
        Airport zürich = new Airport("Zürich");
        Airport amsterdam_schiphol = new Airport("Amsterdam Schiphol");
        Airport hamburg = new Airport("Hamburg");

        Flight a1 = new Flight(leipzig, frankfurt_am_main, Duration.ofMinutes(55), 20);
        Flight a2 = new Flight(frankfurt_am_main, leipzig, Duration.ofMinutes(55), 20);
        Flight a3 = new Flight(frankfurt_am_main, zürich, Duration.ofMinutes(55), 20);
        Flight a4 = new Flight(zürich, frankfurt_am_main, Duration.ofMinutes(55), 20);

        Flight a5 = new Flight(münchen, frankfurt_am_main, Duration.ofMinutes(60), 2);
        Flight a6 = new Flight(frankfurt_am_main, dresden_international, Duration.ofMinutes(60), 32);
        Flight a7 = new Flight(frankfurt_am_main, münchen, Duration.ofMinutes(60), 13);
        Flight a8 = new Flight(dresden_international, frankfurt_am_main, Duration.ofMinutes(60), 20);
        Flight a9 = new Flight(dresden_international, münchen, Duration.ofMinutes(60), 20);

        Flight a10 = new Flight(hamburg, frankfurt_am_main, Duration.ofMinutes(65), 20);
        Flight a11 = new Flight(frankfurt_am_main, hamburg, Duration.ofMinutes(65), 20);

        Flight a12 = new Flight(frankfurt_am_main, berlin_tegel, Duration.ofMinutes(70), 11);
        Flight a13 = new Flight(berlin_tegel, frankfurt_am_main, Duration.ofMinutes(70), 11);

        Flight a14 = new Flight(london_heathrow_airport, amsterdam_schiphol, Duration.ofMinutes(75),
                20);
        Flight a15 = new Flight(frankfurt_am_main, cdg, Duration.ofMinutes(75), 20);
        Flight a16 = new Flight(cdg, frankfurt_am_main, Duration.ofMinutes(75), 20);
        Flight a17 = new Flight(london_heathrow_airport, zürich, Duration.ofMinutes(75), 100);

        Flight a18 = new Flight(dresden_international, zürich, Duration.ofMinutes(80), 20);
        Flight a19 = new Flight(zürich, dresden_international, Duration.ofMinutes(80), 20);
        Flight a20 = new Flight(dresden_international, amsterdam_schiphol, Duration.ofMinutes(80), 20);

        Flight a21 = new Flight(mettmann_international_airport, münchen, Duration.ofMinutes(90), 100);
        Flight a22 = new Flight(london_heathrow_airport, münchen, Duration.ofMinutes(90), 100);
        Flight a23 = new Flight(mettmann_international_airport, frankfurt_am_main,
                Duration.ofMinutes(90), 100);
        Flight a24 = new Flight(london_heathrow_airport, istanbul_international, Duration.ofMinutes(90),
                30);

        Flight a25 = new Flight(frankfurt_am_main, london_heathrow_airport, Duration.ofMinutes(100),
                20);
        Flight a26 = new Flight(london_heathrow_airport, frankfurt_am_main, Duration.ofMinutes(100),
                20);

        Flight a27 = new Flight(frankfurt_am_main, barcelona, Duration.ofMinutes(110), 0);

        Flight a28 = new Flight(barcelona, frankfurt_am_main, Duration.ofMinutes(120), 2);

        Flight a29 = new Flight(london_heathrow_airport, barcelona, Duration.ofMinutes(130), 20);
        Flight a30 = new Flight(münchen, barcelona, Duration.ofMinutes(130), 2);
        Flight a31 = new Flight(barcelona, münchen, Duration.ofMinutes(130), 2);
        Flight a32 = new Flight(amsterdam_schiphol, barcelona, Duration.ofMinutes(130), 20);

        Flight a33 = new Flight(london_heathrow_airport, istanbul_international,
                Duration.ofMinutes(240), 30);
        Flight a34 = new Flight(frankfurt_am_main, istanbul_international, Duration.ofMinutes(240), 30);
        Flight a35 = new Flight(istanbul_international, dresden_international, Duration.ofMinutes(240),
                30);
        Flight a36 = new Flight(istanbul_international, frankfurt_am_main, Duration.ofMinutes(240), 30);
        Flight a37 = new Flight(dresden_international, istanbul_international, Duration.ofMinutes(240),
                30);
        Flight a38 = new Flight(istanbul_international, london_heathrow_airport,
                Duration.ofMinutes(240), 30);
        Flight a39 = new Flight(mettmann_international_airport, istanbul_international,
                Duration.ofMinutes(240), 30);

        edges.add(a1);
        edges.add(a2);
        edges.add(a3);
        edges.add(a4);
        edges.add(a5);
        edges.add(a6);
        edges.add(a7);
        edges.add(a8);
        edges.add(a9);
        edges.add(a10);
        edges.add(a11);
        edges.add(a12);
        edges.add(a13);
        edges.add(a14);
        edges.add(a15);
        edges.add(a16);
        edges.add(a17);
        edges.add(a18);
        edges.add(a19);
        edges.add(a20);
        edges.add(a21);
        edges.add(a22);
        edges.add(a23);
        edges.add(a24);
        edges.add(a25);
        edges.add(a26);
        edges.add(a27);
        edges.add(a28);
        edges.add(a29);
        edges.add(a30);
        edges.add(a31);
        edges.add(a32);
        edges.add(a33);
        edges.add(a34);
        edges.add(a35);
        edges.add(a36);
        edges.add(a37);
        edges.add(a38);
        edges.add(a39);
    }

    private Map<String, Duration> distance = new HashMap<>();
    private Set<String> settledNodes = new HashSet<>();
    private Queue<String> unSettledNodes = new PriorityQueue<>(new FlightComparator());
    private Map<String, String> predecessors = new HashMap<>();

    private Collection<Flight> availableFlights;

    private List<Flight> flights = new ArrayList<>();
    private Map<String, List<Flight>> flightsFrom = new HashMap<>();
    private Map<String, List<Flight>> flightsTo = new HashMap<>();

    private FlightService(Collection<Flight> availableFlights) {
        this.availableFlights = availableFlights;
    }

    public static void main(String[] args) {

        FlightService fs = FlightService.of(edges);

        System.out.println(fs.getShortestFlightByRoute(dresden_international, barcelona));


        FlightService fs2 = FlightService.of(edges);
        System.out.println(fs.getShortestFlightByRoute(dresden_international, barcelona));
    }

    public static FlightService of(Collection<Flight> availableFlights) {
        return new FlightService(availableFlights);
    }

    public Stream<Flight> getFullFlights() {
        return availableFlights.stream().filter(flight -> flight.getAvailableSeats() <= 0);
    }

    public Stream<Flight> getFlightsForDestination(Airport destination) {
        if (flightsTo.isEmpty()) {
            flightsTo = getFlightsTo();
        }
        return flightsTo.get(destination.getName()).stream();
    }

    public Stream<Flight> getFlightsForOrigin(Airport origin) {
        if (flightsFrom.isEmpty()) {
            flightsFrom = getFlightsTo();
        }
        return flightsFrom.get(origin.getName()).stream();
    }

    public void fillDistanceMapToHighValue(Set<String> keys) {
        keys.forEach(key -> distance.put(key, Duration.ofHours(10L)));
    }

    public List<Flight> getShortestFlightByRoute(Airport origin, Airport destination) {

        flightsTo = getFlightsTo();
        flightsFrom = getFlightsFrom();

        if (origin == null || destination == null || !flightsFrom.containsKey(origin.getName())
                || !flightsTo.containsKey(destination.getName())) {
            return new ArrayList<>();
        }

        Set<String> keys = new HashSet<>();
        keys.addAll(flightsFrom.keySet());
        keys.addAll(flightsTo.keySet());
        fillDistanceMapToHighValue(keys);

        distance.put(origin.getName(), Duration.ZERO);
        unSettledNodes.add(origin.getName());

        while (!unSettledNodes.isEmpty()) {
            String node = unSettledNodes.poll();

            for (String edge : getNeighbors(node, flightsFrom)) {
                if (!settledNodes.contains(edge)) {
                    Flight flight = flightsFrom.get(node).stream()
                            .filter(f -> f.getDestination().getName().equalsIgnoreCase(edge))
                            .findFirst().orElse(null);
                    Duration newDistance = distance.get(node).plus(flight.getDuration());
                    flights.add(flight);

                    if (newDistance.compareTo(distance.get(edge)) < 1) {
                        unSettledNodes.remove(edge);
                        distance.put(edge, newDistance);
                        predecessors.put(edge, node);
                        unSettledNodes.add(edge);
                    }
                }
            }
            if (node.equalsIgnoreCase(destination.getName())) {
                break;
            }
            settledNodes.add(node);
        }
        if (flights.isEmpty()) {
            return new ArrayList<>();
        }
        List<Flight> result = backtrack(flightsFrom, destination, origin);

        return result;
    }

    private Map<String, List<Flight>> getFlightsFrom() {
        if (flightsFrom.isEmpty())
            flightsFrom = filterStreamOfFlights()
                    .collect(Collectors.groupingBy(flight -> flight.getOrigin().getName()));
        return flightsFrom;
    }

    private Stream<Flight> filterStreamOfFlights() {
        return availableFlights.stream()
                .filter(flight -> flight.getAvailableSeats() != null)
                .filter(flight -> flight.getAvailableSeats() > 0)
                .filter(flight -> flight.getDuration() != null)
                .filter(flight -> !flight.getDuration().isNegative() && !flight.getDuration()
                        .equals(Duration.ZERO))
                .filter(flight -> flight.getDestination() != null)
                .filter(flight -> flight.getOrigin() != null)
                .filter(flight -> flight.getDestination().getName() != null)
                .filter(flight -> flight.getOrigin().getName() != null)
                .filter(flight -> !flight.getOrigin().getName().trim().isEmpty() && !flight.getDestination()
                        .getName().trim().isEmpty());
    }

    private Map<String, List<Flight>> getFlightsTo() {
        if (flightsTo.isEmpty())
            flightsTo = filterStreamOfFlights()
                    .collect(Collectors.groupingBy(flight -> flight.getDestination().getName()));
        return flightsTo;
    }

    private List<Flight> backtrack(Map<String, List<Flight>> flightsFrom, Airport destination,
                                   Airport origin) {

        List<Flight> result = new ArrayList<>();
        Flight flight = null;
        String from;
        String to = destination.getName();
        if (predecessors.containsKey(to)) {
            while (flight == null || !to.equalsIgnoreCase(origin.getName())) {
                from = predecessors.get(to);
                predecessors.remove(to);
                String finalTo = to;
                flight = flightsFrom.get(from).stream()
                        .filter(flight1 -> flight1.getDestination().getName().equalsIgnoreCase(finalTo))
                        .findFirst().orElse(null);
                result.add(flight);
                to = flight.getOrigin().getName();
            }

            Collections.reverse(result);
        }
        return result;
    }

    private List<String> getNeighbors(String node, Map<String, List<Flight>> flightsFrom) {
        List<String> neighbors = new ArrayList<>();
        if (!flightsFrom.containsKey(node)) {
            return new ArrayList<>();
        }
        List<Flight> from = flightsFrom.get(node);
        for (Flight edge : from) {
            if (!isSettled(edge.getDestination())) {
                neighbors.add(edge.getDestination().getName());
            }
        }
        return neighbors;
    }

    private boolean isSettled(Airport vertex) {
        return settledNodes.contains(vertex.getName());
    }

    class FlightComparator implements Comparator<String> {

        @Override
        public int compare(String airport1, String airport2) {
            return distance.get(airport1).compareTo(distance.get(airport2));
        }
    }

}
