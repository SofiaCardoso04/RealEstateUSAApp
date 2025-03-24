package pt.ipp.isep.dei.esoft.project.INTERFACES;

import pt.ipp.isep.dei.esoft.project.domain.Address;

/**
 * Interface for sending emails.
 */
public interface Email {

    /**
     * Sends an email with the provided information.
     *
     * @param prompt     The prompt or message of the email.
     * @param name       The name of the recipient.
     * @param phoneNumber The phone number of the recipient.
     * @param address    The address of the recipient.
     * @param op         An operation code specifying the type of email.
     */
    void sendEmail(String prompt, String name, String phoneNumber, Address address, int op);
}