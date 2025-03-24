package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.DTO.VisitRequestDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GnomeSortAlgorithmTest {

    @Test
    void testSortDTO() {
        // Create an instance of GnomeSortAlgorithm
        GnomeSortAlgorithm algorithm = new GnomeSortAlgorithm();

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
                new VisitRequestDTO(null, date1, startTime1, endTime1),
                new VisitRequestDTO(null, date3, startTime3, endTime3),
                new VisitRequestDTO(null, date2, startTime2, endTime2)
        );

        // Sort the list using the sortDTO() method
        ArrayList<VisitRequestDTO> sortedList = algorithm.sortDTO(new ArrayList<>(visitRequests));

        // Create a list with the expected sorted order
        List<VisitRequestDTO> expectedSortedList = Arrays.asList(
                new VisitRequestDTO(null, date3, startTime3, endTime3),
                new VisitRequestDTO(null, date2, startTime2, endTime2),
                new VisitRequestDTO(null, date1, startTime1, endTime1)
        );

        // Assert the sorted list
        Assertions.assertEquals(expectedSortedList, sortedList, "Sorted list should match the expected sorted order");
    }

    @Test
    void testSort() {
        // Create an instance of GnomeSortAlgorithm
        GnomeSortAlgorithm algorithm = new GnomeSortAlgorithm();

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

        // Create a list of VisitRequest objects
        List<VisitRequest> visitRequests = Arrays.asList(
                new VisitRequest(null, date1, startTime1, endTime1),
                new VisitRequest(null, date3, startTime3, endTime3),
                new VisitRequest(null, date2, startTime2, endTime2)
        );

        // Sort the list using the sort() method
        ArrayList<VisitRequest> sortedList = algorithm.sort(new ArrayList<>(visitRequests));

        // Create a list with the expected sorted order
        List<VisitRequest> expectedSortedList = Arrays.asList(
                new VisitRequest(null, date3, startTime3, endTime3),
                new VisitRequest(null, date2, startTime2, endTime2),
                new VisitRequest(null, date1, startTime1, endTime1)
        );

        // Assert the sorted list
        Assertions.assertEquals(expectedSortedList, sortedList, "Sorted list should match the expected sorted order");
    }
}