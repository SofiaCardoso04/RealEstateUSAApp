package pt.ipp.isep.dei.esoft.project.application.controller;
import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.domain.Store;
import pt.ipp.isep.dei.esoft.project.repository.AddressRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.StoreRepository;

import java.util.ArrayList;

 /**
 * RegisterStoreController is a class that serves as a controller for the registration of a new store and its associated address.
 */
public class RegisterStoreController {

    private AddressRepository addressRepository = null;
    private StoreRepository storeRepository = null;
    private ArrayList<Store> stores;
    private ArrayList<Address> addresses;

    /**
     * Constructor for RegisterStoreController that initializes AddressRepository and StoreRepository instances.
     */
    public RegisterStoreController() {
        getAddressRepository();
        getStoreRepository();
    }

    /**
     * Gets the StoreRepository instance and creates one if it doesn't exist.
     *
     * @return StoreRepository instance
     */
    public StoreRepository getStoreRepository() {
        if (storeRepository == null) {
            Repositories repositories = Repositories.getInstance();
            storeRepository = repositories.getStoreRepository();
        }
        return storeRepository;
    }

    /**
     * Gets the AddressRepository instance and creates one if it doesn't exist.
     *
     * @return AddressRepository instance
     */
    public AddressRepository getAddressRepository() {
        if (addressRepository == null) {
            Repositories repositories = Repositories.getInstance();
            addressRepository = repositories.getAddressRepository();
        }
        return addressRepository;
    }

    /**
     * Gets the list of registered stores.
     *
     * @return list of registered stores
     */
    public ArrayList<Store> getStoresList() {
        StoreRepository storeRepository = Repositories.getInstance().getStoreRepository();
        this.stores = storeRepository.getStoresList();
        return stores;
    }

    /**
     * Gets the list of registered addresses.
     *
     * @return list of registered addresses
     */
    public ArrayList<Address> getAdressesList() {
        AddressRepository addressRepository = Repositories.getInstance().getAddressRepository();
        this.addresses = addressRepository.getAddressList();
        return addresses;
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
        return this.addressRepository.registerAddress(streetName, cityName, zipCode, district);
    }

    /**
     * Registers a new store in the system with an associated address.
     *
     * @param address     the address of the store
     * @param id          the id of the store
     * @param designation the designation of the store
     * @param phoneNumber the phone number of the store
     * @param email       the email of the store
     * @return true if the store is successfully registered, false otherwise
     */
    public boolean registerStore(Address address, String id, String designation, String phoneNumber, String email) {
        StoreRepository storeRepository = getStoreRepository();
        return this.storeRepository.registerStore(address, id, phoneNumber, designation, email);
    }
}

