package pt.ipp.isep.dei.esoft.project.DTO;

import pt.ipp.isep.dei.esoft.project.domain.Advertisement;
import pt.ipp.isep.dei.esoft.project.domain.Client;

/**
 * Data Transfer Object (DTO) class representing a purchase order.
 */
public class PurchaseOrderDTO {

    private String dateOfSale;
    private double orderAmount;
    private ClientDTO client;
    private AdvertisementDTO advertisement;

    /**
     * Constructs a PurchaseOrderDTO object with the specified order amount, client, and advertisement.
     *
     * @param orderAmount    The amount of the purchase order.
     * @param client         The client associated with the purchase order.
     * @param advertisement  The advertisement associated with the purchase order.
     */
    public PurchaseOrderDTO(double orderAmount, ClientDTO client, AdvertisementDTO advertisement) {
        this.orderAmount = orderAmount;
        this.client = client;
        this.advertisement = advertisement;
    }

    /**
     * Constructs a PurchaseOrderDTO object with the specified order amount, client, advertisement, and date of sale.
     *
     * @param orderAmount    The amount of the purchase order.
     * @param client         The client associated with the purchase order.
     * @param advertisement  The advertisement associated with the purchase order.
     * @param dateOfSale     The date of sale for the purchase order.
     */
    public PurchaseOrderDTO(double orderAmount, ClientDTO client, AdvertisementDTO advertisement, String dateOfSale) {
        this.orderAmount = orderAmount;
        this.client = client;
        this.advertisement = advertisement;
        this.dateOfSale = dateOfSale;
    }

    /**
     * Retrieves the order amount of the purchase order.
     *
     * @return The order amount.
     */
    public double getOrderAmount() {
        return orderAmount;
    }

    /**
     * Retrieves the client associated with the purchase order.
     *
     * @return The ClientDTO object.
     */
    public ClientDTO getClient() {
        return client;
    }

    /**
     * Retrieves the advertisement associated with the purchase order.
     *
     * @return The AdvertisementDTO object.
     */
    public AdvertisementDTO getAdvertisement() {
        return advertisement;
    }

    /**
     * Sets the date of sale for the purchase order.
     *
     * @param dateOfSale The date of sale.
     */
    public void setDateOfSale(String dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    /**
     * Returns a string representation of the PurchaseOrderDTO object.
     *
     * @return The string representation.
     */
    @Override
    public String toString() {
        return "Order Amount: " + orderAmount +
                " | Client: " + client +
                " | Advertisement: " + advertisement;
    }
}