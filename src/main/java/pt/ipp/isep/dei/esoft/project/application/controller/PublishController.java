package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.isep.lei.esoft.auth.UserSession;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The PublishController class manages the publishment of new advertisements, clients and addresses in the system.
 */
public class PublishController {
    private AddressRepository addressRepository = null;
    private AdvertisementRepository advertisementRepository = null;
    private AuthenticationRepository authenticationRepository = null;
    private EmployeeRepository employeeRepository = null;
    private ClientRepository clientRepository = null;
    private PropertyRepository propertyRepository = null;


    /**
     * Constructor for PublishController that initializes ClientRepository, AddressRepository, AdvertisementRepository and PropertyRepository instances.
     */
    public PublishController(){
        getClientRepository();
        getAddressRepository();
        getAdvertisementRepository();
        getPropertyRepository();
        getAuthenticationRepository();
        getEmployeeRepository();
    }

    private AuthenticationRepository getAuthenticationRepository(){
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();

            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    private EmployeeRepository getEmployeeRepository() {
        if (employeeRepository == null) {
            Repositories repositories = Repositories.getInstance();

            employeeRepository = repositories.getEmployeeRepository();
        }
        return employeeRepository;
    }

    /**
     * Returns the ClientRepository object, initializing it if necessary.
     *
     * @return The ClientRepository object.
     */
    private ClientRepository getClientRepository() {
        if (clientRepository == null) {
            Repositories repositories = Repositories.getInstance();

            clientRepository = repositories.getClientRepository();
        }
        return clientRepository;
    }

    /**
     * Returns the AddressRepository object, initializing it if necessary.
     *
     * @return The AddressRepository object.
     */
    private AddressRepository getAddressRepository() {
        if (addressRepository == null) {
            Repositories repositories = Repositories.getInstance();

            addressRepository = repositories.getAddressRepository();
        }
        return addressRepository;
    }

    /**
     * Returns the AdvertisementRepository object, initializing it if necessary.
     * @return The AdvertisementRepository object.
     */
    private AdvertisementRepository getAdvertisementRepository() {
        if (advertisementRepository == null) {
            Repositories repositories = Repositories.getInstance();

            advertisementRepository = repositories.getAdvertisementRepository();
        }
        return advertisementRepository;
    }

    /**
     * Returns the PropertyRepository object, initializing it if necessary.
     * @return The PropertyRepository object.
     */
    private PropertyRepository getPropertyRepository() {
        if (propertyRepository == null) {
            Repositories repositories = Repositories.getInstance();

            propertyRepository = repositories.getPropertyRepository();
        }
        return propertyRepository;
    }

    /**
     * Get the client by their email address.
     * @param ownerEmail the client´s email address
     * @return the client by their email address
     */
    public Client getClient(String ownerEmail){
        return Repositories.getInstance().getClientRepository().getClientByEmail(ownerEmail);
    }

    /**
     * Returns the photograph list with a maximum of 30 photographs.
     * @param photographURI the photograph's URI
     * @param photographList the photographs' list
     * @return the photograph list.
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
     * Registers an address in the system.
     *
     * @param district   the district of the address
     * @param cityName   the city name of the address
     * @param streetName the street name of the address
     * @param zipCode    the zip code of the address
     * @return true if the address is successfully registered, false otherwise
     */
    public boolean registerAddress(String district, String cityName, String streetName, String zipCode) {
        AddressRepository addressRepository = getAddressRepository();
        return addressRepository.registerAddress(streetName, cityName, zipCode, district);
    }

    /**
     * Creates an advertisement in the system.
     * @param emailAddress the email address of the advertisement
     * @param property the property of the advertisement
     * @param propertyType the property type of the advertisement
     * @param requestType the request type of the advertisement
     * @param date the date of the advertisement
     * @param salePrice the salePrice of the advertisement
     * @return true if the advertisement is successfully registered, false otherwise
     */
   public boolean createAdvertisement(Employee agent, Client emailAddress, int advertisementID, Property property, String propertyType, String requestType, String date, double salePrice, Commission commission) {
        AdvertisementRepository advertisementRepository = getAdvertisementRepository();
       return advertisementRepository.createAdvertisement(agent, emailAddress, advertisementID, property, propertyType, requestType, commission, date, salePrice);
    }

    /**

     Retrieves the current agent as an  Employee

     @return The current agent as an Employee
     */
   public Employee getCurrentAgent() {
       AuthenticationRepository rep = Repositories.getInstance().getAuthenticationRepository();
       UserSession us = rep.getCurrentUserSession();
       String email = us.getUserId().getEmail();
       return Repositories.getInstance().getEmployeeRepository().getEmployeeByEmail(email);
   }

    /**
     * Creates a property in the system.
     * @param area the property's area
     * @param distanceFromCity the property's distance from city
     * @param photograph the property's photograph
     * @param address the property's address
     * @return true if the property is successfully registered, false otherwise
     */
    public boolean createProperty(double area, double distanceFromCity, String photograph, Address address) {
        PropertyRepository propertyRepository = getPropertyRepository();
        return propertyRepository.createProperty(area, distanceFromCity, photograph, address);
    }

    /**
     * Creates a residence in the system.
     * @param area the residence's area
     * @param distanceFromCity the residence's distance from city
     * @param photograph the residence's photograph
     * @param address the residence's address
     * @param numberBedrooms the residence's number of bedrooms
     * @param numberBathrooms the residence's number of bathrooms
     * @param numberParkingSpaces the residence's number of parking spaces
     * @param availableEquipments the residence's available equipment
     * @return true if the residence is successfully registered, false otherwise
     */
    public boolean createResidence(double area, double distanceFromCity, String photograph, Address address, int numberBedrooms, int numberBathrooms, int numberParkingSpaces, AvailableEquipment availableEquipments) {
        PropertyRepository propertyRepository = getPropertyRepository();
        return propertyRepository.createResidence(area, distanceFromCity, photograph, address, numberBedrooms, numberBathrooms, numberParkingSpaces, availableEquipments);
    }

    /**
     * Creates a house in the system.
     * @param area the house's area
     * @param distanceFromCity the house's distance from city
     * @param photograph the house's photograph
     * @param address the house's address
     * @param numberBedrooms the house's number of bedrooms
     * @param numberBathrooms the house's number of bathrooms
     * @param numberParkingSpaces the house's number of parking spaces
     * @param availableEquipments the house's available equipment
     * @param existenceBasement the house's existence of basement
     * @param existenceLoft the house's existence of loft
     * @param sunExposure the house's sun exposure
     * @return true if the house is successfully registered, false otherwise
     */
    public boolean createHouse(double area, double distanceFromCity, String photograph, Address address, int numberBedrooms, int numberBathrooms, int numberParkingSpaces, AvailableEquipment availableEquipments, int existenceBasement, int existenceLoft, int sunExposure) {
        PropertyRepository propertyRepository = getPropertyRepository();
        return propertyRepository.createHouse(area, distanceFromCity, photograph, address, numberBedrooms, numberBathrooms, numberParkingSpaces, availableEquipments, existenceBasement, existenceLoft, sunExposure);
    }

    public void sendSMSMessageToOwner(String clientPhone, String agentPhone, String clientName, String streetName, String cityName, String district, String zipCode, String date, String agentName) throws IOException {
        advertisementRepository.sendSMSMessageToOwner(clientPhone, agentPhone, clientName, streetName, cityName, district, zipCode, date, agentName);
    }

    public String getCurrentUserEmail() {
        return authenticationRepository.getCurrentUserEmail();
    }

    public String getCurrentUserName() {
        String userEmail = getCurrentUserEmail();
        if (userEmail != null) {
            Employee employee = employeeRepository.getEmployeeByEmail(userEmail);

            if (employee != null) {
                return employee.getName();
            }
        }
        return null;
    }

    public String getCurrentUserPhoneNumber() {
        String userEmail = getCurrentUserEmail();
        if (userEmail != null) {
            Employee employee = employeeRepository.getEmployeeByEmail(userEmail);

            if (employee != null) {
                return employee.getPhoneNumber();
            }
        }
        return null;
    }

    public String getOwnersName(String ownerEmail) {
        if (ownerEmail != null) {
            Client client = clientRepository.getClientByEmail(ownerEmail);

            if (client != null) {
                return client.getName();
            }
        }
        return null;
    }

    public String getOwnersPhoneNumber(String ownerEmail) {
        if (ownerEmail != null) {
            Client client = clientRepository.getClientByEmail(ownerEmail);

            if (client != null) {
                return client.getPhoneNumber();
            }
        }
        return null;
    }

}
