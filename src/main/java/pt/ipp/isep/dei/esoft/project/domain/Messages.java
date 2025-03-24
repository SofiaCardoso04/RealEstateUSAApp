package pt.ipp.isep.dei.esoft.project.domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Represents a class that handles sending messages, such as SMS and email, to clients and agents.
 */
public class Messages implements Serializable {

    /**
     * Sends an SMS message to the owner of a property.
     *
     * @param clientPhone   the phone number of the client
     * @param agentPhone    the phone number of the agent
     * @param clientName    the name of the client
     * @param streetName    the street name of the property
     * @param cityName      the city name of the property
     * @param district      the district of the property
     * @param zipCode       the zip code of the property
     * @param date          the date when the property became available for purchase
     * @param agentName     the name of the agent
     * @throws IOException if an I/O error occurs while writing the message to a file
     */
    public void sendSMSMessageToOwner(String clientPhone, String agentPhone, String clientName, String streetName, String cityName, String district, String zipCode, String date, String agentName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/ClientsMessages/SMS.txt", true));

        writer.write("To: " + clientPhone + "\n");
        writer.write("From: " + agentPhone + "\n\n");
        writer.write("Hello " + clientName + ",\n");
        writer.write("I would like to inform you that the property located at " + streetName +
                ", " + cityName + ", " + district + ", " + zipCode + " has become available for purchase since " + date + ".\n\n");
        writer.write("Thank you for your attention.\n\n");
        writer.write("Best regards,\n");
        writer.write(agentName + "\n");
        writer.write("------------------------------------\n");

        writer.close();
    }

    /**
     * Sends an email message to a client.
     *
     * @param clientEmail   the email address of the client
     * @param message       the message to be sent to the client
     * @throws IOException if an I/O error occurs while writing the message to a file
     */
    public void sendMessageEmailToClient(String clientEmail, String message) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/ClientsMessages/" + clientEmail + ".txt", true));

        writer.write("To " + clientEmail + "\n");

        writer.write("Dear Client,\n");
        writer.write(message);
        writer.write("\nThank you for your attention.\n\n");
        writer.write("Best regards\n");
        writer.write("------------------------------------\n");

        writer.close();
    }

    /**
     * Sends an email message to an agent.
     *
     * @param agentEmail    the email address of the agent
     * @param name          the name of the person interested in visiting the property
     * @param propertyID    the ID of the property
     * @param phoneNumber   the phone number of the person interested in visiting the property
     * @param date          the date for the property visit
     * @param startTime     the start time of the property visit
     * @param endTime       the end time of the property visit
     * @throws IOException if an I/O error occurs while writing the message to a file
     */
    public void sendMessageEmailToAgent(String agentEmail, String name, int propertyID, String phoneNumber, LocalDate date, LocalTime startTime, LocalTime endTime) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/AgentsEmail/" + agentEmail + ".txt", true));

        writer.write("To " + agentEmail + "\n");

        writer.write("Dear Agent,\n");
        writer.write("I am " + name + " and I am interested in visiting the property with id " + propertyID);
        writer.write(" I would like to schedule a visit on " + date + " from " + startTime + " hours to " + endTime + " hours.\n");
        writer.write("If there is any problem, please contact me at the following phone number " + phoneNumber + "\n\n");
        writer.write("I'm waiting for your confirmation.\n" + "Thank you for your attention and availability.\n\n");
        writer.write("Best regards,\n");
        writer.write(name + "\n");
        writer.write("------------------------------------\n");

        writer.close();
    }
}