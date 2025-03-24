package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.DTO.VisitRequestDTO;
import pt.ipp.isep.dei.esoft.project.INTERFACES.SortingAlgorithm;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a bubble sort algorithm for sorting visit request data.
 */
public class BubbleSortAlgorithm implements SortingAlgorithm, Serializable {

    /**
     * Sorts a list of VisitRequestDTO objects using the bubble sort algorithm.
     *
     * @param listVisits the list of VisitRequestDTO objects to be sorted
     * @return the sorted list of VisitRequestDTO objects
     */
    @Override
    public ArrayList<VisitRequestDTO> sortDTO(ArrayList<VisitRequestDTO> listVisits) {
        int n = listVisits.size();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (listVisits.get(j - 1).getDate().isBefore(listVisits.get(j).getDate())) {
                    VisitRequestDTO temp = listVisits.get(j - 1);
                    listVisits.set(j - 1, listVisits.get(j));
                    listVisits.set(j, temp);
                }
            }
        }
        return listVisits;
    }

    /**
     * Sorts a list of VisitRequest objects using the bubble sort algorithm.
     *
     * @param listVisits the list of VisitRequest objects to be sorted
     * @return the sorted list of VisitRequest objects
     */
    public ArrayList<VisitRequest> sort(ArrayList<VisitRequest> listVisits) {
        int n = listVisits.size();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (listVisits.get(j - 1).getDate().isBefore(listVisits.get(j).getDate())) {
                    VisitRequest temp = listVisits.get(j - 1);
                    listVisits.set(j - 1, listVisits.get(j));
                    listVisits.set(j, temp);
                }
            }
        }
        return listVisits;
    }
}