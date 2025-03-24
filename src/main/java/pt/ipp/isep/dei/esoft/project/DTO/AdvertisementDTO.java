package pt.ipp.isep.dei.esoft.project.DTO;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.time.LocalDate;
import java.util.Date;

public class AdvertisementDTO {

    private ClientDTO emailAddress;
    private Property property;
    private String propertyType;
    private String requestType;
    private String date;
    private double salePrice;
    private int advertisementID;
    private Employee agent;
    private AdvertisementRequestDTO advertisementRequest;
    private String state;
    private Commission commission;


    /**
     * Builds an instance of Advertisement with a given email address, property, property type, request type, date and commission type.
     * @param emailAddress the advertisement's email address
     * @param property the advertisement's property
     * @param propertyType the advertisement's property type
     * @param requestType the advertisement's request type
     * @param date the advertisement's date
     * @param salePrice the advertisement's sale price
     */

    public AdvertisementDTO(Employee agent, ClientDTO emailAddress, int advertisementID, Property property, String propertyType, String requestType, String date, double salePrice, Commission commission) {
        this.emailAddress = emailAddress;
        this.agent = agent;
        this.advertisementID = advertisementID;
        this.property = property;
        this.propertyType = propertyType;
        this.requestType = requestType;
        this.date = date;
        this.salePrice = salePrice;
        this.commission = commission;
    }

    /**
     * Builds an instance of Advertisement with a advertisement request, commission type and date.
     * @param advertisementRequest the advertisement's request information
     * @param salePrice the advertisement's sale price
     * @param date the advertisement's date
     */
    public AdvertisementDTO (AdvertisementRequestDTO advertisementRequest, double salePrice, String date, Commission commission){
        this.advertisementRequest = advertisementRequest;
        this.commission = commission;
        this.salePrice = salePrice;
        this.date = date;
    }

    public Employee getAgent() {
        return agent;
    }

    public String getAgentEmail() {
        if (this.agent != null) {
            return this.agent.getEmailAddress();
        } else {
            // Handle the case when this.agent is null
            return null; // or throw an exception, return a default value, etc.
        }
    }

    /**
     * Get the advertisement's email address.
     * @return the advertisement's email address
     */
    public ClientDTO getEmailAddress() {
        return emailAddress;
    }

    /**
     * Get the advertisement's ID.
     * @return the advertisement's ID
     */
    public int getAdvertisementID() {
        return advertisementID;
    }

    /**
     * Get the advertisement's property.
     * @return the advertisement's property
     */
    public Property getProperty() {
        return property;
    }

    /**
     * Get the advertisement's property type.
     * @return the advertisement's property type
     */
    public String getPropertyType() {
        return propertyType;
    }

    /**
     * Get the advertisement's request type.
     * @return the advertisement's request type
     */
    public String getRequestType() {
        return requestType;
    }

    /**
     * Get the advertisement's date.
     * @return the advertisement's date
     */
    public String getDate() {
        return date;
    }

    public Commission getCommission() {
        return commission;
    }
    /**
     * Get the advertisement's sale price.
     * @return the advertisement's sale price
     */
    public double getSalePrice() {
        return salePrice;
    }



    public void soldAdvertisement() {
        setState("Sold");
        this.date = getCurrentDate();
    }

    public String getState() {
        return state;
    }

    private void setState(String sold) {
    }

    public static String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        int day = currentDate.getDayOfMonth();
        int month = currentDate.getMonthValue();
        int year = currentDate.getYear();
        return day + "/" + month + "/" + year;
    }

    @Override
    public String toString() {return "Property:" + property +
            " | Property Type: " + propertyType +
            " | Request Type: " + requestType +
            " | Date: " + date +
            "\n";
    }
}
