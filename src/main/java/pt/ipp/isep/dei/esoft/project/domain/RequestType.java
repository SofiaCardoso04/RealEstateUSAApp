package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;

/**
 * Represents a request through fixed ammount and percentage attributes.
 */
public class RequestType implements Serializable {
    /**
     * String array of the types of request.
     */
    private static final String[] requestTypes = {"Sale", "Rent"};

    /**
     * Get the types of request.
     * @return types of request.
     */
    public static String[] getRequestTypes() {
        return requestTypes;
    }

}
