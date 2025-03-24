package pt.ipp.isep.dei.esoft.project.Mappers;

import pt.ipp.isep.dei.esoft.project.DTO.AdvertisementDTO;
import pt.ipp.isep.dei.esoft.project.DTO.ClientDTO;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.ClientRepository;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;

/**
 * Mapper class for converting Advertisement objects to AdvertisementDTO objects and vice versa.
 */
public class AdvertisementMapper {

    /**
     * Converts an Advertisement object to an AdvertisementDTO object.
     *
     * @param advertisement The Advertisement object to be converted.
     * @return The corresponding AdvertisementDTO object.
     */
    public static AdvertisementDTO toDTO(Advertisement advertisement) {
        ClientDTO emailAddress = ClientMapper.toDTO(advertisement.getEmailAddress());
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Employee agent = employeeRepository.getEmployeeByEmail(advertisement.getAgentEmail());
        Property property = advertisement.getProperty();
        int advertisementID = advertisement.getAdvertisementID();
        String propertyType = advertisement.getPropertyType();
        String requestType = advertisement.getRequestType();
        String date = advertisement.getDate();
        double salePrice = advertisement.getSalePrice();
        Commission commission = advertisement.getCommission();

        return new AdvertisementDTO(agent, emailAddress, advertisementID, property, propertyType, requestType, date, salePrice, commission);
    }

    /**
     * Converts an AdvertisementDTO object to an Advertisement entity.
     *
     * @param advertisementDTO The AdvertisementDTO object to be converted.
     * @return The corresponding Advertisement entity.
     */
    public static Advertisement toEntity(AdvertisementDTO advertisementDTO) {
        ClientRepository clientRepository = new ClientRepository();
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Employee agent = employeeRepository.getEmployeeByEmail(advertisementDTO.getAgentEmail());
        Client client = ClientMapper.toEntity(advertisementDTO.getEmailAddress());
        int advertisementID = advertisementDTO.getAdvertisementID();
        Property property = advertisementDTO.getProperty();
        String propertyType = advertisementDTO.getPropertyType();
        String requestType = advertisementDTO.getRequestType();
        String date = advertisementDTO.getDate();
        double salePrice = advertisementDTO.getSalePrice();
        Commission commission = advertisementDTO.getCommission();

        return new Advertisement(agent, client, advertisementID, property, propertyType, commission, requestType, date, salePrice);
    }
}