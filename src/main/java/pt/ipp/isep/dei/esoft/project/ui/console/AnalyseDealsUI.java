package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.DTO.DealsDTO;
import pt.ipp.isep.dei.esoft.project.application.controller.AnalyseDealsController;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.io.IOException;
import java.util.List;

/**
 * User interface class for analyzing deals.
 */
public class AnalyseDealsUI implements Runnable {

    private final AnalyseDealsController controller = new AnalyseDealsController();

    private int regressionModel;
    private double confidenceLevel;
    private int independentVariable;
    private List<DealsDTO> deals = controller.getDeals();

    /**
     * Runs the analyze deals user interface.
     */
    public void run() {
        try {
            requestData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Requests input data from the user.
     *
     * @throws IOException If an error occurs while reading user input.
     */
    private void requestData() throws IOException {
        regressionModel = displayRegressionModelOptions();
        confidenceLevel = displayConfidenceLevelOptions();
        if (regressionModel == 1) {
            independentVariable = displayIndependentVariableOptions();
            if (independentVariable == 1) {
                controller.calcSimpleRegressionArea(deals, confidenceLevel);
            } else if (independentVariable == 2) {
                controller.calcSimpleRegressionDistance(deals, confidenceLevel);
            } else if (independentVariable == 3) {
                controller.calcSimpleRegressionBedrooms(deals, confidenceLevel);
            } else if (independentVariable == 4) {
                controller.calcSimpleRegressionBathrooms(deals, confidenceLevel);
            } else if (independentVariable == 5) {
                controller.calcSimpleRegressionParkingSpaces(deals, confidenceLevel);
            } else {
                System.out.println("Invalid option. Please try again.");
                requestData();
            }
        } else if (regressionModel == 2) {
            controller.calcMultipleRegression(deals, confidenceLevel);
        } else {
            System.out.println("Invalid option. Please try again.");
            requestData();
        }
    }

    /**
     * Displays the options for selecting the regression model.
     *
     * @return The selected regression model option.
     */
    private int displayRegressionModelOptions() {
        return Utils.readIntegerFromConsole("Do you wish to use a Simple Linear Regression or a Multiple Linear Regression?\n"
                + "1 - Simple Linear Regression\n"
                + "2 - Multiple Linear Regression\n");
    }

    /**
     * Displays the options for selecting the independent variable.
     *
     * @return The selected independent variable option.
     */
    private int displayIndependentVariableOptions() {
        return Utils.readIntegerFromConsole("Please choose a variable to be used as the independent variable.\n"
                + "1 - Area (in square feet)\n"
                + "2 - Distance from city center (in miles)\n"
                + "3 - Number of bedrooms\n"
                + "4 - Number of bathrooms\n"
                + "5 - Number of parking\n");
    }

    /**
     * Displays the options for entering the confidence level.
     *
     * @return The entered confidence level.
     */
    private double displayConfidenceLevelOptions() {
        return Utils.readDoubleFromConsole("Confidence level (must be 90, 95, or 99): ");
    }
}
