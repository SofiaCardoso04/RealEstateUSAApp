package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;

/**
 * Represents a rent advertisement request through store, agent, property, property type, request type and rent price attributes.
 */
public class RentAdvertisementRequest extends AdvertisementRequest implements Serializable {
    /**
     * The rent advertisement request's price per month
     */
    private final int rentPricePerMonth;

    /**
     * Builds an instance of RentAdvertisementRequest with a given store, agent, property, property type, request type and rent price.
     * @param store the rent advertisement request's store
     * @param agent the rent advertisement request's agent
     * @param property the rent advertisement request's property
     * @param propertyType the rent advertisement request's property type
     * @param requestType the rent advertisement request's request type
     * @param rentPricePerMonth the rent advertisement request's rent price
     */
    public RentAdvertisementRequest(String emailAddress, Store store, Employee agent, Property property, String propertyType, String requestType, double requestedPrice, String date, int rentPricePerMonth){
        super(emailAddress, store, agent, property, propertyType, requestType, requestedPrice, date);
        this.rentPricePerMonth = rentPricePerMonth;
    }

    /**
     * Get the rent advertisement request's rent price.
     * @returnt the rent advertisement request's rent price
     */
    public int getRentPricePerMonth() {
        return rentPricePerMonth;
    }

}
