package pt.ipp.isep.dei.esoft.project.application.controller;

import javafx.util.Pair;
import pt.ipp.isep.dei.esoft.project.ENUMS.OrderStatus;
import pt.ipp.isep.dei.esoft.project.domain.PurchaseOrder;
import pt.ipp.isep.dei.esoft.project.repository.OrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.StoreRepository;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class DivideIntoSubsetsController {
    private StoreRepository storeRepository;
    private OrderRepository orderRepository;

    /**
     * Constructs a new DivideIntoSubsetsController.
     * Initializes the storeRepository and orderRepository.
     */
    public DivideIntoSubsetsController() {
        getStoreRepository();
        getOrderRepository();
    }

    /**
     * Retrieves the StoreRepository instance.
     *
     * @return the StoreRepository instance
     */
    public StoreRepository getStoreRepository() {
        if (storeRepository == null) {
            Repositories repositories = Repositories.getInstance();
            storeRepository = repositories.getStoreRepository();
        }
        return storeRepository;
    }

    /**
     * Retrieves the OrderRepository instance.
     *
     * @return the OrderRepository instance
     */
    public OrderRepository getOrderRepository() {
        if (orderRepository == null) {
            Repositories repositories = Repositories.getInstance();
            orderRepository = repositories.getOrderRepository();
        }
        return orderRepository;
    }

    /**
     * Retrieves the list of purchased orders.
     *
     * @return the list of PurchaseOrder instances
     */
    public List<PurchaseOrder> getPurchasesSold() {
        return orderRepository.getPurchasesSold();
    }

    /**
     * Generates subsets based on the number of stores.
     *
     * @param numberOfStores the number of stores
     * @return the generated subsets as a string
     */
    public String generateSubsets(int numberOfStores) {
        List<String> output = new ArrayList<>();
        String[] storeIdArray = storeRepository.getListOfStoreIds(numberOfStores);
        int[] propertiesPerStoreArray = storeRepository.getListOfPropertiesPerStore(numberOfStores, getPurchasesSold());
        List<Pair> nums = storeRepository.nums(numberOfStores, getPurchasesSold());
        output.add("List of storeIds: " + Arrays.toString(storeIdArray));
        output.add("Number of properties per store: " + Arrays.toString(propertiesPerStoreArray) + "\n");
        output.add("List of tuples: " + storeRepository.subsetToString(nums) + "\n");

        List<String> moreToOutput = storeRepository.divideIntoSubsets(nums);
        addToList(output, moreToOutput);

        String outputString = outputToString(output);

        return outputString;
    }

    private void addToList(List<String> output, List<String> moreToOutput) {
        output.addAll(moreToOutput);
    }

    private String outputToString(List<String> output) {
        StringBuilder string = new StringBuilder();
        for (String s : output) {
            string.append(s).append("\n");
        }
        return string.toString();
    }
}