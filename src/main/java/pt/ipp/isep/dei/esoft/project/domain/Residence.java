package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *  * Represents a residence through area, distance from city, price, photograph, address, number of bedrooms, number of bathrooms,
 *  * number of parking spaces, central heating and air conditioning.
 */
public class Residence extends Property implements Serializable {
    /**
     * The residence's number of bedrooms
     */
    private final int numberBedrooms;

    /**
     * The residence's number of bathrooms
     */
    private int numberBathrooms;

    /**
     * The residence's number of parking spaces
     */
    private final int numberParkingSpaces;

    /**
     * The residence's available equipment
     */
    private AvailableEquipment availableEquipment;

    /**
     * Builds an instance of House with a given area, distance from city, price, photograph, address, number of bedrooms, number of bathrooms,
     * number of parking spaces, central heating and air conditioning.
     * @param area the residence's area
     * @param distanceFromCity the residence's distance from city
     * @param photograph the residence's photograph
     * @param address the residence's address
     * @param numberBedrooms the residence's number of bedrooms
     * @param numberBathrooms the residence's number of bathrooms
     * @param numberParkingSpaces the residence's number of parking spaces
     * @param availableEquipment the residence's available equipment
     */
    public Residence(double area, double distanceFromCity, String photograph, Address address, int numberBedrooms, int numberBathrooms, int numberParkingSpaces, AvailableEquipment availableEquipment) {
        super(area, distanceFromCity, photograph, address);
        this.numberBedrooms = numberBedrooms;
        this.numberBathrooms = numberBathrooms;
        this.numberParkingSpaces = numberParkingSpaces;
        this.availableEquipment = availableEquipment;
    }

    //number of bathrooms and equipment are not mandatory
    public Residence(double area, double distanceFromCity, String photograph, Address address, int numberBedrooms, int numberParkingSpaces) {
        super(area, distanceFromCity, photograph, address);
        this.numberBedrooms = numberBedrooms;
        this.numberParkingSpaces = numberParkingSpaces;
    }

    /**
     * Get the residence's available equipment
     * @return the residence's available equipment
     */
    public AvailableEquipment getAvailableEquipment() {
        return availableEquipment;
    }

    /**
     * Get the residence's number of bedrooms.
     * @return the residence's number of bedrooms
     */
    public int getNumberBedrooms() {
        return numberBedrooms;
    }

    /**
     * Get the residence's number of bathrooms.
     * @return the residence's number of bathrooms
     */
    public int getNumberBathrooms() {
        return numberBathrooms;
    }

    /**
     * Get the residence's number of parking spaces.
     * @return the residence's number of parking spaces
     */
    public int getNumberParkingSpaces() {
        return numberParkingSpaces;
    }
}
