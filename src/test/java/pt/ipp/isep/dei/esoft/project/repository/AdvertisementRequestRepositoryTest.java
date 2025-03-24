package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.Before;
import org.junit.Test;
import pt.ipp.isep.dei.esoft.project.DTO.AdvertisementRequestDTO;
import pt.ipp.isep.dei.esoft.project.Mappers.AdvertisementRequestMapper;
import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AdvertisementRequestRepositoryTest {

    private AdvertisementRequestRepository advertisementRequestRepository;

    @Before
    public void setup() {
        advertisementRequestRepository = new AdvertisementRequestRepository();
    }

    @Test
    public void testGetAdvertisementRequests() {
        // Create test data
        AdvertisementRequest advertisementRequest1 = createAdvertisementRequest();
        AdvertisementRequest advertisementRequest2 = createAdvertisementRequest();
        advertisementRequestRepository.addAdvertisementRequest(advertisementRequest1);
        advertisementRequestRepository.addAdvertisementRequest(advertisementRequest2);

        // Get the advertisement requests
        ArrayList<AdvertisementRequest> advertisementRequests = advertisementRequestRepository.getAdvertisementRequests();

        // Check if the advertisement requests are retrieved correctly
        assertEquals(2, advertisementRequests.size());
        assertTrue(advertisementRequests.contains(advertisementRequest1));
        assertTrue(advertisementRequests.contains(advertisementRequest2));
    }

    @Test
    public void testValidateAdvertisementRequest() {
        // Create test data
        AdvertisementRequest advertisementRequest = createAdvertisementRequest();
        advertisementRequestRepository.addAdvertisementRequest(advertisementRequest);

        // Check if the advertisement request is validated correctly
        assertTrue(advertisementRequestRepository.validateAdvertisementRequest(advertisementRequest));
    }

    @Test
    public void testAddAdvertisementRequest() {
        // Create test data
        AdvertisementRequest advertisementRequest = createAdvertisementRequest();

        // Add the advertisement request
        boolean added = advertisementRequestRepository.addAdvertisementRequest(advertisementRequest);

        // Check if the advertisement request is added successfully
        assertTrue(added);
        assertTrue(advertisementRequestRepository.getAdvertisementRequests().contains(advertisementRequest));
    }

    @Test
    public void testCreateRequest() {
        // Create test data


        String name = "John Doe";
        String passportCardNumber = "123456789";
        String taxNumber = "123-45-6789";
        String emailAddress = "john.doe@example.com";
        String phoneNumber = "123-456-7890";
        int advertisementID = 1;
        double area = 100.0;
        double distanceFromCity = 10.0;
        String photograph = "property.jpg";
        String id = "12345";
        String designation = "Manager";
        String email = "store@example.com";
        String propertyType = "House";
        String requestType = "Sale";
        String date1 = "2023-06-13";
        double salePrice = 200000.0;
        double orderAmount = 1000;

        Commission commission1 = new Commission(500.0, 10);
        Address address = new Address("123 Main St", "City", "State", "12345");
        Client client = new Client(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        Property property = new Property(area, distanceFromCity, photograph, address);
        OrganizationRole organizationRole = new OrganizationRole("Agent");
        Store store = new Store(address, id, phoneNumber, designation, email);
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);
        double requestedPrice = 200000.0;
        String date = "2023-06-13";

        // Create the advertisement request
        boolean created = advertisementRequestRepository.createRequest(emailAddress, store, employee, property, propertyType, requestType, requestedPrice, date);

        // Check if the advertisement request is created successfully
        assertTrue(created);
        ArrayList<AdvertisementRequest> advertisementRequests = advertisementRequestRepository.getAdvertisementRequests();
        assertEquals(1, advertisementRequests.size());
        AdvertisementRequest createdRequest = advertisementRequests.get(0);
        assertEquals(emailAddress, createdRequest.getEmailAddress());
        assertEquals(store, createdRequest.getStore());
        assertEquals(employee, createdRequest.getAgent());
        assertEquals(property, createdRequest.getProperty());
        assertEquals(propertyType, createdRequest.getPropertyType());
        assertEquals(requestType, createdRequest.getRequestType());
        assertEquals(requestedPrice, createdRequest.getRequestedPrice(), 0.001);
        assertEquals(date, createdRequest.getDate());
    }

    @Test
    public void testGetAdvertisementByStore() {
        // Create test data


        // Create sample data for testing
        String name = "John Doe";
        String passportCardNumber = "123456789";
        String taxNumber = "123-45-6789";
        String emailAddress = "john.doe@example.com";
        String phoneNumber = "123-456-7890";
        int advertisementID = 1;
        double area = 100.0;
        double distanceFromCity = 10.0;
        String photograph = "property.jpg";
        String id = "12345";
        String designation = "Manager";
        String email = "store@example.com";
        String propertyType = "House";
        String requestType = "Sale";
        String date1 = "2023-06-13";
        double salePrice = 200000.0;
        double orderAmount = 1000;

        Commission commission1 = new Commission(500.0, 10);
        Address address = new Address("123 Main St", "City", "State", "12345");
        Client client = new Client(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        Property property = new Property(area, distanceFromCity, photograph, address);
        OrganizationRole organizationRole = new OrganizationRole("Agent");
        Store store = new Store(address, id, phoneNumber, designation, email);
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);

        AdvertisementRequest advertisementRequest1 = createAdvertisementRequest();
        AdvertisementRequest advertisementRequest2 = createAdvertisementRequest();
        advertisementRequestRepository.addAdvertisementRequest(advertisementRequest1);
        advertisementRequestRepository.addAdvertisementRequest(advertisementRequest2);

        // Get the number of advertisement requests by store
        int count = advertisementRequestRepository.getAdvertisementByStore(store);

        // Check if the count is correct
        assertEquals(2, count);
    }

    @Test
    public void testListPendingAdvertisementRequests() {
        // Create test data
        AdvertisementRequest advertisementRequest1 = createAdvertisementRequest();
        AdvertisementRequest advertisementRequest2 = createAdvertisementRequest();
        advertisementRequest2.setStatusToAccepted();
        advertisementRequestRepository.addAdvertisementRequest(advertisementRequest1);
        advertisementRequestRepository.addAdvertisementRequest(advertisementRequest2);

        // Get the pending advertisement requests
        ArrayList<AdvertisementRequest> pendingRequests = advertisementRequestRepository.listPendingAdvertisementRequests();

        // Check if only the pending advertisement requests are retrieved
        assertEquals(1, pendingRequests.size());
        assertTrue(pendingRequests.contains(advertisementRequest1));
    }

    @Test
    public void testGetAdvertisementRequestsDTOs() {
        // Create test data
        AdvertisementRequest advertisementRequest1 = createAdvertisementRequest();
        AdvertisementRequest advertisementRequest2 = createAdvertisementRequest();
        advertisementRequestRepository.addAdvertisementRequest(advertisementRequest1);
        advertisementRequestRepository.addAdvertisementRequest(advertisementRequest2);

        // Get the advertisement request DTOs
        ArrayList<AdvertisementRequestDTO> advertisementRequestDTOs = advertisementRequestRepository.getAdvertisementRequestsDTOs();

        // Check if the advertisement request DTOs are retrieved correctly
        assertEquals(2, advertisementRequestDTOs.size());
        assertFalse(advertisementRequestDTOs.contains(AdvertisementRequestMapper.toDTO(advertisementRequest1)));
        assertFalse(advertisementRequestDTOs.contains(AdvertisementRequestMapper.toDTO(advertisementRequest2)));
    }

    @Test
    public void testGetAdvertisementRequestsSortedFromTheMostRecentToTheOldest() {
        // Create test data
        AdvertisementRequest advertisementRequest1 = createAdvertisementRequest();
        AdvertisementRequest advertisementRequest2 = createAdvertisementRequest();
        advertisementRequestRepository.addAdvertisementRequest(advertisementRequest1);
        advertisementRequestRepository.addAdvertisementRequest(advertisementRequest2);

        // Get the sorted advertisement request DTOs
        ArrayList<AdvertisementRequestDTO> advertisementRequestDTOs = advertisementRequestRepository.getAdvertisementRequestsDTOs();
        ArrayList<AdvertisementRequestDTO> sortedDTOs = advertisementRequestRepository.getAdvertisementRequestsSortedFromTheMostRecentToTheOldest(advertisementRequestDTOs);

        // Check if the advertisement request DTOs are sorted correctly
        assertEquals(2, sortedDTOs.size());
        assertNotEquals(advertisementRequestDTOs.get(0), sortedDTOs.get(1));
        assertNotEquals(advertisementRequestDTOs.get(1), sortedDTOs.get(0));
    }

    @Test
    public void testFind() {
        // Create test data
        AdvertisementRequestDTO advertisementRequestDTO = createAdvertisementRequestDTO();
        AdvertisementRequest advertisementRequest = AdvertisementRequestMapper.toEntity(advertisementRequestDTO);
        advertisementRequestRepository.addAdvertisementRequest(advertisementRequest);

        // Find the advertisement request
        AdvertisementRequest foundRequest = advertisementRequestRepository.find(advertisementRequestDTO);

        // Check if the advertisement request is found correctly
        assertEquals(advertisementRequest, foundRequest);
    }

    // Helper method to create an AdvertisementRequest
    private AdvertisementRequest createAdvertisementRequest() {
        // Create sample data for testing
        String name = "John Doe";
        String passportCardNumber = "123456789";
        String taxNumber = "123-45-6789";
        String emailAddress = "john.doe@example.com";
        String phoneNumber = "123-456-7890";
        int advertisementID = 1;
        double area = 100.0;
        double distanceFromCity = 10.0;
        String photograph = "property.jpg";
        String id = "12345";
        String designation = "Manager";
        String email = "store@example.com";
        String propertyType = "House";
        String requestType = "Sale";
        String date1 = "2023-06-13";
        double salePrice = 200000.0;
        double orderAmount = 1000;

        Commission commission1 = new Commission(500.0, 10);
        Address address = new Address("123 Main St", "City", "State", "12345");
        Client client = new Client(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        Property property = new Property(area, distanceFromCity, photograph, address);
        OrganizationRole organizationRole = new OrganizationRole("Agent");
        Store store = new Store(address, id, phoneNumber, designation, email);
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);



        return new AdvertisementRequest("john.doe@example.com", store, employee, property, "House", "Sale", 200000.0, "2023-06-13");
    }

    // Helper method to create an AdvertisementRequestDTO
    private AdvertisementRequestDTO createAdvertisementRequestDTO() {

        String name = "John Doe";
        String passportCardNumber = "123456789";
        String taxNumber = "123-45-6789";
        String emailAddress = "john.doe@example.com";
        String phoneNumber = "123-456-7890";
        int advertisementID = 1;
        double area = 100.0;
        double distanceFromCity = 10.0;
        String photograph = "property.jpg";
        String id = "12345";
        String designation = "Manager";
        String email = "store@example.com";
        String propertyType = "House";
        String requestType = "Sale";
        String date1 = "2023-06-13";
        double salePrice = 200000.0;
        double orderAmount = 1000;

        Commission commission1 = new Commission(500.0, 10);
        Address address = new Address("123 Main St", "City", "State", "12345");
        Client client = new Client(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        Property property = new Property(area, distanceFromCity, photograph, address);
        OrganizationRole organizationRole = new OrganizationRole("Agent");
        Store store = new Store(address, id, phoneNumber, designation, email);
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);


        return new AdvertisementRequestDTO("john.doe@example.com", store, employee, property, "House", "Sale", 200000.0, "2023-06-13");
    }
}

