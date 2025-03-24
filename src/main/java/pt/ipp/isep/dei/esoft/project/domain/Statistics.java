package pt.ipp.isep.dei.esoft.project.domain;

import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import pt.ipp.isep.dei.esoft.project.DTO.DealsDTO;
import org.apache.commons.math3.distribution.TDistribution;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * The Statistics class is responsible for performing statistical calculations related to simple regression analysis.
 * It provides methods to calculate regression results for two different variables: area and distance from the city.
 * The class follows the singleton design pattern to ensure only one instance is created.
 */
public class Statistics implements Serializable {
    private static final Statistics instance = new Statistics();
    private ArrayList<Double> forecastedPrices = new ArrayList<>();
    private double intercept;
    private double slope;
    private double correlationCoefficient;
    private double determinationCoefficient;
    private double adjustedDeterminationCoefficient;
    private double slopeStandardError;
    private double interceptStandardError;
    private double alfa;
    private int n;
    private double[][] confidenceIntervals = new double[3][2];
    private boolean[] rejects = new boolean[2];
    private double totalSumOfSquares;
    private double residualSumOfSquares;
    private double regressionSumOfSquares;
    private int totalDegreesOfFreedom;
    private double regressionMeanSquare;
    private double residualMeanSquare;
    private int regressionDegreesOfFreedom;
    private int residualDegreesOfFreedom;
    private double fValue;
    private double criticalValue;
    private double interceptTValue;
    private double[] coefficientLowerBounds = new double[6];
    private double[] coefficientUpperBounds = new double[6];
    private double[] standardErrors;
    private double meanSquareRegression;
    private double interceptCriticalValue;
    private double slopeCriticalValue;
    private double explainedSumOfSquares;
    private double degreesOfFreedomR;
    private double degreesOfFreedomRSS;
    private double degreesOfFreedomTSS;
    private double meanSquaredError;
    private double multipleCriticalValue;
    private double[][] covarianceMatrix;
    private double[] estimatedCoefficient;
    private double[] testStatistics;
    //private List<String> output = new ArrayList<>();

    /**
     * Returns the singleton instance of the Statistics class.
     *
     * @return The singleton instance.
     */
    public static Statistics getInstance() {
        return instance;
    }

    /**
     * Calculates the regression analysis results for the variable "area" using the provided list of DealsDTO objects.
     *
     * @param deals           The list of DealsDTO objects containing the data for regression analysis.
     * @param confidenceLevel The confidence level for the calculations.
     * @return A list of strings representing the calculated regression results.
     */
    public List<String> calcSimpleRegressionArea(List<DealsDTO> deals, double confidenceLevel) {
        List<String> output = new ArrayList<>();
        SimpleRegression regression = new SimpleRegression();
        //Forecast Prices
        for (DealsDTO deal : deals) {
            regression.addData(deal.getAdvertisement().getProperty().getArea(), deal.getSale());
        }

        if (!forecastedPrices.isEmpty()) {
            forecastedPrices.clear();
        }
        for (DealsDTO deal : deals) {
            forecastedPrices.add(regression.predict(deal.getAdvertisement().getProperty().getArea()));
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        StringBuilder formattedNumbers = new StringBuilder();

        for (double forecastPrice : forecastedPrices) {
            String formattedNumber = decimalFormat.format(forecastPrice);
            formattedNumbers.append(formattedNumber).append("; ");
            output.add(formattedNumber);
        }

        output.add("Next");

        if (formattedNumbers.length() > 0) {
            formattedNumbers.setLength(formattedNumbers.length() - 2);
        }

        //R, R^2 and adjusted R^2
        correlationCoefficient = regression.getR();
        determinationCoefficient = regression.getRSquare();
        adjustedDeterminationCoefficient = 1 - (1 - determinationCoefficient) * (deals.size() - 1) / (deals.size() - 2 - 1);

        //Confidence Interval
        slopeStandardError = regression.getSlopeStdErr();
        slope = regression.getSlope();
        confidenceLevel = confidenceLevel / 100;
        alfa = 1 - confidenceLevel;
        n = deals.size();
        residualDegreesOfFreedom = n - 2;
        intercept = regression.getIntercept();
        TDistribution tDistribution = new TDistribution(residualDegreesOfFreedom);

        interceptStandardError = regression.getInterceptStdErr();
        double interceptLowerBound = intercept - tDistribution.inverseCumulativeProbability(1 - alfa / 2) * interceptStandardError;
        double interceptUpperBound = intercept + tDistribution.inverseCumulativeProbability(1 - alfa / 2) * interceptStandardError;
        confidenceIntervals[0][0] = interceptLowerBound;
        confidenceIntervals[1][1] = interceptUpperBound;

        double slopeLowerBound = regression.getSlope() - tDistribution.inverseCumulativeProbability(1 - alfa / 2) * slopeStandardError;
        double slopeUpperBound = regression.getSlope() + tDistribution.inverseCumulativeProbability(1 - alfa / 2) * slopeStandardError;
        confidenceIntervals[2][0] = slopeLowerBound;
        confidenceIntervals[2][1] = slopeUpperBound;

        //Hyphotesis Test
        double a0 = 0;
        double b0 = 0;
        boolean interceptReject;
        boolean slopeReject;
        intercept = regression.getIntercept();
        double interceptTValue = (intercept - a0) / interceptStandardError;
        interceptCriticalValue = tDistribution.inverseCumulativeProbability(1 - alfa / 2);

        if (Math.abs(interceptTValue) > interceptCriticalValue) {
            interceptReject = true;
        } else {
            interceptReject = false;
        }

        slope = regression.getSlope();
        double slopeTValue = (slope - b0) / slopeStandardError;
        slopeCriticalValue = tDistribution.inverseCumulativeProbability(1 - (alfa / 2));

        if (Math.abs(slopeTValue) > slopeCriticalValue) {
            slopeReject = true;
        } else {
            slopeReject = false;
        }

        rejects[0] = interceptReject;
        rejects[1] = slopeReject;

        //Anova
        totalSumOfSquares = regression.getTotalSumSquares();
        regressionSumOfSquares = regression.getRegressionSumSquares();
        residualSumOfSquares = regression.getSumSquaredErrors();

        totalDegreesOfFreedom = n - 1;
        regressionDegreesOfFreedom = 1;
        residualDegreesOfFreedom = n - 2;

        regressionMeanSquare = regressionSumOfSquares / regressionDegreesOfFreedom;
        residualMeanSquare = residualSumOfSquares / residualDegreesOfFreedom;

        fValue = regressionMeanSquare / residualMeanSquare;
        FDistribution fDistribution = new FDistribution(regressionDegreesOfFreedom, residualDegreesOfFreedom);
        criticalValue = fDistribution.inverseCumulativeProbability(1 - alfa);

        output.add(String.valueOf(intercept));
        output.add(String.valueOf(slope));

        output.add(String.valueOf(correlationCoefficient));
        output.add(String.valueOf(determinationCoefficient));

        output.add(String.valueOf(interceptLowerBound));
        output.add(String.valueOf(interceptUpperBound));

        output.add(String.valueOf(slopeLowerBound));
        output.add(String.valueOf(slopeUpperBound));

        output.add(String.valueOf(interceptTValue));
        output.add(String.valueOf(interceptCriticalValue));
        output.add(String.valueOf(interceptReject));

        output.add(String.valueOf(slopeTValue));
        output.add(String.valueOf(slopeCriticalValue));
        output.add(String.valueOf(slopeReject));

        output.add(String.valueOf(regressionDegreesOfFreedom));
        output.add(String.valueOf(regressionSumOfSquares));
        output.add(String.valueOf(regressionMeanSquare));
        output.add(String.valueOf(fValue));
        output.add(String.valueOf(residualDegreesOfFreedom));
        output.add(String.valueOf(residualSumOfSquares));
        output.add(String.valueOf(residualMeanSquare));
        output.add(String.valueOf(totalDegreesOfFreedom));
        output.add(String.valueOf(totalSumOfSquares));

        return output;
    }

    /**
     * Calculates the regression analysis results for the variable "distance from the city" using the provided list of DealsDTO objects.
     *
     * @param deals           The list of DealsDTO objects containing the data for regression analysis.
     * @param confidenceLevel The confidence level for the calculations.
     * @return A list of strings representing the calculated regression results.
     */
    public List<String> calcSimpleRegressionDistance(List<DealsDTO> deals, double confidenceLevel) {
        List<String> output = new ArrayList<>();
        SimpleRegression regression = new SimpleRegression();
        //Forecast Prices
        for (DealsDTO deal : deals) {
            regression.addData(deal.getAdvertisement().getProperty().getDistanceFromCity(), deal.getSale());
        }
        if (!forecastedPrices.isEmpty()) {
            forecastedPrices.clear();
        }
        for (DealsDTO deal : deals) {
            forecastedPrices.add(regression.predict(deal.getAdvertisement().getProperty().getDistanceFromCity()));
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        StringBuilder formattedNumbers = new StringBuilder();

        for (double forecastPrice : forecastedPrices) {
            String formattedNumber = decimalFormat.format(forecastPrice);
            formattedNumbers.append(formattedNumber).append("; ");
            output.add(formattedNumber);
        }

        output.add("Next");

        if (formattedNumbers.length() > 0) {
            formattedNumbers.setLength(formattedNumbers.length() - 2);
        }

        //R, R^2 and adjusted R^2
        correlationCoefficient = regression.getR();
        determinationCoefficient = regression.getRSquare();
        adjustedDeterminationCoefficient = 1 - (1 - determinationCoefficient) * (deals.size() - 1) / (deals.size() - 2 - 1);

        //Confidence Interval
        slopeStandardError = regression.getSlopeStdErr();
        slope = regression.getSlope();
        confidenceLevel = confidenceLevel / 100;
        alfa = 1 - confidenceLevel;
        n = deals.size();
        residualDegreesOfFreedom = n - 2;
        intercept = regression.getIntercept();
        TDistribution tDistribution = new TDistribution(residualDegreesOfFreedom);

        interceptStandardError = regression.getInterceptStdErr();
        double interceptLowerBound = intercept - tDistribution.inverseCumulativeProbability(1 - alfa / 2) * interceptStandardError;
        double interceptUpperBound = intercept + tDistribution.inverseCumulativeProbability(1 - alfa / 2) * interceptStandardError;
        confidenceIntervals[1][0] = interceptLowerBound;
        confidenceIntervals[1][1] = interceptUpperBound;

        double slopeLowerBound = regression.getSlope() - tDistribution.inverseCumulativeProbability(1 - alfa / 2) * slopeStandardError;
        double slopeUpperBound = regression.getSlope() + tDistribution.inverseCumulativeProbability(1 - alfa / 2) * slopeStandardError;
        confidenceIntervals[2][0] = slopeLowerBound;
        confidenceIntervals[2][1] = slopeUpperBound;

        //Hyphotesis Test
        double a0 = 0;
        double b0 = 0;
        boolean interceptReject;
        boolean slopeReject;
        intercept = regression.getIntercept();
        double interceptTValue = (intercept - a0) / interceptStandardError;
        interceptCriticalValue = tDistribution.inverseCumulativeProbability(1 - alfa / 2);

        if (Math.abs(interceptTValue) > interceptCriticalValue) {
            interceptReject = true;
        } else {
            interceptReject = false;
        }

        slope = regression.getSlope();
        double slopeTValue = (slope - b0) / slopeStandardError;
        slopeCriticalValue = tDistribution.inverseCumulativeProbability(1 - (alfa / 2));

        if (Math.abs(slopeTValue) > slopeCriticalValue) {
            slopeReject = true;
        } else {
            slopeReject = false;
        }

        rejects[0] = interceptReject;
        rejects[1] = slopeReject;

        //Anova
        totalSumOfSquares = regression.getTotalSumSquares();
        regressionSumOfSquares = regression.getRegressionSumSquares();
        residualSumOfSquares = regression.getSumSquaredErrors();

        totalDegreesOfFreedom = n - 1;
        regressionDegreesOfFreedom = 1;
        residualDegreesOfFreedom = n - 2;

        regressionMeanSquare = regressionSumOfSquares / regressionDegreesOfFreedom;
        residualMeanSquare = residualSumOfSquares / residualDegreesOfFreedom;

        fValue = regressionMeanSquare / residualMeanSquare;
        FDistribution fDistribution = new FDistribution(regressionDegreesOfFreedom, residualDegreesOfFreedom);
        criticalValue = fDistribution.inverseCumulativeProbability(1 - alfa);

        output.add(String.valueOf(intercept));
        output.add(String.valueOf(slope));

        output.add(String.valueOf(correlationCoefficient));
        output.add(String.valueOf(determinationCoefficient));

        output.add(String.valueOf(interceptLowerBound));
        output.add(String.valueOf(interceptUpperBound));

        output.add(String.valueOf(slopeLowerBound));
        output.add(String.valueOf(slopeUpperBound));

        output.add(String.valueOf(interceptTValue));
        output.add(String.valueOf(interceptCriticalValue));
        output.add(String.valueOf(interceptReject));

        output.add(String.valueOf(slopeTValue));
        output.add(String.valueOf(slopeCriticalValue));
        output.add(String.valueOf(slopeReject));

        output.add(String.valueOf(regressionDegreesOfFreedom));
        output.add(String.valueOf(regressionSumOfSquares));
        output.add(String.valueOf(regressionMeanSquare));
        output.add(String.valueOf(fValue));
        output.add(String.valueOf(residualDegreesOfFreedom));
        output.add(String.valueOf(residualSumOfSquares));
        output.add(String.valueOf(residualMeanSquare));
        output.add(String.valueOf(totalDegreesOfFreedom));
        output.add(String.valueOf(totalSumOfSquares));

        return output;
    }

    /**
     * Calculates simple regression for the number of bedrooms.
     *
     * @param deals           a list of DealsDTO objects representing the deals
     * @param confidenceLevel the confidence level for the regression analysis
     * @return a list of strings containing the forecasted prices and regression analysis results
     */
    public List<String> calcSimpleRegressionBedrooms(List<DealsDTO> deals, double confidenceLevel) {
        List<String> output = new ArrayList<>();
        SimpleRegression regression = new SimpleRegression();
        for (DealsDTO deal : deals) {
            if (deal.getAdvertisement().getProperty() instanceof House) {
                regression.addData(((House) deal.getAdvertisement().getProperty()).getNumberBedrooms(), deal.getSale());
            } else if (deal.getAdvertisement().getProperty() instanceof Residence) {
                regression.addData(((Residence) deal.getAdvertisement().getProperty()).getNumberBedrooms(), deal.getSale());
            }

        }
        if (!forecastedPrices.isEmpty()) {
            forecastedPrices.clear();
        }
        for (DealsDTO deal : deals) {
            if (deal.getAdvertisement().getProperty() instanceof House) {
                forecastedPrices.add(regression.predict(((House) deal.getAdvertisement().getProperty()).getNumberBedrooms()));
            } else if (deal.getAdvertisement().getProperty() instanceof Residence) {
                forecastedPrices.add(regression.predict(((Residence) deal.getAdvertisement().getProperty()).getNumberBedrooms()));
            }

        }

        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        StringBuilder formattedNumbers = new StringBuilder();

        for (double forecastPrice : forecastedPrices) {
            String formattedNumber = decimalFormat.format(forecastPrice);
            formattedNumbers.append(formattedNumber).append("; ");
            output.add(formattedNumber);
        }

        output.add("Next");

        if (formattedNumbers.length() > 0) {
            formattedNumbers.setLength(formattedNumbers.length() - 2);
        }

        //R, R^2 and adjusted R^2
        correlationCoefficient = regression.getR();
        determinationCoefficient = regression.getRSquare();
        adjustedDeterminationCoefficient = 1 - (1 - determinationCoefficient) * (deals.size() - 1) / (deals.size() - 2 - 1);

        //Confidence Interval
        slopeStandardError = regression.getSlopeStdErr();
        slope = regression.getSlope();
        confidenceLevel = confidenceLevel / 100;
        alfa = 1 - confidenceLevel;
        n = deals.size();
        residualDegreesOfFreedom = n - 2;
        intercept = regression.getIntercept();
        TDistribution tDistribution = new TDistribution(residualDegreesOfFreedom);

        interceptStandardError = regression.getInterceptStdErr();
        double interceptLowerBound = intercept - tDistribution.inverseCumulativeProbability(1 - alfa / 2) * interceptStandardError;
        double interceptUpperBound = intercept + tDistribution.inverseCumulativeProbability(1 - alfa / 2) * interceptStandardError;
        confidenceIntervals[1][0] = interceptLowerBound;
        confidenceIntervals[1][1] = interceptUpperBound;

        double slopeLowerBound = regression.getSlope() - tDistribution.inverseCumulativeProbability(1 - alfa / 2) * slopeStandardError;
        double slopeUpperBound = regression.getSlope() + tDistribution.inverseCumulativeProbability(1 - alfa / 2) * slopeStandardError;
        confidenceIntervals[2][0] = slopeLowerBound;
        confidenceIntervals[2][1] = slopeUpperBound;

        //Hyphotesis Test
        double a0 = 0;
        double b0 = 0;
        boolean interceptReject;
        boolean slopeReject;
        intercept = regression.getIntercept();
        double interceptTValue = (intercept - a0) / interceptStandardError;
        interceptCriticalValue = tDistribution.inverseCumulativeProbability(1 - alfa / 2);

        if (Math.abs(interceptTValue) > interceptCriticalValue) {
            interceptReject = true;
        } else {
            interceptReject = false;
        }

        slope = regression.getSlope();
        double slopeTValue = (slope - b0) / slopeStandardError;
        slopeCriticalValue = tDistribution.inverseCumulativeProbability(1 - (alfa / 2));

        if (Math.abs(slopeTValue) > slopeCriticalValue) {
            slopeReject = true;
        } else {
            slopeReject = false;
        }

        rejects[0] = interceptReject;
        rejects[1] = slopeReject;

        //Anova
        totalSumOfSquares = regression.getTotalSumSquares();
        regressionSumOfSquares = regression.getRegressionSumSquares();
        residualSumOfSquares = regression.getSumSquaredErrors();

        totalDegreesOfFreedom = n - 1;
        regressionDegreesOfFreedom = 1;
        residualDegreesOfFreedom = n - 2;

        regressionMeanSquare = regressionSumOfSquares / regressionDegreesOfFreedom;
        residualMeanSquare = residualSumOfSquares / residualDegreesOfFreedom;

        fValue = regressionMeanSquare / residualMeanSquare;
        FDistribution fDistribution = new FDistribution(regressionDegreesOfFreedom, residualDegreesOfFreedom);
        criticalValue = fDistribution.inverseCumulativeProbability(1 - alfa);

        output.add(String.valueOf(intercept));
        output.add(String.valueOf(slope));

        output.add(String.valueOf(correlationCoefficient));
        output.add(String.valueOf(determinationCoefficient));

        output.add(String.valueOf(interceptLowerBound));
        output.add(String.valueOf(interceptUpperBound));

        output.add(String.valueOf(slopeLowerBound));
        output.add(String.valueOf(slopeUpperBound));

        output.add(String.valueOf(interceptTValue));
        output.add(String.valueOf(interceptCriticalValue));
        output.add(String.valueOf(interceptReject));

        output.add(String.valueOf(slopeTValue));
        output.add(String.valueOf(slopeCriticalValue));
        output.add(String.valueOf(slopeReject));

        output.add(String.valueOf(regressionDegreesOfFreedom));
        output.add(String.valueOf(regressionSumOfSquares));
        output.add(String.valueOf(regressionMeanSquare));
        output.add(String.valueOf(fValue));
        output.add(String.valueOf(residualDegreesOfFreedom));
        output.add(String.valueOf(residualSumOfSquares));
        output.add(String.valueOf(residualMeanSquare));
        output.add(String.valueOf(totalDegreesOfFreedom));
        output.add(String.valueOf(totalSumOfSquares));

        return output;
    }

    /**
     * Calculates simple regression for the number of bathrooms.
     *
     * @param deals           a list of DealsDTO objects representing the deals
     * @param confidenceLevel the confidence level for the regression analysis
     * @return a list of strings containing the forecasted prices and regression analysis results
     */
    public List<String> calcSimpleRegressionBathrooms(List<DealsDTO> deals, double confidenceLevel) {
        List<String> output = new ArrayList<>();
        SimpleRegression regression = new SimpleRegression();
        for (DealsDTO deal : deals) {
            if (deal.getAdvertisement().getProperty() instanceof House) {
                regression.addData(((House) deal.getAdvertisement().getProperty()).getNumberBathrooms(), deal.getSale());
            } else if (deal.getAdvertisement().getProperty() instanceof Residence) {
                regression.addData(((Residence) deal.getAdvertisement().getProperty()).getNumberBathrooms(), deal.getSale());
            }
        }
        if (!forecastedPrices.isEmpty()) {
            forecastedPrices.clear();
        }
        for (DealsDTO deal : deals) {
            if (deal.getAdvertisement().getProperty() instanceof House) {
                forecastedPrices.add(regression.predict(((House) deal.getAdvertisement().getProperty()).getNumberBathrooms()));
            } else if (deal.getAdvertisement().getProperty() instanceof Residence) {
                forecastedPrices.add(regression.predict(((Residence) deal.getAdvertisement().getProperty()).getNumberBathrooms()));
            }
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        StringBuilder formattedNumbers = new StringBuilder();

        for (double forecastPrice : forecastedPrices) {
            String formattedNumber = decimalFormat.format(forecastPrice);
            formattedNumbers.append(formattedNumber).append("; ");
            output.add(formattedNumber);
        }

        output.add("Next");

        if (formattedNumbers.length() > 0) {
            formattedNumbers.setLength(formattedNumbers.length() - 2);
        }

        //R, R^2 and adjusted R^2
        correlationCoefficient = regression.getR();
        determinationCoefficient = regression.getRSquare();
        adjustedDeterminationCoefficient = 1 - (1 - determinationCoefficient) * (deals.size() - 1) / (deals.size() - 2 - 1);

        //Confidence Interval
        slopeStandardError = regression.getSlopeStdErr();
        slope = regression.getSlope();
        confidenceLevel = confidenceLevel / 100;
        alfa = 1 - confidenceLevel;
        n = deals.size();
        residualDegreesOfFreedom = n - 2;
        intercept = regression.getIntercept();
        TDistribution tDistribution = new TDistribution(residualDegreesOfFreedom);

        interceptStandardError = regression.getInterceptStdErr();
        double interceptLowerBound = intercept - tDistribution.inverseCumulativeProbability(1 - alfa / 2) * interceptStandardError;
        double interceptUpperBound = intercept + tDistribution.inverseCumulativeProbability(1 - alfa / 2) * interceptStandardError;
        confidenceIntervals[1][0] = interceptLowerBound;
        confidenceIntervals[1][1] = interceptUpperBound;

        double slopeLowerBound = regression.getSlope() - tDistribution.inverseCumulativeProbability(1 - alfa / 2) * slopeStandardError;
        double slopeUpperBound = regression.getSlope() + tDistribution.inverseCumulativeProbability(1 - alfa / 2) * slopeStandardError;
        confidenceIntervals[2][0] = slopeLowerBound;
        confidenceIntervals[2][1] = slopeUpperBound;

        //Hyphotesis Test
        double a0 = 0;
        double b0 = 0;
        boolean interceptReject;
        boolean slopeReject;
        intercept = regression.getIntercept();
        double interceptTValue = (intercept - a0) / interceptStandardError;
        interceptCriticalValue = tDistribution.inverseCumulativeProbability(1 - alfa / 2);

        if (Math.abs(interceptTValue) > interceptCriticalValue) {
            interceptReject = true;
        } else {
            interceptReject = false;
        }

        slope = regression.getSlope();
        double slopeTValue = (slope - b0) / slopeStandardError;
        slopeCriticalValue = tDistribution.inverseCumulativeProbability(1 - (alfa / 2));

        if (Math.abs(slopeTValue) > slopeCriticalValue) {
            slopeReject = true;
        } else {
            slopeReject = false;
        }

        rejects[0] = interceptReject;
        rejects[1] = slopeReject;

        //Anova
        totalSumOfSquares = regression.getTotalSumSquares();
        regressionSumOfSquares = regression.getRegressionSumSquares();
        residualSumOfSquares = regression.getSumSquaredErrors();

        totalDegreesOfFreedom = n - 1;
        regressionDegreesOfFreedom = 1;
        residualDegreesOfFreedom = n - 2;

        regressionMeanSquare = regressionSumOfSquares / regressionDegreesOfFreedom;
        residualMeanSquare = residualSumOfSquares / residualDegreesOfFreedom;

        fValue = regressionMeanSquare / residualMeanSquare;
        FDistribution fDistribution = new FDistribution(regressionDegreesOfFreedom, residualDegreesOfFreedom);
        criticalValue = fDistribution.inverseCumulativeProbability(1 - alfa);

        output.add(String.valueOf(intercept));
        output.add(String.valueOf(slope));

        output.add(String.valueOf(correlationCoefficient));
        output.add(String.valueOf(determinationCoefficient));

        output.add(String.valueOf(interceptLowerBound));
        output.add(String.valueOf(interceptUpperBound));

        output.add(String.valueOf(slopeLowerBound));
        output.add(String.valueOf(slopeUpperBound));

        output.add(String.valueOf(interceptTValue));
        output.add(String.valueOf(interceptCriticalValue));
        output.add(String.valueOf(interceptReject));

        output.add(String.valueOf(slopeTValue));
        output.add(String.valueOf(slopeCriticalValue));
        output.add(String.valueOf(slopeReject));

        output.add(String.valueOf(regressionDegreesOfFreedom));
        output.add(String.valueOf(regressionSumOfSquares));
        output.add(String.valueOf(regressionMeanSquare));
        output.add(String.valueOf(fValue));
        output.add(String.valueOf(residualDegreesOfFreedom));
        output.add(String.valueOf(residualSumOfSquares));
        output.add(String.valueOf(residualMeanSquare));
        output.add(String.valueOf(totalDegreesOfFreedom));
        output.add(String.valueOf(totalSumOfSquares));

        return output;
    }

    /**
     * Calculates simple regression for the number of parking spaces.
     *
     * @param deals           a list of DealsDTO objects representing the deals
     * @param confidenceLevel the confidence level for the regression analysis
     * @return a list of strings containing the forecasted prices and regression analysis results
     */
    public List<String> calcSimpleRegressionParkingSpaces(List<DealsDTO> deals, double confidenceLevel) {
        List<String> output = new ArrayList<>();
        SimpleRegression regression = new SimpleRegression();
        for (DealsDTO deal : deals) {
            if (deal.getAdvertisement().getProperty() instanceof House) {
                regression.addData(((House) deal.getAdvertisement().getProperty()).getNumberParkingSpaces(), deal.getSale());
            } else if (deal.getAdvertisement().getProperty() instanceof Residence) {
                regression.addData(((Residence) deal.getAdvertisement().getProperty()).getNumberParkingSpaces(), deal.getSale());
            }
        }
        if (!forecastedPrices.isEmpty()) {
            forecastedPrices.clear();
        }
        for (DealsDTO deal : deals) {
            if (deal.getAdvertisement().getProperty() instanceof House) {
                forecastedPrices.add(regression.predict(((House) deal.getAdvertisement().getProperty()).getNumberParkingSpaces()));
            } else if (deal.getAdvertisement().getProperty() instanceof Residence) {
                forecastedPrices.add(regression.predict(((Residence) deal.getAdvertisement().getProperty()).getNumberParkingSpaces()));
            }
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        StringBuilder formattedNumbers = new StringBuilder();

        for (double forecastPrice : forecastedPrices) {
            String formattedNumber = decimalFormat.format(forecastPrice);
            formattedNumbers.append(formattedNumber).append("; ");
            output.add(formattedNumber);
        }

        output.add("Next");

        if (formattedNumbers.length() > 0) {
            formattedNumbers.setLength(formattedNumbers.length() - 2);
        }

        //System.out.println("Forecasted Prices: " + forecastedPrices);

        //R, R^2 and adjusted R^2
        correlationCoefficient = regression.getR();
        determinationCoefficient = regression.getRSquare();
        adjustedDeterminationCoefficient = 1 - (1 - determinationCoefficient) * (deals.size() - 1) / (deals.size() - 2 - 1);

        //Confidence Interval
        slopeStandardError = regression.getSlopeStdErr();
        slope = regression.getSlope();
        confidenceLevel = confidenceLevel / 100;
        alfa = 1 - confidenceLevel;
        n = deals.size();
        residualDegreesOfFreedom = n - 2;
        intercept = regression.getIntercept();
        TDistribution tDistribution = new TDistribution(residualDegreesOfFreedom);

        interceptStandardError = regression.getInterceptStdErr();
        double interceptLowerBound = intercept - tDistribution.inverseCumulativeProbability(1 - alfa / 2) * interceptStandardError;
        double interceptUpperBound = intercept + tDistribution.inverseCumulativeProbability(1 - alfa / 2) * interceptStandardError;
        confidenceIntervals[1][0] = interceptLowerBound;
        confidenceIntervals[1][1] = interceptUpperBound;

        double slopeLowerBound = regression.getSlope() - tDistribution.inverseCumulativeProbability(1 - alfa / 2) * slopeStandardError;
        double slopeUpperBound = regression.getSlope() + tDistribution.inverseCumulativeProbability(1 - alfa / 2) * slopeStandardError;
        confidenceIntervals[2][0] = slopeLowerBound;
        confidenceIntervals[2][1] = slopeUpperBound;

        //Hyphotesis Test
        double a0 = 0;
        double b0 = 0;
        boolean interceptReject;
        boolean slopeReject;
        intercept = regression.getIntercept();
        double interceptTValue = (intercept - a0) / interceptStandardError;
        interceptCriticalValue = tDistribution.inverseCumulativeProbability(1 - alfa / 2);

        if (Math.abs(interceptTValue) > interceptCriticalValue) {
            interceptReject = true;
        } else {
            interceptReject = false;
        }

        slope = regression.getSlope();
        double slopeTValue = (slope - b0) / slopeStandardError;
        slopeCriticalValue = tDistribution.inverseCumulativeProbability(1 - (alfa / 2));

        if (Math.abs(slopeTValue) > slopeCriticalValue) {
            slopeReject = true;
        } else {
            slopeReject = false;
        }

        rejects[0] = interceptReject;
        rejects[1] = slopeReject;

        //Anova
        totalSumOfSquares = regression.getTotalSumSquares();
        regressionSumOfSquares = regression.getRegressionSumSquares();
        residualSumOfSquares = regression.getSumSquaredErrors();

        totalDegreesOfFreedom = n - 1;
        regressionDegreesOfFreedom = 1;
        residualDegreesOfFreedom = n - 2;

        regressionMeanSquare = regressionSumOfSquares / regressionDegreesOfFreedom;
        residualMeanSquare = residualSumOfSquares / residualDegreesOfFreedom;

        fValue = regressionMeanSquare / residualMeanSquare;
        FDistribution fDistribution = new FDistribution(regressionDegreesOfFreedom, residualDegreesOfFreedom);
        criticalValue = fDistribution.inverseCumulativeProbability(1 - alfa);

        output.add(String.valueOf(intercept));
        output.add(String.valueOf(slope));

        output.add(String.valueOf(correlationCoefficient));
        output.add(String.valueOf(determinationCoefficient));

        output.add(String.valueOf(interceptLowerBound));
        output.add(String.valueOf(interceptUpperBound));

        output.add(String.valueOf(slopeLowerBound));
        output.add(String.valueOf(slopeUpperBound));

        output.add(String.valueOf(interceptTValue));
        output.add(String.valueOf(interceptCriticalValue));
        output.add(String.valueOf(interceptReject));

        output.add(String.valueOf(slopeTValue));
        output.add(String.valueOf(slopeCriticalValue));
        output.add(String.valueOf(slopeReject));

        output.add(String.valueOf(regressionDegreesOfFreedom));
        output.add(String.valueOf(regressionSumOfSquares));
        output.add(String.valueOf(regressionMeanSquare));
        output.add(String.valueOf(fValue));
        output.add(String.valueOf(residualDegreesOfFreedom));
        output.add(String.valueOf(residualSumOfSquares));
        output.add(String.valueOf(residualMeanSquare));
        output.add(String.valueOf(totalDegreesOfFreedom));
        output.add(String.valueOf(totalSumOfSquares));

        return output;
    }

    public List<String> calcMultipleRegression(List<DealsDTO> deals, double confidenceLevel) {
        List<String> output = new ArrayList<>();
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();

        confidenceLevel = confidenceLevel / 100;
        n = deals.size();
        double[][] independentVariables = new double[deals.size()][5];
        double[] dependentVariable = new double[deals.size()];

        for (int i = 0; i < deals.size(); i++) {
            DealsDTO deal = deals.get(i);
            independentVariables[i][0] = deal.getAdvertisement().getProperty().getArea();
            independentVariables[i][1] = deal.getAdvertisement().getProperty().getDistanceFromCity();
            if (deal.getAdvertisement().getProperty() instanceof House) {
                independentVariables[i][2] = ((House) deal.getAdvertisement().getProperty()).getNumberBedrooms();
                independentVariables[i][3] = ((House) deal.getAdvertisement().getProperty()).getNumberBathrooms();
                independentVariables[i][4] = ((House) deal.getAdvertisement().getProperty()).getNumberParkingSpaces();
            } else if (deal.getAdvertisement().getProperty() instanceof Residence) {
                independentVariables[i][2] = ((Residence) deal.getAdvertisement().getProperty()).getNumberBedrooms();
                independentVariables[i][3] = ((Residence) deal.getAdvertisement().getProperty()).getNumberBathrooms();
                independentVariables[i][4] = ((Residence) deal.getAdvertisement().getProperty()).getNumberParkingSpaces();
            }
            dependentVariable[i] = deal.getSale();
        }

        regression.newSampleData(dependentVariable, independentVariables);

        // General Data
        double[] coefficients = regression.estimateRegressionParameters();
        determinationCoefficient = regression.calculateRSquared();
        adjustedDeterminationCoefficient = regression.calculateAdjustedRSquared();
        standardErrors = regression.estimateRegressionParametersStandardErrors();
        estimatedCoefficient = regression.estimateRegressionParameters();
        covarianceMatrix = regression.estimateRegressionParametersVariance();
        alfa = 1 - confidenceLevel;
        int numIndependentVariables = 5;

        //Forecasted Prices
        if (!forecastedPrices.isEmpty()) {
            forecastedPrices.clear();
        }

        for (DealsDTO deal : deals) {
            Property property = deal.getAdvertisement().getProperty();
            double predictedSaleValue = coefficients[0] + coefficients[1] * property.getArea() + coefficients[2] * property.getDistanceFromCity();

            if (property instanceof House) {
                House house = (House) property;
                predictedSaleValue += coefficients[3] * house.getNumberBedrooms() + coefficients[4] * house.getNumberBathrooms()
                        + coefficients[5] * house.getNumberParkingSpaces();
            } else if (property instanceof Residence) {
                Residence apartment = (Residence) property;
                predictedSaleValue += coefficients[3] * apartment.getNumberBedrooms() + coefficients[4] * apartment.getNumberBathrooms()
                        + coefficients[5] * apartment.getNumberParkingSpaces();
            }

            forecastedPrices.add(predictedSaleValue);
            output.add(String.valueOf(predictedSaleValue));
        }

        output.add("Next");
        output.add(String.valueOf(determinationCoefficient));
        output.add(String.valueOf(adjustedDeterminationCoefficient));

        // Coefficient Intervals
        int numPredictors = 5; // Number of independent variables
        int degreesOfFreedom = n - numPredictors - 1;
        TDistribution tDistribution = new TDistribution(degreesOfFreedom);
        criticalValue = tDistribution.inverseCumulativeProbability(1 - (1 - confidenceLevel) / 2);

        for (int i = 0; i < coefficients.length; i++) {
            double coefficient = coefficients[i];
            double standardError = standardErrors[i];
            coefficientLowerBounds[i] = coefficient - criticalValue * standardError;
            coefficientUpperBounds[i] = coefficient + criticalValue * standardError;
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        StringBuilder formattedNumbers = new StringBuilder();
        StringBuilder formattedNumbers2 = new StringBuilder();

        for (double coefficientLowerBounds : coefficientLowerBounds) {
            String formattedNumber = decimalFormat.format(coefficientLowerBounds);
            formattedNumbers.append(formattedNumber).append("; ");
            output.add(formattedNumber);
        }

        if (formattedNumbers.length() > 0) {
            formattedNumbers.setLength(formattedNumbers.length() - 2);
        }

        for (double coefficientUpperFormat : coefficientUpperBounds) {
            String formattedNumber2 = decimalFormat.format(coefficientUpperFormat);
            formattedNumbers2.append(formattedNumber2).append("; ");
            output.add(formattedNumber2);
        }

        if (formattedNumbers2.length() > 0) {
            formattedNumbers2.setLength(formattedNumbers.length() - 2);
        }

        //ANOVA
        residualSumOfSquares = regression.calculateResidualSumOfSquares();
        explainedSumOfSquares = regression.calculateTotalSumOfSquares() - residualSumOfSquares;
        totalSumOfSquares = regression.calculateTotalSumOfSquares();
        degreesOfFreedomR = 5;
        degreesOfFreedomRSS = n - numIndependentVariables - 1;
        degreesOfFreedomTSS = n - 1;
        meanSquareRegression = explainedSumOfSquares / numIndependentVariables;
        meanSquaredError = residualSumOfSquares / degreesOfFreedomRSS;
        fValue = meanSquareRegression / meanSquaredError;

        FDistribution fDistribution = new FDistribution(numIndependentVariables, n - numIndependentVariables - 1);
        multipleCriticalValue = fDistribution.inverseCumulativeProbability(1 - alfa);

        //Hyphotesis Testing
        testStatistics = new double[estimatedCoefficient.length];

        for (int i = 0; i < estimatedCoefficient.length; i++) {
            double tStat = coefficients[i] / standardErrors[i]; //t0
            testStatistics[i] = estimatedCoefficient[i] / Math.sqrt(meanSquaredError * covarianceMatrix[i][i]);
            output.add(String.valueOf(tStat));
            output.add(String.valueOf(multipleCriticalValue));
        }

        output.add(String.valueOf(explainedSumOfSquares));
        output.add(String.valueOf(degreesOfFreedomR));
        output.add(String.valueOf(meanSquareRegression));
        output.add(String.valueOf(fValue));
        output.add(String.valueOf(residualSumOfSquares));
        output.add(String.valueOf(degreesOfFreedomRSS));
        output.add(String.valueOf(meanSquaredError));
        output.add(String.valueOf(totalSumOfSquares));
        output.add(String.valueOf(degreesOfFreedomTSS));

        return output;
    }
}