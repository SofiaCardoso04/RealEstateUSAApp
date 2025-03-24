package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents an employee through name, passport card number, tax number, email address, phone number, organization role and address attributes.
 */
public class Employee extends Person implements Serializable {
    private OrganizationRole organizationRole;
    private Address address;
    private Store store;

    /**
     * Builds an instance of Employee with a given name, passport card number, tax number, email address and phone number.
     *
     * @param name               the employee's name
     * @param passportCardNumber the employee's passport card number
     * @param taxNumber          the employee's tax number
     * @param emailAddress       the employee's email address
     * @param phoneNumber        the employee's phone number
     * @param organizationRole   the employee's organization role
     * @param address            the employee's address
     */
    public Employee(String name, String passportCardNumber, String taxNumber, String emailAddress, String phoneNumber, OrganizationRole organizationRole, Address address, Store store) {
        super(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        this.organizationRole = organizationRole;
        this.address = address;
        this.store = store;
    }

    public Employee(String name,String passportCardNumber,String taxNumber,String emailAddress, String phoneNumber) {
        super(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);

    }
    /**
     * Get the employee's organization role.
     *
     * @return the employee's organization role
     */
    public OrganizationRole getOrganizationRole() {
        return organizationRole;
    }

    /**
     * Get the employee's address.
     *
     * @return the employee's address
     */
    public Address getAddress() {
        return address;
    }

    public Store getStore() {
        return store;
    }


}
