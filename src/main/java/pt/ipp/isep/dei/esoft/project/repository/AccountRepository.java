package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.Account;
import pt.ipp.isep.dei.esoft.project.domain.Address;

import java.io.*;
import java.util.ArrayList;

/**
 * The AccountRepository class manages a collection of accounts and provides methods to register, validate and add accounts.
 */
public class AccountRepository implements Serializable{
    private static final String ACCOUNT_SERIALIZATION_FILE_PATH = "Serialization/Account.ser";
    /**
     * The collection of accounts managed by this repository.
     */
    private ArrayList<Account> accountsList = new ArrayList<>();

    /**
     * Returns the collection of accounts managed by this repository.
     *
     * @return the collection of accounts managed by this repository
     */
    public ArrayList<Account> getAccountsList() {
        return accountsList;
    }
    /**
     * Checks if the given account is a valid account.
     *
     * @param account the account to be validated
     * @return true if the account is valid, false otherwise
     */
    public boolean validateAccount(Account account) {
        return this.accountsList.contains(account);
    }
    /**
     * Adds a new account to the repository.
     *
     * @param account the account to be added
     * @return true if the account is added successfully, false otherwise
     */
    public boolean addAccount(Account account) {
        if (account == null) {
            return false;
        }
        if (validateAccount(account)) {
            return false;
        }

        this.accountsList.add(account);
        return true;
    }

    /**
     * Registers a new account with the given information and address.
     *
     * @param name                the name of the account holder
     * @param passportCardNumber  the passport or card number of the account holder
     * @param taxNumber           the tax number of the account holder
     * @param emailAddress       the email address of the account holder
     * @param phoneNumber        the phone number of the account holder
     * @param password           the password of the account
     * @param address            the address of the account holder
     * @return the newly created account if it is registered successfully, null otherwise
     */
    public boolean registerAccount(String name, String passportCardNumber, String taxNumber, String emailAddress, String phoneNumber, String password, Address address) {
        return this.addAccount(new Account(name,passportCardNumber,taxNumber,emailAddress, phoneNumber, password, address));
    }

    /**
     * Registers a new account with the given information without an address.
     *
     * @param name               the name of the account holder
     * @param passportCardNumber the passport or card number of the account holder
     * @param taxNumber          the tax number of the account holder
     * @param emailAddress      the email address of the account holder
     * @param phoneNumber       the phone number of the account holder
     * @param password          the password of the account
     * @return the newly created account if it is registered successfully, null otherwise
     */
    public boolean registerAccount(String name, String passportCardNumber, String taxNumber, String emailAddress, String phoneNumber, String password) {
        return this.addAccount(new Account(name,passportCardNumber,taxNumber,emailAddress, phoneNumber, password));

    }
}