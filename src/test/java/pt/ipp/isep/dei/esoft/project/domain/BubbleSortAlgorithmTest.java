package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.DTO.AdvertisementDTO;
import pt.ipp.isep.dei.esoft.project.DTO.ClientDTO;
import pt.ipp.isep.dei.esoft.project.DTO.VisitRequestDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BubbleSortAlgorithmTest {

    @Test
    void testSortDTO() {
        // Create an instance of BubbleSortAlgorithm
        BubbleSortAlgorithm algorithm = new BubbleSortAlgorithm();


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
        ClientDTO client = new ClientDTO(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        Property property = new Property(area, distanceFromCity, photograph, address);
        OrganizationRole organizationRole = new OrganizationRole("Agent");
        Store store = new Store(address, id, phoneNumber, designation, email);
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);

        AdvertisementDTO advertisement1 = new AdvertisementDTO(employee, client, advertisementID, property, propertyType, requestType, date, salePrice, commission1);

        // Create sample data for testing
        LocalDate date1 = LocalDate.of(2023, 6, 13);
        LocalTime startTime1 = LocalTime.of(9, 0);
        LocalTime endTime1 = LocalTime.of(10, 0);

        LocalDate date2 = LocalDate.of(2023, 6, 14);
        LocalTime startTime2 = LocalTime.of(9, 0);
        LocalTime endTime2 = LocalTime.of(10, 0);

        LocalDate date3 = LocalDate.of(2023, 6, 15);
        LocalTime startTime3 = LocalTime.of(9, 0);
        LocalTime endTime3 = LocalTime.of(10, 0);

        // Create a list of VisitRequestDTO objects
        List<VisitRequestDTO> visitRequests = Arrays.asList(
                new VisitRequestDTO(advertisement1, date1, startTime1, endTime1),
                new VisitRequestDTO(advertisement1, date2, startTime2, endTime2),
                new VisitRequestDTO(advertisement1, date3, startTime3, endTime3)
        );

        // Sort the list using the sortDTO() method
        ArrayList<VisitRequestDTO> sortedList = algorithm.sortDTO(new ArrayList<>(visitRequests));

        // Create a list with the expected sorted order
        List<VisitRequestDTO> expectedSortedList = Arrays.asList(
                new VisitRequestDTO(advertisement1, date3, startTime3, endTime3),
                new VisitRequestDTO(advertisement1, date2, startTime2, endTime2),
                new VisitRequestDTO(advertisement1, date1, startTime1, endTime1)
        );

        // Assert the sorted list
        Assertions.assertEquals(expectedSortedList, sortedList, "Sorted list should match the expected sorted order");
    }

    @Test
    void testSort() {
        // Create an instance of BubbleSortAlgorithm
        BubbleSortAlgorithm algorithm = new BubbleSortAlgorithm();


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

        // Create sample data for testing
        LocalDate date1 = LocalDate.of(2023, 6, 13);
        LocalTime startTime1 = LocalTime.of(9, 0);
        LocalTime endTime1 = LocalTime.of(10, 0);

        LocalDate date2 = LocalDate.of(2023, 6, 14);
        LocalTime startTime2 = LocalTime.of(9, 0);
        LocalTime endTime2 = LocalTime.of(10, 0);

        LocalDate date3 = LocalDate.of(2023, 6, 15);
        LocalTime startTime3 = LocalTime.of(9, 0);
        LocalTime endTime3 = LocalTime.of(10, 0);

        // Create a list of VisitRequestDTO objects
        List<VisitRequest> visitRequests = Arrays.asList(
                new VisitRequest(advertisement1, date1, startTime1, endTime1),
                new VisitRequest(advertisement1, date2, startTime2, endTime2),
                new VisitRequest(advertisement1, date3, startTime3, endTime3)
        );

        // Sort the list using the sortDTO() method
        ArrayList<VisitRequest> sortedList = algorithm.sort(new ArrayList<>(visitRequests));

        // Create a list with the expected sorted order
        List<VisitRequest> expectedSortedList = Arrays.asList(
                new VisitRequest(advertisement1, date3, startTime3, endTime3),
                new VisitRequest(advertisement1, date2, startTime2, endTime2),
                new VisitRequest(advertisement1, date1, startTime1, endTime1)
        );

        // Assert the sorted list
        Assertions.assertEquals(expectedSortedList, sortedList, "Sorted list should match the expected sorted order");
    }
}

