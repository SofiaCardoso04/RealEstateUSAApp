package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;

public class OrganizationRole implements Serializable {
    //private static String[] organizationRoles = {"Agent", "Store manager", "Store network manager"};
    private String designation;

    /*public static String[] getOrganizationRoles() {
        return organizationRoles;
    }

    public OrganizationRole(String[] organizationRoles) {
        this.organizationRoles = organizationRoles;
    }*/

    public OrganizationRole(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    @Override
    public String toString() {
        return "OrganizationRole{" +
                "designation='" + designation + '\'' +
                '}';
    }
}
