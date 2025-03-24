package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a house through area, distance from city, price and photograph attributes.
 */
public class Property implements Serializable {
    /**
     * The property area
     */
    private final double area;

    /**
     * The property distance from the city centre
     */
    private final double distanceFromCity;

    /**
     * The property photograph
     */
    private String photograph;

    /**
     * The property address
     */
    private final Address address;

    private String PHOTO_BY_DEFAULT = "NOT APPLICABLE";

    /**
     * Builds an instance of Property with a given area, distance from city, price, photograph and address.
     * @param area the property's area
     * @param distanceFromCity the property's distance from city
     * @param photograph the property's photograph
     * @param address the property's address
     */
    public Property(double area, double distanceFromCity, String photograph, Address address) {
        this.area = area;
        this.distanceFromCity = distanceFromCity;
        this.photograph = photograph;
        this.address = address;
    }

    public Property(){
        this.area = 0;
        this.distanceFromCity = 0;
        this.photograph = PHOTO_BY_DEFAULT;
        this.address = new Address();
    }

    /**
     * Get the property's area.
     * @return the property's area
     */
    public double getArea() {
        return area;
    }

    /**
     * Get the property's distance from city.
     * @return the property's distance from city
     */
    public double getDistanceFromCity() {
        return distanceFromCity;
    }

    /**
     * Get the property's photograph.
     * @return the property's photograph
     */
    public String getPhotograph() {
        return photograph;
    }

    /**
     * Get the property's address.
     * @return the property's address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Returns a textual description of the property on the format:
     * Property Information:
     * -area: %f
     * -Distance from center: %f
     * -Price: %f
     * -Address: %s
     *
     * @return property's description
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Area: ").append(area)
                .append(" | Distance From City: ").append(distanceFromCity)
                .append(" | Photograph: ").append(photograph)
                .append(" | Address: ").append(address);
        return stringBuilder.toString();
    }
}
