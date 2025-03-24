package pt.ipp.isep.dei.esoft.project.repository;


import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.OrganizationRole;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a repository for organization roles.
 */
public class RoleRepository  implements Serializable{
    private static final String ROLE_SERIALIZATION_FILE_PATH = "Serialization/Role.ser";
    /**
     * A list of organization roles.
     */
    private List<OrganizationRole> roles = new ArrayList<>();

    /**
     * Returns the list of organization roles.
     *
     * @return the list of organization roles.
     */
    public List<OrganizationRole> getRoles() {
        return roles;
    }

    /**
     * Adds a new organization role to the repository.
     *
     * @param organizationRole the organization role to be added.
     * @return true if the organization role was successfully added, false otherwise.
     */
    public boolean addEmployeeRole(OrganizationRole organizationRole) {
        if (organizationRole == null) {
            return false;
        }
        if (this.roles.contains(organizationRole)) {
            return false;
        }

        this.roles.add(organizationRole);
        return true;
    }
}
