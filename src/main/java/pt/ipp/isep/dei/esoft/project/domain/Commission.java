package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;

/**
 * Represents a commission through fixed ammount and percentage attributes.
 */
public class Commission implements Serializable {
    private static final double FIXED_AMMOUNT_BY_DEFAULT = -1;
    private static final int PERCENTAGE_BY_DEFAULT = -1;
    private double fixedAmmount;
    private int percentage;

    /**
     * Builds an instance of Commission with a given fixed ammount and percentage.
     * @param fixedAmmount the commission's fixed ammount
     * @param percentage the commission's percentage
     */
    public Commission(double fixedAmmount, int percentage){
        this.fixedAmmount = fixedAmmount;
        this.percentage = percentage;
    }

    /**
     * Builds an instance of Commission with a given fixed ammount.
     * @param fixedAmmount the commission's fixed ammount
     */
    public Commission(double fixedAmmount){
        this.fixedAmmount = fixedAmmount;
        percentage = PERCENTAGE_BY_DEFAULT;
    }

    /**
     * Builds an instance of Commission with a given percentage.
     * @param percentage the commission's percentage
     */
    public Commission(int percentage){
        this.percentage = percentage;
        fixedAmmount = FIXED_AMMOUNT_BY_DEFAULT;
    }

    public Commission(){
        this.fixedAmmount = FIXED_AMMOUNT_BY_DEFAULT;
    }

    /**
     * Get the commission's fixed ammount.
     * @return the commission's fixed ammount
     */
    public double getFixedAmmount(){
        return this.fixedAmmount;
    }

    /**
     * Get the commission's percentage.
     * @return the commission's percentage
     */
    public int getPercentage(){
        return this.percentage;
    }

    @Override
    public String toString() {
        if (fixedAmmount == -1){
            return "Percentage = " + percentage;
        } else if(percentage == -1){
            return "Fixed ammount = " + fixedAmmount;
        }
        return null;
    }
}
