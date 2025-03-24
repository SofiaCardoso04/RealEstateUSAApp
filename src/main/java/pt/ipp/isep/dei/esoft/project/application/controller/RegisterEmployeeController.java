package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RegisterEmployeeController class manages the registration of new employees, by handling the retrieval of roles, stores
 * <p>
 * and employee information from the repositories and calling the necessary methods to add the employee to the employee repository
 * <p>
 * and generate a password for their email address.
 */

public class RegisterEmployeeController {
    private StoreRepository storeRepository = null;
    private RoleRepository roleRepository = null;
    private EmployeeRepository employeeRepository = null;
    private ArrayList<Store> storeList;

    /**
     * Initializes a new RegisterEmployeeController object by calling the getRoles(), getStoreList(), and getEmployeeRepository() methods.
     */
    public RegisterEmployeeController() {
        getRoles();
        getStoreList();
        getEmployeeRepository();
    }

    /**
     * Retrieves the list of organization roles from the role repository.
     *
     * @return a list of OrganizationRole objects.
     */
    public List<OrganizationRole> getRoles() {
        Repositories repo = Repositories.getInstance();
        return repo.getRoleRepository().getRoles();
    }

    /**
     * Retrieves the list of stores from the store repository.
     *
     * @return an ArrayList of Store objects.
     */
    public ArrayList<Store> getStoreList() {
        StoreRepository storeRepository = Repositories.getInstance().getStoreRepository();
        this.storeList = storeRepository.getStoresList();
        return storeList;
    }

    /**
     * Retrieves the employee repository instance.
     *
     * @return the EmployeeRepository instance.
     */
    public EmployeeRepository getEmployeeRepository() {
        if (employeeRepository == null) {
            Repositories repositories = Repositories.getInstance();
            employeeRepository = repositories.getEmployeeRepository();
        }
        return employeeRepository;
    }

    /**
     * Registers an employee in the employee repository and generates a password for their email address.
     *
     * @param employee the Employee object to be registered.
     * @return true if the employee was successfully registered, false otherwise.
     */

    public boolean registerEmployee(Employee employee) {
        saveCredentials(employee);
        return this.employeeRepository.addEmployee(employee);
    }

    /**
     * Generates a password for the given employee's email address and saves it to a text file.
     *
     * @param employee the Employee object for which the password will be generated.
     * @return true if the password was successfully generated and saved, false otherwise.
     */


    public boolean saveCredentials(Employee employee) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/credentials/email.txt", true));
            writer.write(String.format("Email: %s\nPassword: %s\n", employee.getEmailAddress(), PasswordGenerator.generatePwd()));
            writer.close();
            return true;  // indicate success
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            return false;  // indicate failure
        }
    }
}
