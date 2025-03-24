package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.DTO.DealsDTO;
import pt.ipp.isep.dei.esoft.project.domain.Statistics;

import java.io.Serializable;
import java.util.List;

/**
 * Repository class for performing statistical calculations on DealsDTO objects.
 */
public class StaticticsRepository implements Serializable {
    private Statistics statistics = new Statistics();

    /**
     * Calculates the simple regression for the area property of DealsDTO objects.
     *
     * @param deals            The list of DealsDTO objects.
     * @param confidenceLevel  The confidence level for the regression calculation.
     */
    public List<String> calcSimpleRegressionArea(List<DealsDTO> deals, double confidenceLevel) {
        return statistics.calcSimpleRegressionArea(deals, confidenceLevel);
    }

    /**
     * Calculates the simple regression for the distance property of DealsDTO objects.
     *
     * @param deals            The list of DealsDTO objects.
     * @param confidenceLevel  The confidence level for the regression calculation.
     */
    public List<String> calcSimpleRegressionDistance(List<DealsDTO> deals, double confidenceLevel) {
       return statistics.calcSimpleRegressionDistance(deals, confidenceLevel);
    }

    /**
     * Calculates the simple regression for the bedrooms property of DealsDTO objects.
     *
     * @param deals            The list of DealsDTO objects.
     * @param confidenceLevel  The confidence level for the regression calculation.
     */
    public List<String> calcSimpleRegressionBedrooms(List<DealsDTO> deals, double confidenceLevel) {
        return statistics.calcSimpleRegressionBedrooms(deals, confidenceLevel);
    }

    /**
     * Calculates the simple regression for the bathrooms property of DealsDTO objects.
     *
     * @param deals            The list of DealsDTO objects.
     * @param confidenceLevel  The confidence level for the regression calculation.
     */
    public List<String> calcSimpleRegressionBathrooms(List<DealsDTO> deals, double confidenceLevel) {
        return statistics.calcSimpleRegressionBathrooms(deals, confidenceLevel);
    }

    /**
     * Calculates the simple regression for the parking spaces property of DealsDTO objects.
     *
     * @param deals            The list of DealsDTO objects.
     * @param confidenceLevel  The confidence level for the regression calculation.
     */
    public List<String> calcSimpleRegressionParkingSpaces(List<DealsDTO> deals, double confidenceLevel) {
        return statistics.calcSimpleRegressionParkingSpaces(deals, confidenceLevel);
    }

    /**
     * Calculates the multiple regression for the properties of DealsDTO objects.
     *
     * @param deals            The list of DealsDTO objects.
     * @param confidenceLevel  The confidence level for the regression calculation.
     */
    public List<String> calcMultipleRegression(List<DealsDTO> deals, double confidenceLevel) {
        return statistics.calcMultipleRegression(deals, confidenceLevel);
    }
}