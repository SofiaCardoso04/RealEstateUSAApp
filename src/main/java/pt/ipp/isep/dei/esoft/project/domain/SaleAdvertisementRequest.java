package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;

/**
 * Represents a sale advertisement request through store, agent, property, property type, request type and total price attributes.
 */
public class SaleAdvertisementRequest extends AdvertisementRequest implements Serializable {
    /**
     * The sale advertisement request's total price
     */
    private final int totalPrice;

    /**
     * Builds an instance of SaleAdvertisementRequest with a given store, agent, property, property type, request type and total price.
     * @param store the sale advertisement request's store
     * @param agent the sale advertisement request's agent
     * @param property the sale advertisement request's property
     * @param propertyType the sale advertisement request's property type
     * @param requestType the sale advertisement request's request type
     * @param totalPrice the sale advertisement request's total price
     */
    public SaleAdvertisementRequest(String emailAddress, Store store, Employee agent, Property property, String propertyType, String requestType, String date, double requestedPrice,  int totalPrice){
        super(emailAddress, store, agent, property, propertyType, requestType, requestedPrice, date);
        this.totalPrice = totalPrice;
    }

    /**
     * Get the sale advertisement request's total price.
     * @return the sale advertisement request's total price
     */
    public int getTotalPrice() {
        return totalPrice;
    }
}
