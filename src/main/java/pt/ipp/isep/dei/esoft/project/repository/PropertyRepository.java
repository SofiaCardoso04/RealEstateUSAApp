package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.io.*;
import java.util.ArrayList;

/**
 * The PropertyRepository class manages a collection of properties and provides methods to create, validate and add properties.
 */
public class PropertyRepository implements Serializable {
    private static final String PROPERTY_SERIALIZATION_FILE_PATH = "Serialization/Property.ser";

    /**
     * The collection of properties managed by this repository.
     */
    private ArrayList<Property> properties = new ArrayList<>();

    /**
     * The collection of residences managed by this repository.
     */
    private ArrayList<Residence> residences = new ArrayList<>();

    /**
     * The collection of houses managed by this repository.
     */
    private ArrayList<House> houses = new ArrayList<>();

    /**
     * Returns the collection of properties managed by this repository.
     *
     * @return the collection of properties managed by this repository
     */
    public ArrayList<Property> getProperties() {
        return properties;
    }

    /**
     * Returns the collection of residences managed by this repository.
     *
     * @return the collection of residences managed by this repository
     */
    public ArrayList<Residence> getResidences() {
        return residences;
    }

    /**
     * Returns the collection of houses managed by this repository.
     *
     * @return the collection of houses managed by this repository
     */
    public ArrayList<House> getHouses() {
        return houses;
    }

    /**
     * Checks if the given property is a valid property.
     *
     * @param property the property to be validated
     * @return true if the property is valid, false otherwise
     */
    public boolean validateProperty(Property property) {
        return this.properties.contains(property);
    }

    /**
     * Checks if the given residence is a valid residence.
     *
     * @param residence the residence to be validated
     * @return true if the residence is valid, false otherwise
     */
    public boolean validateResidence(Residence residence) {
        return this.properties.contains(residence);
    }

    /**
     * Checks if the given house is a valid house.
     *
     * @param house the property to be validated
     * @return true if the house is valid, false otherwise
     */
    public boolean validateHouse(House house) {
        return this.properties.contains(house);
    }

    /**
     * Adds a new property to the repository.
     *
     * @param property the property to be added
     * @return true if the property is added successfully, false otherwise
     */
    public boolean addProperty(Property property) {
        if (property == null) {
            return false;
        }

        if (validateProperty(property)) {
            return false;
        }

        this.properties.add(property);
        return true;
    }

    /**
     * Adds a new residence to the repository.
     *
     * @param residence the residence to be added
     * @return true if the residence is added successfully, false otherwise
     */
    public boolean addResidence(Residence residence) {
        if (residence == null) {
            return false;
        }

        if (validateResidence(residence)) {
            return false;
        }

        this.residences.add(residence);
        return true;
    }

    /**
     * Adds a new house to the repository.
     *
     * @param house the house to be added
     * @return true if the house is added successfully, false otherwise
     */
    public boolean addHouse(House house) {
        if (house == null) {
            return false;
        }

        if (validateHouse(house)) {
            return false;
        }

        this.houses.add(house);
        return true;
    }

    /**
     * Creates a new property with the given information
     *
     * @param area             the property's area
     * @param distanceFromCity the property's distance from city
     * @param photograph       the property's photograph
     * @param address          the property's address
     * @return the newly created property if it is created successfully, null otherwise
     */
    public boolean createProperty(double area, double distanceFromCity, String photograph, Address address) {
        return this.addProperty(new Property(area, distanceFromCity, photograph, address));
    }

    /**
     * Creates a new residence with the given information
     *
     * @param area                the residence's area
     * @param distanceFromCity    the residence's distance from city
     * @param photograph          the residence's photograph
     * @param address             the residence's address
     * @param numberBedrooms      the residence's number of bedrooms
     * @param numberBathrooms     the residence's number of bathrooms
     * @param numberParkingSpaces the residence's number of parking spaces
     * @param availableEquipment  the residence's available equipment
     * @return the newly created residence if it is created successfully, null otherwise
     */
    public boolean createResidence(double area, double distanceFromCity, String photograph, Address address, int numberBedrooms, int numberBathrooms, int numberParkingSpaces, AvailableEquipment availableEquipment) {
        return this.addResidence(new Residence(area, distanceFromCity, photograph, address, numberBedrooms, numberBathrooms, numberParkingSpaces, availableEquipment));
    }

    public Residence createResidence2(double area, double distanceFromCity, String photograph, Address address, int numberOfBathrooms, int numberOfBedrooms, int numberOfParkingSpaces, AvailableEquipment availableEquipment) {
        return new Residence(area, distanceFromCity, photograph, address, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, availableEquipment);
    }

    /**
     * Creates a new house with the given information
     *
     * @param area                the house's area
     * @param distanceFromCity    the house's distance from city
     * @param photograph          the house's photograph
     * @param address             the house's address
     * @param numberBedrooms      the house's number of bedrooms
     * @param numberBathrooms     the house's number of bathrooms
     * @param numberParkingSpaces the house's number of parking spaces
     * @param availableEquipment  the house's available equipment
     * @param existenceBasement   the house's existence of basement
     * @param existenceLoft       the house's existence of loft
     * @param sunExposure         the house's sun exposure
     * @return the newly created property if it is created successfully, null otherwise
     */
    public boolean createHouse(double area, double distanceFromCity, String photograph, Address address, int numberBedrooms, int numberBathrooms, int numberParkingSpaces, AvailableEquipment availableEquipment, int existenceBasement, int existenceLoft, int sunExposure) {
        return this.addHouse(new House(area, distanceFromCity, photograph, address, numberBedrooms, numberBathrooms, numberParkingSpaces, availableEquipment, existenceBasement, existenceLoft, sunExposure));
    }

    public House createHouse2(double area, double distanceFromCity, String photograph, Address address, int numberBedrooms, int numberBathrooms, int numberParkingSpaces, AvailableEquipment availableEquipment, int existenceOfBasement, int inhabitableLoft, int sunExposure) {
        return new House(area, distanceFromCity, photograph, address, numberBedrooms, numberBathrooms, numberParkingSpaces, availableEquipment, existenceOfBasement, inhabitableLoft, sunExposure);
    }

    public Property createProperty2(double areaInM2, double distanceFromCityCentre, String photoURI, Address address) {
        return new Property(areaInM2, distanceFromCityCentre, photoURI, address);
    }

    public Property createPropertyEmpty() {
        return new Property();
    }
}
