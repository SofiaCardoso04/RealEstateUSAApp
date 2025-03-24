package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents the types of property through an array of land, apartment and house attributes.
 */
public class PropertyType implements Serializable {
    /**
     * String array of the types of property.
     */
    private static final String[] propertyTypes = {"Land", "Apartment", "House"};

    /**
     * Get types of property.
     * @return types of property.
     */
    public static String[] getPropertyTypes() {
        return propertyTypes;
    }
}
