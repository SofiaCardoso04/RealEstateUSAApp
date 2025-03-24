package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.DTO.AdvertisementDTO;
import pt.ipp.isep.dei.esoft.project.Mappers.AdvertisementMapper;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Controller class for scheduling property visits.
 */
public class ScheduleVisitController {
    private Repositories repository;
    private AdvertisementRepository advertisementRepository = null;
    private ScheduleVisitRepository scheduleVisitRepository;
    private ClientRepository clientRepository = null;
    private AuthenticationRepository authenticationRepository = null;
    private ArrayList<Advertisement> advertisements;
    private ArrayList<Client> clients;
    private ArrayList<VisitRequest> visits;

    /**
     * Creates a new instance of ScheduleVisitController.
     */
    public ScheduleVisitController() {
        getAdvertisementsList();
        getAuthenticationRepository();
        getClientRepository();
    }

    /**
     * Gets the AuthenticationRepository instance.
     *
     * @return The AuthenticationRepository instance.
     */
    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();

            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    /**
     * Gets the ClientRepository instance.
     *
     * @return The ClientRepository instance.
     */
    private ClientRepository getClientRepository() {
        if (clientRepository == null) {
            Repositories repositories = Repositories.getInstance();

            clientRepository = repositories.getClientRepository();
        }
        return clientRepository;
    }

    /**
     * Gets the AdvertisementRepository instance.
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
     * Gets the ScheduleVisitRepository instance.
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
     * Gets the list of advertisements.
     *
     * @return The list of advertisements.
     */
    public ArrayList<Advertisement> getAdvertisementsList() {
        AdvertisementRepository advertisementRepository = Repositories.getInstance().getAdvertisementRepository();
        this.advertisements = advertisementRepository.getAdvertisements();
        return advertisements;
    }

    /**
     * Gets the list of clients.
     *
     * @return The list of clients.
     */
    public ArrayList<Client> getClientsList() {
        ClientRepository clientRepository = Repositories.getInstance().getClientRepository();
        this.clients = clientRepository.getClientsList();
        return clients;
    }

    /**
     * Gets the list of visit requests.
     *
     * @return The list of visit requests.
     */
    public ArrayList<VisitRequest> getVisitRequestsList() {
        ScheduleVisitRepository visitRepository = Repositories.getInstance().getScheduleVisitRepository();
        this.visits = visitRepository.getVisitsList();
        return visits;
    }

    /**
     * Gets the email of the current user.
     *
     * @return The email of the current user.
     */
    public String getCurrentUserEmail() {
        return authenticationRepository.getCurrentUserEmail();
    }

    /**
     * Gets the name of the current client.
     *
     * @return The name of the current client.
     */
    public String getCurrentClientName() {
        String userEmail = getCurrentUserEmail();
        if (userEmail != null) {
            Client client = clientRepository.getClientByEmail(userEmail);

            if (client != null) {
                return client.getName();
            }
        }
        return null;
    }

    /**
     * Gets the phone number of the current client.
     *
     * @return The phone number of the current client.
     */
    public String getCurrentClientPhoneNumber() {
        String userEmail = getCurrentUserEmail();
        if (userEmail != null) {
            Client client = clientRepository.getClientByEmail(userEmail);

            if (client != null) {
                return client.getPhoneNumber();
            }
        }
        return null;
    }

    /**
     * Gets the list of advertisements.
     *
     * @return The list of advertisements.
     */
    public ArrayList<Advertisement> getAdvertisements() {
        AdvertisementRepository advertisementRepository = Repositories.getInstance().getAdvertisementRepository();
        this.advertisements = advertisementRepository.getAdvertisements();
        return advertisements;
    }

    /**
     * Creates a visit for a property.
     *
     * @param advertisement The advertisement of the property.
     * @param date          The date of the visit.
     * @param startTime     The start time of the visit.
     * @param endTime       The end time of the visit.
     * @return True if the visit is successfully created, false otherwise.
     */
    public boolean createVisit(Advertisement advertisement, LocalDate date, LocalTime startTime, LocalTime endTime) {
        ScheduleVisitRepository scheduleVisitRepository = getScheduleVisitRepository();
        return this.scheduleVisitRepository.createVisit(advertisement, date, startTime, endTime);
    }

    /**
     * Checks if there are overlapping schedules for a given date and time range.
     *
     * @param date  The date of the visit.
     * @param start The start time of the visit.
     * @param end   The end time of the visit.
     * @return True if there are overlapping schedules, false otherwise.
     */
    public boolean isOverlappingSchedules(LocalDate date, LocalTime start, LocalTime end) {
        LocalTime startTime = start;
        LocalTime endTime = end;

        ArrayList<VisitRequest> visitsSchedules = Repositories.getInstance().getScheduleVisitRepository().getVisitsScheduleByDate(date);

        for (VisitRequest visit : visitsSchedules) {
            if (visit.isOverlapping(startTime, endTime)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Shows the list of advertisements in a specific order.
     *
     * @param list The list of advertisements.
     */
    public void showAdvertisementsByOrder(ArrayList<Advertisement> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Property#" + (i + 1) + ": " + list.get(i).toString());
        }
    }

    /**
     * Sorts the list of advertisements from the most recent to the oldest.
     *
     * @param advertisementList The list of advertisements.
     * @return The sorted list of advertisements.
     */
    public ArrayList<Advertisement> getAdvertisementsSortedFromTheMostRecentToTheOldest(ArrayList<Advertisement> advertisementList) {
        for (int i = 0; i < advertisementList.size() - 1; i++) {
            for (int j = i; j < advertisementList.size(); j++) {
                if (!(advertisementList.get(i).getDate().compareTo(advertisementList.get(j).getDate()) > 0)) {
                    Collections.swap(advertisementList, i, j);
                }
            }
        }
        return advertisementList;
    }

    /**
     * Sends a message email to the agent regarding a property visit.
     *
     * @param agentEmail  The email of the agent.
     * @param name        The name of the client.
     * @param propertyID  The ID of the property.
     * @param phoneNumber The phone number of the client.
     * @param date        The date of the visit.
     * @param startTime   The start time of the visit.
     * @param endTime     The end time of the visit.
     * @throws IOException if there is an error sending the email.
     */
    public void sendMessageEmailToAgent(String agentEmail, String name, int propertyID, String phoneNumber, LocalDate date, LocalTime startTime, LocalTime endTime) throws IOException {
        scheduleVisitRepository.sendMessageEmailToAgent(agentEmail, name, propertyID, phoneNumber, date, startTime, endTime);
    }

    /**
     * Saves a visit request for a property.
     *
     * @param name        The name of the client.
     * @param propertyID  The ID of the property.
     * @param phoneNumber The phone number of the client.
     * @param advertisement The advertisement of the property.
     * @param date        The date of the visit.
     * @param startTime   The start time of the visit.
     * @param endTime     The end time of the visit.
     * @throws IOException if there is an error saving the visit request or sending the email.
     */
    public void saveVisitRequest(String name, int propertyID, String phoneNumber, Advertisement advertisement, LocalDate date, LocalTime startTime, LocalTime endTime) throws IOException {
        String agentEmail = getAgentEmailByAdvertisementID(propertyID);
        VisitRequest visitRequest = new VisitRequest(advertisement, date, startTime, endTime);

        Repositories.getInstance().getScheduleVisitRepository().addVisit(visitRequest);
        sendMessageEmailToAgent(agentEmail, name, propertyID, phoneNumber, date, startTime, endTime);
    }

    /**
     * Gets the email of the agent associated with a specific advertisement.
     *
     * @param id The ID of the advertisement.
     * @return The email of the agent.
     */
    public String getAgentEmailByAdvertisementID(int id) {
        Advertisement advertisement = getAdvertisementRepository().getAdvertisementsByID(id);
        if (advertisement != null) {
            return advertisement.getAgentEmail();
        }
        return null;
    }
}