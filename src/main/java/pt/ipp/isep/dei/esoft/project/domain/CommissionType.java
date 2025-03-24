package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;

/**
 * Represents the types of commission through an array of fixed ammount and percentage attributes.
 */
public class CommissionType implements Serializable {
    /**
     * String array of the types of commission.
     */
    private static final String[] commissionTypes = {"Fixed Amount", "Percentage"};

    /**
     * Get types of commission.
     * @return types of commission.
     */
    public static String[] getCommissionTypes() {
        return commissionTypes;
    }
}
