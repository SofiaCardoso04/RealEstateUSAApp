package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.DTO.AdvertisementRequestDTO;
import pt.ipp.isep.dei.esoft.project.DTO.PurchaseOrderDTO;
import pt.ipp.isep.dei.esoft.project.ENUMS.RequestStatus;
import pt.ipp.isep.dei.esoft.project.Mappers.AdvertisementRequestMapper;
import pt.ipp.isep.dei.esoft.project.domain.Advertisement;
import pt.ipp.isep.dei.esoft.project.domain.AdvertisementRequest;
import pt.ipp.isep.dei.esoft.project.domain.Commission;
import pt.ipp.isep.dei.esoft.project.domain.PurchaseOrder;
import pt.ipp.isep.dei.esoft.project.repository.AdvertisementRepository;
import pt.ipp.isep.dei.esoft.project.repository.AdvertisementRequestRepository;
import pt.ipp.isep.dei.esoft.project.repository.OrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class PublishRequestController {
    private AdvertisementRepository advertisementRepository = null;
    private AdvertisementRequestRepository advertisementRequestRepository = null;
    private ArrayList<AdvertisementRequest> advertisementRequests;

    /**
     * Constructs a new PublishRequestController.
     * Initializes the advertisementRepository and advertisementRequestRepository.
     */
    public PublishRequestController(){
        getAdvertisementRepository();
        getAdvertisementRequestRepository();
    }

    private AdvertisementRepository getAdvertisementRepository() {
        if (advertisementRepository == null) {
            Repositories repositories = Repositories.getInstance();
            advertisementRepository = repositories.getAdvertisementRepository();
        }
        return advertisementRepository;
    }

    /**
     * Retrieves the AdvertisementRequestRepository instance.
     *
     * @return the AdvertisementRequestRepository instance
     */
    public AdvertisementRequestRepository getAdvertisementRequestRepository() {
        if (advertisementRequestRepository == null) {
            Repositories repositories = Repositories.getInstance();
            advertisementRequestRepository = repositories.getAdvertisementRequestRepository();
        }
        return advertisementRequestRepository;
    }

    /**
     * Retrieves the list of AdvertisementRequestDTOs.
     *
     * @return the list of AdvertisementRequestDTOs
     */
    public ArrayList<AdvertisementRequestDTO> getAdvertisementRequestsDTOs() {
        return advertisementRequestRepository.getAdvertisementRequestsDTOs();
    }

    /**
     * Sorts the advertisement requests from the most recent to the oldest.
     *
     * @param advertisementRequestList the list of AdvertisementRequestDTOs
     * @return the sorted list of AdvertisementRequestDTOs
     */
    public ArrayList<AdvertisementRequestDTO> getAdvertisementRequestsSortedFromTheMostRecentToTheOldest(ArrayList<AdvertisementRequestDTO> advertisementRequestList) {
        return advertisementRequestRepository.getAdvertisementRequestsSortedFromTheMostRecentToTheOldest(advertisementRequestList);
    }

    /**
     * Displays the advertisement requests in the specified order.
     *
     * @param list the list of AdvertisementRequestDTOs
     */
    public void showAdvertisementRequestsByOrder(ArrayList<AdvertisementRequestDTO> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Request " + (i + 1) + ": " + list.get(i).toString());
        }
    }

    /**
     * Creates an advertisement from the specified request.
     *
     * @param advertisementRequestDTO the AdvertisementRequestDTO
     * @param salePrice the sale price of the advertisement
     * @param date the date of the advertisement
     * @param commission the commission of the advertisement
     * @return true if the advertisement is created successfully, false otherwise
     */
    public boolean createAdvertisementFromRequest(AdvertisementRequestDTO advertisementRequestDTO, double salePrice, String date, Commission commission) {
        AdvertisementRepository advertisementRepository = getAdvertisementRepository();
        AdvertisementRequestRepository advertisementRequestRepository = getAdvertisementRequestRepository();
        AdvertisementRequest advertisementRequest = advertisementRequestRepository.find(advertisementRequestDTO);

        advertisementRequest.setStatusToAccepted();
        return advertisementRepository.createAdvertisementFromRequest(advertisementRequestDTO, salePrice, commission, date);
    }

    /**
     * Declines the specified advertisement request.
     *
     * @param advertisementRequestDTO the AdvertisementRequestDTO to decline
     */
    public void declineRequest(AdvertisementRequestDTO advertisementRequestDTO) {
        AdvertisementRequestRepository advertisementRequestRepository = getAdvertisementRequestRepository();
        AdvertisementRequest advertisementRequest = advertisementRequestRepository.find(advertisementRequestDTO);

        advertisementRequest.setStatusToDecline();
    }

    /**
     * Sends a message email to the specified client.
     *
     * @param clientEmail the email of the client
     * @param message the message to send
     * @throws IOException if an I/O error occurs
     */
    public void sendMessageEmailToClient(String clientEmail, String message) throws IOException {
        advertisementRepository.sendMessageEmailToClient(clientEmail, message);
    }
}