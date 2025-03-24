package pt.ipp.isep.dei.esoft.project.application.controller;
import pt.ipp.isep.dei.esoft.project.domain.Account;
import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.ArrayList;


/**
 * The RegisterAccountController class manages the registration of new accounts and addresses in the system.
 */
public class RegisterAccountController {

    private AddressRepository addressRepository = null;
    private AccountRepository accountRepository = null;
    private ArrayList<Account> accounts;

    /**
     * Creates a new RegisterAccountController object and initializes the AddressRepository.
     */
    public RegisterAccountController() {
        getAddressRepository();
    }

    /**
     * Returns the AddressRepository object, initializing it if necessary.
     *
     * @return The AddressRepository object.
     */
    public AddressRepository getAddressRepository() {
        if (addressRepository == null) {
            Repositories repositories = Repositories.getInstance();
            addressRepository = repositories.getAddressRepository();
        }
        return addressRepository;
    }

    /**
     * Returns the AccountRepository object, initializing it if necessary.
     *
     * @return The AccountRepository object.
     */
    public AccountRepository getAccountRepository() {
        if(accountRepository == null) {
            Repositories repositories = Repositories.getInstance();
            accountRepository = repositories.getAccountRepository();
        }
        return accountRepository;
    }

    /**
     * Registers a new address in the system.
     *
     * @param district The district of the address.
     * @param cityName The city of the address.
     * @param streetName The street name of the address.
     * @param zipCode The zip code of the address.
     * @return True if the address was registered successfully, false otherwise.
     */
    public boolean registerAddress(String district, String cityName, String streetName, String zipCode) {
        AddressRepository addressRepository = getAddressRepository();
        return this.addressRepository.registerAddress(streetName, cityName, zipCode, district);
    }

    /**
     * Registers a new account in the system with the given address.
     *
     * @param name The name of the account holder.
     * @param passportCardNumber The passport or card number of the account holder.
     * @param taxNumber The tax number of the account holder.
     * @param emailAddress The email address of the account holder.
     * @param phoneNumber The phone number of the account holder.
     * @param password The password for the account.
     * @param address The address associated with the account.
     * @return The new Account object if the registration was successful, null otherwise.
     */
    public boolean registerAccount(String name, String passportCardNumber, String taxNumber, String emailAddress, String phoneNumber, String password, Address address) {
        AccountRepository accountRepository = getAccountRepository();
        return this.accountRepository.registerAccount(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, password, address);
    }

    /**
     * Registers a new account in the system without an associated address.
     *
     * @param name The name of the account holder.
     * @param passportCardNumber The passport or card number of the account holder.
     * @param taxNumber The tax number of the account holder.
     * @param emailAddress The email address of the account holder.
     * @param phoneNumber The phone number of the account holder.
     * @param password The password for the account.
     * @return The new Account object if the registration was successful, null otherwise.
     */
    public boolean registerAccount(String name, String passportCardNumber, String taxNumber, String emailAddress, String phoneNumber, String password) {
        AccountRepository accountRepository = getAccountRepository();
        return accountRepository.registerAccount(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, password);
    }

    public void addUserWithRole(String name, String email, String password, String roleId) {
        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        authenticationRepository.addUserWithRole(name, email, password, roleId);
    }



    public ArrayList<Account> getAccountsList() {
        AccountRepository accountRepository = Repositories.getInstance().getAccountRepository();
        this.accounts = accountRepository.getAccountsList();
        return accounts;
    }
}




