package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.isep.lei.esoft.auth.UserSession;

import java.util.ArrayList;
import java.util.List;



/**
 * The ListEmployeeController class is responsible for handling the listing of employees.
 * It interacts with the repositories to retrieve employee and store information, and performs sorting operations.
 */
public class ListEmployeeController {

    private StoreRepository storeRepository = null;
    private EmployeeRepository employeeRepository = null;
    private AdvertisementRepository advertisementRepository = null;
    private AdvertisementRequestRepository advertisementRequestRepository = null;
    private AuthenticationRepository authenticationRepository = null;
    private Employee employee;
    private ArrayList<Store> storeList;
    Sorting sorter = new Sorting();
    private List<Store> storeNetwork;

    /**
     * Constructs a new instance of the ListEmployeeController class.
     * Initializes the required repositories.
     */

    public ListEmployeeController() {
        getStoreList();
        getEmployeeRepository();
        getAdvertisementRepository();
        getAdvertisementRequestRepository();
        getAuthenticationRepository();
    }

    /**
     * Retrieves the advertisement request repository.
     *
     * @return The advertisement request repository.
     */
    public AdvertisementRequestRepository getAdvertisementRequestRepository() {
        if (advertisementRequestRepository == null) {
            Repositories repositories = Repositories.getInstance();
            advertisementRequestRepository = repositories.getAdvertisementRequestRepository();
        }
        return advertisementRequestRepository;
    }

    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();

            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    /**
     * Retrieves the list of stores from the store repository.
     *
     * @return The list of stores.
     */
    public ArrayList<Store> getStoreList() {
        StoreRepository storeRepository = Repositories.getInstance().getStoreRepository();
        this.storeList = storeRepository.getStoresList();
        return storeList;
    }

    /**
     * Retrieves the employee repository.
     *
     * @return The employee repository.
     */

    public EmployeeRepository getEmployeeRepository() {
        if (employeeRepository == null) {
            Repositories repositories = Repositories.getInstance();
            employeeRepository = repositories.getEmployeeRepository();
        }
        return employeeRepository;
    }

    /**
     * Retrieves the advertisement repository.
     *
     * @return The advertisement repository.
     */
    public AdvertisementRepository getAdvertisementRepository() {
        if (advertisementRepository == null) {
            Repositories repositories = Repositories.getInstance();

            advertisementRepository = repositories.getAdvertisementRepository();
        }
        return advertisementRepository;
    }


    /**
     * Lists the employees from the employee repository.
     *
     * @param stores The list of stores to consider.
     * @return The list of employees sorted alphabetically, excluding the network manager.
     */
    public List<Employee> listEmployees(List<Store> stores) {
        List<Employee> list =employeeRepository.getEmployees();

        ArrayList<Employee> employeesInStores = new ArrayList<>();

        for (Store store : stores) {
            employeesInStores.addAll(store.getEmployees());
        }

        ArrayList<Employee> filteredEmployees = new ArrayList<>();

        for (Employee employee : list) {
            if (employeesInStores.contains(employee)) {
                filteredEmployees.add(employee);
            }
        }


        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals("Network Manager")) {
                list.remove(i);
            }
        }

        return list;

    }


    public String getCurrentUserEmail() {
        return authenticationRepository.getCurrentUserEmail();
    }

    public Employee getCurrentUser() {
        String userEmail = getCurrentUserEmail();
        if (userEmail != null) {
            Employee employee = employeeRepository.getEmployeeByEmail(userEmail);
            if (employee != null) {
                return employee;
            }
        }
        return null;
    }

    /**
     * Retrieves the stores associated with the network manager identified by the given user email.
     *
     * @param userEmail The user email of the network manager.
     * @return The list of stores associated with the network manager.
     */
    public ArrayList<Store> getNetworkManagerStores(String userEmail) {
        NetworkManager networkManager = (NetworkManager) employeeRepository.getEmployeeByEmail(userEmail);
        storeList = (ArrayList<Store>) networkManager.getStoreNetwork();
        return storeList;
    }

    /**
     * Counts the number of properties for each store in the given list of stores.
     *
     * @param stores The list of stores to count the properties for.
     * @return The list of store IDs and their corresponding property counts.
     */
    public List<String> countPropertiesByStore(List<Store> stores) {
        List<String> propertiesCounted = new ArrayList<>();

        for (Store store : stores) {
            propertiesCounted.add(store.getId());
            propertiesCounted.add(String.valueOf(advertisementRequestRepository.getAdvertisementByStore(store)));
        }
        return propertiesCounted;
    }
    /**
     * Displays the employees from the provided list who belong to the specified store.
     *
     * @param list  The list of employees.
     * @param store The store to filter the employees by.
     */

    public void showEmployyesByOrder(List<Employee> list, Store store) {

        for (int i = 0; i < list.size(); i++) {
            String storeID = String.valueOf((list.get(i).getStore().getId()));
            if ((store.getId()).equals(storeID)) {
                System.out.println(list.get(i));
            }
        }


    }

}
