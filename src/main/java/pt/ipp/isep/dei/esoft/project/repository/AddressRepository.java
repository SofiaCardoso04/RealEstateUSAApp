package pt.ipp.isep.dei.esoft.project.repository;

import org.apache.commons.math3.analysis.function.Add;
import pt.ipp.isep.dei.esoft.project.domain.Address;

import java.io.*;
import java.util.ArrayList;

/**
 * This class represents a repository of addresses.
 */
public class AddressRepository  implements Serializable{
    private static final String ADDRESS_SERIALIZATION_FILE_PATH = "Serialization/Address.ser";

    // Instance variable to store a list of Address objects
    private ArrayList<Address> addressList = new ArrayList<>();
    private AddressRepository addressRepository;

    /**
     * Returns the list of addresses stored in the repository.
     *
     * @return ArrayList of Address objects
     */
    public ArrayList<Address> getAddressList() {
        return this.addressList;
    }

    /**
     * Registers a new address with the repository and adds it to the list of addresses.
     *
     * @param streetName String representing the name of the street
     * @param cityName   String representing the name of the city
     * @param zipCode    String representing the zip code of the city
     * @param district   String representing the district of the city
     * @return boolean true if the address was successfully added, false otherwise
     */
    public boolean registerAddress(String streetName, String cityName, String zipCode, String district) {
        return this.addAddress(new Address(streetName, cityName, district, zipCode));
    }

    /**
     * Adds the given address to the list of addresses stored in the repository.
     *
     * @param address Address object to be added to the list of addresses
     * @return boolean true if the address was successfully added, false otherwise
     */


    public boolean validateAddress(Address address) {
        if (address == null) {
            return false;
        }
        if (this.addressList.contains(address)) {
            return false;
        }
        return true;
    }


    public boolean addAddress(Address address) {
        if (!validateAddress(address)) {
            return false;
        } else {
            this.addressList.add(address);
            return true;
        }
    }

    public Address createAddress(String state, String district, String city, String street, String zipCode) {
        return new Address(street, city, district, zipCode, state);
    }

    /**
     * Creates a new instance of class Address with one parameter.
     *
     * @return instance of Address with one parameter
     */
    public Address createAddressString(String addressString) {
        String[] address = addressString.split(",");

        for (int i = 0; i < address.length; i++) {
            address[i] = address[i].trim();
        }

        int firstDigitIndex = findLastDigitIndex(address[0]);

        String[] address2 = readDoorNumberAndStreet(address[0], firstDigitIndex);
        Address address1 = null;
        if (address.length == 4) {

            String street = address2[1];
            String city = address[1];
            String state = address[2];
            String zipCode = address[3];
            address1 = new Address(street, city, state, zipCode);
            Repositories.getInstance().getAddressRepository().addAddress(address1);

        } else if (address.length == 5) {

            String street = address2[1];
            String city = address[1];
            String county = address[2];
            String state = address[3];
            String zipCode = address[4];

            address1 = new Address(street, city, state, zipCode);
            Repositories.getInstance().getAddressRepository().addAddress(address1);
        } else {

            String street = address2[1];
            String building = address[1];
            String floor = address[2];
            String apart = address[3];
            String city = address[4];
            String state = address[5];
            String zipCode = address[6];

            address1 = new Address(street, city, state, zipCode);
            Repositories.getInstance().getAddressRepository().addAddress(address1);
        }
        return address1;
    }

    public static int findLastDigitIndex(String line) {
        for (int i = 1; i <= line.length(); i++) {
            if (Character.isDigit(line.charAt(i - 1)) && Character.isSpaceChar(line.charAt(i))) {
                return i;
            }
        }
        return -1; // Return -1 if no digit is found
    }

    private String[] readDoorNumberAndStreet(String address, int firstDigitIndex) {
        String[] address2 = new String[2];
        if (firstDigitIndex == -1) {
            address2[0] = "-1";
            address2[1] = address.trim();
        } else {
            address2[0] = address.substring(0, firstDigitIndex);
            address2[1] = address.substring(firstDigitIndex + 1);
        }
        return address2;
    }
}

