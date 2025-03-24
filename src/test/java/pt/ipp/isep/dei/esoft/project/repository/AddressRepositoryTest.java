package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Address;


import static org.junit.jupiter.api.Assertions.*;

public class AddressRepositoryTest {

    /*@Test
    void RegisterValidAddress() {
        AddressRepository addressRepository = new AddressRepository();

        assertTrue(addressRepository.registerAddress("Labradores", "Lisboa", "12345", "Valongo"));
    }

    @Test
    void RegisterNullAddress() {
        AddressRepository addressRepository = new AddressRepository();
        assertThrows(IllegalArgumentException.class,
                () -> addressRepository.registerAddress(null, null, null, null));

    }

    @Test
    void AddValidAddress() {
        AddressRepository addressRepository = new AddressRepository();

        Address address = new Address("Labradores", "Lisboa", "Valongo", "12345");

        assertTrue(addressRepository.addAddress(address));
    }

    @Test
    void AddNullAddress() {
        AddressRepository addressRepository = new AddressRepository();

        assertFalse(addressRepository.addAddress(null));
    }

    @Test
    void GetAddressList() {
        AddressRepository addressRepository = new AddressRepository();

        assertEquals(0, addressRepository.getAddressList().size());

        Address address = new Address("Labradores", "Lisboa", "Valongo", "12345");
        addressRepository.addAddress(address);
        assertEquals(1, addressRepository.getAddressList().size());
        assertEquals(address, addressRepository.getAddressList().get(0));
    }*/
}