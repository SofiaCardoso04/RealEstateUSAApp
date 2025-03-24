package pt.ipp.isep.dei.esoft.project.Mappers;

import pt.ipp.isep.dei.esoft.project.DTO.ClientDTO;
import pt.ipp.isep.dei.esoft.project.domain.Client;

/**
 * Mapper class for converting Client objects to ClientDTO objects and vice versa.
 */
public class ClientMapper {

    /**
     * Converts a Client object to a ClientDTO object.
     *
     * @param client The Client object to be converted.
     * @return The corresponding ClientDTO object.
     */
    public static ClientDTO toDTO(Client client) {
        String name = client.getName();
        String passportCardNumber = client.getPassportCardNumber();
        String taxNumber = client.getTaxNumber();
        String emailAddress = client.getEmailAddress();
        String phoneNumber = client.getPhoneNumber();

        return new ClientDTO(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
    }

    /**
     * Converts a ClientDTO object to a Client entity.
     *
     * @param clientDTO The ClientDTO object to be converted.
     * @return The corresponding Client entity.
     */
    public static Client toEntity(ClientDTO clientDTO) {
        String name = clientDTO.getName();
        String passportCardNumber = clientDTO.getPassportCardNumber();
        String taxNumber = clientDTO.getTaxNumber();
        String emailAddress = clientDTO.getEmailAddress();
        String phoneNumber = clientDTO.getPhoneNumber();

        return new Client(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
    }

}