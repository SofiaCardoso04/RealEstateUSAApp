package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Algorithm;
import pt.ipp.isep.dei.esoft.project.domain.PurchaseOrder;
import pt.ipp.isep.dei.esoft.project.repository.OrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.List;

/**
 * Controller class for listing deals.
 */
public class ListDealsController {
    private static OrderRepository orderRepository = null;
    private final Algorithm algorithm = new Algorithm();
    private List<PurchaseOrder> listDeals = null;

    /**
     * Constructs a ListDealsController and retrieves the OrderRepository instance.
     */
    public ListDealsController() {
        getOrderRepository();
    }

    /**
     * Retrieves the OrderRepository instance.
     *
     * @return The OrderRepository instance.
     */
    public OrderRepository getOrderRepository() {
        if (orderRepository == null) {
            Repositories repositories = Repositories.getInstance();
            orderRepository = repositories.getOrderRepository();
        }
        return orderRepository;
    }

    /**
     * Retrieves the list of deals.
     *
     * @return The list of PurchaseOrder objects representing the deals.
     */
    public List<PurchaseOrder> getListOfDeals() {
        listDeals = orderRepository.getPurchasesSold();
        return listDeals;
    }

    /**
     * Retrieves the sorted list of deals using the Gnome Sort algorithm.
     *
     * @param option The sorting option.
     * @return The sorted list of PurchaseOrder objects.
     */
    public List<PurchaseOrder> getListByGnomeSort(int option) {
        return algorithm.gnomeSortByPropertyArea(getListOfDeals(), option);
    }

    /**
     * Retrieves the sorted list of deals using the Bubble Sort algorithm.
     *
     * @param option The sorting option.
     * @return The sorted list of PurchaseOrder objects.
     */
    public List<PurchaseOrder> getListByBubbleSort(int option) {
        return algorithm.bubbleSortByPropertyArea(getListOfDeals(), option);
    }

    /**
     * Displays the deals based on the specified sorting option.
     *
     * @param option The sorting option.
     */
    public void showDeals(int option) {
        if (option == 1) {
            for (int i = 0; i < getListByGnomeSort(option).size(); i++) {
                System.out.println("Deal " + (i + 1) + ": " + getListByGnomeSort(option).get(i).toString());
            }
        } else {
            for (int i = 0; i < getListByBubbleSort(option).size(); i++) {
                System.out.println("Deal " + (i + 1) + ": " + getListByBubbleSort(option).get(i).toString());
            }
        }
    }
}
