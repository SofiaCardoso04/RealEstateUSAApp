package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.DTO.AdvertisementDTO;
import pt.ipp.isep.dei.esoft.project.DTO.AdvertisementRequestDTO;
import pt.ipp.isep.dei.esoft.project.DTO.ClientDTO;
import pt.ipp.isep.dei.esoft.project.DTO.PurchaseOrderDTO;
import pt.ipp.isep.dei.esoft.project.ENUMS.OrderStatus;
import pt.ipp.isep.dei.esoft.project.ENUMS.RequestStatus;
import pt.ipp.isep.dei.esoft.project.Mappers.AdvertisementMapper;
import pt.ipp.isep.dei.esoft.project.Mappers.AdvertisementRequestMapper;
import pt.ipp.isep.dei.esoft.project.Mappers.ClientMapper;
import pt.ipp.isep.dei.esoft.project.domain.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The AdvertisementRequestRepository class manages a collection of advertisements requests and provides methods to create, validate and add advertisements.
 */
public class AdvertisementRequestRepository  implements Serializable{
    private static final String ADVERTISEMENT_REQUEST_SERIALIZATION_FILE_PATH= "Serialization/AdvertisementRequest.ser";
    /**
     * The collection of advertisements requests managed by this repository.
     */
    private ArrayList<AdvertisementRequest> advertisementRequests = new ArrayList<>();
    private Sorting sorting = new Sorting();

    /**
     * Returns the collection of advertisements requests managed by this repository.
     *
     * @return the collection of advertisements requests managed by this repository
     */
    public ArrayList<AdvertisementRequest> getAdvertisementRequests() {
        return this.advertisementRequests;
    }

    /**
     * Checks if the given advertisement request is a valid advertisement.
     *
     * @param advertisementRequest the advertisement request to be validated
     * @return true if the advertisement request is valid, false otherwise
     */
    public boolean validateAdvertisementRequest(AdvertisementRequest advertisementRequest) {
        return this.advertisementRequests.contains(advertisementRequest);
    }

    /**
     * Adds a new advertisement request to the repository.
     *
     * @param advertisementRequest the advertisement request to be added
     * @return true if the advertisement request is added successfully, false otherwise
     */
    public boolean addAdvertisementRequest(AdvertisementRequest advertisementRequest) {
        if (advertisementRequest == null) {
            return false;
        }

        if (validateAdvertisementRequest(advertisementRequest)) {
            return false;
        }
        this.advertisementRequests.add(advertisementRequest);
        return true;
    }

    /**
     * Creates a new advertisement request with the given information.
     *
     * @param store        the advertisement request's store
     * @param agent        the advertisement request's agent
     * @param property     the advertisement request's property
     * @param propertyType the advertisement request's property type
     * @param requestType  the advertisement request's request type
     * @param date  the advertisement request's date
     * @return the newly created advertisement request if it is created successfully, null otherwise
     */
    public boolean createRequest(String emailAddress, Store store, Employee agent, Property property, String propertyType, String requestType, double requestedPrice, String date) {
        return this.addAdvertisementRequest(new AdvertisementRequest(emailAddress, store, agent, property, propertyType, requestType, requestedPrice, date));
    }

    /**
     * Retrieves the number of advertisement requests associated with the given store.
     *
     * @param store The store to count the advertisement requests for.
     * @return The number of advertisement requests associated with the store.
     */
    public int getAdvertisementByStore(Store store) {
        int i = 0;
        for (AdvertisementRequest advertisementRequest : advertisementRequests) {

            if (store.getId().equals(advertisementRequest.getStore().getId())) {
                i++;

            }
        }
        return i;
    }

    public ArrayList<AdvertisementRequest> listPendingAdvertisementRequests() {
        ArrayList<AdvertisementRequest> pendingAdvertisementRequests = new ArrayList<>();
        for (AdvertisementRequest advertisementRequest : advertisementRequests) {
            if (advertisementRequest.getRequestStatus() == RequestStatus.PENDING) {
                pendingAdvertisementRequests.add(advertisementRequest);
            }
        }
        return pendingAdvertisementRequests;
    }

    public ArrayList<AdvertisementRequestDTO> getAdvertisementRequestsDTOs() {
        ArrayList<AdvertisementRequest> list = listPendingAdvertisementRequests();
        ArrayList<AdvertisementRequestDTO> listDTO = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listDTO.add(AdvertisementRequestMapper.toDTO(list.get(i)));
        }
        return listDTO;
    }

    public ArrayList<AdvertisementRequestDTO> getAdvertisementRequestsSortedFromTheMostRecentToTheOldest(ArrayList<AdvertisementRequestDTO> advertisementRequestList) {
        return sorting.getAdvertisementRequestsSortedFromTheMostRecentToTheOldest(advertisementRequestList);
    }

    public AdvertisementRequest find(AdvertisementRequestDTO advertisementRequestDTO) {
        String emailAddress = advertisementRequestDTO.getEmailAddress();
        Store store = advertisementRequestDTO.getStore();
        Employee agent = advertisementRequestDTO.getAgent();
        Property property = advertisementRequestDTO.getProperty();
        String propertyType = advertisementRequestDTO.getPropertyType();
        String requestType = advertisementRequestDTO.getRequestType();
        String date = advertisementRequestDTO.getDate();

        for (AdvertisementRequest advertisementRequest : advertisementRequests) {
            if (advertisementRequest.getEmailAddress() == emailAddress &&
                    advertisementRequest.getStore() == store &&
                    advertisementRequest.getAgent() == agent &&
                    advertisementRequest.getProperty() == property &&
                    advertisementRequest.getPropertyType() == propertyType &&
                    advertisementRequest.getRequestType() == requestType &&
                    advertisementRequest.getDate() == date) {
                return advertisementRequest;
            }
        }
        return null;
    }
}
