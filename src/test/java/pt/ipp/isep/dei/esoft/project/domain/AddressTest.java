package pt.ipp.isep.dei.esoft.project.domain;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AddressTest {

    /*@Test
    void testConstructorWithValidArguments() {
        Address address = new Address("Labradores", "Porto", "Valongo", "12345");
        assertEquals("Labradores", address.getStreetName());
        assertEquals("Porto", address.getCityName());
        assertEquals("Valongo", address.getDistrict());
        assertEquals("12345", address.getZipCode());
    }

    @Test
    void testConstructorWithNullArguments() {
        assertThrows(IllegalArgumentException.class, () -> new Address(null, "Porto", "Valongo", "12345"));
        assertThrows(IllegalArgumentException.class, () -> new Address("Labradores.", null, "Valongo", "12345"));
        assertThrows(IllegalArgumentException.class, () -> new Address("Labradores", "Porto", null, "12345"));
        assertThrows(IllegalArgumentException.class, () -> new Address("Labradores", "Porto", "Valongo", null));
    }

    @Test
    void testConstructorWithEmptyStringArguments() {
        assertThrows(IllegalArgumentException.class, () -> new Address("", "Porto", "Valongo", "12345"));
        assertThrows(IllegalArgumentException.class, () -> new Address("Labradores", "", "Valongo", "12345"));
        assertThrows(IllegalArgumentException.class, () -> new Address("Labradores", "Porto", "", "12345"));
        assertThrows(IllegalArgumentException.class, () -> new Address("Labradores", "Porto", "Valongo", ""));
    }

    @Test
    void ConstructorWithInvalidZipCode() {
        assertThrows(IllegalArgumentException.class, () -> new Address("Labradores", "Porto", "Porto", "1234"));
        assertThrows(IllegalArgumentException.class, () -> new Address("Labradores", "Porto", "Porto", "123456"));
        assertThrows(IllegalArgumentException.class, () -> new Address("Labradores", "Porto", "Porto", "12A45"));
    }

    @Test
    void testToString() {
        Address address = new Address("Labradores", "Porto", "Valongo", "12345");
        assertEquals("District name: Valongo | City name: Porto | Street name: Labradores | Zip Code: 12345", address.toString());
    }

    @Test
    public void testGetters() {
        Address address = new Address("Labradores", "Porto", "Valongo", "12345");
        assertEquals("Labradores", address.getStreetName());
        assertEquals("Porto", address.getCityName());
        assertEquals("12345", address.getZipCode());
        assertEquals("Valongo", address.getDistrict());
    }*/


}
