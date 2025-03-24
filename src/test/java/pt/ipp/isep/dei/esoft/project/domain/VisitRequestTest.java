package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.ENUMS.VisitRequestStatus;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class VisitRequestTest {

    @Test
    void testIsOverlapping() {
        // Create sample data for testing
        LocalDate date = LocalDate.of(2023, 6, 13);
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(10, 0);

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



        VisitRequest visitRequest = new VisitRequest(advertisement1, date, startTime, endTime);

        // Test overlapping scenarios
        LocalTime overlappingStartTime = LocalTime.of(9, 30);
        LocalTime overlappingEndTime = LocalTime.of(10, 30);
        assertTrue(visitRequest.isOverlapping(overlappingStartTime, overlappingEndTime), "Should detect overlapping when start and end times are within visit's start and end times");

        overlappingStartTime = LocalTime.of(8, 30);
        overlappingEndTime = LocalTime.of(9, 30);
        assertTrue(visitRequest.isOverlapping(overlappingStartTime, overlappingEndTime), "Should detect overlapping when start time is before visit's start time and end time is within visit's start and end times");

        overlappingStartTime = LocalTime.of(9, 30);
        overlappingEndTime = LocalTime.of(10, 30);
        assertTrue(visitRequest.isOverlapping(overlappingStartTime, overlappingEndTime), "Should detect overlapping when start time is within visit's start and end times and end time is after visit's end time");

        overlappingStartTime = LocalTime.of(8, 30);
        overlappingEndTime = LocalTime.of(10, 30);
        assertTrue(visitRequest.isOverlapping(overlappingStartTime, overlappingEndTime), "Should detect overlapping when start and end times are before and after visit's start and end times");

        overlappingStartTime = LocalTime.of(9, 0);
        overlappingEndTime = LocalTime.of(10, 0);
        assertTrue(visitRequest.isOverlapping(overlappingStartTime, overlappingEndTime), "Should detect overlapping when start and end times are the same as visit's start and end times");

        // Test non-overlapping scenarios
        LocalTime nonOverlappingStartTime = LocalTime.of(8, 0);
        LocalTime nonOverlappingEndTime = LocalTime.of(8, 30);
        assertTrue(visitRequest.isOverlapping(nonOverlappingStartTime, nonOverlappingEndTime), "Should not detect overlapping when start and end times are before visit's start time");

        nonOverlappingStartTime = LocalTime.of(10, 0);
        nonOverlappingEndTime = LocalTime.of(11, 0);
        assertTrue(visitRequest.isOverlapping(nonOverlappingStartTime, nonOverlappingEndTime), "Should not detect overlapping when start and end times are after visit's end time");
    }

    @Test
    void testToString() {
        // Create sample data for testing
        LocalDate date = LocalDate.of(2023, 6, 13);
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(10, 0);



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


        VisitRequest visitRequest = new VisitRequest(advertisement1, date, startTime, endTime);

        // Test toString method
        String expectedString = "Visit Request:\n" +
                "Advertisement: " + advertisement1 + "\n" +
                "Date: " + date + "\n" +
                "Start Time: " + startTime + "\n" +
                "End Time: " + endTime + "\n" +
                "Status: PENDING\n";

        assertEquals(expectedString, visitRequest.toString(), "Incorrect string representation of VisitRequest");
    }
    @Test
    void testGetters() {
        // Create sample data for testing
        LocalDate date = LocalDate.of(2023, 6, 13);
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(10, 0);
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


        VisitRequest visitRequest = new VisitRequest(advertisement1, date, startTime, endTime);

        // Test getters
        assertEquals(advertisement1, visitRequest.getAdvertisement(), "Incorrect Advertisement");
        assertEquals(date, visitRequest.getDate(), "Incorrect Date");
        assertEquals(startTime, visitRequest.getStartTime(), "Incorrect Start Time");
        assertEquals(endTime, visitRequest.getEndTime(), "Incorrect End Time");
        assertEquals(VisitRequestStatus.PENDING, visitRequest.getStatus(), "Incorrect Status");
    }
    @Test
    void testSetStatus() {
        LocalDate date = LocalDate.of(2023, 6, 13);
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(10, 0);

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

        VisitRequest visitRequest = new VisitRequest(advertisement1, date, startTime, endTime);

        visitRequest.setStatus(VisitRequestStatus.RESPONDED);
        assertEquals(VisitRequestStatus.RESPONDED, visitRequest.getStatus(), "Status mismatch");
    }


    @Test
    void testEquals() {
        LocalDate date11 = LocalDate.of(2023, 6, 13);
        LocalTime startTime1 = LocalTime.of(9, 0);
        LocalTime endTime1 = LocalTime.of(10, 0);
        VisitRequestStatus status1 = VisitRequestStatus.PENDING;

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

        VisitRequest visitRequest = new VisitRequest(advertisement1, date11, startTime1, endTime1);






        VisitRequestStatus status2 = VisitRequestStatus.PENDING;
        String name2 = "Jane Smith";
        String passportCardNumber2 = "987654321";
        String taxNumber2 = "987-65-4321";
        String emailAddress2 = "jane.smith@example.com";
        String phoneNumber2 = "987-654-3210";
        int advertisementID2 = 2;
        double area2 = 150.0;
        double distanceFromCity2 = 15.0;
        String photograph2 = "property2.jpg";
        String id2 = "54321";
        String designation2 = "Sales Representative";
        String email2 = "sales@example.com";
        String propertyType2 = "Apartment";
        String requestType2 = "Rent";
        String date2 = "2023-06-15";
        double salePrice2 = 300000.0;

        Commission commission2 = new Commission(750.0, 12);
        Address address2 = new Address("456 Elm St", "City", "State", "54321");
        Client client2 = new Client(name2, passportCardNumber2, taxNumber2, emailAddress2, phoneNumber2);
        Property property2 = new Property(area2, distanceFromCity2, photograph2, address2);
        OrganizationRole organizationRole2 = new OrganizationRole("Agent");
        Store store2 = new Store(address2, id2, phoneNumber2, designation2, email2);
        Employee employee2 = new Employee(name2, passportCardNumber2, taxNumber2, emailAddress2, phoneNumber2, organizationRole2, address2, store2);
        Advertisement advertisement2 = new Advertisement(employee2, client2, advertisementID2, property2, propertyType2, commission2, requestType2, date2, salePrice2);

        LocalDate date = LocalDate.of(2023, 6, 18);
        LocalTime startTime2 = LocalTime.of(14, 0);
        LocalTime endTime2 = LocalTime.of(15, 0);

        VisitRequest visitRequest2 = new VisitRequest(advertisement2, date, startTime2, endTime2);

        assertNotEquals(visitRequest, visitRequest2, "Visit requests should be equal");

        // Modify visitRequest2 and check equality again
        visitRequest2.setStatus(VisitRequestStatus.RESPONDED);
        assertNotEquals(visitRequest, visitRequest2, "Visit requests should not be equal after modifying status");


    }

    @Test
    void testHashCode() {
        LocalDate date11 = LocalDate.of(2023, 6, 13);
        LocalTime startTime1 = LocalTime.of(9, 0);
        LocalTime endTime1 = LocalTime.of(10, 0);
        VisitRequestStatus status1 = VisitRequestStatus.PENDING;

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

        VisitRequest visitRequest = new VisitRequest(advertisement1, date11, startTime1, endTime1);


        LocalDate date2 = LocalDate.of(2023, 6, 13);
        LocalTime startTime2 = LocalTime.of(9, 0);
        LocalTime endTime2 = LocalTime.of(10, 0);
        VisitRequestStatus status2 = VisitRequestStatus.PENDING;

        String name2 = "Jane Smith";
        String passportCardNumber2 = "987654321";
        String taxNumber2 = "987-65-4321";
        String emailAddress2 = "jane.smith@example.com";
        String phoneNumber2 = "987-654-3210";
        int advertisementID2 = 2;
        double area2 = 150.0;
        double distanceFromCity2 = 15.0;
        String photograph2 = "property2.jpg";
        String id2 = "54321";
        String designation2 = "Sales Representative";
        String email2 = "sales@example.com";
        String propertyType2 = "Apartment";
        String requestType2 = "Rent";
        String date = "2023-06-15";
        double salePrice2 = 300000.0;

        Commission commission2 = new Commission(750.0, 12);
        Address address2 = new Address("456 Elm St", "City", "State", "54321");
        Client client2 = new Client(name2, passportCardNumber2, taxNumber2, emailAddress2, phoneNumber2);
        Property property2 = new Property(area2, distanceFromCity2, photograph2, address2);
        OrganizationRole organizationRole2 = new OrganizationRole("Agent");
        Store store2 = new Store(address2, id2, phoneNumber2, designation2, email2);
        Employee employee2 = new Employee(name2, passportCardNumber2, taxNumber2, emailAddress2, phoneNumber2, organizationRole2, address2, store2);
        Advertisement advertisement2 = new Advertisement(employee2, client2, advertisementID2, property2, propertyType2, commission2, requestType2, date, salePrice2);

        VisitRequest visitRequest2 = new VisitRequest(advertisement2, date2, startTime2, endTime2);


        assertNotEquals(visitRequest.hashCode(), visitRequest2.hashCode(), "Hash codes should be equal");

        // Modify visitRequest2 and check hash code again
        visitRequest2.setStatus(VisitRequestStatus.RESPONDED);
        assertNotEquals(visitRequest.hashCode(), visitRequest2.hashCode(), "Hash codes should not be equal after modifying status");

    }


}
