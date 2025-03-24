package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.DTO.VisitRequestDTO;
import pt.ipp.isep.dei.esoft.project.INTERFACES.SortingAlgorithm;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a gnome sort algorithm for sorting visit request data.
 */
public class GnomeSortAlgorithm implements SortingAlgorithm, Serializable {

    /**
     * Sorts a list of VisitRequestDTO objects using the gnome sort algorithm.
     *
     * @param listVisits the list of VisitRequestDTO objects to be sorted
     * @return the sorted list of VisitRequestDTO objects
     */
    @Override
    public ArrayList<VisitRequestDTO> sortDTO(ArrayList<VisitRequestDTO> listVisits) {
        int index = 0;
        while (index < listVisits.size()) {
            if (index == 0 || listVisits.get(index).getDate().isBefore(listVisits.get(index - 1).getDate())) {
                index++;
            } else {
                VisitRequestDTO temp = listVisits.get(index);
                listVisits.set(index, listVisits.get(index - 1));
                listVisits.set(index - 1, temp);
                index--;
            }
        }

        return listVisits;
    }

    /**
     * Sorts a list of VisitRequest objects using the gnome sort algorithm.
     *
     * @param listVisits the list of VisitRequest objects to be sorted
     * @return the sorted list of VisitRequest objects
     */
    public ArrayList<VisitRequest> sort(ArrayList<VisitRequest> listVisits) {
        int index = 0;
        while (index < listVisits.size()) {
            if (index == 0 || listVisits.get(index).getDate().isBefore(listVisits.get(index - 1).getDate())) {
                index++;
            } else {
                VisitRequest temp = listVisits.get(index);
                listVisits.set(index, listVisits.get(index - 1));
                listVisits.set(index - 1, temp);
                index--;
            }
        }

        return listVisits;
    }
}