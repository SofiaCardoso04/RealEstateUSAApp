package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.Adapters.SortingAdapter;
import pt.ipp.isep.dei.esoft.project.DTO.AdvertisementDTO;
import pt.ipp.isep.dei.esoft.project.DTO.VisitRequestDTO;
import pt.ipp.isep.dei.esoft.project.application.controller.BookingListController;
import pt.ipp.isep.dei.esoft.project.application.controller.ManageBookingRequestController;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * User interface class for the booking list.
 */
public class BookingListUI implements Runnable {

    Scanner sc = new Scanner(System.in);

    private final BookingListController controller = new BookingListController();
    private final ManageBookingRequestController controller2 = new ManageBookingRequestController();

    /**
     * Runs the booking list user interface.
     */
    @Override
    public void run() {
        try {
            controller.getSortingMethods();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<VisitRequestDTO> list = controller.getVisitsDTOs();

        String sortingAlgorithmClassName = "pt.ipp.isep.dei.esoft.project.domain.BubbleSortAlgorithm";
        SortingAdapter adapter = new SortingAdapter(sortingAlgorithmClassName);
        ArrayList<VisitRequestDTO> sortedVisitRequests = adapter.sortDTO(list);

        System.out.println();
        if (!sortedVisitRequests.isEmpty()) {
            LocalDate beginDate = beginDate();
            LocalDate endDate = endDate();
            controller.showFilteredBookingRequests(beginDate, endDate, sortedVisitRequests);
        } else {
            System.out.println("Currently there are no booking requests");
        }

        boolean option = Utils.confirm("Do you want to respond to booking requests? (Yes/No)");
        if (option) {
            System.out.println("These are your booking requests, please select the one you want to respond:");
            controller.showBookingRequests(sortedVisitRequests);

            int selectedBookingIndex = SelectedBookingIndex(list); // Get the selected booking index from user input
            if (selectedBookingIndex >= 0 && selectedBookingIndex < sortedVisitRequests.size()) {

                String typedResponse = TypedResponse(); // Get the typed response from user input
                VisitRequestDTO visitRequestDTO = sortedVisitRequests.get(selectedBookingIndex);
                controller2.respondBookingRequest(typedResponse, visitRequestDTO);
                System.out.println();
            } else {
                System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    /**
     * Reads the selected booking index from user input.
     *
     * @param list The list of visit request DTOs.
     * @return The selected booking index adjusted for zero-based index.
     */
    private int SelectedBookingIndex(ArrayList<VisitRequestDTO> list) {
        System.out.print("Enter the index of the booking request: ");
        int index = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        return index - 1; // Adjust the index to match the ArrayList's zero-based index
    }

    /**
     * Reads the typed response from user input.
     *
     * @return The typed response.
     */
    private String TypedResponse() {
        System.out.print("Enter your response: ");
        return sc.nextLine();
    }

    /**
     * Reads the begin date from user input.
     *
     * @return The begin date.
     */
    private LocalDate beginDate() {
        System.out.println("Begin date: ");
        String date = sc.nextLine();
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

    /**
     * Reads the end date from user input.
     *
     * @return The end date.
     */
    private LocalDate endDate() {
        System.out.println("End date: ");
        String date = sc.nextLine();
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
}
