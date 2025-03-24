package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A repository class to manage employee data.
 */
public class EmployeeRepository  implements Serializable{
    private static final String EMPLOYEE_SERIALIZATION_FILE_PATH = "Serialization/Employee.ser";
    private static ArrayList<Employee> employees = new ArrayList<>();

    /**
     * Get a list of all employees.
     *
     * @return ArrayList of all employees.
     */
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    /**
     * Validate if an employee already exists in the repository.
     *
     * @param employee Employee to validate.
     * @return True if the employee already exists, false otherwise.
     */
    public boolean validateEmployee(Employee employee) {
        return employees.contains(employee);
    }

    /**
     * Add an employee to the repository.
     *
     * @param employee Employee to add.
     * @return True if the employee was added successfully, false otherwise.
     */
    public boolean addEmployee(Employee employee) {
        if (employee == null) {
            return false;
        }
        if (validateEmployee(employee)) {
            return false;
        }

        employees.add(employee);
        return true;

    }

    /**
     * Retrieves an employee based on the provided email address.
     *
     * @param userEmail The email address of the employee to retrieve.
     * @return The employee with the matching email address, or null if not found.
     */
    public Employee getEmployeeByEmail(String userEmail) {
        for (Employee employee : employees) {
            if (userEmail.equals(employee.getEmailAddress())) {
                return employee;
            }
        }
        return null;
    }

    public Employee createEmployee(String name, String passportCardNumber, String taxNumber, String emailAddress, String phoneNumber, OrganizationRole organizationRole, Address address, Store store) {
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);
        if (!validateEmployee(employee)) {
            addEmployee(employee);
        }
        return employee;
    }
}