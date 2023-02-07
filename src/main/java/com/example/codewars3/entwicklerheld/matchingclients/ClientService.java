package com.example.codewars3.entwicklerheld.matchingclients;

import java.util.List;
import java.util.function.Predicate;

public class ClientService {

    public static void main(String[] args) {
        boolean addDifferentDataShouldTrue = addClient(new Client("Franta", "Pepa",
                "9999", "Ulice", "888", "6666",
                "City", "89794"));

        boolean addExistingShouldFalse = addClient(new Client("Petr", "Novotny", "123456", "Kocianova",
                "8", "15500", "Praha", "123456"));

        boolean addExistingWhen2Of3DataAreTheSameAndEditDifferentShouldTrue = addClient(new Client("Diane", "Nguyenn",
                "015234531642", "Finkenweg", "8", "29992",
                "Bremen", "20227349"));

        System.out.println("addDifferentDataShouldTrue " + addDifferentDataShouldTrue);
        System.out.println("addExistingShouldFalse " + addExistingShouldFalse);
        System.out.println("addExistingWithDifferentDataWhen2Of3ShouldTrue " + addExistingWhen2Of3DataAreTheSameAndEditDifferentShouldTrue);

    }


    public static Boolean addClient(Client client) {
        if (client == null) return false;

        List<Client> persistedClients = ClientDatabase.getAllClients();

        for (int index = 0; index < persistedClients.size(); index++) {
            Client currentIndexCLient = persistedClients.get(index);
            if (currentIndexCLient == null) continue;

            CountingBean countingBean = createCountingBean(currentIndexCLient, client);

            //if ids are equal, and all data are equal return false. DO NOT ADD CLIENT
            if (currentIndexCLient.clientId.equalsIgnoreCase(client.clientId) && countingBean.isAllClientDataEqual) {
                return false;
            }//if ids are equal, and all data are not equal update the client and return true. EDIT CLIENT ON INDEX
            else if (currentIndexCLient.clientId.equalsIgnoreCase(client.clientId) && !countingBean.isAllClientDataEqual) {
                //data should be updated to the new client's data.
                persistedClients.set(index, client);
                return true;
            } // if ids are NOT equal and two of the three (first and last name, phone number, complete address) criteria IS equal,
            // update client idList. EDIT CLIENT ON INDEX
            else if (countingBean.isClientEqualOn2Of3OfFirstLastNameOrPhoneOrCompleteAddress) {
                client.otherIds = currentIndexCLient.otherIds;
                client.otherIds.add(client.clientId);
                client.clientId = currentIndexCLient.clientId;
                persistedClients.set(index, client);
                return true;
            } //later start looking for a soft match...
        }

        ClientDatabase.addClient(client);
        return true;
    }

    private static Client parseClientData(Client client) {

        client.firstName = client.firstName.trim();
        client.lastName = client.lastName.trim();
        client.postcode = client.postcode.replace(" ", "");
        client.street = client.street.replace("ß", "ss");

        client.phoneNumber = client.phoneNumber.replace("/", "").replace(" ", "");
        if (client.phoneNumber.startsWith("+49"))
            client.phoneNumber = client.phoneNumber.substring(3);
        else if (client.phoneNumber.startsWith("0049"))
            client.phoneNumber = client.phoneNumber.substring(4);

        return client;

        //trailing space in lastname

        //phone has slash
        //phone has whitespaces
        //phone has international prefix +4919685848009 vs local: 019685848009 which starts with 0 while the international doesnt have it

        //street has MyStreet Str instead of MyStreet Straße
        //street has - instead of whitespace
        //street is abbreviated Weinbergstr. vs Weinbergstraße

        //city has some extra value

        //small typo like Asternwge vs Asternweg

        //ss vs ß
        //Antonia vs Anny
        //Siegbert vs Siggi

        /*0 != 1 : Client {first_name:'Ortrud', last_name:'Hill ', phone_number:'0191 25610664', street:'Bergstraße', house_number:'25', postcode:'6241', city:'Luckenwalde'}
                      Was {first_name:'Ortrud', last_name:'Hill', phone_number:'019125610664', street:'Bergstraße', house_number:'25', postcode:'6241', city:'Luckenwalde', client_id:'20221565'} 
                      not updated?*/
        //space in phone number
         /*0 != 1 : Client {first_name:'Herma', last_name:'Heitmann', phone_number:'0195 21068868', street:'Geschwister-Scholl Straße', house_number:'20B', postcode:'31429', city:'Mülheim an der Ruhr'}
                       Was {first_name:'Herma', last_name:'Heitmann', phone_number:'019521068868', street:'Geschwister-Scholl-Straße', house_number:'20B', postcode:'31429', city:'Mülheim an der Ruhr', client_id:'20221572'}
                      not updated?*/

        //last name is substring
         /*0 != 1 : Client {first_name:'Monika', last_name:'Kastner-Jacobi', phone_number:'019135763642', street:'Nelken Weg', house_number:'45', postcode:'58262', city:'Wangen im Allgäu'}
                       Was {first_name:'Monika', last_name:'Kastner', phone_number:'019135763642', street:'Nelkenweg', house_number:'45', postcode:'58262', city:'Wangen im Allgäu', client_id:'20221579'}
                      not updated?*/


        /*0 != 1 : Client {first_name:'Ulf', last_name:'Ebel', phone_number:'0194/87766204', street:'Gerhart Hauptmann Str.', house_number:'30B', postcode:'47132', city:'Voerde'}
                      Was {first_name:'Ulf', last_name:'Ebel', phone_number:'019487766204', street:'Gerhart-Hauptmann-Straße', house_number:'30B', postcode:'47132', city:'Voerde (Niederrhein)', client_id:'20221586'}
                       not updated?*/

       /*0 != 1 : Client {first_name:'Volkmar', last_name:'Straub', phone_number:'06257266578', street:'Weinbergstr.', house_number:'28', postcode:'84537', city:'Büren'}
                     Was {first_name:'Volkmar', last_name:'Straub', phone_number:'019678275367', street:'Weinbergstraße', house_number:'28', postcode:'84537', city:'Büren', client_id:'20221593'}
                    not updated?*/

       /*0 != 1 : Client {first_name:'Lukas', last_name:'Schauer', phone_number:'+4919254918395', street:'Zeppelinstr.', house_number:'30A', postcode:'24339', city:'Coburg'}
                     Was {first_name:'Lukas', last_name:'Schauer', phone_number:'019254918395', street:'Zeppelinstraße', house_number:'30A', postcode:'24339', city:'Coburg', client_id:'20221607'}
                    not updated?*/

        /*0 != 1 : Client {first_name:'Jun', last_name:'Bauer', phone_number:'019527098446', street:'Forststrasse', house_number:'9 a', postcode:'3572', city:'Cloppenburg'}
                      Was {first_name:'Jun', last_name:'Frey', phone_number:'019527098446', street:'Forststraße', house_number:'9 a', postcode:'3572', city:'Cloppenburg', client_id:'20221649'}
                    not updated?*/

       /*0 != 1 : Client {first_name:'Gustav ', last_name:' Klug ', phone_number:' 0192 70 041 802 ', street:' Amselweg ', house_number:' 3 ', postcode:'97142 ', city:' Speyer '}
                     Was {first_name:'Gustav', last_name:'Klug', phone_number:'019270041802', street:'Amselweg', house_number:'3', postcode:'97142', city:'Speyer', client_id:'20221614'}
                    not updated?*/

       /*0 != 1 : Client {first_name:'Thomas', last_name:'Wlikens', phone_number:'05231 144159', street:'Burgweg', house_number:' 42', postcode:'94853', city:'Fürstenfeldbruck'}
                     Was {first_name:'Thomas', last_name:'Wilkens', phone_number:'019371119865', street:'Burgweg', house_number:'42', postcode:'94853', city:'Fürstenfeldbruck', client_id:'20221628'}
                    not updated?*/

        /*0 != 1 : Client {first_name:'Matthias', last_name:'Burkhardt', phone_number:'019364674817', street:'Asternwge', house_number:'19 ', postcode:'60647', city:'Gardelegen'}
                      Was {first_name:'Matthias', last_name:'Burkhardt', phone_number:'019366474817', street:'Asternweg', house_number:'19', postcode:'60647', city:'Gardelegen', client_id:'20221642'}
                    not updated?*/

       /*0 != 1 : Client {first_name:'Maggie', last_name:'Schmitt', phone_number:'019332177170', street:'Birkenstr.', house_number:'21 ', postcode:'60187', city:' Aachen'}
                     Was {first_name:'Maritta', last_name:'Niemann', phone_number:'019332177170', street:'Birkenstraße', house_number:'21', postcode:'60187', city:'Aachen', client_id:'20221656'}
                    not updated?*/

        /*0 != 1 : Client {first_name:'Felix', last_name:'Hamm', phone_number:'09151 15 03 73', street:'Hochstrasse', house_number:'6', postcode:'41983', city:'Schoenebeck'}
                      Was {first_name:'Felix', last_name:'Hamm', phone_number:'019738956535', street:'Hochstraße', house_number:'6', postcode:'41983', city:'Schönebeck', client_id:'20221663'}
                    not updated?*/

        /*0 != 1 : Client {first_name:'Waldi', last_name:'Lechner-Kaiser', phone_number:'019741459277', street:'Sonnenstraße', house_number:'30 D', postcode:'66895', city:'Dessau'}
                      Was {first_name:'Waldemar', last_name:'Lechner', phone_number:'019741459277', street:'Sonnenstraße', house_number:'30d', postcode:'66895', city:'Dessau-Roßlau', client_id:'20221670'}
                    not updated?*/

       /*0 != 1 : Client {first_name:'Anny', last_name:'Clemens', phone_number:'0199 / 45133672', street:'Burg-Strasse', house_number:'36', postcode:'27342', city:'Neufahrn bei Freising'}
                     Was {first_name:'Antonia', last_name:'Clemens', phone_number:'019945133672', street:'Burgstraße', house_number:'36', postcode:'27342', city:'Neufahrn bei Freising', client_id:'20221677'}
                    not updated?*/

       /*0 != 1 : Client {first_name:'Kurt-Ulf', last_name:'Schweiger', phone_number:'019536045141', street:'Eichendorff Strasse', house_number:'9', postcode:'23116', city:'Bad Honnef'}
                     Was {first_name:'Kurt', last_name:'Schweiger', phone_number:'019536045141', street:'Eichendorffstraße', house_number:'9', postcode:'23116', city:'Bad Honnef', client_id:'20221691'}
                    not updated?*/

       /*0 != 1 : Client {first_name:'Siggi', last_name:'Wild', phone_number:'019644858382', street:'Weidenweg', house_number:'7', postcode:'84628', city:'Plauen (Sachsen)'}
                     Was {first_name:'Siegbert', last_name:'Wild', phone_number:'019644858382', street:'Weidenweg', house_number:'7', postcode:'84628', city:'Plauen', client_id:'20221698'}
                    not updated?*/

      /*0 != 1 : Client {first_name:'Anett Catrin', last_name:'Haug', phone_number:'+4919685848009', street:'Kiefernweg', house_number:'10a', postcode:'71723', city:'Bruchköbel'}
                    Was {first_name:'Anett', last_name:'Haug', phone_number:'019685848009', street:'Feldstraße', house_number:'14', postcode:'70676', city:'Uelzen', client_id:'20221635'}
                    not updated?*/
    }

    private static boolean isClientEqualOnFirstLastNamePhoneCompleteAddress(Client currentIndexCLient, Client client) {

        Predicate<Client> firstNamePredicate = c -> client.firstName == null || client.firstName.isEmpty() || client.firstName.equalsIgnoreCase(currentIndexCLient.firstName);
        Predicate<Client> lastNamePredicate = c -> client.lastName == null || client.lastName.isEmpty() || client.lastName.equalsIgnoreCase(currentIndexCLient.lastName);

        Predicate<Client> phoneNumberPredicate = c -> client.phoneNumber == null || client.phoneNumber.isEmpty() || client.phoneNumber.equalsIgnoreCase(currentIndexCLient.phoneNumber);

        Predicate<Client> streetPredicate = c -> client.street == null || client.street.isEmpty() || client.street.equalsIgnoreCase(currentIndexCLient.street);
        Predicate<Client> houseNumberPredicate = c -> client.houseNumber == null || client.houseNumber.isEmpty() || client.houseNumber.equalsIgnoreCase(currentIndexCLient.houseNumber);
        Predicate<Client> postcodePredicate = c -> client.postcode == null || client.postcode.isEmpty() || client.postcode.equalsIgnoreCase(currentIndexCLient.postcode);
        Predicate<Client> cityPredicate = c -> client.city == null || client.city.isEmpty() || client.city.equalsIgnoreCase(currentIndexCLient.city);
        int isTrueCounter = 0;

        boolean isName = firstNamePredicate.and(lastNamePredicate).test(currentIndexCLient);
        if (isName) isTrueCounter++;

        boolean isPhone = phoneNumberPredicate.test(currentIndexCLient);
        if (isPhone) isTrueCounter++;

        boolean isAddress = streetPredicate.and(houseNumberPredicate).and(postcodePredicate).and(cityPredicate).test(currentIndexCLient);
        if (isAddress) isTrueCounter++;

        return isTrueCounter >= 2;
    }

    private static CountingBean createCountingBean(Client persisted, Client param) {
        boolean istFirstName = param.firstName.equalsIgnoreCase(persisted.firstName);
        boolean isLastName = param.lastName.equalsIgnoreCase(persisted.lastName);
        boolean isPhone = param.phoneNumber.equalsIgnoreCase(persisted.phoneNumber);
        boolean isStreet = param.street.equalsIgnoreCase(persisted.street);
        boolean isHouseNr = param.houseNumber.equalsIgnoreCase(persisted.houseNumber);
        boolean isPostCode = param.postcode.equalsIgnoreCase(persisted.postcode);
        boolean isClientId = param.clientId.equalsIgnoreCase(persisted.clientId);
        boolean isCity = param.city.equalsIgnoreCase(persisted.city);
        CountingBean result = new CountingBean(istFirstName, isLastName, isPhone, isStreet, isHouseNr, isPostCode, isClientId, isCity);
        return result;
    }

    static class CountingBean {
        public boolean isAllClientDataEqual;
        public boolean isClientEqualOn2Of3OfFirstLastNameOrPhoneOrCompleteAddress;

        public CountingBean(boolean istFirstName, boolean isLastName, boolean isPhone, boolean isStreet, boolean isHouseNr, boolean isPostCode, boolean isClientId, boolean isCity) {
            this.isAllClientDataEqual = istFirstName && isLastName && isPhone && isStreet && isHouseNr && isPostCode && isClientId && isCity;

            int nameCounter = istFirstName && isLastName ? 1 : 0;
            int phoneCounter = isPhone ? 1 : 0;
            int addressCounter = isStreet && isHouseNr && isPostCode && isCity ? 1 : 0;
            int total = nameCounter + phoneCounter + addressCounter;
            this.isClientEqualOn2Of3OfFirstLastNameOrPhoneOrCompleteAddress = total >= 2;
        }
    }

}
