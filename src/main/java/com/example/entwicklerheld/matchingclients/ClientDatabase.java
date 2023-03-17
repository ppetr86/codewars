package com.example.entwicklerheld.matchingclients;

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

        //zacinaji kompletni parsovaci data
        DATABASE.add(new Client("Ortrud", "Hill", "019125610664", "Bergstraße",
                "25", "6241", "Luckenwalde", "20221565"));

        DATABASE.add(new Client("Herma", "Heitmann ", "019521068868", "Geschwister-Scholl-Straße",
                "20B", "31429", "Mülheim an der Ruhr", "20221572"));

        DATABASE.add(new Client("Monika", "Kastner", "019135763642", "Nelkenweg",
                "45", "58262", "Wangen im Allgäu", "20221579"));

        //zacinaji nekompletni parsovaci data
        DATABASE.add(new Client("Diane", "Nguyen", "015234531642", "Finkenweg",
                "8", "29992", "Bremen", "20221586"));

        DATABASE.add(new Client("Diane", "Nguyen", "015234531642", "Finkenweg",
                "8", "29992", "Bremen", "20221593"));

        DATABASE.add(new Client("Diane", "Nguyen", "015234531642", "Finkenweg",
                "8", "29992", "Bremen", "20221607"));

        DATABASE.add(new Client("Diane", "Nguyen", "015234531642", "Finkenweg",
                "8", "29992", "Bremen", "20221649"));

        DATABASE.add(new Client("Diane", "Nguyen", "015234531642", "Finkenweg",
                "8", "29992", "Bremen", "20221614"));

        DATABASE.add(new Client("Diane", "Nguyen", "015234531642", "Finkenweg",
                "8", "29992", "Bremen", "20221628"));

        DATABASE.add(new Client("Diane", "Nguyen", "015234531642", "Finkenweg",
                "8", "29992", "Bremen", "20221642"));

        DATABASE.add(new Client("Diane", "Nguyen", "015234531642", "Finkenweg",
                "8", "29992", "Bremen", "20221656"));

        DATABASE.add(new Client("Diane", "Nguyen", "015234531642", "Finkenweg",
                "8", "29992", "Bremen", "20221663"));

        DATABASE.add(new Client("Diane", "Nguyen", "015234531642", "Finkenweg",
                "8", "29992", "Bremen", "20221670"));

        DATABASE.add(new Client("Diane", "Nguyen", "015234531642", "Finkenweg",
                "8", "29992", "Bremen", "20221677"));

        DATABASE.add(new Client("Diane", "Nguyen", "015234531642", "Finkenweg",
                "8", "29992", "Bremen", "20221691"));

        DATABASE.add(new Client("Diane", "Nguyen", "015234531642", "Finkenweg",
                "8", "29992", "Bremen", "20221698"));

        DATABASE.add(new Client("Anett", "Haug", "019685848009", "Feldstraße",
                "14", "70676", "Uelzen", "20221635"));
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
