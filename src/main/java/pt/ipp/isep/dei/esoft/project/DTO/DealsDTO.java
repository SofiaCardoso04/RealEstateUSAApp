package pt.ipp.isep.dei.esoft.project.DTO;

import pt.ipp.isep.dei.esoft.project.ENUMS.OrderStatus;
import pt.ipp.isep.dei.esoft.project.domain.Advertisement;

/**
 * DTO (Data Transfer Object) class representing a deal.
 */
public class DealsDTO {
    public Advertisement advertisement; // Advertisement associated with the deal
    public double sale; // Sale amount of the deal
    public String dateOfSale; // Date of the sale
    public OrderStatus status; // Status of the deal

    /**
     * Default constructor for DealsDTO.
     */
    public DealsDTO() {
    }

    /**
     * Gets the advertisement associated with the deal.
     *
     * @return The advertisement associated with the deal.
     */
    public Advertisement getAdvertisement() {
        return advertisement;
    }

    /**
     * Gets the sale amount of the deal.
     *
     * @return The sale amount of the deal.
     */
    public double getSale() {
        return sale;
    }

    /**
     * Returns a string representation of the DealsDTO object.
     *
     * @return A string representation of the DealsDTO object.
     */
    @Override
    public String toString() {
        return "DealsDTO{" +
                "advertisement=" + advertisement +
                ", sale=" + sale +
                ", dateOfSale='" + dateOfSale + '\'' +
                ", status=" + status +
                '}';
    }
}