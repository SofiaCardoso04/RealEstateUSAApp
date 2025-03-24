package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.DTO.AdvertisementRequestDTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents an advertisement through email address, property, property type, request type, date and commission type attributes.
 */
public class  Advertisement implements Serializable {
    private Client emailAddress;
    private Property property;
    private String propertyType;
    private String requestType;
    private Commission commission;
    private String date;
    private double salePrice;
    private int advertisementID;
    private Employee agent;
    private AdvertisementRequestDTO advertisementRequest;
    private String state;
    private Client owner;
    private Store store;
    private double requestedPrice;
    private String dateOfSale;
    private String commission2;


    /**
     * Builds an instance of Advertisement with a given email address, property, property type, request type, date and commission type.
     * @param emailAddress the advertisement's email address
     * @param property the advertisement's property
     * @param propertyType the advertisement's property type
     * @param requestType the advertisement's request type
     * @param date the advertisement's date
     * @param salePrice the advertisement's sale price
     */
    public Advertisement(Client emailAddress, int advertisementID, Property property, String propertyType, String requestType, Commission commission, String date, double salePrice) {
        this.emailAddress = emailAddress;
        this.advertisementID = advertisementID;
        this.state = "On Sale";
        this.property = property;
        this.propertyType = propertyType;
        this.requestType = requestType;
        this.commission = commission;
        this.date = date;
        this.salePrice = salePrice;
    }
   public Advertisement(Employee agent, Client emailAddress, int advertisementID, Property property, String propertyType, Commission commission, String requestType, String date, double salePrice) {
       this.emailAddress = emailAddress;
       this.agent = agent;
       this.advertisementID = advertisementID;
       this.property = property;
       this.propertyType = propertyType;
       this.requestType = requestType;
       this.commission = commission;
       this.date = date;
       this.salePrice = salePrice;
   }

   public Advertisement(Client owner, Employee agent, Store store, Property property, String propertyType, String requestType, String commission2, String date){
        this.owner = owner;
        this.store = store;
        this.agent = agent;
        this.property = property;
        this.propertyType = propertyType;
        this.requestType = requestType;
        this.commission2 = commission2;
        this.date = date;
    }

    /**
     * Builds an instance of Advertisement with a advertisement request, commission type and date.
     * @param advertisementRequest the advertisement's request information
     * @param salePrice the advertisement's sale price
     * @param date the advertisement's date
     */
    public Advertisement (AdvertisementRequestDTO advertisementRequest, Commission commission, double salePrice, String date){
        this.advertisementRequest = advertisementRequest;
        this.commission = commission;
        this.salePrice = salePrice;
        this.date = date;
    }

    /**
     * Get the advertisement's email address.
     * @return the advertisement's email address
     */
    public Client getEmailAddress() {
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

    public Commission getCommission() {
        return commission;
    }

    /**
     * Get the advertisement's date.
     * @return the advertisement's date
     */
    public String getDate() {
        return date;
    }

    /**
     * Get the advertisement's sale price.
     * @return the advertisement's sale price
     */
    public double getSalePrice() {
        return salePrice;
    }

    public String getAgentEmail() {
        return agent.getEmailAddress();
    }

    /**
     * Get the advertisement's request information.
     * @return the advertisement's request information
     */
    public AdvertisementRequestDTO getAdvertisementRequest() {
        return advertisementRequest;
    }


    public Employee getAgent() {
        return agent;
    }

    public Store getStore() {
        return store;
    }

    public void soldAdvertisement() {
        setState("Sold");
        this.date = getCurrentDate();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public static String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        int day = currentDate.getDayOfMonth();
        int month = currentDate.getMonthValue();
        int year = currentDate.getYear();
        return day + "/" + month + "/" + year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advertisement that = (Advertisement) o;
        return Double.compare(that.salePrice, salePrice) == 0 && advertisementID == that.advertisementID && Double.compare(that.requestedPrice, requestedPrice) == 0 && Objects.equals(emailAddress, that.emailAddress) && Objects.equals(property, that.property) && Objects.equals(propertyType, that.propertyType) && Objects.equals(requestType, that.requestType) && Objects.equals(commission, that.commission) && Objects.equals(date, that.date) && Objects.equals(agent, that.agent) && Objects.equals(advertisementRequest, that.advertisementRequest) && Objects.equals(state, that.state) && Objects.equals(owner, that.owner) && Objects.equals(store, that.store) && Objects.equals(dateOfSale, that.dateOfSale) && Objects.equals(commission2, that.commission2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAddress, property, propertyType, requestType, commission, date, salePrice, advertisementID, agent, advertisementRequest, state, owner, store, requestedPrice, dateOfSale, commission2);
    }

    @Override
    public String toString() {return "Property:" + property +
            " | Property Type: " + propertyType +
            " | Request Type: " + requestType +
            " | Date: " + date +
            "\n";
    }

}
