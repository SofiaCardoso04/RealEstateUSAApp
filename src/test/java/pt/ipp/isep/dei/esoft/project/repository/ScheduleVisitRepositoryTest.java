package pt.ipp.isep.dei.esoft.project.repository;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.*;
import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;
public class ScheduleVisitRepositoryTest {

    @Test
    void testAddVisit() {
        ScheduleVisitRepository repository = new ScheduleVisitRepository();

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
        String date = "2023-06-13";
        double salePrice = 200000.0;

        Commission commission1 = new Commission(500.0, 10);
        Address address = new Address("123 Main St", "City", "State", "12345");
        Client client = new Client(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        Property property = new Property(area, distanceFromCity, photograph, address);
        OrganizationRole organizationRole = new OrganizationRole("Agent");
        Store store = new Store(address, id, phoneNumber, designation, email);
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);
        Advertisement advertisement1 = new Advertisement(employee, client, advertisementID, property, propertyType, commission1, requestType, date, salePrice);

        LocalDate dateRequest = LocalDate.now();
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(10, 0);
        VisitRequest visit = new VisitRequest(advertisement1, dateRequest, startTime, endTime);

        // Test adding visits
        assertTrue(repository.addVisit(visit), "Should add visit successfully");
        assertFalse(repository.addVisit(visit), "Should not add visit twice");
    }

    @Test
    void testCreateVisit() {
        ScheduleVisitRepository repository = new ScheduleVisitRepository();

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
        String date = "2023-06-13";
        double salePrice = 200000.0;

        Commission commission1 = new Commission(500.0, 10);
        Address address = new Address("123 Main St", "City", "State", "12345");
        Client client = new Client(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        Property property = new Property(area, distanceFromCity, photograph, address);
        OrganizationRole organizationRole = new OrganizationRole("Agent");
        Store store = new Store(address, id, phoneNumber, designation, email);
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);
        Advertisement advertisement1 = new Advertisement(employee, client, advertisementID, property, propertyType, commission1, requestType, date, salePrice);

        LocalDate dateRequest = LocalDate.now();
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(10, 0);

        // Test creating visits
        assertTrue(repository.createVisit(advertisement1, dateRequest, startTime, endTime), "Should create visit successfully");
    }

    @Test
    void testGetVisitsList() {
        ScheduleVisitRepository repository = new ScheduleVisitRepository();

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
        String date = "2023-06-13";
        double salePrice = 200000.0;

        Commission commission1 = new Commission(500.0, 10);
        Address address = new Address("123 Main St", "City", "State", "12345");
        Client client = new Client(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        Property property = new Property(area, distanceFromCity, photograph, address);
        OrganizationRole organizationRole = new OrganizationRole("Agent");
        Store store = new Store(address, id, phoneNumber, designation, email);
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);
        Advertisement advertisement1 = new Advertisement(employee, client, advertisementID, property, propertyType, commission1, requestType, date, salePrice);

        LocalDate dateRequest = LocalDate.now();
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(10, 0);
        VisitRequest visit = new VisitRequest(advertisement1, dateRequest, startTime, endTime);

        // Test getting visits list
        repository.addVisit(visit);
        assertEquals(1, repository.getVisitsList().size(), "Visits list count should be 1");
    }

    @Test
    void testGetVisitsScheduleByDate() {
        ScheduleVisitRepository repository = new ScheduleVisitRepository();

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

        LocalDate dateRequest1 = LocalDate.parse(date1);
        LocalTime startTime1 = LocalTime.of(9, 0);
        LocalTime endTime1 = LocalTime.of(10, 0);
        VisitRequest visit1 = new VisitRequest(advertisement1, dateRequest1, startTime1, endTime1);

        String date2 = "2023-06-14";
        LocalDate dateRequest2 = LocalDate.parse(date2);
        LocalTime startTime2 = LocalTime.of(10, 0);
        LocalTime endTime2 = LocalTime.of(11, 0);
        VisitRequest visit2 = new VisitRequest(advertisement1, dateRequest2, startTime2, endTime2);

        // Test getting visits schedule by date
        repository.addVisit(visit1);
        repository.addVisit(visit2);

        assertEquals(1, repository.getVisitsScheduleByDate(dateRequest1).size(), "Visits schedule count should be 1 for date1");
        assertEquals(1, repository.getVisitsScheduleByDate(dateRequest2).size(), "Visits schedule count should be 1 for date2");
        assertEquals(0, repository.getVisitsScheduleByDate(LocalDate.now()).size(), "Visits schedule count should be 1 for today's date");
    }

}