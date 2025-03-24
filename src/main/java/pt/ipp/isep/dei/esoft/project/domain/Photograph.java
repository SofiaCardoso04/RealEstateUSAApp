package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;

/**
 * Represents the array of all the property photographs
 */
public class Photograph implements Serializable {
    /**
     * Array of strings to the photographs URI with size 30.
     */
    private static final String[] photographs = new String[30];

    /**
     * Get the photographs URI.
     * @return photographs.
     */
    public static String[] getPhotographs() {
        return photographs;
    }
}
