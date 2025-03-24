package pt.ipp.isep.dei.esoft.project.application.controller;


import pt.ipp.isep.dei.esoft.project.DTO.VisitRequestDTO;
import pt.ipp.isep.dei.esoft.project.INTERFACES.Email;
import pt.ipp.isep.dei.esoft.project.Mappers.VisitRequestMapper;
import pt.ipp.isep.dei.esoft.project.application.session.ApplicationSession;
import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;
import pt.ipp.isep.dei.esoft.project.repository.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Controller class for managing booking requests.
 */
public class ManageBookingRequestController {

    private ScheduleVisitRepository scheduleVisitRepository;
    private AdvertisementRepository advertisementRepository;
    private PropertyRepository propertyRepository;
    private AddressRepository addressRepository;

    ArrayList<VisitRequest> visits;

    BookingListController bookingListController = new BookingListController();

    /**
     * Constructor for ManageBookingRequestController.
     * Initializes the repositories.
     */
    public ManageBookingRequestController() {
        getAddressRepository();
        getAdvertisementRepository();
        getPropertyRepository();
        getScheduleVisitRepository();
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
     * Retrieves the PropertyRepository instance.
     *
     * @return The PropertyRepository instance.
     */
    public PropertyRepository getPropertyRepository() {
        if (propertyRepository == null) {
            Repositories repositories = Repositories.getInstance();
            propertyRepository = repositories.getPropertyRepository();
        }
        return propertyRepository;
    }

    /**
     * Retrieves the AddressRepository instance.
     *
     * @return The AddressRepository instance.
     */
    public AddressRepository getAddressRepository() {
        if (addressRepository == null) {
            Repositories repositories = Repositories.getInstance();
            addressRepository = repositories.getAddressRepository();
        }
        return addressRepository;
    }

    /**
     * Retrieves the list of visit requests.
     *
     * @return The list of visit requests.
     */
    public ArrayList<VisitRequest> getVisits() {
        ScheduleVisitRepository scheduleVisitRepository = getScheduleVisitRepository();
        this.visits = scheduleVisitRepository.getVisitsList();
        return visits;
    }

    /**
     * Responds to a booking request.
     *
     * @param typedResponse   The typed response message.
     * @param visitRequestDTO The VisitRequestDTO object.
     */
    public void respondBookingRequest(String typedResponse, VisitRequestDTO visitRequestDTO) {

        VisitRequest visitRequest = VisitRequestMapper.toEntity(visitRequestDTO);

        // Change the booking request status
        scheduleVisitRepository.changeStatus(visitRequest);

        // Send an email with the typed response
        Address address = visitRequest.getAdvertisement().getProperty().getAddress();
        String phoneNumber = visitRequest.getAdvertisement().getAgent().getPhoneNumber();
        String name = visitRequest.getAdvertisement().getAgent().getName();

        try {
            ApplicationSession applicationSession = ApplicationSession.getInstance();
            Email emailService = applicationSession.getEmailService();
            emailService.sendEmail(typedResponse, name, phoneNumber, address, 1);
        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }
}




