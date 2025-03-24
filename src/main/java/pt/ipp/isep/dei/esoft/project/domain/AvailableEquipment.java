package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Represents the available equipment through air conditioning and central heating attributes.
 */
public class AvailableEquipment implements Serializable {
    private int airConditioning = -1;
    private int centralHeating = -1;

    /**
     * Builds an instance of AvailableEquipment with a given air conditioning and central heating.
     * @param airConditioning the available equipment's air conditioning
     * @param centralHeating the available equipment's central heating
     */
    public AvailableEquipment(int airConditioning, int centralHeating) {
        this.airConditioning = airConditioning;
        this.centralHeating = centralHeating;
    }

    public AvailableEquipment (){
        this.airConditioning = 0;
        this.centralHeating = 0;
    }

    /**
     * Get the available equipment's air conditioning.
     * @return the available equipment's air conditioning
     */
    public int getAirConditioning() {
        return airConditioning;
    }

    /**
     * Get the available equipment's central heating.
     * @return the available equipment's central heating
     */
    public int getCentralHeating() {
        return centralHeating;
    }

    @Override
    public String toString() {
        return "\nAir Conditioning: " + airConditioning + "\nCentral Heating: " + centralHeating;
    }
}
