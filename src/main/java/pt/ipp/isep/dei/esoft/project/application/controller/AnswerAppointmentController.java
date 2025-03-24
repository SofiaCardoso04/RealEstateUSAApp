package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.DTO.AdvertisementDTO;
import pt.ipp.isep.dei.esoft.project.DTO.ClientDTO;
import pt.ipp.isep.dei.esoft.project.DTO.VisitRequestDTO;
import pt.ipp.isep.dei.esoft.project.Mappers.AdvertisementMapper;
import pt.ipp.isep.dei.esoft.project.Mappers.ClientMapper;
import pt.ipp.isep.dei.esoft.project.Mappers.VisitRequestMapper;
import pt.ipp.isep.dei.esoft.project.domain.Advertisement;
import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.PasswordGenerator;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;
import pt.ipp.isep.dei.esoft.project.repository.AdvertisementRepository;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.ScheduleVisitRepository;
import pt.isep.lei.esoft.auth.UserSession;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Controller class for managing appointment answers and related operations.
 */
public class AnswerAppointmentController {
    ArrayList<Advertisement> advertisements;

    private ScheduleVisitRepository scheduleVisitRepository;
    private AdvertisementRepository advertisementRepository;
    private AuthenticationRepository authenticationRepository = null;

    /**
     * Default constructor for the AnswerAppointmentController class.
     * Initializes the ScheduleVisitRepository and AdvertisementRepository.
     */
    public AnswerAppointmentController() {
        getScheduleVisitRepository();
        getAdvertisementRepository();
    }

    /**
     * Retrieves the ScheduleVisitRepository instance.
     *
     * @return The ScheduleVisitRepository instance.
     */
    public ScheduleVisitRepository getScheduleVisitRepository() {
        if (scheduleVisitRepository == null) {
            Repositories repositories = Repositories.getInstance();

            scheduleVisitRepository = repositories.getScheduleVisitRepository();
        }
        return scheduleVisitRepository;
    }
    /**
     * Retrieves the AdvertisementRepository instance.
     *
     * @return The AdvertisementRepository instance.
     */

    public AdvertisementRepository getAdvertisementRepository() {
        if (advertisementRepository == null) {
            Repositories repositories = Repositories.getInstance();

            advertisementRepository = repositories.getAdvertisementRepository();
        }
        return advertisementRepository;
    }
    /**
     * Retrieves the list of advertisements.
     *
     * @return The list of advertisements.
     */
    public ArrayList<Advertisement> getAdvertisements() {
        AdvertisementRepository advertisementRepository = Repositories.getInstance().getAdvertisementRepository();
        this.advertisements = advertisementRepository.getAdvertisements();
        return advertisements;
    }
    /**
     * Retrieves the list of VisitRequestDTO objects.
     *
     * @return The list of VisitRequestDTO objects.
     */
    public ArrayList<VisitRequestDTO> getVisitRequestDTOs() {
        ArrayList<VisitRequest> list = getScheduleVisitRepository().getVisitsList();
        ArrayList<VisitRequestDTO> listDTO = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listDTO.add(VisitRequestMapper.toDTO(list.get(i)));
        }
        return listDTO;

    }
    /**
     * Retrieves the list of AdvertisementDTO objects.
     *
     * @return The list of AdvertisementDTO objects.
     */
    public ArrayList<AdvertisementDTO> getAdvertisementsDTOs() {
        ArrayList<Advertisement> lists = getAdvertisements();
        ArrayList<AdvertisementDTO> listsDTO = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            listsDTO.add(AdvertisementMapper.toDTO(lists.get(i)));
        }
        return listsDTO;
    }
    /**
     * Retrieves the ClientDTO object for the current client.
     *
     * @return The ClientDTO object.
     */
    public ClientDTO getClientDTO() {
        Client client = getCurrentClient();
        ClientDTO clientDTO = ClientMapper.toDTO(client);
        return clientDTO;
    }
    /**
     * Retrieves the Client object for the current client.
     *
     * @return The Client object.
     */
    public Client getCurrentClient() {
        AuthenticationRepository rep = Repositories.getInstance().getAuthenticationRepository();
        UserSession us = rep.getCurrentUserSession();
        String email = us.getUserId().getEmail();
        return Repositories.getInstance().getClientRepository().getClientByEmail(email);
    }

    /**
     * Retrieves the Advertisement object by client email from the provided list of VisitRequestDTO objects.
     *
     * @param email The email address of the client.
     * @param list  The list of VisitRequestDTO objects.
     * @return The Advertisement object.
     */
    public Advertisement getAdvertisementByClientEmail(String email, ArrayList<VisitRequestDTO> list){
        Advertisement advertisement= null;
        for (int i = 0; i < list.size() ; i++) {

          Client client= ClientMapper.toEntity( list.get(i).getAdvertisement().getEmailAddress());
            if ( email.equals(client.getEmailAddress() )  ) {
             advertisement = AdvertisementMapper.toEntity(list.get(i).getAdvertisement());
            }

        }

        return advertisement;
    }
    /**
     * Retrieves the VisitRequestDTO object based on the provided Advertisement object and list of VisitRequestDTO objects.
     *
     * @param advertisement The Advertisement object.
     * @param list          The list of VisitRequestDTO objects.
     * @return The VisitRequestDTO object.
     */
    public VisitRequestDTO getVisitRequest(Advertisement advertisement, ArrayList<VisitRequestDTO> list) {
        VisitRequestDTO visitRequestDTO = null;

        for (int i = 0; i < list.size(); i++) {
            if (advertisement.getProperty().getAddress().equals(list.get(i).getAdvertisement().getProperty().getAddress()))


            visitRequestDTO = list.get(i);
        }

        return visitRequestDTO;
    }

    public boolean sendNotification(String notification){

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/AgentsEmail/messages.txt", true));
            writer.write(notification);
            writer.close();
            return true;  // indicate success
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            return false;  // indicate failure
        }
    }

    }


