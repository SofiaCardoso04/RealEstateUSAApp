package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.AddRequestController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.StoreRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class AddRequestUI implements Runnable {
    /**
     * The client's email address
     */
    private String emailAddress;

    /**
     * The respective store
     */
    private Store store;

    /**
     * The responsible agent
     */
    private Employee agent;

    /**
     * The type of request
     */
    private String requestType;

    /**
     * The type of property
     */
    private String propertyType;

    /**
     * The property's area
     */
    private double area;

    /**
     * The property's street name
     */
    private String streetName;

    /**
     * The property's city name
     */
    private String cityName;

    /**
     * The property's zip code
     */
    private String zipCode;

    /**
     * The property's district
     */
    private String district;

    /**
     * The property's photograph
     */
    private String photograph;

    /**
     * The property's distance from city
     */
    private double distanceFromCity;

    /**
     * The property's price
     */
    private double price;

    /**
     * The property's number of bedrooms
     */
    private int numberBedrooms = -1;

    /**
     * The property's number of bathrooms
     */
    private int numberBathrooms = -1;

    /**
     * The property's number of parking spaces
     */
    private int numberParkingSpaces = -1;

    /**
     * The property's existence of basement
     */
    private int existenceBasement = -1;

    /**
     * The property's existence of loft
     */
    private int existenceLoft = -1;

    /**
     * The property's existence of sun exposure
     */
    private int sunExposure = -1;

    /**
     * The property's available equipments
     */
    private AvailableEquipment availableEquipments = new AvailableEquipment(0, 0);

    private double requestedPrice;

    /**
     * The request's date
     */
    private String date;

    /**
     * The property's photograph URI list
     */
    ArrayList<String> photographURIList = new ArrayList<>();

    /**
     * The UI's controller
     */
    private final AddRequestController controller = new AddRequestController();

    /**
     * Get controller
     *
     * @return controller
     */
    private AddRequestController getController() {
        return controller;
    }

    /**
     * Requests the client's email address and execute all the request data method
     */
    @Override
    public void run() {
        System.out.println("###### Submit a Request For Listing a Property ######");
        emailAddress = readValidEmail();
        int option = displayPropertyTypeOptions();

        requestData(option);
    }

    /**
     * Requests and displays all the data of the request for listing a property, according to the chosen property type
     * Asks to confirm all the information and shows if the request succeeded or failed.
     *
     * @param option displays property types options
     */
    private void requestData(int option) {
        System.out.println("###Choose a Store###");
        store = (Store) Utils.showAndSelectOne(controller.getStoresList(), "Stores: ");
        //agentName = requestAgentName();
        System.out.println("###Choose an agent###");
        controller.getAgentList(store);
        agent = (Employee) Utils.showAndSelectOne(controller.getAgentList(store), "Agents: ");

        requestType = requestTypeOfRequest();
        if (requestType.equals(RequestType.getRequestTypes()[0])) {
            requestSalePrice();

        } else if (requestType.equals(RequestType.getRequestTypes()[1])) {
            requestRentPrice();
        }

        propertyType = PropertyType.getPropertyTypes()[0];
        area = requestArea();
        distanceFromCity = requestDistanceFromCity();

        System.out.println("### Address ###");
        streetName = requestStreet();
        cityName = requestCity();
        zipCode = readValidZipCode();
        district = requestDistrict();

        photograph = requestPhotographsURI();
        do {
            photographURIList = controller.addPhotographsURIToList(photograph, photographURIList);
            photograph = Utils.readLineFromConsole("");
        } while (!Objects.equals(photograph, "FINISH"));

        int option2 = -1;
        int option3 = -1;
        int option4 = -1;
        if (option == 2 || option == 3) {
            propertyType = PropertyType.getPropertyTypes()[1];
            numberBedrooms = requestNumberBedrooms();

            option2 = displayNumberOfBathroomsOptions();
            if (option2 == 1) {
                numberBathrooms = Utils.readIntegerFromConsole("Number of bathrooms: ");
            } else {
                numberBathrooms = -1;
            }
            numberParkingSpaces = requestNumberParkingSpaces();

            option3 = displayAvailableEquipmentOptions();
            if (option3 == 1) {
                availableEquipments = new AvailableEquipment(displayAirConditioning(), displayCentralHeating());
            } else {
                availableEquipments = new AvailableEquipment(0, 0);
            }

            if (option == 3) {
                propertyType = PropertyType.getPropertyTypes()[2];
                existenceBasement = Utils.readIntegerFromConsole("Existence of Basement:\n" + "1 - Yes\n" + "2 - No\n");
                existenceLoft = Utils.readIntegerFromConsole("Existence of Loft:\n" + "1 - Yes\n" + "2 - No\n");

                option4 = displaySunExposureOptions();
                if (option4 == 1) {
                    sunExposure = Utils.readIntegerFromConsole("Sun Exposure:\n" + "1 - North\n" + "2 - South\n" + "3 - East\n" + "4 - West\n");
                } else {
                    sunExposure = -1;
                }
            }
        }

        date = requestDate();
        requestedPrice = requestPrice();
        System.out.println("Do you want to confirm the following information?");
        System.out.println();

        System.out.println("Email Address: " + emailAddress);
        System.out.println("Store: " + store);
        System.out.println("Agent:" + agent);
        System.out.println();
        System.out.println("### Request data ###");
        System.out.println("Property Type: " + propertyType);
        System.out.println("Area (sqaure feet): " + area);
        System.out.println("Distance from city (miles): " + distanceFromCity);
        System.out.println();
        System.out.println("### Address ###");
        System.out.println("Street: " + streetName);
        System.out.println("City: " + cityName);
        System.out.println("Zip Code: " + zipCode);
        System.out.println("District: " + district);
        System.out.println();
        System.out.println("Photographs: " + photographURIList);
        if (option == 2 || option == 3) {
            System.out.println("Number of bedrooms: " + numberBedrooms);
            if (option2 == 1){
                System.out.println("Number of bathrooms: " + numberBathrooms);
            }
            System.out.println("Number of parking spaces: " + numberParkingSpaces);
            System.out.println();

            if (option3 == 1){
                System.out.println("### Available Equipments ### " + availableEquipments);
            }

            if (option == 3) {
                if (existenceBasement == 1){
                    System.out.println("Property has basement.");
                } else {
                    System.out.println("Property doesn't have basement.");
                }
                if (existenceLoft == 1){
                    System.out.println("Property has loft.");
                } else {
                    System.out.println("Property doesn't have loft.");
                }

                if (option4 == 1){
                    switch(sunExposure){
                        case 1:
                            System.out.println("Sun exposure: North");
                            break;
                        case 2:
                            System.out.println("Sun exposure: South");
                            break;
                        case 3:
                            System.out.println("Sun exposure: East");
                            break;
                        case 4:
                            System.out.println("Sun exposure: West");
                            break;
                    }
                }
            }
        }
        System.out.println("Date: " + date);

        boolean confirmation = Utils.confirm("Please confirm if you want to proceed with the request of the property: (Yes/No)");
        if (confirmation) {
            if (!controller.registerAddress(streetName, cityName, district, zipCode) ||
                    !controller.createProperty(area, distanceFromCity, photograph, new Address(streetName, cityName, district, zipCode)) ||
                    !controller.createResidence(area, distanceFromCity, photograph, new Address(streetName, cityName, district, zipCode), numberBedrooms, numberBathrooms, numberParkingSpaces, availableEquipments) ||
                    !controller.createHouse(area, distanceFromCity, photograph, new Address(streetName, cityName, district, zipCode), numberBedrooms, numberBathrooms, numberParkingSpaces, availableEquipments, existenceBasement, existenceLoft, sunExposure) ||
                    !controller.createAdvertisementRequest(emailAddress, store, agent, new Property(area, distanceFromCity, photograph, new Address(streetName, cityName, district, zipCode)), propertyType, requestType, requestedPrice, date)) {
                System.out.println();
                System.out.println("The request of the property failed!");
            } else {
                System.out.println();
                System.out.println("The request of the property succeeded!");
            }
        } else {
            System.out.println();
            System.out.println("The request of the property was cancelled!");
        }
    }

    /**
     * The request of the email address
     *
     * @return displays "Email Address: "
     */

    private String readValidEmail() {
        while (true) {
            try {
                String email = Utils.readLineFromConsole("E-mail: ");
                if (isValidEmail(email)) {
                    return email;
                } else {
                    throw new IllegalArgumentException("Invalid email address! Please enter a valid email address.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private boolean isValidEmail(String email) {
        String EMAIL_REGEX = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
        return email.matches(EMAIL_REGEX);
    }



    /**
     * The request of the type of request
     * If option2 equal to 1:
     * @return the request of the sale price
     * If not:
     * @return the request of the rent price
     */
    private String requestTypeOfRequest() {
        int option2 = displayRequestTypeOptions();

        if (option2 == 1) {
            return requestSalePrice();
        } else {
            return requestRentPrice();
        }
    }

    /**
     * Displays type of request options
     *
     * @return type of request options
     */
    private int displayRequestTypeOptions() {
        return Utils.readIntegerFromConsole("Type of request:\n" + "1 - Sale\n" + "2 - Rent\n");
    }

    /**
     * Requests the property's sale price
     *
     * @return displays "Total price: "
     */
    private String requestSalePrice() {
        return Utils.readLineFromConsole("Total price: ");
    }

    /**
     * Requests the property's rent price
     *
     * @return displays "Price per month: "
     */
    private String requestRentPrice() {
        return Utils.readLineFromConsole("Price per month: ");
    }

    /**
     * Requests the photograph's URI
     *
     * @return displays "Photographs URI: (Type 'FINISH' when you're done.)"
     */
    private String requestPhotographsURI() {
        return Utils.readLineFromConsole("Photographs URI: (Type 'FINISH' when you're done.)");
    }

    /**
     * Requests the property's area
     *
     * @return displays "Area (m2): "
     */
    private double requestArea() {
        return Utils.readDoubleFromConsole("Area (square feet): ");
    }

    /**
     * Requests the property's distance from the city centre
     *
     * @return displays "Distance from the city centre: "
     */
    private double requestDistanceFromCity() {
        return Utils.readDoubleFromConsole("Distance from the city centre (miles): ");
    }

    /**
     * Requests the property's street name
     *
     * @return displays "Street name: "
     */
    private String requestStreet() {
        return Utils.readLineFromConsole("Street name: ");
    }

    /**
     * Requests the property's city name
     *
     * @return displays "City name: "
     */
    private String requestCity() {
        return Utils.readLineFromConsole("City name: ");
    }

    /**
     * Requests the property's zip code
     *
     * @return displays "Zip code: "
     */
    private String readValidZipCode() {
        while (true) {
            try {
                String zipCode = Utils.readLineFromConsole("Zip Code (5 digits): ");
                if (zipCode.matches("\\d{5}")) {
                    return zipCode;
                } else {
                    throw new IllegalArgumentException("Invalid zip code! Please enter a 5-digit zip code.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Requests the property's district
     *
     * @return displays "District: "
     */
    private String requestDistrict() {
        return Utils.readLineFromConsole("District: ");
    }

    /**
     * Requests the property's number of bedrooms
     *
     * @return displays "Number of bedrooms: "
     */
    private int requestNumberBedrooms() {
        return Utils.readIntegerFromConsole("Number of bedrooms: ");
    }

    /**
     * Requests the property's number of parking spaces
     *
     * @return displays "Number of parking spaces: "
     */
    private int requestNumberParkingSpaces() {
        return Utils.readIntegerFromConsole("Number of parking spaces: ");
    }


    /**
     * Requests the property's existence of basement
     *
     * @return displays the existence of basement options
     */
    private int requestExistenceOfBasementOptions() {
        return Utils.readIntegerFromConsole("Existence of Basement:\n" + "1 - Yes\n" + "2 - No\n");
    }

    /**
     * Requests the property's existence of loft
     *
     * @return displays the existence of loft options
     */
    private int requestExistenceOfLoftOptions() {
        return Utils.readIntegerFromConsole("Existence of Loft:\n" + "1 - Yes\n" + "2 - No\n");
    }

    /**
     * Requests the request's date
     *
     * @return displays "Date: "
     */
    private String requestDate() {
        String date;
        do {
            try {
                date = Utils.readLineFromConsole("Date (yyyy/mm/dd): ");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                dateFormat.setLenient(false);
                Date parsedDate = dateFormat.parse(date);
                break; // Break the loop if no exception is thrown
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter the date in yyyy/mm/dd format.");
            }
        } while (true);
        return date;
    }
    private double requestPrice() {
        return Utils.readDoubleFromConsole("Requested Price (USD): ");
    }

    /**
     * Displays types of properties options
     *
     * @return displays "Type of property:\n" + "1 - Land\n" + "2 - Apartment\n" + "3 - House\n"
     */
    private int displayPropertyTypeOptions() {
        return Utils.readIntegerFromConsole("Type of property:\n" + "1 - Land\n" + "2 - Apartment\n" + "3 - House\n");
    }

    /**
     * Displays the property's number of bathrooms options
     *
     * @return displays "Do you want to put the number of bathrooms?\n" + "1 - Yes\n" + "2 - No\n"
     */
    private int displayNumberOfBathroomsOptions() {
        return Utils.readIntegerFromConsole("Do you want to put the number of bathrooms?\n" + "1 - Yes\n" + "2 - No\n");
    }

    /**
     * Displays the property's sun exposure options
     *
     * @return displays "Do you want to put the sun exposure?\n" + "1 - Yes\n" + "2 - No\n"
     */
    private int displaySunExposureOptions() {
        return Utils.readIntegerFromConsole("Do you want to put the sun exposure?\n" + "1 - Yes\n" + "2 - No\n");
    }

    /**
     * Displays the property's available equipment options
     *
     * @return displays "Do you want to put the number of available equipments?\n" + "1 - Yes\n" + "2 - No\n"
     */
    private int displayAvailableEquipmentOptions() {
        return Utils.readIntegerFromConsole("Do you want to put the number of available equipments?\n" + "1 - Yes\n" + "2 - No\n");
    }

    /**
     * Requests the property's number of air conditioning
     *
     * @return displays "Number of air conditioning: "
     */
    private int displayAirConditioning() {
        return Utils.readIntegerFromConsole("Number of air conditioning: ");
    }

    /**
     * Requests the property's number of central heating
     *
     * @return displays "Number of central heating: "
     */
    private int displayCentralHeating() {
        return Utils.readIntegerFromConsole("Number of central heating: ");
    }
}