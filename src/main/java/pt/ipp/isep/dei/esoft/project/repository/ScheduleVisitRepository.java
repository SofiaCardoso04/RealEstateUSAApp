package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.DTO.VisitRequestDTO;
import pt.ipp.isep.dei.esoft.project.ENUMS.VisitRequestStatus;
import pt.ipp.isep.dei.esoft.project.Mappers.AdvertisementMapper;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Repository class for managing VisitRequest objects.
 */
public class ScheduleVisitRepository implements Serializable {

    private static final String SCHEDULE_VISIT_SERIALIZATION_FILE_PATH = "Serialization/ScheduleVisit.ser";
    private ClientRepository clientRepository = null;
    private AuthenticationController authenticationController = null;
    private Messages messages = new Messages();
    private ArrayList<VisitRequest> visits = new ArrayList<>();

    /**
     * Retrieves the list of VisitRequests.
     *
     * @return The list of VisitRequests.
     */
    public ArrayList<VisitRequest> getVisitsList() {
        return this.visits;
    }

    /**
     * Validates if a VisitRequest is valid and can be added.
     *
     * @param visit The VisitRequest to validate.
     * @return True if the VisitRequest is valid, false otherwise.
     */
    public boolean validateVisitRequest(VisitRequest visit) {
        return this.visits.contains(visit);
    }

    /**
     * Adds a VisitRequest to the repository.
     *
     * @param visit The VisitRequest to add.
     * @return True if the VisitRequest is added successfully, false otherwise.
     */
    public boolean addVisit(VisitRequest visit) {
        if (visit == null) {
            return false;
        }

        if (validateVisitRequest(visit)) {
            return false;
        }

        this.visits.add(visit);
        return true;
    }

    /**
     * Creates a VisitRequest with the given details and adds it to the repository.
     *
     * @param advertisement The Advertisement for the visit.
     * @param date          The date of the visit.
     * @param startTime     The start time of the visit.
     * @param endTime       The end time of the visit.
     * @return True if the VisitRequest is created and added successfully, false otherwise.
     */
    public boolean createVisit(Advertisement advertisement, LocalDate date, LocalTime startTime, LocalTime endTime) {
        return this.addVisit(new VisitRequest(advertisement, date, startTime, endTime));
    }

    /**
     * Retrieves a list of VisitRequests scheduled for a specific date.
     *
     * @param date The date to filter the VisitRequests.
     * @return The list of VisitRequests scheduled for the given date.
     */
    public ArrayList<VisitRequest> getVisitsScheduleByDate(LocalDate date) {
        ArrayList<VisitRequest> clientSchedules = new ArrayList<>();

        for (VisitRequest visit : visits) {
            if (visit.getDate().equals(date)) {
                clientSchedules.add(visit);
            }
        }

        return clientSchedules;
    }

    /**
     * Changes the status of a VisitRequest to RESPONDED.
     *
     * @param visitRequest The VisitRequest to update.
     */
    public void changeStatus(VisitRequest visitRequest) {
        for (int i = 0; i < this.visits.size(); i++) {
            boolean condition = ((visitRequest.getAdvertisement().equals(this.visits.get(i).getAdvertisement())) && (visitRequest.getDate().equals(this.visits.get(i).getDate())) && (visitRequest.getStartTime().equals(this.visits.get(i).getStartTime())) && (visitRequest.getEndTime().equals(this.visits.get(i).getEndTime())));
            if (condition) {
                this.visits.get(i).setStatus(VisitRequestStatus.RESPONDED);
            }
        }
    }

    /**
     * Sends a message email to the agent with visit details.
     *
     * @param agentEmail   The email of the agent.
     * @param name         The name of the agent.
     * @param propertyID   The ID of the property.
     * @param phoneNumber  The phone number of the client.
     * @param date         The date of the visit.
     * @param startTime    The start time of the visit.
     * @param endTime      The end time of the visit.
     * @throws IOException If an I/O error occurs while sending the message.
     */
    public void sendMessageEmailToAgent(String agentEmail, String name, int propertyID, String phoneNumber, LocalDate date, LocalTime startTime, LocalTime endTime) throws IOException {
        messages.sendMessageEmailToAgent(agentEmail, name, propertyID, phoneNumber, date, startTime, endTime);
    }
}
