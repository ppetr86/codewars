package com.example.codewars3.entwicklerheld.matchingclients;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ClientDatabase {

    private static final List<Client> DATABASE = new ArrayList<>();

    static {
        DATABASE.add(new Client("Petr", "Novotny", "123456", "Kocianova",
                "8", "15500", "Praha", "123456"));
        DATABASE.add(new Client("Diane", "Nguyen", "015234531642", "Finkenweg",
                "8", "29992", "Bremen", "20201157"));
    }

    public static List<Client> getAllClients() {
        return DATABASE;
    }

    public static List<Client> getClientByFirstName(String firstName) {
        return DATABASE.stream()
                .filter(each -> each.firstName.equalsIgnoreCase(firstName))
                .collect(Collectors.toList());
    }

    public static List<Client> getClientByLastName(String lastName) {
        Predicate<Client> clientPredicate = each -> each.lastName.equalsIgnoreCase(lastName);
        return DATABASE.stream()
                .filter(clientPredicate)
                .collect(Collectors.toList());
    }

    public static List<Client> findClients(String firstNameParam, String lastNameParam,
                                           String phoneNumberParam, String streetParam,
                                           String houseNumberParam, String postcodeParam,
                                           String clientIdParam, String cityParam) {
        Predicate<Client> firstNamePredicate = client -> firstNameParam == null || firstNameParam.isEmpty() || firstNameParam.equalsIgnoreCase(client.firstName);
        Predicate<Client> lastNamePredicate = client -> lastNameParam == null || lastNameParam.isEmpty() || lastNameParam.equalsIgnoreCase(client.lastName);

        Predicate<Client> phoneNumberPredicate = client -> phoneNumberParam == null || phoneNumberParam.isEmpty() || phoneNumberParam.equalsIgnoreCase(client.phoneNumber);
        Predicate<Client> streetPredicate = client -> streetParam == null || streetParam.isEmpty() || streetParam.equalsIgnoreCase(client.street);

        Predicate<Client> houseNumberPredicate = client -> houseNumberParam == null || houseNumberParam.isEmpty() || houseNumberParam.equalsIgnoreCase(client.houseNumber);
        Predicate<Client> postcodePredicate = client -> postcodeParam == null || postcodeParam.isEmpty() || postcodeParam.equalsIgnoreCase(client.postcode);

        Predicate<Client> clientIdPredicate = client -> clientIdParam == null || clientIdParam.isEmpty() || clientIdParam.equalsIgnoreCase(client.clientId);
        Predicate<Client> cityPredicate = client -> cityParam == null || cityParam.isEmpty() || cityParam.equalsIgnoreCase(client.city);

        return DATABASE.stream()
                .filter(firstNamePredicate)
                .filter(lastNamePredicate)

                .filter(phoneNumberPredicate)
                .filter(streetPredicate)

                .filter(houseNumberPredicate)
                .filter(postcodePredicate)

                .filter(clientIdPredicate)
                .filter(cityPredicate)

                .collect(Collectors.toList());
    }

    public static void addClient(Client client) {
        DATABASE.add(client);
    }

    public static void addClients(List<Client> clients) {
        DATABASE.addAll(clients);
    }


}
