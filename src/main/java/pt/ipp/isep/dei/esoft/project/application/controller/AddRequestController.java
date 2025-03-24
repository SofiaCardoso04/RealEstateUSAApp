package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.ArrayList;
import java.util.Objects;

/**
 * The AddRequestController class manages the publishment of new advertisements, clients and addresses in the system.
 */
public class AddRequestController {
    /**
     * The repositories
     */
    private Repositories repository;

    /**
     * The store repository
     */
    private StoreRepository storeRepository = null;

    /**
     * The agent list repository
     */
    private AgentListRepository agentListRepository = null;

    /**
     * The address repository
     */
    private AddressRepository addressRepository = null;

    /**
     * The advertisement request repository
     */
    private AdvertisementRequestRepository advertisementRequestRepository = null;

    /**
     * The property repository
     */
    private PropertyRepository propertyRepository = null;

    /**
     * The list of stores
     */
    private ArrayList<Store> stores;

    private ArrayList<Employee> employees;

    /**
     * The list of agents
     */
    private ArrayList<Agent> agents;

    /**
     * The photograph list
     */
    private ArrayList<String> photographList;

    /**
     * Get of all repositories
     */
    public AddRequestController() {
        getStoreRepository();
        getAgentListRepository();
        getAddressRepository();
        getAdvertisementRequestRepository();
    }

    /**
     * Returns the StoreRepository object, initializing it if necessary.
     *
     * @return The StoreRepository object.
     */
    public StoreRepository getStoreRepository() {
        if (storeRepository == null) {
            Repositories repositories = Repositories.getInstance();

            storeRepository = repositories.getStoreRepository();
        }
        return storeRepository;
    }

    /**
     * Returns the AgentListRepository object, initializing it if necessary.
     *
     * @return The AgentListRepository object.
     */
    public AgentListRepository getAgentListRepository() {
        if (agentListRepository == null) {
            Repositories repositories = Repositories.getInstance();

            agentListRepository = repositories.getAgentListRepository();
        }
        return agentListRepository;
    }

    /**
     * Returns the AddressRepository object, initializing it if necessary.
     *
     * @return The AddressRepository object.
     */
    public AddressRepository getAddressRepository() {
        if (addressRepository == null) {
            Repositories repositories = Repositories.getInstance();

            addressRepository = repositories.getAddressRepository();
        }
        return addressRepository;
    }

    /**
     * Returns the AdvertisementRequestRepository object, initializing it if necessary.
     *
     * @return The AdvertisementRequestRepository object.
     */
    public AdvertisementRequestRepository getAdvertisementRequestRepository() {
        if (advertisementRequestRepository == null) {
            Repositories repositories = Repositories.getInstance();

            advertisementRequestRepository = repositories.getAdvertisementRequestRepository();
        }
        return advertisementRequestRepository;
    }

    /**
     * Get the stores list
     *
     * @return the stores
     */
    public ArrayList<Store> getStoresList() {
        StoreRepository storeRepository = Repositories.getInstance().getStoreRepository();
        this.stores = storeRepository.getStoresList();
        return stores;
    }

    public ArrayList<Employee> getEmployeesList() {
        EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
        this.employees = employeeRepository.getEmployees();
        return employees;
    }

    /**
     * Get the agents list
     *
     * @param store the store where the agent is working
     * @return the agents in a specific store
     */
    public ArrayList<Employee> getAgentList(Store store) {
        ArrayList<Employee> Agents = new ArrayList<>();
        for (Employee employee : store.getEmployees()) {
            if (Objects.equals(employee.getOrganizationRole().getDesignation(), "Agent")) {
                Agents.add(employee);
            }
        }
        return Agents;
    }

    /**
     * Get property repository3
     *
     * @return the property repository
     */
    private PropertyRepository getPropertyRepository() {
        if (propertyRepository == null) {
            Repositories repositories = Repositories.getInstance();

            propertyRepository = repositories.getPropertyRepository();
        }
        return propertyRepository;
    }

    /**
     * Add the photographs URI to the list
     * The user can't add more than 30 photographs
     *
     * @param photographURI  the URI of the photograph
     * @param photographList the photographs list
     * @return the photograph list
     */
    public ArrayList<String> addPhotographsURIToList(String photographURI, ArrayList<String> photographList) {
        if (photographList.size() < 30) {
            photographList.add(photographURI);
        } else {
            System.out.println("It is not possible to put more photos!");
        }
        return photographList;
    }

    /**
     * Creates a new address object and adds it to the repository.
     *
     * @param district   the district
     * @param cityName   the city name
     * @param streetName the street name
     * @param zipCode    the zip code
     * @return true if the address was added successfully, false otherwise.
     */
    public boolean registerAddress(String district, String cityName, String streetName, String zipCode) {
        AddressRepository addressRepository = getAddressRepository();
        return this.addressRepository.registerAddress(streetName, cityName, zipCode, district);
    }

    /**
     * Creates a new property object and adds it to the repository.
     *
     * @param area             the property area
     * @param distanceFromCity the property distance from the city centre
     * @param photograph       the property photograph
     * @param address          the property address
     * @return true if the address was added successfully, false otherwise.
     */
    public boolean createProperty(double area, double distanceFromCity, String photograph, Address address) {
        PropertyRepository propertyRepository = getPropertyRepository();
        return this.propertyRepository.createProperty(area, distanceFromCity, photograph, address);
    }

    /**
     * Creates a new residence object and adds it to the repository.
     *
     * @param area                the property area
     * @param distanceFromCity    the property distance from the city centre
     * @param photograph          the property photograph
     * @param address             the property address
     * @param numberBedrooms      the property number of bedrooms
     * @param numberBathrooms     the property number of bathrooms
     * @param numberParkingSpaces the property number of parking spaces
     * @param availableEquipments the property available equipments
     * @return true if the address was added successfully, false otherwise.
     */
    public boolean createResidence(double area, double distanceFromCity, String photograph, Address address, int numberBedrooms, int numberBathrooms, int numberParkingSpaces, AvailableEquipment availableEquipments) {
        PropertyRepository propertyRepository = getPropertyRepository();
        return this.propertyRepository.createResidence(area, distanceFromCity, photograph, address, numberBedrooms, numberBathrooms, numberParkingSpaces, availableEquipments);
    }

    /**
     * Creates a new house object and adds it to the repository.
     *
     * @param area                the property area
     * @param distanceFromCity    the property distance from the city centre
     * @param photograph          the property photograph
     * @param address             the property address
     * @param numberBedrooms      the property number of bedrooms
     * @param numberBathrooms     the property number of bathrooms
     * @param numberParkingSpaces the property number of parking spaces
     * @param availableEquipments the property available equipments
     * @param existenceBasement   the property existence of basement
     * @param existenceLoft       the property existence of loft
     * @param sunExposure         the property sun exposure
     * @return true if the address was added successfully, false otherwise.
     */
    public boolean createHouse(double area, double distanceFromCity, String photograph, Address address, int numberBedrooms, int numberBathrooms, int numberParkingSpaces, AvailableEquipment availableEquipments, int existenceBasement, int existenceLoft, int sunExposure) {
        PropertyRepository propertyRepository = getPropertyRepository();
        return this.propertyRepository.createHouse(area, distanceFromCity, photograph, address, numberBedrooms, numberBathrooms, numberParkingSpaces, availableEquipments, existenceBasement, existenceLoft, sunExposure);
    }

    /**
     * Creates a new advertisement request object and adds it to the repository.
     *
     * @param emailAddress the client email address
     * @param store the store
     * @param agent the responsible agent
     * @param property the property
     * @param propertyType the type of property
     * @param requestType the request type
     * @return true if the address was added successfully, false otherwise.
     */
    public boolean createAdvertisementRequest(String emailAddress, Store store, Employee agent, Property property, String propertyType, String requestType, double requestedPrice, String date) {
        AdvertisementRequestRepository advertisementRequestRepository = getAdvertisementRequestRepository();
        return this.advertisementRequestRepository.createRequest(emailAddress, store, agent, property, propertyType, requestType, requestedPrice, date);
    }
}
