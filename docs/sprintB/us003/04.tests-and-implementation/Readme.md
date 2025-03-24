# US 003 - Register a employee

# 4. Tests 

**Test 1:** Tests the constructor.

	 @Test public void testPersonConstructor() {
        Person person = new Employee("John Smith", "12345678", "123-45-6789", "johnsmith@realestate.com", "(555) 123-4567");

        assertEquals("John Smith", person.getName());
        assertEquals("12345678", person.getPassportCardNumber());
        assertEquals("123-45-6789", person.getTaxNumber());
        assertEquals("johnsmith@realestate.com", person.getEmailAddress());
        assertEquals("(555) 123-4567", person.getPhoneNumber());
    }

**Test 2:** Checks if an employee is register successfully. 

	    void registerEmployee() {
        RegisterEmployeeController controller = new RegisterEmployeeController();

        // Create a new employee
        String name = "Vicente";
        String passportCardNumber = "12345678";
        String taxNumber = "123-45-6789";
        String emailAddress = "user123@realestate.com";
        String phoneNumber = "(555) 555-1212";
        OrganizationRole organizationRole = new OrganizationRole("Agent");
        Address address = new Address("123 Main St", "Anytown", "TX", "12345");
        Store store = new Store(address, "12345678", "(555) 555-1234", "storeDesignation", "user123@realestate.com");
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);

        // Register the employee
        boolean result = controller.registerEmployee(employee);

        // Check that the employee was registered successfully
        if(result)

        {
            System.out.println("Employee registered successfully!");
        } else

        {
            System.out.println("Failed to register employee.");
        }
    }
}

*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class RegisterEmployeeController 

```java
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
```


#

# 6. Integration and Demo 

* A new option on the Administrator menu options was added.

* Some demo purposes some tasks are bootstrapped while system starts.







