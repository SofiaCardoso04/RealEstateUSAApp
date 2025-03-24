package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Account;
import pt.ipp.isep.dei.esoft.project.domain.Address;

import static org.junit.jupiter.api.Assertions.*;

public class AccountRepositoryTest {

    /*@Test
    void testAddAccount() {
        AccountRepository repository = new AccountRepository();
        Address address1 = new Address("rua dos reis", "amadora", "lisboa", "54321");

        Account account1 = new Account("Fátima", "12345678", "333-22-4444", "user@gmail.com",
                "(333) 333-4444", "password");
        Account account2 = new Account("Jorge", "87654321", "111-11-1111", "user2@gmail.com",
                "(111) 111-1111", "password2", address1);

        assertTrue(repository.addAccount(account1));
        assertFalse(repository.addAccount(account1));
        assertTrue(repository.addAccount(account2));
        assertFalse(repository.addAccount(account2));
    }

    @Test
    void testRegisterAccount() {
        AccountRepository repository = new AccountRepository();
        Address address1 = new Address("rua dos reis", "amadora", "lisboa", "54321");

        assertTrue(repository.registerAccount("Fátima", "12345678", "333-22-4444", "user@gmail.com",
                "(333) 333-4444", "password"));
        assertFalse(repository.registerAccount("Fátima", "12345678", "333-22-4444", "user@gmail.com",
                "(333) 333-4444", "password"));

        assertTrue(repository.registerAccount("Jorge", "87654321", "111-11-1111", "user2@gmail.com",
                "(111) 111-1111", "password2", address1));
        assertFalse(repository.registerAccount("Jorge", "87654321", "111-11-1111", "user2@gmail.com",
                "(111) 111-1111", "password2", address1));
    }

    @Test
    void testGetAccountsList() {
        AccountRepository repository = new AccountRepository();
        Address address1 = new Address("rua dos reis", "amadora", "lisboa", "54321");

        Account account1 = new Account("Fátima", "12345678", "333-22-4444", "user@gmail.com",
                "(333) 333-4444", "password");
        Account account2 = new Account("Jorge", "87654321", "111-11-1111", "user2@gmail.com",
                "(111) 111-1111", "password2", address1);

        assertTrue(repository.addAccount(account1));
        assertTrue(repository.addAccount(account2));

        assertEquals(2, repository.getAccountsList().size());
        assertTrue(repository.getAccountsList().contains(account1));
        assertTrue(repository.getAccountsList().contains(account2));
    }

    @Test
    void testValidateAccount() {
        AccountRepository repository = new AccountRepository();
        Address address1 = new Address("rua dos reis", "amadora", "lisboa", "54321");

        Account account1 = new Account("Fátima", "12345678", "333-22-4444", "user@gmail.com",
                "(333) 333-4444", "password");
        Account account2 = new Account("Jorge", "87654321", "111-11-1111", "user2@gmail.com",
                "(111) 111-1111", "password2", address1);

        assertFalse(repository.validateAccount(account1));
        assertFalse(repository.validateAccount(account2));

        assertTrue(repository.addAccount(account1));
        assertFalse(repository.addAccount(account1));

        assertTrue(repository.addAccount(account2));
        assertFalse(repository.addAccount(account2));

    }*/
}
