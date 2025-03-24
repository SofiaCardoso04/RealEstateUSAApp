package pt.ipp.isep.dei.esoft.project.Adapters;

import pt.ipp.isep.dei.esoft.project.DTO.VisitRequestDTO;
import pt.ipp.isep.dei.esoft.project.INTERFACES.SortingAlgorithm;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class SortingAdapter {
    private String sortingAlgorithmClassName;

    /**
     * Constructs a new SortingAdapter instance with the specified sorting algorithm class name.
     *
     * @param sortingAlgorithmClassName the name of the sorting algorithm class
     */
    public SortingAdapter(String sortingAlgorithmClassName) {
        this.sortingAlgorithmClassName = sortingAlgorithmClassName;
    }

    /**
     * Sorts a list of VisitRequestDTO objects using the specified sorting algorithm.
     *
     * @param visitRequestsDTO the list of VisitRequestDTO objects to be sorted
     * @return the sorted list of VisitRequestDTO objects
     */
    public ArrayList<VisitRequestDTO> sortDTO(ArrayList<VisitRequestDTO> visitRequestsDTO) {
        try {
            // Dynamically load the sorting algorithm class
            Class<?> sortingAlgorithmClass = Class.forName(sortingAlgorithmClassName);

            // Get the constructor of the sorting algorithm class that takes no arguments
            Constructor<?> sortingAlgorithmConstructor = sortingAlgorithmClass.getConstructor();

            // Instantiate the sorting algorithm object
            SortingAlgorithm sortingAlgorithm = (SortingAlgorithm) sortingAlgorithmConstructor.newInstance();

            // Apply the sorting algorithm to the visitRequests list
            return sortingAlgorithm.sortDTO(visitRequestsDTO);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                 InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return visitRequestsDTO; // Return the original list if an error occurs
    }

    /**
     * Sorts a list of VisitRequest objects using the specified sorting algorithm.
     *
     * @param visitRequests the list of VisitRequest objects to be sorted
     * @return the sorted list of VisitRequest objects
     */
    public ArrayList<VisitRequest> sort(ArrayList<VisitRequest> visitRequests) {
        try {
            // Dynamically load the sorting algorithm class
            Class<?> sortingAlgorithmClass = Class.forName(sortingAlgorithmClassName);

            // Get the constructor of the sorting algorithm class that takes no arguments
            Constructor<?> sortingAlgorithmConstructor = sortingAlgorithmClass.getConstructor();

            // Instantiate the sorting algorithm object
            SortingAlgorithm sortingAlgorithm = (SortingAlgorithm) sortingAlgorithmConstructor.newInstance();

            // Apply the sorting algorithm to the visitRequests list
            return sortingAlgorithm.sort(visitRequests);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                 InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return visitRequests; // Return the original list if an error occurs
    }
}