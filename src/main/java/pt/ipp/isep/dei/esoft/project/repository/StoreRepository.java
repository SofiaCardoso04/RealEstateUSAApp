package pt.ipp.isep.dei.esoft.project.repository;

import javafx.util.Pair;
import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.domain.PurchaseOrder;
import pt.ipp.isep.dei.esoft.project.domain.Store;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The StoreRepository class manages the list of stores and provides methods to add and register a store.
 */
public class StoreRepository implements Serializable {
    private static final String STORE_SERIALIZATION_FILE_PATH = "Serialization/Store.ser";
    /**
     * The list of stores managed by this repository.
     */
    private ArrayList<Store> storesList = new ArrayList<>();

    /**
     * Returns the list of stores managed by this repository.
     *
     * @return The list of stores.
     */
    public ArrayList<Store> getStoresList() {
        return storesList;
    }

    /**
     * Creates a new store object and adds it to the repository.
     *
     * @param address     The store address.
     * @param id          The store ID.
     * @param phoneNumber The store phone number.
     * @param designation The store designation.
     * @param email       The store email.
     * @return True if the store was added successfully, false otherwise.
     */
    public boolean registerStore(Address address, String id, String phoneNumber, String designation, String email) {
        return this.addStore(new Store(address, id, phoneNumber, designation, email));
    }

    /**
     * Validates if a given store is valid for registration.
     *
     * @param store The store to validate.
     * @return True if the store is valid, false otherwise.
     */
    public boolean validateStore(Store store) {
        if (store == null) {
            return false;
        }
        if (this.storesList.contains(store)) {
            return false;
        }
        if (checkIfStoreExists(store.getId())) {
            return false;
        }
        return true;
    }


    public boolean checkIfStoreExists(String id) {
        for (Store store : this.storesList) {
            if (store.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a store to the repository.
     *
     * @param store The store to add.
     * @return True if the store was added successfully, false otherwise.
     */
    public boolean addStore(Store store) {
        if (!validateStore(store))
            return false;
        else {
            return this.storesList.add(store);
        }
    }

    public Store createStore(Address address, String id, String designation, String phoneNumber, String emailAddress) {
        Store store = new Store(address, id, designation, phoneNumber, emailAddress);
        if (!validateStore(store)) {
            addStore(store);
        }
        return store;
    }

    public String[] getListOfStoreIds(int size) {
        String[] storeIds = new String[size];
        for (int i = 0; i < size; i++) {
            storeIds[i] = storesList.get(i).getId();
        }
        return storeIds;
    }

    private int getPropertiesPerStore(String id, List<PurchaseOrder> listPurchasesSold){
        int qnt = 0;
        for (int i = 0; i < listPurchasesSold.size(); i++) {
            if (listPurchasesSold.get(i).getAdvertisement().getStore().getId().equals(id)) {
                qnt++;
            }
        }
        return qnt;
    }

    public int[] getListOfPropertiesPerStore(int size, List<PurchaseOrder> listPurchasesSold) {
        int[] propertiesPerStore = new int[size];
        String[] storeIds = getListOfStoreIds(size);
        for (int j = 0; j < size; j++) {
            propertiesPerStore[j] = getPropertiesPerStore(storeIds[j], listPurchasesSold);
        }
        return propertiesPerStore;
    }

    public List<String> divideIntoSubsets(List<Pair> nums) {
        long startTime = System.currentTimeMillis();

        boolean[] flags = new boolean[nums.size()];

        List<Pair> subset1 = new ArrayList<>();
        List<Pair> subset2 = new ArrayList<>();

        Pair pair = new Pair(0,0);

        int difference = 0;
        int attempts = 0;
        int maxAttempts = (int) Math.pow(2, nums.size() - 1);

        for (int i = 0; i < maxAttempts; i++) {

            List<Pair> subsetA = new ArrayList<>();
            List<Pair> subsetB = new ArrayList<>();

            for (int j = 0; j < nums.size(); j++) {
                if (flags[j]) {
                    subsetA.add(nums.get(j));
                    subsetB.add(pair);
                } else {
                    subsetB.add(nums.get(j));
                    subsetA.add(pair);
                }
            }

            int sumA = calculateSum(subsetA);
            int sumB = calculateSum(subsetB);

            if (attempts == 0) {
                attempts++;
                difference = Math.abs(sumA - sumB);
            } else if (Math.abs(sumA - sumB) < difference) {
                attempts++;
                difference = Math.abs(sumA - sumB);
                subset1 = new ArrayList<>(subsetA);
                subset2 = new ArrayList<>(subsetB);
            } else {
                attempts++;
            }

            boolean validator = true;

            for (int j = 0; j < nums.size() && validator; j++) {
                flags[j] = !flags[j];
                if (flags[j]) {
                    validator = false;
                }
            }
        }

        long endTime = System.currentTimeMillis();

        List<String> returns = new ArrayList<>();


        returns.add("Iterations made: " + attempts);
        returns.add("SubsetA: " + subsetToString(subset1));
        returns.add("SubsetB: " + subsetToString(subset2));
        returns.add("Difference: " + difference);
        returns.add("Time elapsed: " + (endTime - startTime) + " milliseconds");

        return returns;
    }

    private int calculateSum(List<Pair> nums) {
        int sum = 0;
        for (Pair num : nums) {
            sum = sum + (int) num.getValue();
        }
        return sum;
    }

    public String subsetToString(List<Pair> subset) {
        StringBuilder string= new StringBuilder("{");
        for (Pair pair : subset) {
            string.append("( ").append(pair.getKey()).append(", ").append(pair.getValue()).append(")");
        }
        string.append("}");
        return string.toString();
    }

    public List<Pair> nums(int numberOfStores, List<PurchaseOrder> listPurchasesSold) {
        List<Pair> nums = new ArrayList<>();

        String[] storeIdArray = getListOfStoreIds(numberOfStores);
        int[] propertiesPerStoreArray = getListOfPropertiesPerStore(numberOfStores, listPurchasesSold);

        for (int i = 0; i < storeIdArray.length; i++) {
            Pair pair = new Pair(storeIdArray[i], propertiesPerStoreArray[i]);
            nums.add(pair);
        }
        return nums;
    }
}