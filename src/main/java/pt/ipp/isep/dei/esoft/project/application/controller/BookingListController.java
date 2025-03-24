package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.DTO.VisitRequestDTO;
import pt.ipp.isep.dei.esoft.project.ENUMS.VisitRequestStatus;
import pt.ipp.isep.dei.esoft.project.INTERFACES.SortingAlgorithm;
import pt.ipp.isep.dei.esoft.project.Mappers.VisitRequestMapper;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.ScheduleVisitRepository;
import pt.isep.lei.esoft.auth.UserSession;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

public class BookingListController {

    ArrayList<VisitRequest> visits;

    private ScheduleVisitRepository ScheduleVisitRepository = null;

    /**
     * Retrieves the ScheduleVisitRepository instance.
     *
     * @return the ScheduleVisitRepository instance
     */
    public ScheduleVisitRepository getScheduleVisitRepository(){
        if(ScheduleVisitRepository == null){
            Repositories repositories = Repositories.getInstance();
            ScheduleVisitRepository = repositories.getScheduleVisitRepository();
        }
        return ScheduleVisitRepository;
    }

    /**
     * Retrieves the list of visit requests.
     *
     * @return the list of visit requests
     */
    public ArrayList<VisitRequest> getVisits(){
        ScheduleVisitRepository ScheduleVisitRepository = getScheduleVisitRepository();
        this.visits = ScheduleVisitRepository.getVisitsList();
        return visits;
    }

    /**
     * Retrieves the list of visit request DTOs.
     *
     * @return the list of visit request DTOs
     */
    public ArrayList<VisitRequestDTO> getVisitsDTOs(){
        ArrayList<VisitRequest> list = getVisits();
        ArrayList<VisitRequestDTO> listDTO = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listDTO.add(VisitRequestMapper.toDTO(list.get(i)));
        }
        return listDTO;
    }

    /**
     * Displays the booking requests for the logged-in agent.
     *
     * @param list the list of visit request DTOs
     */
    public void showBookingRequests(ArrayList<VisitRequestDTO> list) {
        Employee loggedInAgent = getCurrentAgent();
        for (int i = 0; i < list.size(); i++) {
            if((loggedInAgent.equals(list.get(i).getAdvertisement().getAgent())) && (list.get(i).getStatus().equals(VisitRequestStatus.PENDING))){
                System.out.println("Booking Request#" + (i + 1) + ": " + list.get(i).toString());
            }
        }
    }

    /**
     * Displays the filtered booking requests for the logged-in agent within a specified date range.
     *
     * @param beginDate the start date of the range
     * @param endDate the end date of the range
     * @param list the list of visit request DTOs
     */
    public void showFilteredBookingRequests(LocalDate beginDate, LocalDate endDate, ArrayList<VisitRequestDTO> list){
        Employee loggedInAgent = getCurrentAgent();
        for (int i = 0; i < list.size(); i++) {
            if((loggedInAgent.equals(list.get(i).getAdvertisement().getAgent())) && ((list.get(i).getDate().isAfter(beginDate)) && (list.get(i).getDate().isBefore(endDate))) && list.get(i).getStatus().equals(VisitRequestStatus.PENDING)){
                System.out.println("Booking Request#" + (i + 1) + ": " + list.get(i).toString());
            }
        }
    }

    /**
     * Retrieves the current agent logged in the system.
     *
     * @return the current agent
     */
    public Employee getCurrentAgent() {
        AuthenticationRepository rep = Repositories.getInstance().getAuthenticationRepository();
        UserSession us = rep.getCurrentUserSession();
        String email = us.getUserId().getEmail();
        return Repositories.getInstance().getEmployeeRepository().getEmployeeByEmail(email);
    }

    /**
     * Retrieves the sorting algorithm for the booking list.
     *
     * @return the sorting algorithm
     * @throws IOException if an I/O error occurs
     */
    public SortingAlgorithm getSortingMethods() throws IOException {
        InputStream inputStream = null;
        Properties prop = new Properties();

        try {
            String sortingFileName = "sorting.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(sortingFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("sorting file" + sortingFileName + "not found in the classpath.");
            }

            String sorting1 = prop.getProperty("sorting1");

            SortingAlgorithm sortingAlgorithm = (SortingAlgorithm) Class.forName(sorting1).getDeclaredConstructor().newInstance();

            return sortingAlgorithm;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }

        return null;
    }
}