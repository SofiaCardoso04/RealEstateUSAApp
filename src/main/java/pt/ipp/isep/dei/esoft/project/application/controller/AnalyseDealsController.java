package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.DTO.DealsDTO;
import pt.ipp.isep.dei.esoft.project.domain.PurchaseOrder;
import pt.ipp.isep.dei.esoft.project.repository.OrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.StaticticsRepository;

import java.text.DecimalFormat;
import java.util.List;

public class AnalyseDealsController {
    private OrderRepository orderRepository;
    private StaticticsRepository statisticsRepository;

    /**
     * Constructs a new AnalyseDealsController.
     * Initializes the orderRepository and statisticsRepository.
     */
    public AnalyseDealsController() {
        getOrderRepository();
        getStatisticsRepository();
    }

    /**
     * Retrieves the OrderRepository instance.
     *
     * @return the OrderRepository instance
     */
    public OrderRepository getOrderRepository() {
        if (orderRepository == null) {
            Repositories repositories = Repositories.getInstance();
            orderRepository = repositories.getOrderRepository();
        }
        return orderRepository;
    }

    /**
     * Retrieves the StatisticsRepository instance.
     *
     * @return the StatisticsRepository instance
     */
    public StaticticsRepository getStatisticsRepository() {
        if (statisticsRepository == null) {
            Repositories repositories = Repositories.getInstance();
            statisticsRepository = repositories.getStaticticsRepository();
        }
        return statisticsRepository;
    }


    /**
     * Retrieves the list of deals.
     *
     * @return the list of DealsDTO instances
     */
    public List<DealsDTO> getDeals() {
        return orderRepository.getDeals();
    }

    /**
     * Calculates the simple regression area based on deals and a confidence level.
     *
     * @param deals            the list of deals
     * @param confidenceLevel  the confidence level
     */
    public void calcSimpleRegressionArea(List<DealsDTO> deals, double confidenceLevel) {
        List<String> statistics = statisticsRepository.calcSimpleRegressionArea(deals, confidenceLevel);
        System.out.println(simpleRegressionToString(statistics, 1));
    }

    /**
     * Calculates the simple regression distance based on deals and a confidence level.
     *
     * @param deals            the list of deals
     * @param confidenceLevel  the confidence level
     */
    public void calcSimpleRegressionDistance(List<DealsDTO> deals, double confidenceLevel) {
        List<String> statistics = statisticsRepository.calcSimpleRegressionDistance(deals, confidenceLevel);
        System.out.println(simpleRegressionToString(statistics, 2));
    }

    /**
     * Calculates the simple regression bedrooms based on deals and a confidence level.
     *
     * @param deals            the list of deals
     * @param confidenceLevel  the confidence level
     */
    public void calcSimpleRegressionBedrooms(List<DealsDTO> deals, double confidenceLevel) {
        List<String> statistics = statisticsRepository.calcSimpleRegressionBedrooms(deals, confidenceLevel);
        System.out.println(simpleRegressionToString(statistics, 3));
    }

    /**
     * Calculates the simple regression bathrooms based on deals and a confidence level.
     *
     * @param deals            the list of deals
     * @param confidenceLevel  the confidence level
     */
    public void calcSimpleRegressionBathrooms(List<DealsDTO> deals, double confidenceLevel) {
        List<String> statistics = statisticsRepository.calcSimpleRegressionBathrooms(deals, confidenceLevel);
        System.out.println(simpleRegressionToString(statistics, 4));
    }

    /**
     * Calculates the simple regression parking spaces based on deals and a confidence level.
     *
     * @param deals            the list of deals
     * @param confidenceLevel  the confidence level
     */
    public void calcSimpleRegressionParkingSpaces(List<DealsDTO> deals, double confidenceLevel) {
        List<String> statistics = statisticsRepository.calcSimpleRegressionParkingSpaces(deals, confidenceLevel);
        System.out.println(simpleRegressionToString(statistics, 5));
    }

    /**
     * Calculates the multiple regression based on deals and a confidence level.
     *
     * @param deals            the list of deals
     * @param confidenceLevel  the confidence level
     */
    public void calcMultipleRegression(List<DealsDTO> deals, double confidenceLevel) {
        List<String> statistics = statisticsRepository.calcMultipleRegression(deals, confidenceLevel);
        System.out.println(multiRegressionToString(statistics));
    }

    public String simpleRegressionToString(List<String> output, int option) {
        List<DealsDTO> deals = getDeals();
        String independentVariable = independentVariableToString(option);


        StringBuilder result = new StringBuilder();
        int i = 0;
        result.append("Forecasted value for ").append(independentVariable).append(":\n");

        while (!output.get(i).equals("Next")) {
            result.append("Property sold for: ").append(deals.get(i).getSale()).append("$").append(" - Forecasted value: ");
            result.append(output.get(i)).append("$").append("\n");
            i++;
        }
        double slope = Double.parseDouble(output.get(i + 1));
        System.out.println(slope);
        double intercept = Double.parseDouble(output.get(i + 2));
        System.out.println(intercept);

        if (slope < 0) {
            result.append("\nFor ").append(independentVariable).append(":\ny^ = ").append(toDecimalFormat(Math.abs(intercept))).append("x - ").append(toDecimalFormat(Math.abs(slope))).append("\n");
        } else {
            result.append("\nFor ").append(independentVariable).append(":\ny^ = ").append(toDecimalFormat(Math.abs(intercept))).append("x + ").append(toDecimalFormat(Math.abs(slope))).append("\n");
        }

        double correlationCoefficient = Double.parseDouble(output.get(i + 3));
        double determinationCoefficient = Double.parseDouble(output.get(i + 4));

        result.append("\nR = ").append(toDecimalFormat(correlationCoefficient)).append("\n");
        result.append("R^2 = ").append(toDecimalFormat(determinationCoefficient)).append("\n");

        double interceptLowerBound = Double.parseDouble(output.get(i + 5));
        double interceptUpperBound = Double.parseDouble(output.get(i + 6));

        result.append("\nThe confidence interval for a^ is ]").append(toDecimalFormat(interceptLowerBound)).append(" ; ").append(toDecimalFormat(interceptUpperBound)).append("[\n");

        double slopeLowerBound = Double.parseDouble(output.get(i + 7));
        double slopeUpperBound = Double.parseDouble(output.get(i + 8));

        result.append("The confidence interval for b^ is ]").append(toDecimalFormat(slopeLowerBound)).append(" ; ").append(toDecimalFormat(slopeUpperBound)).append("[\n");


        double interceptValue = Double.parseDouble(output.get(i + 9));
        double interceptCriticalValue = Double.parseDouble(output.get(i + 10));
        String interceptReject = output.get(i + 11);

        result.append("\nHypothesis test for a^:\n");
        result.append("H0: a = 0\n");
        result.append("H1: a ≠ 0\n");
        result.append("The Ta: ").append(toDecimalFormat(interceptValue)).append("\n");
        result.append("The critical value: ").append(toDecimalFormat(interceptCriticalValue)).append("\n");
        if (interceptReject.equals("true")) {
            result.append("The hypothesis H0 was accepted because Ta > Critical value\n");
        } else {
            result.append("The hypothesis H0 was rejected because Ta < Critical value\n");
        }

        double slopeValue = Double.parseDouble(output.get(i + 12));
        double slopeCriticalValue = Double.parseDouble(output.get(i + 13));
        String slopeReject = output.get(i + 14);

        result.append("\nHypothesis test for b^:\n");
        result.append("H0: b = 0\n");
        result.append("H1: b ≠ 0\n");
        result.append("The Tb: ").append(toDecimalFormat(slopeValue)).append("\n");
        result.append("The critical value: ").append(toDecimalFormat(slopeCriticalValue)).append("\n");
        if (slopeReject.equals("true")) {
            result.append("The hypothesis H0 was accepted because Tb > Critical value\n");
        } else {
            result.append("The hypothesis H0 was rejected because Tb < Critical value\n");
        }

        double regressionDegreesOfFreedom = Double.parseDouble(output.get(i + 15));
        double regressionSumOfSquares = Double.parseDouble(output.get(i + 16));
        double regressionMeanSquare = Double.parseDouble(output.get(i + 17));
        double regressionFValue = Double.parseDouble(output.get(i + 18));
        double residualDegreesOfFreedom = Double.parseDouble(output.get(i + 19));
        double residualSumOfSquares = Double.parseDouble(output.get(i + 20));
        double residualMeanSquare = Double.parseDouble(output.get(i + 21));
        double totalDegreesOfFreedom = Double.parseDouble(output.get(i + 22));
        double totalSumOfSquares = Double.parseDouble(output.get(i + 23));

        result.append("Anova Table:\n");
        result.append("------------------------------------------------------------------------------------------------------------------------------\n");
        result.append("Source of Variation     Degrees of Freedom          Sum of Squares             Mean Square            F Value   \n");
        result.append("Regression                   ").append(toDecimalFormat(regressionDegreesOfFreedom)).append("                   ");
        result.append(toDecimalFormat(regressionSumOfSquares)).append("         ").append(toDecimalFormat(regressionMeanSquare));
        result.append("        ").append(toDecimalFormat(regressionFValue)).append("\n");
        result.append("Residual                    ").append(toDecimalFormat(residualDegreesOfFreedom)).append("                  ");
        result.append(toDecimalFormat(residualSumOfSquares)).append("          ").append(toDecimalFormat(residualMeanSquare)).append("\n");
        result.append("Total                       ").append(toDecimalFormat(totalDegreesOfFreedom)).append("                  ");
        result.append(toDecimalFormat(totalSumOfSquares)).append("\n");
        result.append("------------------------------------------------------------------------------------------------------------------------------\n");

        return result.toString();
    }

    public String multiRegressionToString(List<String> output) {
        List<DealsDTO> deals = getDeals();

        StringBuilder result = new StringBuilder();

        result.append("Multiple Linear Regression\n");

        result.append("Forecasted value for : \n");

        int i = 0;
        while (!output.get(i).equals("Next")) {
            result.append("Property sold for: ").append(deals.get(i).getSale()).append("$").append(" - Forecasted value: ");
            result.append(output.get(i)).append("$").append("\n");
            i++;
        }

        double correlationCoefficient = Double.parseDouble(output.get(i + 1));
        double determinationCoefficient = Double.parseDouble(output.get(i + 2));

        result.append("\nR^2= ").append(toDecimalFormat(correlationCoefficient)).append("\n");
        result.append("R^2  adjusted = ").append(toDecimalFormat(determinationCoefficient)).append("\n");


        for (int j = 0; j < 6; j++) {
            double coefficientLowerBound = Double.parseDouble(output.get(i + 3 + j).replace(",", "."));

            double coefficientUpperBound = Double.parseDouble(output.get(i + 9 + j).replace(",", "."));

            double tStatistic = Double.parseDouble(output.get(i + 15 + 2 * j).replace(",", "."));

            double criticalValue = Double.parseDouble(output.get(i + 16 + 2 * j).replace(",", "."));

            String independentVariableString = independentVariableToString(j);

            result.append("\nHypothesis test for ").append(independentVariableString).append(":\n");
            result.append("H0: β = 0\n");
            result.append("H1: β ≠ 0\n");
            result.append("T value: ").append(toDecimalFormat(tStatistic)).append("\n");
            result.append("The critical value: ").append(toDecimalFormat(criticalValue)).append("\n");
            if (tStatistic <= criticalValue) {
                result.append("The hypothesis H0 was accepted because Tb > Critical value\n");
            } else {
                result.append("The hypothesis H0 was rejected because Tb < Critical value\n");
            }
            result.append("\nThe confidence interval for ").append(independentVariableString).append("  is ]").append(toDecimalFormat(coefficientLowerBound));
            result.append(" ; ").append(toDecimalFormat(coefficientUpperBound)).append("[\n");



        }
        double explainedSumOfSquares = Double.parseDouble(output.get(i + 27).replace(",", "."));
        double degreesOfFreedomR = Double.parseDouble(output.get(i + 28).replace(",", "."));
        double meanSquareRegression = Double.parseDouble(output.get(i + 29).replace(",", "."));
        double fValue = Double.parseDouble(output.get(i + 30).replace(",", "."));
        double residualSumOfSquares = Double.parseDouble(output.get(i + 31).replace(",", "."));
        double degreesOfFreedomRSS = Double.parseDouble(output.get(i + 32).replace(",", "."));
        double meanSquaredError = Double.parseDouble(output.get(i + 33).replace(",", "."));
        double totalSumOfSquares = Double.parseDouble(output.get(i + 34).replace(",", "."));
        double degreesOfFreedomTSS = Double.parseDouble(output.get(i + 35).replace(",", "."));

        result.append("Anova Table\n");
        result.append("-------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        // Table headers
        result.append("Source of Variation     Sum of Squares       Degrees of Freedom         Mean Square            F   \n");
        result.append("-------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        // Table data
        result.append("Regression             ").append(toDecimalFormat(explainedSumOfSquares)).append("                 ").append(toDecimalFormat(degreesOfFreedomR));
        result.append("                ").append(toDecimalFormat(meanSquareRegression)).append("        ").append(toDecimalFormat(fValue));
        result.append("\nError                  ").append(toDecimalFormat(residualSumOfSquares)).append("            ").append(toDecimalFormat(degreesOfFreedomRSS)).append("               ")
                .append(toDecimalFormat(meanSquaredError));
        result.append("\nTotal                  ").append(toDecimalFormat(totalSumOfSquares)).append("           ")
                .append(toDecimalFormat(degreesOfFreedomTSS));


        return result.toString();
    }

    private String toDecimalFormat(double number) {
        DecimalFormat df = new DecimalFormat("#.####");
        return df.format(number);
    }

    private String independentVariableToString(int option) {
        String independentVariable = "";

        switch (option) {
            case 0:
                independentVariable = "Intercept";
                break;
            case 1:
                independentVariable = "Area (square feet)";
                break;
            case 2:
                independentVariable = "Distance from city center (miles)";
                break;
            case 3:
                independentVariable = "Number of bedrooms";
                break;
            case 4:
                independentVariable = "Number of bathrooms";
                break;
            case 5:
                independentVariable = "Number of parking spaces";
                break;
            default:
        }
        return independentVariable;
    }
}