package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;

/**
 * The Account class represents a bank account.
 */
public class Account extends Client implements Serializable {

    /**
     * The password associated with the account.
     */
    private String password;

    /**
     * The address associated with the account.
     */
    private Address address;

    /**
     * Constructs a new Account object without an address.
     * @param name the name of the account holder
     * @param passportCardNumber the passport or card number of the account holder
     * @param taxNumber the tax number of the account holder
     * @param emailAddress the email address of the account holder
     * @param phoneNumber the phone number of the account holder
     * @param password the password for the account
     */
    public Account(String name, String passportCardNumber, String taxNumber, String emailAddress, String phoneNumber, String password) {
        super(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        this.password = password;
    }

    /**
     * Constructs a new Account object with an address.
     * @param name the name of the account holder
     * @param passportCardNumber the passport or card number of the account holder
     * @param taxNumber the tax number of the account holder
     * @param emailAddress the email address of the account holder
     * @param phoneNumber the phone number of the account holder
     * @param password the password for the account
     * @param address the address of the account holder
     */
    public Account(String name, String passportCardNumber, String taxNumber, String emailAddress, String phoneNumber, String password, Address address) {
        super(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        this.password = password;
        this.address = address;
    }

    /**
     * Returns the password for the account.
     * @return the password for the account
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns the address for the account.
     * @return the address for the account
     */
    public Address getAddress() {
        return address;
    }


    @Override
    public String toString() {
        return String.format("Name: %s | E-mail : %s | Password : %s | Tax Number : %s | Passport Card Number: %s | Address : %s \n", this.getName(), this.getEmailAddress(), password , this.getTaxNumber(), this.getPassportCardNumber(), address);
    }

}