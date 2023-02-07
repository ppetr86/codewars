package com.example.codewars3.entwicklerheld.matchingclients;

import java.util.ArrayList;

public class Client {
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String street;
    public String houseNumber;
    public String postcode;
    public String clientId;
    public String city;
    public ArrayList<String> otherIds;

    Client(String firstName, String lastName,
           String phoneNumber, String street,
           String houseNumber, String postcode,
           String city, String clientId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postcode = postcode;
        this.clientId = clientId;
        this.city = city;
        this.otherIds = new ArrayList<String>();
    }

    public Client() {
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", postcode='" + postcode + '\'' +
                ", clientId='" + clientId + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
