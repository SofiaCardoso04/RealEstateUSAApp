package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.ENUMS.RequestStatus;

import static org.junit.jupiter.api.Assertions.*;

public class AdvertisementRequestTest {
    private AdvertisementRequest advertisementRequest;
    private Store store;
    private Employee agent;
    private Property property;

    @BeforeEach
    public void setUp() {
        // Create sample data for testing
        String name = "John Doe";
        String passportCardNumber = "123456789";
        String taxNumber = "123-45-6789";
        String emailAddress = "john.doe@example.com";
        String phoneNumber = "123-456-7890";
        double area = 100.0;
        double distanceFromCity = 10.0;
        String photograph = "property.jpg";
        String id = "12345";
        String designation = "Manager";
        String email = "store@example.com";


        Address address = new Address("123 Main St", "City", "State", "12345");
        Property property = new Property(area, distanceFromCity, photograph, address);
        OrganizationRole organizationRole = new OrganizationRole("Agent");
        Store store = new Store(address, id, phoneNumber, designation, email);
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);

        advertisementRequest = new AdvertisementRequest("john.doe@example.com", store, employee, property, "House", "Sale", 200000.0, "2023-06-13");
    }

    @Test
    public void testConstructor_ValidArguments_ObjectCreated() {
        assertEquals("john.doe@example.com", advertisementRequest.getEmailAddress());
        assertNotEquals(store, advertisementRequest.getStore());
        assertNotEquals(agent, advertisementRequest.getAgent());
        assertNotEquals(property, advertisementRequest.getProperty());
        assertEquals("House", advertisementRequest.getPropertyType());
        assertEquals("Sale", advertisementRequest.getRequestType());
        assertEquals(200000.0, advertisementRequest.getRequestedPrice());
        assertEquals("2023-06-13", advertisementRequest.getDate());
        assertEquals(RequestStatus.PENDING, advertisementRequest.getRequestStatus());
    }

    @Test
    public void testConstructor_NullEmailAddress_ExceptionThrown() {
        assertThrows(IllegalArgumentException.class, () -> new AdvertisementRequest(null, store, agent, property, "House", "Sale", 200000.0, "2023-06-13"));
    }

    @Test
    public void testConstructor_InvalidEmailAddress_ExceptionThrown() {
        assertThrows(IllegalArgumentException.class, () -> new AdvertisementRequest("invalid_email", store, agent, property, "House", "Sale", 200000.0, "2023-06-13"));
    }

    @Test
    public void testSetStatusToAccepted_StatusChanged() {
        advertisementRequest.setStatusToAccepted();
        assertEquals(RequestStatus.ACCEPTED, advertisementRequest.getRequestStatus());
    }

    @Test
    public void testSetStatusToDecline_StatusChanged() {
        advertisementRequest.setStatusToDecline();
        assertEquals(RequestStatus.DECLINED, advertisementRequest.getRequestStatus());
    }

    @Test
    public void testToString_ReturnsFormattedString() {
        String expected = "Email Address: john.doe@example.com | Store: Store designation: Manager | ID: 12345 | E-mail: store@example.com | Phone Number: 123-456-7890 | Store manager: null \n" +
                " | Agent: Name: John Doe | Passport Card Number: 123456789 | Tax Number: 123-45-6789 | Email Address: john.doe@example.com | Phone Number: 123-456-7890 | Property: Area: 100.0 | Distance From City: 10.0 | Photograph: property.jpg | Address: District name: State | City name: City | Street name: 123 Main St | Zip Code: 12345 | Property Type: House | Request Type: Sale | Requested Price: 200000.0 | Date: 2023-06-13";
        assertEquals(expected, advertisementRequest.toString());
    }
    @Test
    public void testGetEmailAddress_ReturnsEmailAddress() {
        assertEquals("john.doe@example.com", advertisementRequest.getEmailAddress());
    }

    @Test
    public void testGetPropertyType_ReturnsPropertyType() {
        assertEquals("House", advertisementRequest.getPropertyType());
    }

    @Test
    public void testGetRequestType_ReturnsRequestType() {
        assertEquals("Sale", advertisementRequest.getRequestType());
    }

    @Test
    public void testGetStore_ReturnsStore() {
        assertNotEquals(store, advertisementRequest.getStore());
    }

    @Test
    public void testGetAgent_ReturnsAgent() {
        assertNotEquals(agent, advertisementRequest.getAgent());
    }

    @Test
    public void testGetRequestedPrice_ReturnsRequestedPrice() {
        assertEquals(200000.0, advertisementRequest.getRequestedPrice());
    }

    @Test
    public void testGetDate_ReturnsDate() {
        assertEquals("2023-06-13", advertisementRequest.getDate());
    }

    @Test
    public void testGetRequestStatus_ReturnsRequestStatus() {
        assertEquals(RequestStatus.PENDING, advertisementRequest.getRequestStatus());
    }

}
