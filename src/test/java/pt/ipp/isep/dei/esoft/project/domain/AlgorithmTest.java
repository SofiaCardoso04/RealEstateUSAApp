package pt.ipp.isep.dei.esoft.project.domain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AlgorithmTest {

    @Test
    void testGnomeSortByPropertyArea() {
        // Create an instance of Algorithm
        Algorithm algorithm = new Algorithm();

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

        // Create an instance of Advertisement
        Advertisement advertisement1 = new Advertisement(employee, client, advertisementID, property, propertyType, commission1, requestType, date1, salePrice);

        // Create a list of PurchaseOrder objects
        List<PurchaseOrder> purchaseOrders = Arrays.asList(
                new PurchaseOrder(orderAmount, client, advertisement1),
                new PurchaseOrder(orderAmount, client, advertisement1),
                new PurchaseOrder(orderAmount, client, advertisement1)
        );

        // Sort the list using the gnomeSortByPropertyArea() method
        List<PurchaseOrder> sortedList = algorithm.gnomeSortByPropertyArea(new ArrayList<>(purchaseOrders), 1);

        // Create a list with the expected sorted order
        List<PurchaseOrder> expectedSortedList = Arrays.asList(
                new PurchaseOrder(orderAmount, client, advertisement1),
                new PurchaseOrder(orderAmount, client, advertisement1),
                new PurchaseOrder(orderAmount, client, advertisement1)
        );

        // Assert the sorted list
        Assertions.assertEquals(expectedSortedList, sortedList, "Sorted list should match the expected sorted order");
    }

    @Test
    void testBubbleSortByPropertyArea() {
        // Create an instance of Algorithm
        Algorithm algorithm = new Algorithm();

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

        // Create an instance of Advertisement
        Advertisement advertisement1 = new Advertisement(employee, client, advertisementID, property, propertyType, commission1, requestType, date1, salePrice);

        // Create a list of PurchaseOrder objects
        List<PurchaseOrder> purchaseOrders = Arrays.asList(
                new PurchaseOrder(orderAmount, client, advertisement1),
                new PurchaseOrder(orderAmount, client, advertisement1),
                new PurchaseOrder(orderAmount, client, advertisement1)
        );

        // Sort the list using the bubbleSortByPropertyArea() method
        List<PurchaseOrder> sortedList = algorithm.bubbleSortByPropertyArea(new ArrayList<>(purchaseOrders), 1);

        // Create a list with the expected sorted order
        List<PurchaseOrder> expectedSortedList = Arrays.asList(
                new PurchaseOrder(orderAmount, client, advertisement1),
                new PurchaseOrder(orderAmount, client, advertisement1),
                new PurchaseOrder(orderAmount, client, advertisement1)
        );

        // Assert the sorted list
        Assertions.assertEquals(expectedSortedList, sortedList, "Sorted list should match the expected sorted order");
    }

    // Add more test methods if needed
}