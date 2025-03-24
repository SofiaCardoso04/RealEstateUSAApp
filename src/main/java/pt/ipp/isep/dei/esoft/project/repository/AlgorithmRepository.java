package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Algorithm;
import pt.ipp.isep.dei.esoft.project.domain.PurchaseOrder;

import java.io.Serializable;
import java.util.List;

/**
 * Repository class for Algorithm objects.
 */
public class AlgorithmRepository implements Serializable {

    private Algorithm algorithm = new Algorithm();

    /**
     * Sorts the list of PurchaseOrders using the Gnome Sort algorithm based on a specified option.
     *
     * @param listDeals The list of PurchaseOrders to be sorted.
     * @param option    The sorting option.
     * @return The sorted list of PurchaseOrders.
     */
    public List<PurchaseOrder> getListByGnomeSort(List<PurchaseOrder> listDeals, int option) {
        return algorithm.gnomeSortByPropertyArea(listDeals, option);
    }

    /**
     * Sorts the list of PurchaseOrders using the Bubble Sort algorithm based on a specified option.
     *
     * @param listDeals The list of PurchaseOrders to be sorted.
     * @param option    The sorting option.
     * @return The sorted list of PurchaseOrders.
     */
    public List<PurchaseOrder> getListByBubbleSort(List<PurchaseOrder> listDeals, int option) {
        return algorithm.bubbleSortByPropertyArea(listDeals, option);
    }
}