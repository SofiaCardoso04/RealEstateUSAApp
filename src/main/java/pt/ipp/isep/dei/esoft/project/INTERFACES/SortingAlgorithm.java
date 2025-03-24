package pt.ipp.isep.dei.esoft.project.INTERFACES;

import pt.ipp.isep.dei.esoft.project.DTO.VisitRequestDTO;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;

import java.util.ArrayList;

/**
 * Interface for sorting algorithms.
 */
public interface SortingAlgorithm {

    /**
     * Sorts a list of VisitRequestDTO objects.
     *
     * @param visitRequestsDTO The list of VisitRequestDTO objects to be sorted.
     * @return The sorted list of VisitRequestDTO objects.
     */
    ArrayList<VisitRequestDTO> sortDTO(ArrayList<VisitRequestDTO> visitRequestsDTO);

    /**
     * Sorts a list of VisitRequest objects.
     *
     * @param visitRequests The list of VisitRequest objects to be sorted.
     * @return The sorted list of VisitRequest objects.
     */
    ArrayList<VisitRequest> sort(ArrayList<VisitRequest> visitRequests);
}
