package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LegacySystemController {

    /**
     * Initiate instance repos of the class Repositories
     */
    private final Repositories repository = Repositories.getInstance();
    /**
     * Initiate instance announcementRepository of the class AnnouncementRepository
     */
    private AdvertisementRepository advertisementRepository;
    private ClientRepository clientRepository;

    /**
     * Initiate instance agencyRepository of the class AgencyRepository
     */
    private StoreRepository storeRepository;

    /**
     * Initiate instance employeeRepository of the class EmployeeRepository
     */
    private EmployeeRepository employeeRepository;
    private OrderRepository orderRepository;
    private PropertyRepository propertyRepository;
    private AddressRepository addressRepository;

    /**
     * get repository
     *
     * @return repository
     */
    public Repositories getRepository() {
        return repository;
    }

    /**
     * Initiates an instance of ImportSystemController.
     */
    public LegacySystemController() {
        this.advertisementRepository = repository.getAdvertisementRepository();
        this.storeRepository = repository.getStoreRepository();
        this.employeeRepository = repository.getEmployeeRepository();
        this.orderRepository = repository.getOrderRepository();

    }

    public StoreRepository getStoreRepository() {
        if (storeRepository == null) {
            Repositories repositories = Repositories.getInstance();

            storeRepository = repositories.getStoreRepository();
        }
        return storeRepository;
    }

    public AddressRepository getAddressRepository() {
        if (addressRepository == null) {
            Repositories repositories = Repositories.getInstance();

            addressRepository = repositories.getAddressRepository();
        }
        return addressRepository;
    }

    public PropertyRepository getPropertyRepository() {
        if (propertyRepository == null) {
            Repositories repositories = Repositories.getInstance();

            propertyRepository = repositories.getPropertyRepository();
        }
        return propertyRepository;
    }

    /**
     * Creates a new instance of class EmployeeRole.
     *
     * @param
     * @param designation
     * @return instance of EmployeeRole
     */
    public OrganizationRole role(String designation) {
        return new OrganizationRole(designation);
    }

    /**
     * Creates a new instance of class Announcement.
     *
     * @param property
     * @param dealType
     * @param
     * @param
     * @param commission
     * @param publicationDate
     * @return instance of Announcement
     */
    public PurchaseOrder createDealFromCSV(String ownerPassportNum, String ownerTIN, String ownerName, String ownerPhone, String ownerEmail, String propertyType, Property property, double requestedPrice, String dealType, String commission, double salePrice, String publicationDate, String dateOfSale, String storeID, String storeName, String storeAddress, String storePhoneNumber, String storeEmailAddress, String citizenCardNumber, String taxNumber, String name, String phoneNumber, String emailAddress) {
        Client owner = Repositories.getInstance().getClientRepository().createClient(ownerPassportNum, ownerTIN, ownerName, ownerPhone, ownerEmail);
        Address address = Repositories.getInstance().getAddressRepository().createAddressString(storeAddress);
        Store store = Repositories.getInstance().getStoreRepository().createStore(address, storeID, storePhoneNumber, storeName, storeEmailAddress);
        Repositories.getInstance().getStoreRepository().addStore(store);
        OrganizationRole agentRole = role("Agent");
        Employee agent = Repositories.getInstance().getEmployeeRepository().createEmployee(name, citizenCardNumber, taxNumber, emailAddress, phoneNumber, agentRole, address, store);
        Advertisement advertisement = new Advertisement(owner, agent, store, property, propertyType, dealType, commission, publicationDate);
        PurchaseOrder purchaseOrder = new PurchaseOrder(requestedPrice, owner, advertisement, dateOfSale, salePrice, store);
        purchaseOrder.accept();
        return purchaseOrder;
    }

    /**
     * Adds announcement to AnnouncementRepository.
     *
     * @param
     * @return announcement in AnnouncementRepository
     */
    public boolean addDeal(PurchaseOrder purchaseOrder) {
        this.orderRepository = repository.getOrderRepository();
        return this.orderRepository.addOrder(purchaseOrder);
    }

    /**
     * creates toString method using the instance announcement of the class Announcement.
     *
     * @param
     * @return toString method using the instance announcement of the class Announcement.
     */
    public String showAdvertisement(Advertisement advertisement) {
        return advertisement.toString();
    }

    /**
     * Sets a new status to an announcement.
     *
     * @param , status
     */
    public void setStatus(Advertisement advertisement, String status) {
        advertisement.setState(status);
    }

    public void print() {
        List<PurchaseOrder> deals = orderRepository.getPurchasesSold();
        for (PurchaseOrder purchaseOrder : deals) {
            System.out.println(purchaseOrder);
        }
    }


    public void showFilesInSystem() {
        String directoryPath = "LegacySystemFiles";

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            System.out.println("Here are the existing files to import: ");
            System.out.println();
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                    System.out.println();
                }
            }
            System.out.println();
        } else {
            System.out.println("No files found in the directory.");
        }
    }

    public boolean verifyFileExistenceAndFormat(String chosenFile) {

        String directoryPath = "LegacySystemFiles";

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        int fileNameLength = chosenFile.length();
        String correctFormat = ".csv";
        if (files != null) {
            if (fileNameLength < 4)
                return false;
            else {
                String fileFormat = chosenFile.substring(chosenFile.length() - 4);
                for (File file : files) {
                    if (file.isFile() && file.getName().equalsIgnoreCase(chosenFile) && fileFormat.equalsIgnoreCase(correctFormat)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
