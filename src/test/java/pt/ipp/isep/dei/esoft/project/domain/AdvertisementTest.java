package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.DTO.AdvertisementRequestDTO;

class AdvertisementTest {

    @Test
    void testGetEmailAddress() {
        // Define the test data
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

        Commission commission1 = new Commission(500.0, 10);
        Address address = new Address("123 Main St", "City", "State", "12345");
        Client client = new Client(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        Property property = new Property(area, distanceFromCity, photograph, address);
        OrganizationRole organizationRole = new OrganizationRole("Agent");
        Store store = new Store(address, id, phoneNumber, designation, email);
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);
        Advertisement advertisement1 = new Advertisement(employee, client, advertisementID, property, propertyType, commission1, requestType, date1, salePrice);

        // Call the getEmailAddress method and assert the result
        Client actualEmailAddress = advertisement1.getEmailAddress();
        Assertions.assertEquals(client, actualEmailAddress, "Email address should match the expected value");
    }

    @Test
    void testGetAdvertisementID() {
        // Define the test data
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

        Commission commission1 = new Commission(500.0, 10);
        Address address = new Address("123 Main St", "City", "State", "12345");
        Client client = new Client(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        Property property = new Property(area, distanceFromCity, photograph, address);
        OrganizationRole organizationRole = new OrganizationRole("Agent");
        Store store = new Store(address, id, phoneNumber, designation, email);
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);
        Advertisement advertisement1 = new Advertisement(employee, client, advertisementID, property, propertyType, commission1, requestType, date1, salePrice);

        // Call the getAdvertisementID method and assert the result
        int actualAdvertisementID = advertisement1.getAdvertisementID();
        Assertions.assertEquals(advertisementID, actualAdvertisementID, "Advertisement ID should match the expected value");
    }

    @Test
    void testGetProperty() {
        // Define the test data
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

        Commission commission1 = new Commission(500.0, 10);
        Address address = new Address("123 Main St", "City", "State", "12345");
        Client client = new Client(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        Property property = new Property(area, distanceFromCity, photograph, address);
        OrganizationRole organizationRole = new OrganizationRole("Agent");
        Store store = new Store(address, id, phoneNumber, designation, email);
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);
        Advertisement advertisement1 = new Advertisement(employee, client, advertisementID, property, propertyType, commission1, requestType, date1, salePrice);

        // Call the getProperty method and assert the result
        Property actualProperty = advertisement1.getProperty();
        Assertions.assertEquals(property, actualProperty, "Property should match the expected value");
    }

    @Test
    void testGetPropertyType() {
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

        Commission commission1 = new Commission(500.0, 10);
        Address address = new Address("123 Main St", "City", "State", "12345");
        Client client = new Client(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        Property property = new Property(area, distanceFromCity, photograph, address);
        OrganizationRole organizationRole = new OrganizationRole("Agent");
        Store store = new Store(address, id, phoneNumber, designation, email);
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);
        Advertisement advertisement1 = new Advertisement(employee, client, advertisementID, property, propertyType, commission1, requestType, date1, salePrice);

        // Call the getPropertyType method and assert the result
        String actualPropertyType = advertisement1.getPropertyType();
        Assertions.assertEquals(propertyType, actualPropertyType, "Property type should match the expected value");
    }

    @Test
    void testGetRequestType() {
        // Define the test data
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

        Commission commission1 = new Commission(500.0, 10);
        Address address = new Address("123 Main St", "City", "State", "12345");
        Client client = new Client(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        Property property = new Property(area, distanceFromCity, photograph, address);
        OrganizationRole organizationRole = new OrganizationRole("Agent");
        Store store = new Store(address, id, phoneNumber, designation, email);
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);
        Advertisement advertisement1 = new Advertisement(employee, client, advertisementID, property, propertyType, commission1, requestType, date1, salePrice);

        // Call the getRequestType method and assert the result
        String actualRequestType = advertisement1.getRequestType();
        Assertions.assertEquals(requestType, actualRequestType, "Request type should match the expected value");
    }

    @Test
    void testGetCommission() {
        // Define the test data
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

        Commission commission1 = new Commission(500.0, 10);
        Address address = new Address("123 Main St", "City", "State", "12345");
        Client client = new Client(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        Property property = new Property(area, distanceFromCity, photograph, address);
        OrganizationRole organizationRole = new OrganizationRole("Agent");
        Store store = new Store(address, id, phoneNumber, designation, email);
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);
        Advertisement advertisement1 = new Advertisement(employee, client, advertisementID, property, propertyType, commission1, requestType, date1, salePrice);

        // Call the getCommission method and assert the result
        Commission actualCommission = advertisement1.getCommission();
        Assertions.assertEquals(commission1, actualCommission, "Commission should match the expected value");
    }

    @Test
    void testGetDate() {
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

        Commission commission1 = new Commission(500.0, 10);
        Address address = new Address("123 Main St", "City", "State", "12345");
        Client client = new Client(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        Property property = new Property(area, distanceFromCity, photograph, address);
        OrganizationRole organizationRole = new OrganizationRole("Agent");
        Store store = new Store(address, id, phoneNumber, designation, email);
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);
        Advertisement advertisement1 = new Advertisement(employee, client, advertisementID, property, propertyType, commission1, requestType, date1, salePrice);


        // Call the getDate method and assert the result
        String actualDate = advertisement1.getDate();
        Assertions.assertEquals(date1, actualDate, "Date should match the expected value");
    }

    @Test
    void testGetSalePrice() {
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

        Commission commission1 = new Commission(500.0, 10);
        Address address = new Address("123 Main St", "City", "State", "12345");
        Client client = new Client(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        Property property = new Property(area, distanceFromCity, photograph, address);
        OrganizationRole organizationRole = new OrganizationRole("Agent");
        Store store = new Store(address, id, phoneNumber, designation, email);
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);
        Advertisement advertisement1 = new Advertisement(employee, client, advertisementID, property, propertyType, commission1, requestType, date1, salePrice);

        // Call the getSalePrice method and assert the result
        double actualSalePrice = advertisement1.getSalePrice();
        Assertions.assertEquals(salePrice, actualSalePrice, 0.001, "Sale price should match the expected value");
    }

    @Test
    void testConstructorWithEmailAddress() {
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

        Commission commission1 = new Commission(500.0, 10);
        Address address = new Address("123 Main St", "City", "State", "12345");
        Client client = new Client(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        Property property = new Property(area, distanceFromCity, photograph, address);
        OrganizationRole organizationRole = new OrganizationRole("Agent");
        Store store = new Store(address, id, phoneNumber, designation, email);
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);

        Advertisement advertisement = new Advertisement(client, advertisementID, property, propertyType, requestType, commission1, date1, salePrice);


        // Assert the property values using the getter methods
        Assertions.assertEquals(client, advertisement.getEmailAddress(), "Email address should match the expected value");
        Assertions.assertEquals(advertisementID, advertisement.getAdvertisementID(), "Advertisement ID should match the expected value");
        Assertions.assertEquals(property, advertisement.getProperty(), "Property should match the expected value");
        Assertions.assertEquals(propertyType, advertisement.getPropertyType(), "Property type should match the expected value");
        Assertions.assertEquals(requestType, advertisement.getRequestType(), "Request type should match the expected value");
        Assertions.assertEquals(commission1, advertisement.getCommission(), "Commission should match the expected value");
        Assertions.assertEquals(date1, advertisement.getDate(), "Date should match the expected value");
        Assertions.assertEquals(salePrice, advertisement.getSalePrice(), 0.001, "Sale price should match the expected value");
    }

    @Test
    void testConstructorWithAgent() {
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

        Commission commission1 = new Commission(500.0, 10);
        Address address = new Address("123 Main St", "City", "State", "12345");
        Client client = new Client(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        Property property = new Property(area, distanceFromCity, photograph, address);
        OrganizationRole organizationRole = new OrganizationRole("Agent");
        Store store = new Store(address, id, phoneNumber, designation, email);
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);


        // Create an instance of Advertisement
        Advertisement advertisement = new Advertisement(employee, client, advertisementID, property, propertyType, commission1, requestType, date1, salePrice);

        // Assert the property values using the getter methods
        Assertions.assertEquals(employee, advertisement.getAgent(), "Agent should match the expected value");
        Assertions.assertEquals(client, advertisement.getEmailAddress(), "Email address should match the expected value");
        Assertions.assertEquals(advertisementID, advertisement.getAdvertisementID(), "Advertisement ID should match the expected value");
        Assertions.assertEquals(property, advertisement.getProperty(), "Property should match the expected value");
        Assertions.assertEquals(propertyType, advertisement.getPropertyType(), "Property type should match the expected value");
        Assertions.assertEquals(requestType, advertisement.getRequestType(), "Request type should match the expected value");
        Assertions.assertEquals(commission1, advertisement.getCommission(), "Commission should match the expected value");
        Assertions.assertEquals(date1, advertisement.getDate(), "Date should match the expected value");
        Assertions.assertEquals(salePrice, advertisement.getSalePrice(), 0.001, "Sale price should match the expected value");
    }

   /* @Test
    void testConstructorWithOwner() {
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

        Commission commission1 = new Commission(500.0, 10);
        Address address = new Address("123 Main St", "City", "State", "12345");
        Client client = new Client(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        Property property = new Property(area, distanceFromCity, photograph, address);
        OrganizationRole organizationRole = new OrganizationRole("Agent");
        Store store = new Store(address, id, phoneNumber, designation, email);
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);

        // Create an instance of Advertisement
        Advertisement advertisement = new Advertisement(client, employee, store, property, propertyType, requestType, commission1, date1);

        // Assert the property values using the getter methods
        Assertions.assertEquals(client, advertisement.getEmailAddress(), "Owner should match the expected value");
        Assertions.assertEquals(employee, advertisement.getAgent(), "Agent should match the expected value");
        Assertions.assertEquals(property, advertisement.getProperty(), "Property should match the expected value");
        Assertions.assertEquals(propertyType, advertisement.getPropertyType(), "Property type should match the expected value");
        Assertions.assertEquals(requestType, advertisement.getRequestType(), "Request type should match the expected value");
        Assertions.assertEquals(commission1, advertisement.getCommission(), "Commission 2 should match the expected value");
        Assertions.assertEquals(date1, advertisement.getDate(), "Date should match the expected value");
    } */

    @Test
    void testConstructorWithAdvertisementRequest() {

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
        String propertyType = "House";
        String requestType = "Sale";
        String date1 = "2023-06-13";
        double requestedPrice = 200000.0;

        Address address = new Address("123 Main St", "City", "State", "12345");
        Property property = new Property(area, distanceFromCity, photograph, address);
        OrganizationRole organizationRole = new OrganizationRole("Agent");
        Store store = new Store(address, id, phoneNumber, designation, email);
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);


        AdvertisementRequestDTO advertisementRequest = new AdvertisementRequestDTO(emailAddress, store, employee, property, propertyType, requestType, requestedPrice, date1);
        Commission commission = new Commission();
        double salePrice = 100000.0;
        String date = "2023-06-13";

        // Create an instance of Advertisement
        Advertisement advertisement = new Advertisement(advertisementRequest, commission, salePrice, date);

        // Assert the property values using the getter methods
        Assertions.assertEquals(advertisementRequest, advertisement.getAdvertisementRequest(), "Advertisement request should match the expected value");
        Assertions.assertEquals(commission, advertisement.getCommission(), "Commission should match the expected value");
        Assertions.assertEquals(salePrice, advertisement.getSalePrice(), 0.001, "Sale price should match the expected value");
        Assertions.assertEquals(date, advertisement.getDate(), "Date should match the expected value");
    }

    @Test
    void testSoldAdvertisement() {
        // Create an instance of Advertisement
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

        Commission commission1 = new Commission(500.0, 10);
        Address address = new Address("123 Main St", "City", "State", "12345");
        Client client = new Client(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        Property property = new Property(area, distanceFromCity, photograph, address);
        OrganizationRole organizationRole = new OrganizationRole("Agent");
        Store store = new Store(address, id, phoneNumber, designation, email);
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);
        Advertisement advertisement1 = new Advertisement(employee, client, advertisementID, property, propertyType, commission1, requestType, date1, salePrice);


        // Call the soldAdvertisement() method
        advertisement1.soldAdvertisement();

        // Assert the state after calling the method
        Assertions.assertEquals("Sold", advertisement1.getState(), "State should be set to 'Sold'");
        Assertions.assertEquals(Advertisement.getCurrentDate(), advertisement1.getDate(), "Date should be set to the current date");
    }

    @Test
    void testSetState() {
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

        Commission commission1 = new Commission(500.0, 10);
        Address address = new Address("123 Main St", "City", "State", "12345");
        Client client = new Client(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        Property property = new Property(area, distanceFromCity, photograph, address);
        OrganizationRole organizationRole = new OrganizationRole("Agent");
        Store store = new Store(address, id, phoneNumber, designation, email);
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);
        Advertisement advertisement1 = new Advertisement(employee, client, advertisementID, property, propertyType, commission1, requestType, date1, salePrice);


        // Set the state using the setter method
        advertisement1.setState("Sold");

        // Assert the updated state
        Assertions.assertEquals("Sold", advertisement1.getState(), "State should be set to 'Sold'");
    }

    @Test
    void testToString() {
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

        Commission commission1 = new Commission(500.0, 10);
        Address address = new Address("123 Main St", "City", "State", "12345");
        Client client = new Client(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        Property property = new Property(area, distanceFromCity, photograph, address);
        OrganizationRole organizationRole = new OrganizationRole("Agent");
        Store store = new Store(address, id, phoneNumber, designation, email);
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);

        // Create an instance of Advertisement
        Advertisement advertisement1 = new Advertisement(employee, client, advertisementID, property, propertyType, commission1, requestType, date1, salePrice);

        // Get the string representation using the toString() method
        String advertisementString = advertisement1.toString();

        // Assert the expected string representation
        String expectedString = "Property:Area: 100.0 | Distance From City: 10.0 | Photograph: property.jpg | Address: District name: State | City name: City | Street name: 123 Main St | Zip Code: 12345 | Property Type: House | Request Type: Sale | Date: 2023-06-13\n";
        Assertions.assertEquals(expectedString, advertisementString, "String representation should match the expected value");
    }



    // Add more test methods for the remaining getters if needed
}






