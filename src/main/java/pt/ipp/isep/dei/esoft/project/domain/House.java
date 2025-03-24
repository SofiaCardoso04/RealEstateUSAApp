package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a house through area, distance from city, price, photograph, address, number of bedrooms, number of bathrooms,
 * number of parking spaces, central heating, air conditioning, existence of basement, existence of loft attributes and sun exposure attributes.
 */
public class House extends Residence implements Serializable {
    /**
     * The house's existence of basement
     */
    private final int existenceBasement;

    /**
     * The house's existence of loft
     */
    private final int existenceLoft;

    /**
     * The house's existence of sun exposure
     */
    private final int sunExposure;

    /**
     * Builds an instance of House with a given area, distance from city, price, photograph, address, number of bedrooms, number of bathrooms,
     * number of parking spaces, central heating, air conditioning, existence of basement, existence of loft and sun exposure.
     * @param area the house's area
     * @param distanceFromCity the house's distance from city
     * @param photograph the house's photograph
     * @param address the house's address
     * @param numberBedrooms the house's number of bedrooms
     * @param numberBathrooms the house's number of bathrooms
     * @param numberParkingSpaces the house's number of parking spaces
     * @param availableEquipment the house's available equipment
     * @param existenceBasement the house's existence of basement
     * @param existenceLoft the house's existence of loft
     * @param sunExposure the house's sun exposure
     */
    public House(double area, double distanceFromCity, String photograph, Address address, int numberBedrooms, int numberBathrooms, int numberParkingSpaces, AvailableEquipment availableEquipment, int existenceBasement, int existenceLoft, int sunExposure) {
        super(area, distanceFromCity, photograph, address, numberBedrooms, numberBathrooms, numberParkingSpaces, availableEquipment);
        this.existenceBasement = existenceBasement;
        this.existenceLoft = existenceLoft;
        this.sunExposure = sunExposure;
    }

    /**
     * Get house's existence of basement.
     * @return house's existence of basement
     */
    public int getExistenceBasement() {
        return existenceBasement;
    }

    /**
     * Get house's existence of loft
     * @return house's existence of loft
     */
    public int getExistenceLoft() {
        return existenceLoft;
    }

    /**
     * Get house's sun exposure
     * @return house's sun exposure
     */
    public int getSunExposure() {
        return sunExposure;
    }
}
