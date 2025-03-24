package pt.ipp.isep.dei.esoft.project.application.session;

import pt.ipp.isep.dei.esoft.project.INTERFACES.Email;
import pt.ipp.isep.dei.esoft.project.domain.Address;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DEIsEmailService implements Email {

    /**
     * Sends an email using the DEI email service.
     *
     * @param prompt      the email prompt
     * @param name        the recipient's name
     * @param phoneNumber the recipient's phone number
     * @param address     the recipient's address
     * @param op          the email operation code (1: purchase order status, 2: general)
     */
    public void sendEmail(String prompt, String name, String phoneNumber, Address address, int op) {
        try {
            File fileName = new File("DEIEmailService.txt");
            FileWriter fileWriter = new FileWriter(fileName, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Format the email header
            printWriter.println("#You are using the DEI email service#");
            printWriter.println();
            printWriter.println("From: " + name);
            printWriter.println("Subject: Visit Request Update");
            printWriter.println();

            // Format the email body
            printWriter.println();
            printWriter.println("Response: " + prompt);
            printWriter.println();
            printWriter.println("My Phone Number: " + phoneNumber);
            printWriter.println("The Property Address: " + address.toString());

            printWriter.flush();
            printWriter.close();

            if (op == 1) {
                System.out.println("An email has been sent to the client regarding the purchase order status.");
            } else if (op == 2) {
                System.out.println("Successfully wrote to the file.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}