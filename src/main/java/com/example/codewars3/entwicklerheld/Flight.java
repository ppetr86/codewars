package com.example.codewars3.entwicklerheld;

import java.time.Duration;

public class Flight {
    private Airport origin;
    private Airport destination;
    private Duration duration;
    private Integer availableSeats;


    public Flight(Airport origin, Airport destination, Duration duration, Integer availableSeats) {
        this.origin = origin;
        this.destination = destination;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }

    public Airport getOrigin() {
        return origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public Duration getDuration() {
        return duration;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int number) {
        this.availableSeats = number;
    }

    public String toString() {
        return this.getOrigin().getName() + " -> " + this.getDestination().getName() + " (avail. Seats: " + this.getAvailableSeats() + " (duration mins: " + this.getDuration().toMinutes() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Flight)) {
            return false;
        }
        Flight flightObject = (Flight) obj;
        return (
                flightObject.getDestination() == this.getDestination()
                        && flightObject.getOrigin() == this.getOrigin()
                        && this.getAvailableSeats().equals(flightObject.getAvailableSeats())

        );
    }
}

