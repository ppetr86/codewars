package com.example;

import java.util.ArrayList;
import java.util.List;

class EventSource {
    public record Airplane(String brand, int passengerCount) implements Observer {
        @Override
        public void update(String event) {
            System.out.println("updating Airplane " + event);
        }
    }

    public record Car(String brand, String licensePlate) implements Observer {
        @Override
        public void update(String event) {
            System.out.println("updating Car " + event);
        }
    }

    public record Motorbike(String brand, String power) implements Observer {
        @Override
        public void update(String event) {
            System.out.println("updating Motorbike " + event);
        }
    }

    public interface Observer {
        void update(String event);
    }

    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(String event) {
        observers.forEach(observer -> observer.update(event));
    }

    public static void main(String[] args) {
        EventSource e1 = new EventSource();
        e1.addObserver(new Car("mercedes", "7A1"));
        e1.addObserver(new Motorbike("honda", "105kw"));
        e1.addObserver(new Airplane("airbus", 555));

        e1.notifyObservers("Funny Event");
    }
}