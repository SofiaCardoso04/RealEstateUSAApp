package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;

/**
 * Represents an agent through name, passport card number, tax number, email address, phone number, organization role, address and store atributes.
 */
public class Agent extends Employee implements Serializable {
    private Store store;

    /**
     * Builds an instance of Agent with a given name, passport card number, tax number, email address, phone number, organization role, address and store.
     *
     * @param name               the agent's name
     * @param passportCardNumber the agent's passport card number
     * @param taxNumber          the agent's tax number
     * @param emailAddress       the agent's email address
     * @param phoneNumber        the agent's phone number
     * @param organizationRole   the agent's organization role
     * @param address            the agent's address
     * @param store              the agent's store
     */
    public Agent(String name, String passportCardNumber, String taxNumber, String emailAddress, String phoneNumber, OrganizationRole organizationRole, Address address, Store store) {
        super(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);
        this.store = store;
    }

    /**
     * Get the agent's store.
     *
     * @return the agent's store
     */
    public Store getStore() {
        return store;
    }

/*public boolean isAgentInStore(Store store){
        return store.agents.contains(this);
    }*/
}