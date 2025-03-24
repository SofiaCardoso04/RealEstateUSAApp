package pt.ipp.isep.dei.esoft.project.domain;


import java.io.Serializable;
import java.util.ArrayList;

/**
 * The Store class represents a store in the system. A store is defined by its address, unique ID, phone number,
 * designation, email, and store manager. A store can also have a list of employees.
 */
public class Store implements Serializable {

    /**
     * The address of the store.
     */
    private final Address address;

    /**
     * The unique ID of the store.
     */
    private final String id;

    /**
     * The phone number of the store.
     */
    private final String phoneNumber;

    /**
     * The designation of the store.
     */
    private final String designation;

    /**
     * The email of the store.
     */
    private final String email;

    /**
     * The store manager of the store.
     */
    private final Employee storeManager;

    /**
     * The list of employees of the store.
     */
    private ArrayList<Employee> employees;

    /**
     * Creates a new Store object with the given address, ID, phone number, designation, and email.
     *
     * @param address     The address of the store.
     * @param id          The unique ID of the store.
     * @param phoneNumber The phone number of the store.
     * @param designation The designation of the store.
     * @param email       The email of the store.
     * @throws IllegalArgumentException If any of the arguments are null or invalid.
     */
    public Store(Address address, String id, String phoneNumber, String designation, String email) throws IllegalArgumentException {

        // Validate arguments
        if (id.equals("") || phoneNumber.equals("") || designation.equals("") || email.equals("")) {
            throw new IllegalArgumentException("The arguments can't be null!");
        }
        if (!phoneNumber.matches("^\\d{3}-\\d{3}-\\d{4}$")) {
            throw new IllegalArgumentException("The phone number must be in the xxx-xxx-xxxx format!");
        } // Phone number in the United States must have 10 digits
        if (!id.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("The ID must be an integer number!");
        } // Cannot contain any letters
        if (!email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            throw new IllegalArgumentException("The email address must be in the right format! (Example: user123@realestate.com)");
        }


        // Initialize object
        this.address = address;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.designation = designation;
        this.email = email;
        this.storeManager = null;
        this.employees = new ArrayList<>();
    }

    /**
     * Gets the store manager of the store.
     *
     * @return The store manager of the store.
     */
    public Employee getStoreManager() {
        return storeManager;
    }

    /**
     * Gets the address of the store.
     *
     * @return The address of the store.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Gets the designation of the store.
     *
     * @return The designation of the store.
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Gets the unique ID of the store.
     *
     * @return The unique ID of the store.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the email of the store.
     *
     * @return The email of the store.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the phone number of the store.
     *
     * @return The phone number of the store.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets the employees list of the store
     */
    public ArrayList<Employee> getEmployees() {
        return this.employees;
    }

    public Employee createEmployee(String name, String passportCardNumber, String taxNumber, String emailAddress, String phoneNumber, OrganizationRole organizationRole, Address address, Store store) {
        return new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);
    }

    /**
     * Returns a string representation of this store.
     *
     * @return a string representation of this store
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Store Information:\n");
        sb.append("Designation: ").append(designation).append("\n");
        sb.append("ID: ").append(id).append("\n");
        sb.append("E-mail: ").append(email).append("\n");
        sb.append("Phone Number: ").append(phoneNumber).append("\n");
        sb.append("Store Manager: ").append(storeManager).append("\n");
        return sb.toString();
    }

}


