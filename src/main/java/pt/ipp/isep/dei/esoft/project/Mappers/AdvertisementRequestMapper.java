package pt.ipp.isep.dei.esoft.project.Mappers;

import pt.ipp.isep.dei.esoft.project.DTO.AdvertisementRequestDTO;
import pt.ipp.isep.dei.esoft.project.domain.*;

/**
 * Mapper class for converting AdvertisementRequest objects to AdvertisementRequestDTO objects and vice versa.
 */
public class AdvertisementRequestMapper {

    /**
     * Converts an AdvertisementRequest object to an AdvertisementRequestDTO object.
     *
     * @param advertisementRequest The AdvertisementRequest object to be converted.
     * @return The corresponding AdvertisementRequestDTO object.
     */
    public static AdvertisementRequestDTO toDTO(AdvertisementRequest advertisementRequest) {
        String emailAddress = advertisementRequest.getEmailAddress();
        Store store = advertisementRequest.getStore();
        Employee agent = advertisementRequest.getAgent();
        Property property = advertisementRequest.getProperty();
        String propertyType = advertisementRequest.getPropertyType();
        String requestType = advertisementRequest.getRequestType();
        double requestedPrice = advertisementRequest.getRequestedPrice();
        String date = advertisementRequest.getDate();

        return new AdvertisementRequestDTO(emailAddress, store, agent, property, propertyType, requestType, requestedPrice, date);
    }

    /**
     * Converts an AdvertisementRequestDTO object to an AdvertisementRequest entity.
     *
     * @param advertisementRequestDTO The AdvertisementRequestDTO object to be converted.
     * @return The corresponding AdvertisementRequest entity.
     */
    public static AdvertisementRequest toEntity(AdvertisementRequestDTO advertisementRequestDTO) {
        String emailAddress = advertisementRequestDTO.getEmailAddress();
        Store store = advertisementRequestDTO.getStore();
        Employee agent = advertisementRequestDTO.getAgent();
        Property property = advertisementRequestDTO.getProperty();
        String propertyType = advertisementRequestDTO.getPropertyType();
        String requestType = advertisementRequestDTO.getRequestType();
        double requestedPrice = advertisementRequestDTO.getRequestedPrice();
        String date = advertisementRequestDTO.getDate();

        return new AdvertisementRequest(emailAddress, store, agent, property, propertyType, requestType, requestedPrice, date);
    }
}
