package pt.ipp.isep.dei.esoft.project.application.session;

import pt.ipp.isep.dei.esoft.project.INTERFACES.Email;
import pt.ipp.isep.dei.esoft.project.domain.Address;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class gmail implements Email {

    /**
     * Sends an email using the Gmail service.
     *
     * @param prompt      the email prompt
     * @param name        the sender's name
     * @param phoneNumber the sender's phone number
     * @param address     the property address
     * @param op          the email operation code (1: booking request status, 2: general)
     */
    @Override
    public void sendEmail(String prompt, String name, String phoneNumber, Address address, int op) {
        try {
            File fileName = new File("GmailService.txt");
            FileWriter fileWriter = new FileWriter(fileName, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Format the email header
            printWriter.println("#You are using the Gmail service#");
            printWriter.println();
            printWriter.println("From: " + name);
            printWriter.println("Subject: Booking Request Update");
            printWriter.println();

            // Format the email body
            printWriter.println();
            printWriter.println("Response: " + prompt);
            printWriter.println();
            printWriter.println("My Phone Number: " + phoneNumber);
            printWriter.println("The Property Address: " + address.toString());

            printWriter.flush();
            printWriter.close();
            if (op == 1)
                System.out.println("An email has been sent to the client regarding the booking request status.");
            if (op == 2)
                System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}