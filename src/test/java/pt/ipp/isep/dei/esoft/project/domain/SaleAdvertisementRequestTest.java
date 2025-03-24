package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SaleAdvertisementRequestTest {

    @Test
    void testGetTotalPrice() {
        // Define the test data

        double area = 100.0;
        double distanceFromCity = 10.0;
        String photograph = "property.jpg";
        String name = "John Doe";
        String passportCardNumber = "123456789";
        String taxNumber = "123-45-6789";
        String emailAddress = "john.doe@example.com";
        String phoneNumber = "123-456-7890";
        String designation = "Lojinha";
        String id  = "12345";

        OrganizationRole organizationRole = new OrganizationRole("Agent");
        Address address = new Address("123 Main St", "City", "State", "12345");
        Store store = new Store(address, id, phoneNumber, designation, emailAddress);
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);
        Property property = new Property(area, distanceFromCity, photograph, address);



        String propertyType = "Type 1";
        String requestType = "Request Type 1";
        String date = "2023-06-13";
        double requestedPrice = 1000.0;
        int totalPrice = 50000;

        // Create an instance of SaleAdvertisementRequest
        SaleAdvertisementRequest saleRequest = new SaleAdvertisementRequest(emailAddress, store, employee, property, propertyType, requestType, date, requestedPrice, totalPrice);

        // Call the getTotalPrice method and assert the result
        int actualTotalPrice = saleRequest.getTotalPrice();
        Assertions.assertEquals(totalPrice, actualTotalPrice, "Total price should match the expected value");
    }
}
