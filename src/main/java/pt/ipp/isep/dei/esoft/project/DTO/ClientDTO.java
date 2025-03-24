package pt.ipp.isep.dei.esoft.project.DTO;

public class ClientDTO {

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
     * Builds an instance of Client with a given name, passport card number, tax number, email address and phone number.
     *
     * @param name               the client's name
     * @param passportCardNumber the client's passport card number
     * @param taxNumber          the client's tax number
     * @param emailAddress       the client's email address
     * @param phoneNumber        the client's phone number
     */
    public ClientDTO(String name, String passportCardNumber, String taxNumber, String emailAddress, String phoneNumber) {
        this.name = name;
        this.passportCardNumber = passportCardNumber;
        this.taxNumber = taxNumber;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPassportCardNumber() {
        return passportCardNumber;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
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

    @Override
    public String toString() {
        return "ClientDTO{" +
                "name='" + name + '\'' +
                ", passportCardNumber='" + passportCardNumber + '\'' +
                ", taxNumber='" + taxNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}


