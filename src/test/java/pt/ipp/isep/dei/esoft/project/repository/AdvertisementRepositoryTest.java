package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pt.ipp.isep.dei.esoft.project.DTO.AdvertisementRequestDTO;
import pt.ipp.isep.dei.esoft.project.domain.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AdvertisementRepositoryTest {


    private AdvertisementRepository advertisementRepository;

    @Before
    public void setup() {

        advertisementRepository = new AdvertisementRepository();

    }

    @Test
    public void testGetAdvertisements() {
        // Add test advertisements
        String name1 = "John Doe";
        String passportCardNumber1 = "123456789";
        String taxNumber1 = "123-45-6789";
        String emailAddress1 = "john.doe@example.com";
        String phoneNumber1 = "123-456-7890";
        int advertisementID1 = 1;
        double area1 = 100.0;
        double distanceFromCity1 = 10.0;
        String photograph1 = "property.jpg";
        String propertyType1 = "House";
        String requestType1 = "Sale";
        String date1 = "2023-06-13";
        double salePrice1 = 200000.0;

        Commission commission1 = new Commission(500.0, 10);
        Address address1 = new Address("123 Main St", "City", "State", "12345");
        Client client1 = new Client(name1, passportCardNumber1, taxNumber1, emailAddress1, phoneNumber1);
        Property property1 = new Property(area1, distanceFromCity1, photograph1, address1);
        OrganizationRole organizationRole1 = new OrganizationRole("Agent");
        Store store1 = new Store(address1, "12345", phoneNumber1, "Manager", "store@example.com");
        Employee employee1 = new Employee(name1, passportCardNumber1, taxNumber1, emailAddress1, phoneNumber1, organizationRole1, address1, store1);

        Advertisement ad1 = new Advertisement(employee1, client1, advertisementID1, property1, propertyType1, commission1, requestType1, date1, salePrice1);
        advertisementRepository.addAdvertisement(ad1);

        // Get the advertisements
        ArrayList<Advertisement> advertisements = advertisementRepository.getAdvertisements();

        // Check if the returned advertisements match the added advertisements
        assertTrue(advertisements.contains(ad1));
    }

    @Test
    public void testGetAdvertisementsByID() {
        // Add test advertisements
        String name1 = "John Doe";
        String passportCardNumber1 = "123456789";
        String taxNumber1 = "123-45-6789";
        String emailAddress1 = "john.doe@example.com";
        String phoneNumber1 = "123-456-7890";
        int advertisementID1 = 1;
        double area1 = 100.0;
        double distanceFromCity1 = 10.0;
        String photograph1 = "property.jpg";
        String propertyType1 = "House";
        String requestType1 = "Sale";
        String date1 = "2023-06-13";
        double salePrice1 = 200000.0;

        Commission commission1 = new Commission(500.0, 10);
        Address address1 = new Address("123 Main St", "City", "State", "12345");
        Client client1 = new Client(name1, passportCardNumber1, taxNumber1, emailAddress1, phoneNumber1);
        Property property1 = new Property(area1, distanceFromCity1, photograph1, address1);
        OrganizationRole organizationRole1 = new OrganizationRole("Agent");
        Store store1 = new Store(address1, "12345", phoneNumber1, "Manager", "store@example.com");
        Employee employee1 = new Employee(name1, passportCardNumber1, taxNumber1, emailAddress1, phoneNumber1, organizationRole1, address1, store1);

        Advertisement ad1 = new Advertisement(employee1, client1, advertisementID1, property1, propertyType1, commission1, requestType1, date1, salePrice1);
        advertisementRepository.addAdvertisement(ad1);

        // Get advertisement by ID
        Advertisement foundAd = advertisementRepository.getAdvertisementsByID(advertisementID1);

        // Check if the found advertisement matches the added advertisement
        assertEquals(ad1, foundAd);
    }

    @Test
    public void testValidateAdvertisement() {
        // Add test advertisement
        String name1 = "John Doe";
        String passportCardNumber1 = "123456789";
        String taxNumber1 = "123-45-6789";
        String emailAddress1 = "john.doe@example.com";
        String phoneNumber1 = "123-456-7890";
        int advertisementID1 = 1;
        double area1 = 100.0;
        double distanceFromCity1 = 10.0;
        String photograph1 = "property.jpg";
        String propertyType1 = "House";
        String requestType1 = "Sale";
        String date1 = "2023-06-13";
        double salePrice1 = 200000.0;

        Commission commission1 = new Commission(500.0, 10);
        Address address1 = new Address("123 Main St", "City", "State", "12345");
        Client client1 = new Client(name1, passportCardNumber1, taxNumber1, emailAddress1, phoneNumber1);
        Property property1 = new Property(area1, distanceFromCity1, photograph1, address1);
        OrganizationRole organizationRole1 = new OrganizationRole("Agent");
        Store store1 = new Store(address1, "12345", phoneNumber1, "Manager", "store@example.com");
        Employee employee1 = new Employee(name1, passportCardNumber1, taxNumber1, emailAddress1, phoneNumber1, organizationRole1, address1, store1);

        Advertisement ad1 = new Advertisement(employee1, client1, advertisementID1, property1, propertyType1, commission1, requestType1, date1, salePrice1);
        advertisementRepository.addAdvertisement(ad1);

        // Validate the advertisement
        boolean isValid = advertisementRepository.validateAdvertisement(ad1);

        // Check if the advertisement is considered valid
        assertTrue(isValid);
    }

    @Test
    public void testAddAdvertisement() {
        // Add test advertisement
        String name1 = "John Doe";
        String passportCardNumber1 = "123456789";
        String taxNumber1 = "123-45-6789";
        String emailAddress1 = "john.doe@example.com";
        String phoneNumber1 = "123-456-7890";
        int advertisementID1 = 1;
        double area1 = 100.0;
        double distanceFromCity1 = 10.0;
        String photograph1 = "property.jpg";
        String propertyType1 = "House";
        String requestType1 = "Sale";
        String date1 = "2023-06-13";
        double salePrice1 = 200000.0;

        Commission commission1 = new Commission(500.0, 10);
        Address address1 = new Address("123 Main St", "City", "State", "12345");
        Client client1 = new Client(name1, passportCardNumber1, taxNumber1, emailAddress1, phoneNumber1);
        Property property1 = new Property(area1, distanceFromCity1, photograph1, address1);
        OrganizationRole organizationRole1 = new OrganizationRole("Agent");
        Store store1 = new Store(address1, "12345", phoneNumber1, "Manager", "store@example.com");
        Employee employee1 = new Employee(name1, passportCardNumber1, taxNumber1, emailAddress1, phoneNumber1, organizationRole1, address1, store1);

        Advertisement ad1 = new Advertisement(employee1, client1, advertisementID1, property1, propertyType1, commission1, requestType1, date1, salePrice1);

        // Add the advertisement
        boolean added = advertisementRepository.addAdvertisement(ad1);

        // Check if the advertisement is added successfully
        assertTrue(added);
    }

    @Test
    public void testCreateAdvertisement() {
        // Create test advertisement
        String name1 = "John Doe";
        String passportCardNumber1 = "123456789";
        String taxNumber1 = "123-45-6789";
        String emailAddress1 = "john.doe@example.com";
        String phoneNumber1 = "123-456-7890";
        double area1 = 100.0;
        double distanceFromCity1 = 10.0;
        String photograph1 = "property.jpg";
        String propertyType1 = "House";
        String requestType1 = "Sale";
        String date1 = "2023-06-13";
        double salePrice1 = 200000.0;

        Commission commission1 = new Commission(500.0, 10);
        Address address1 = new Address("123 Main St", "City", "State", "12345");
        Client client1 = new Client(name1, passportCardNumber1, taxNumber1, emailAddress1, phoneNumber1);
        Property property1 = new Property(area1, distanceFromCity1, photograph1, address1);
        OrganizationRole organizationRole1 = new OrganizationRole("Agent");
        Store store1 = new Store(address1, "12345", phoneNumber1, "Manager", "store@example.com");
        Employee employee1 = new Employee(name1, passportCardNumber1, taxNumber1, emailAddress1, phoneNumber1, organizationRole1, address1, store1);

        // Create the advertisement
        boolean created = advertisementRepository.createAdvertisement(employee1, client1, 1, property1, propertyType1, requestType1, commission1, date1, salePrice1);

        // Check if the advertisement is created successfully
        assertTrue(created);
    }

    @Test
    public void testCreateAdvertisementFromRequest() {
        // Create test advertisement request
        String emailAddress = "john.doe@example.com";
        Store store = new Store(new Address("123 Main St", "City", "State", "12345"), "12345", "123-456-7890", "Manager", "store@example.com");
        Employee agent = new Employee("John Doe", "123456789", "123-45-6789", "john.doe@example.com", "123-456-7890", new OrganizationRole("Agent"), new Address("123 Main St", "City", "State", "12345"), store);
        Property property = new Property(100.0, 10.0, "property.jpg", new Address("123 Main St", "City", "State", "12345"));
        String propertyType = "House";
        String requestType = "Sale";
        double requestedPrice = 200000.0;
        String date = "2023-06-13";

        AdvertisementRequestDTO advertisementRequest = new AdvertisementRequestDTO(emailAddress, store, agent, property, propertyType, requestType, requestedPrice, date);

        // Create the advertisement from the request
        boolean created = advertisementRepository.createAdvertisementFromRequest(advertisementRequest, 200000.0, new Commission(500.0, 10), "2023-06-13");

        // Check if the advertisement is created successfully
        assertTrue(created);
    }
    @Test
    public void testSoldAdvertisement() {
        // Add test advertisement
        String name1 = "John Doe";
        String passportCardNumber1 = "123456789";
        String taxNumber1 = "123-45-6789";
        String emailAddress1 = "john.doe@example.com";
        String phoneNumber1 = "123-456-7890";
        int advertisementID1 = 1;
        double area1 = 100.0;
        double distanceFromCity1 = 10.0;
        String photograph1 = "property.jpg";
        String propertyType1 = "House";
        String requestType1 = "Sale";
        String date1 = "2023-06-13";
        double salePrice1 = 200000.0;

        Commission commission1 = new Commission(500.0, 10);
        Address address1 = new Address("123 Main St", "City", "State", "12345");
        Client client1 = new Client(name1, passportCardNumber1, taxNumber1, emailAddress1, phoneNumber1);
        Property property1 = new Property(area1, distanceFromCity1, photograph1, address1);
        OrganizationRole organizationRole1 = new OrganizationRole("Agent");
        Store store1 = new Store(address1, "12345", phoneNumber1, "Manager", "store@example.com");
        Employee employee1 = new Employee(name1, passportCardNumber1, taxNumber1, emailAddress1, phoneNumber1, organizationRole1, address1, store1);

        Advertisement ad1 = new Advertisement(employee1, client1, advertisementID1, property1, propertyType1, commission1, requestType1, date1, salePrice1);
        advertisementRepository.addAdvertisement(ad1);

        // Mark the advertisement as sold
        // Assuming you have an existing Advertisement object called 'advertisement'
        advertisementRepository.soldAdvertisement(ad1);
        boolean isSold = "Sold".equals(ad1.getState());
    }



}

