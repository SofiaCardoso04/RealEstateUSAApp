package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a network manager, a type of employee who manages a network of stores.
 * Inherits from the Employee class.
 */
public class NetworkManager extends Employee implements Serializable {
    private List<Store> storeNetwork = new ArrayList<>();


    /**
     * Constructs a NetworkManager instance with the given name, passport card number, tax number,
     * email address, phone number, organization role, and initial store.
     *
     * @param name               The name of the network manager.
     * @param passportCardNumber The passport card number of the network manager.
     * @param taxNumber          The tax number of the network manager.
     * @param emailAddress       The email address of the network manager.
     * @param phoneNumber        The phone number of the network manager.
     * @param organizationRole   The organization role of the network manager.
     * @param store              The initial store to add to the network manager's store network.
     */
    public NetworkManager(String name, String passportCardNumber, String taxNumber, String emailAddress, String phoneNumber, OrganizationRole organizationRole, Store store) {

        super(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        storeNetwork.add(store);
    }

    /**
     * Adds a store to the network manager's store network.
     *
     * @param store The store to be added.
     */
    public void addStore(Store store) {

        storeNetwork.add(store);
    }

    /**
     * Retrieves the network manager's store network.
     *
     * @return The list of stores in the network manager's store network.
     */
    public List<Store> getStoreNetwork() {
        return this.storeNetwork;

    }
}
