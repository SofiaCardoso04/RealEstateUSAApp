package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.ENUMS.OrderStatus;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a purchase order made by a client for an advertisement.
 * Contains information such as the order amount, client, advertisement, order status, sale price, and date of sale.
 */
public class PurchaseOrder implements Serializable {
    private String dateOfSale;
    private double orderAmount;
    private Client client;
    private Advertisement advertisement;
    private OrderStatus orderStatus;
    private double salePrice;
    private Store store;

    /**
     * Creates a new instance of the PurchaseOrder class with the given order amount, client, and advertisement.
     * The order status is set to PENDING.
     *
     * @param orderAmount    the amount of the purchase order
     * @param client         the client making the purchase order
     * @param advertisement  the advertisement associated with the purchase order
     */
    public PurchaseOrder(double orderAmount, Client client, Advertisement advertisement) {
        this.orderAmount = orderAmount;
        this.client = client;
        this.advertisement = advertisement;
        this.orderStatus = OrderStatus.PENDING;
    }

    /**
     * Creates a new instance of the PurchaseOrder class with the given order amount, client, advertisement, and date of sale.
     * The order status is set to PENDING.
     *
     * @param orderAmount    the amount of the purchase order
     * @param client         the client making the purchase order
     * @param advertisement  the advertisement associated with the purchase order
     * @param dateOfSale     the date of sale of the purchase order
     */
    public PurchaseOrder(double orderAmount, Client client, Advertisement advertisement, String dateOfSale) {
        this.orderAmount = orderAmount;
        this.client = client;
        this.advertisement = advertisement;
        this.orderStatus = OrderStatus.PENDING;
        this.dateOfSale = dateOfSale;
    }

    /**
     * Creates a new instance of the PurchaseOrder class with the given order amount, client, advertisement, date of sale, sale price, and store.
     * The order status is set to ACCEPTED.
     *
     * @param orderAmount    the amount of the purchase order
     * @param client         the client making the purchase order
     * @param advertisement  the advertisement associated with the purchase order
     * @param dateOfSale     the date of sale of the purchase order
     * @param salePrice      the sale price of the purchase order
     * @param store          the store associated with the purchase order
     */
    public PurchaseOrder(double orderAmount, Client client, Advertisement advertisement, String dateOfSale, double salePrice, Store store) {
        this.orderAmount = orderAmount;
        this.client = client;
        this.advertisement = advertisement;
        this.orderStatus = OrderStatus.ACCEPTED;
        this.salePrice = salePrice;
        this.dateOfSale = dateOfSale;
        this.store = store;
    }

    /**
     * Sets the order status of the purchase order to ACCEPTED.
     */
    public void accept() {
        orderStatus = OrderStatus.ACCEPTED;
    }

    /**
     * Sets the order status of the purchase order to DECLINED.
     */
    public void decline() {
        orderStatus = OrderStatus.DECLINED;
    }

    /**
     * Retrieves the order amount of the purchase order.
     *
     * @return the order amount
     */
    public double getOrderAmount() {
        return orderAmount;
    }

    /**
     * Retrieves the client associated with the purchase order.
     *
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Retrieves the order status of the purchase order.
     *
     * @return the order status
     */
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    /**
     * Retrieves the advertisement associated with the purchase order.
     *
     * @return the advertisement
     */
    public Advertisement getAdvertisement() {
        return advertisement;
    }

    /**
     * Retrieves the date of sale of the purchase order.
     *
     * @return the date of sale
     */
    public String getDateOfSale() {
        return dateOfSale;
    }

    /**
     * Retrieves the sale price of the purchase order.
     *
     * @return the sale price
     */
    public double getSalePrice() {
        return salePrice;
    }

    /**
     * Sets the date of sale of the purchase order.
     *
     * @param dateOfSale the date of sale to set
     */
    public void setDateOfSale(String dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    /**
     * Compares this purchase order to the specified object.
     * The result is true if and only if the argument is not null and is a PurchaseOrder object that represents the same order amount,
     * sale price, date of sale, client, advertisement, and order status as this object.
     *
     * @param o the object to compare
     * @return true if the purchase orders are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseOrder that = (PurchaseOrder) o;
        return Double.compare(that.orderAmount, orderAmount) == 0 &&
                Double.compare(that.salePrice, salePrice) == 0 &&
                Objects.equals(dateOfSale, that.dateOfSale) &&
                Objects.equals(client, that.client) &&
                Objects.equals(advertisement, that.advertisement) &&
                orderStatus == that.orderStatus;
    }

    /**
     * Generates a hash code for the purchase order.
     *
     * @return the hash code value
     */
    @Override
    public int hashCode() {
        return Objects.hash(dateOfSale, orderAmount, client, advertisement, orderStatus, salePrice);
    }

    /**
     * Returns a string representation of the purchase order.
     *
     * @return a string representation of the purchase order
     */
    @Override
    public String toString() {
        return "Order Amount: " + orderAmount +
                " | Client's Name: " + client.getName() +
                " | Advertisement: " + advertisement +
                " | Store: " + store +
                " | Date of Sale: " + dateOfSale +
                "\n";
    }
}