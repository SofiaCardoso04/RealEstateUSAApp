package pt.ipp.isep.dei.esoft.project.domain;

import org.apache.commons.math3.analysis.function.Add;

import java.io.Serializable;

/**
 * This class represents an address object with a street name, city name, zip code, and district.
 */
public class Address implements Serializable {

    // Private instance variables to store the address information
    private String streetName, cityName, zipCode, district, state, address;

    private final String STREET_NAME_OMISSION = "NOT APPLICABLE";

    private final String CITY_NAME_OMISSION = "NOT APPLICABLE";

    private final String DISTRICT_OMISSION = "NOT APPLICABLE";
    private final String ZIP_CODE_OMISSION = "NOT APPLICABLE";

    /**
     * Constructs an Address object with the given street name, city name, zip code, and district.
     *
     * @param streetName String representing the name of the street
     * @param cityName   String representing the name of the city
     * @param district   String representing the district of the city
     * @param zipCode    String representing the zip code of the city
     * @throws IllegalArgumentException if any of the arguments are null or if the zip code does not have 5 digits
     */
    public Address(String streetName, String cityName, String district, String zipCode) throws IllegalArgumentException {
        if (streetName == null || cityName == null || zipCode == null || district == null) {
            throw new IllegalArgumentException("The arguments can't be null!");
        }
        if (streetName.equals("") || cityName.equals("") || zipCode.equals("") || district.equals("")) {
            throw new IllegalArgumentException("The arguments can't be null!");
        }
        if (!zipCode.matches("^[0-9]{5}$")) {
            throw new IllegalArgumentException("Zip code must have 5 digits!");
        }

        this.streetName = streetName;
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.district = district;
    }

    public Address(String streetName, String cityName, String district, String zipCode, String state) throws IllegalArgumentException {
        if (streetName == null || cityName == null || zipCode == null || district == null) {
            throw new IllegalArgumentException("The arguments can't be null!");
        }
        if (streetName.equals("") || cityName.equals("") || zipCode.equals("") || district.equals("")) {
            throw new IllegalArgumentException("The arguments can't be null!");
        }
        if (!zipCode.matches("^[0-9]{5}$")) {
            throw new IllegalArgumentException("Zip code must have 5 digits!");
        }

        this.streetName = streetName;
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.district = district;
        this.state = state;
    }

    public Address(String address) {
        this.address = address;
    }

    public Address() {
        this.streetName = STREET_NAME_OMISSION;
        this.cityName = CITY_NAME_OMISSION;
        this.zipCode = ZIP_CODE_OMISSION;
        this.district = DISTRICT_OMISSION;
    }

    /**
     * Returns the name of the street for this address.
     *
     * @return String representing the name of the street
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Returns the name of the city for this address.
     *
     * @return String representing the name of the city
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Returns the zip code for this address.
     *
     * @return String representing the zip code of the city
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Returns the district for this address.
     *
     * @return String representing the district of the city
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Returns a string representation of this address object.
     *
     * @return String representing the address in the format "District name: [district] | City name: [cityName] | Street name: [streetName] | Zip Code: [zipCode]"
     */
    @Override
    public String toString() {
        return String.format("District name: %s | City name: %s | Street name: %s | Zip Code: %s", this.district, this.cityName, this.streetName, this.zipCode);
    }
}
