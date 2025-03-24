package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.DTO.AdvertisementRequestDTO;
import pt.ipp.isep.dei.esoft.project.domain.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The AdvertisementRepository class manages a collection of advertisements and provides methods to create, validate and add advertisements.
 */
public class AdvertisementRepository  implements Serializable{
    private static final String ADVERTISEMENT_SERIALIZATION_FILE_PATH = "Serialization/Advertisement.ser";

    /**
     * The collection of advertisements managed by this repository.
     */
    private ArrayList<Advertisement> advertsisements = new ArrayList<>();
    private Messages messages = new Messages();

    /**
     * Returns the collection of advertisements managed by this repository.
     *
     * @return the collection of advertisements managed by this repository
     */
    public ArrayList<Advertisement> getAdvertisements() {
        return this.advertsisements;
    }


    public Advertisement getAdvertisementsByID(int id) {
        for (Advertisement advertisement : advertsisements) {
            if (advertisement.getAdvertisementID() == id) {
                return advertisement;
            }
        }
        return null;
    }

    /**
     * Checks if the given advertisement is a valid advertisement.
     *
     * @param advertisement the advertisement to be validated
     * @return true if the advertisement is valid, false otherwise
     */
    public boolean validateAdvertisement(Advertisement advertisement) {
        return this.advertsisements.contains(advertisement);
    }

    /**
     * Adds a new advertisement to the repository.
     *
     * @param advertisement the advertisement to be added
     * @return true if the advertisement is added successfully, false otherwise
     */
    public boolean addAdvertisement(Advertisement advertisement) {
        if (advertisement == null) {
            return false;
        }

        if (validateAdvertisement(advertisement)) {
            return false;
        }
        this.advertsisements.add(advertisement);
        return true;
    }

    /**
     * Creates a new advertisement with the given information.
     * <p>
     * //     * @param emailAddress the advertisement's email address
     * //     * @param property     the advertisement's property
     * //     * @param propertyType the advertisement's property type
     * //     * @param requestType  the advertisement's request type
     *
     * @param date      the advertisement's date
     * @param salePrice the advertisement's sale price
     * @return the newly created advertisement if it is created successfully, null otherwise
     */
    public boolean createAdvertisement(Employee agent, Client emailAddress, int advertisementID, Property property, String propertyType, String requestType, Commission commission, String date, double salePrice) {
        return this.addAdvertisement(new Advertisement(agent, emailAddress, advertisementID, property, propertyType, commission, requestType, date, salePrice));
    }

    public boolean createAdvertisementFromRequest(AdvertisementRequestDTO advertisementRequest, double salePrice, Commission commission, String date) {
        return this.addAdvertisement(new Advertisement(advertisementRequest, commission, salePrice, date));
    }

    public void soldAdvertisement(Advertisement advertisement) {
        advertisement.soldAdvertisement();
    }

    public void sendSMSMessageToOwner(String clientPhone, String agentPhone, String clientName, String streetName, String cityName, String district, String zipCode, String date, String agentName) throws IOException {
        messages.sendSMSMessageToOwner(clientPhone, agentPhone, clientName, streetName, cityName, district, zipCode, date, agentName);
    }

    public void sendMessageEmailToClient(String clientEmail, String message) throws IOException {
        messages.sendMessageEmailToClient(clientEmail, message);
    }

}
