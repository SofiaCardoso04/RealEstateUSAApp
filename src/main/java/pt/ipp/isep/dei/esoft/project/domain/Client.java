package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;

/**
 * Represents a client through name, passport card number, tax number, email address and phone number attributes.
 */
public class Client extends Person implements Serializable {

    /**
     * Builds an instance of Client with a given name, passport card number, tax number, email address and phone number.
     *
     * @param name               the client's name
     * @param passportCardNumber the client's passport card number
     * @param taxNumber          the client's tax number
     * @param emailAddress       the client's email address
     * @param phoneNumber        the client's phone number
     */
    public Client(String name, String passportCardNumber, String taxNumber, String emailAddress, String phoneNumber) {
        super(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        if (emailAddress == null) {
            throw new IllegalArgumentException("The argument can't be null!");
        }

        if (!emailAddress.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            throw new IllegalArgumentException("The email address must be in the right format! (Example: user123@realestate.com)");
        }
    }

    /**
     * Check if any owner has email.
     *
     * @param emailAddress the email to check.
     * @return true if owner has an email, otherwise false
     */
    public boolean anyOwnerHasEmail(String emailAddress) {
        return true;
    }



}
