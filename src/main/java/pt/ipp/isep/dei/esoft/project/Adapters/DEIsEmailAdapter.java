package pt.ipp.isep.dei.esoft.project.Adapters;

import pt.ipp.isep.dei.esoft.project.INTERFACES.Email;
import pt.ipp.isep.dei.esoft.project.application.session.DEIsEmailService;
import pt.ipp.isep.dei.esoft.project.domain.Address;

public class DEIsEmailAdapter implements Email {

    private DEIsEmailService deIsEmailService;

    /**
     * Constructs a new DEIsEmailAdapter instance.
     *
     * @param deIsEmailService the DEIsEmailService instance to adapt
     */
    public DEIsEmailAdapter(DEIsEmailService deIsEmailService) {
        this.deIsEmailService = deIsEmailService;
    }

    /**
     * Sends an email using the DEIsEmailService.
     *
     * @param prompt      the prompt or message of the email
     * @param name        the name of the recipient
     * @param phoneNumber the phone number of the recipient
     * @param address     the address of the recipient
     * @param op          the operation to be performed
     */
    @Override
    public void sendEmail(String prompt, String name, String phoneNumber, Address address, int op) {
        // Adapt the method call to the DEIsEmailService instance
        deIsEmailService.sendEmail(prompt, name, phoneNumber, address, op);
    }
}