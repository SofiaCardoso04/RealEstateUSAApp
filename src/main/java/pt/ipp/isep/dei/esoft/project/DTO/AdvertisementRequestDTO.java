package pt.ipp.isep.dei.esoft.project.DTO;

import pt.ipp.isep.dei.esoft.project.ENUMS.RequestStatus;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.Store;

public class AdvertisementRequestDTO {
    private String emailAddress;
    private Store store;
    private Employee agent;
    private Property property;
    private String propertyType;
    private String requestType;
    private double requestedPrice;
    private String date;
    private RequestStatus requestStatus;


    /**
     * Builds an instance of AdvertisementRequest with a given store, agent, property, property type, request type and date.
     *
     * @param emailAddress the client's email address
     * @param store        the advertisement request's store
     * @param agent        the advertisement request's agent
     * @param property     the advertisement request's property
     * @param propertyType the advertisement request's property type
     * @param requestType  the advertisement request's request type
     * @param date  the advertisement request's date
     */
    public AdvertisementRequestDTO(String emailAddress, Store store, Employee agent, Property property, String propertyType, String requestType, double requestedPrice, String date) {
        if (emailAddress == null) {
            throw new IllegalArgumentException("The argument can't be null!");
        }

        if (!emailAddress.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            throw new IllegalArgumentException("The email address must be in the right format! (Example: user123@realestate.com)");
        }

        this.emailAddress = emailAddress;
        this.store = store;
        this.agent = agent;
        this.property = property;
        this.propertyType = propertyType;
        this.requestType = requestType;
        this.requestedPrice = requestedPrice;
        this.date = date;
        this.requestStatus = RequestStatus.PENDING;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Get the advertisement's property.
     *
     * @return the advertisement's property
     */
    public Property getProperty() {
        return property;
    }

    /**
     * Get the advertisement's property type.
     *
     * @return the advertisement's property type
     */
    public String getPropertyType() {
        return propertyType;
    }

    /**
     * Get the advertisement's request type.
     *
     * @return the advertisement's request type
     */
    public String getRequestType() {
        return requestType;
    }

    /**
     * Get the advertisement's store.
     *
     * @return the advertisement's store
     */
    public Store getStore() {
        return store;
    }

    /**
     * Get the advertisement's agent.
     *
     * @return the advertisement's agent
     */
    public Employee getAgent() {
        return agent;
    }

    public double getRequestedPrice() {
        return requestedPrice;
    }

    /**
     * Get the advertisement request's date.
     *
     * @return the advertisement request's date
     */
    public String getDate() {
        return date;
    }
    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void accept() {
        requestStatus = RequestStatus.ACCEPTED;
    }
    public void decline() {
        requestStatus = RequestStatus.DECLINED;
    }

    @Override
    public String toString() {
        return "Email Address: " + emailAddress +
                " | Store: " + store +
                " | Agent: " + agent +
                " | Property: " + property +
                " | Property Type: " + propertyType +
                " | Request Type: " + requestType +
                " | Requested Price: " + requestedPrice +
                " | Date: " + date;
    }
}


