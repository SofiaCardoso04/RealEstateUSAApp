package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a network of stores managed by a network manager.
 */
public class StoreNetwork implements Serializable {
    private NetworkManager manager;
    private List<Store> storeNetwork = new ArrayList<>();

    /**
     * Adds a store to the store network.
     *
     * @param store The store to be added.
     */
    public void addStore(Store store) {
        storeNetwork.add(store);
    }

    /**
     * Retrieves the list of stores in the store network.
     *
     * @return The list of stores in the store network.
     */
    public List<Store> getStoreNetwork() {
        return this.storeNetwork;
    }

}
