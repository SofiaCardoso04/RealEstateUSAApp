package pt.ipp.isep.dei.esoft.project.Adapters;

import pt.ipp.isep.dei.esoft.project.INTERFACES.Email;
import pt.ipp.isep.dei.esoft.project.application.session.gmail;
import pt.ipp.isep.dei.esoft.project.domain.Address;

public class EmailAdapter implements Email {

    private gmail gmail;

    /**
     * Constructs a new EmailAdapter instance with the specified Gmail service.
     *
     * @param gmail the Gmail service to be adapted
     */
    public EmailAdapter(gmail gmail) {
        this.gmail = gmail;
    }

    /**
     * Sends an email using the adapted Gmail service.
     *
     * @param prompt      the email prompt
     * @param name        the recipient's name
     * @param phoneNumber the recipient's phone number
     * @param address     the recipient's address
     * @param op          the email operation code
     */
    @Override
    public void sendEmail(String prompt, String name, String phoneNumber, Address address, int op) {
        gmail.sendEmail(prompt, name, phoneNumber, address, op);
    }
}