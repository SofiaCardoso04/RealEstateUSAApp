package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a person through name, passport card number, tax number, email address and phone number attributes.
 */
public abstract class Person implements Serializable {
    /**
     * The person's name
     */
    private String name;

    /**
     * The person's passport card number
     */
    private String passportCardNumber;

    /**
     * The person's tax number
     */
    private String taxNumber;

    /**
     * The person's email address
     */
    private String emailAddress;

    /**
     * The person's phone number
     */
    private String phoneNumber;

    /**
     * Builds an instance of Person with a given name, passport card number, tax number, email address and phone number.
     * @param name the person's name
     * @param passportCardNumber the person's passport card number
     * @param taxNumber the person's tax number
     * @param emailAddress the person's email address
     * @param phoneNumber the person's phone number
     */
    public Person(String name, String passportCardNumber, String taxNumber, String emailAddress, String phoneNumber) {
        if (name == null || passportCardNumber == null || taxNumber == null || emailAddress == null || phoneNumber == null) {
            throw new IllegalArgumentException("The arguments can't be null!");
        }

        if (!passportCardNumber.matches("^[0-9]{9}$")) {
            throw new IllegalArgumentException("The passport card number must have 9 digits!");
        }

        if (!taxNumber.matches("^\\d{3}-\\d{2}-\\d{4}$")) {
            throw new IllegalArgumentException("The tax number must be in the xxx-xx-xxxx format!");
        }

        if (!emailAddress.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            throw new IllegalArgumentException("The email address must be in the right format! (Example: user123@realestate.com)");
        }

        if (!phoneNumber.matches("^\\d{3}-\\d{3}-\\d{4}$")) {
            throw new IllegalArgumentException("The phone number must be in the xxx-xxx-xxxx format!");
        }

        this.name = name;
        this.passportCardNumber = passportCardNumber;
        this.taxNumber = taxNumber;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get the person's name.
     * @return the person's name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the person's passport card number.
     * @return the person's passport card number
     */
    public String getPassportCardNumber() {
        return passportCardNumber;
    }

    /**
     * Get the person's tax number.
     * @return the person's tax number
     */
    public String getTaxNumber() {
        return taxNumber;
    }

    /**
     * Get the person's email address.
     * @return the person's email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Get the person's phone number.
     * @return the person's phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Returns a textual description of the person on the format:
     * Name: %s%nPassport Card Number: %s%nTax Number: %s%nEmail: %s%nPhone Number: %s%nAddress: %s%n
     * @return person's description
     */
    @Override
    public String toString() {
        return "Name: " + name +
                " | Passport Card Number: " + passportCardNumber +
                " | Tax Number: " + taxNumber +
                " | Email Address: " + emailAddress +
                " | Phone Number: " + phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(emailAddress, person.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAddress);
    }
}
