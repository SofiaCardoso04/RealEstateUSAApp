package pt.ipp.isep.dei.esoft.project.repository;

import javafx.util.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.domain.PurchaseOrder;
import pt.ipp.isep.dei.esoft.project.domain.Store;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StoreRepositoryTest {
    private StoreRepository storeRepository;

    @BeforeEach
    public void setUp() {
        storeRepository = new StoreRepository();
    }

    @Test
    public void testGetStoresList() {
        // Arrange
        assertEquals(0, storeRepository.getStoresList().size());

        Address address = new Address("Almeida Garrett", "Ermesinde", "Porto", "12345");
        String id = "12345";
        String phoneNumber = "111-555-1234";
        String designation = "LojinhaDoGoncalinho1";
        String email = "lojinha1@example.com";

        storeRepository.registerStore(address, id, phoneNumber, designation, email);

        // Assert
        assertEquals(1, storeRepository.getStoresList().size());
    }

    @Test
    public void testRegisterStore() {
        // Arrange
        Address address = new Address("Almeida Garrett", "Ermesinde", "Porto", "12345");
        String id = "12345";
        String phoneNumber = "111-555-1234";
        String designation = "LojinhaDoGoncalinho1";
        String email = "lojinha1@example.com";

        // Act
        boolean result = storeRepository.registerStore(address, id, phoneNumber, designation, email);

        // Assert
        assertTrue(result);
        assertEquals(1, storeRepository.getStoresList().size());
    }

    @Test
    public void testValidateStore() {
        // Arrange
        Address address1 = new Address("Almeida Garrett", "Ermesinde", "Porto", "12345");
        String id1 = "12345";
        String phoneNumber1 = "111-555-1234";
        String designation1 = "LojinhaDoGoncalinho1";
        String email1 = "lojinha1@example.com";

        Address address2 = new Address("Labradores", "Rio Tinto", "Porto", "12345");
        String id2 = "12346";
        String phoneNumber2 = "111-444-1234";
        String designation2 = "LojinhaDoGoncalinho2";
        String email2 = "lojinha2@example.com";

        // Test with a valid store
        Store store1 = new Store(address1, id1, phoneNumber1, designation1, email1);
        assertTrue(storeRepository.validateStore(store1));

        // Test with a null store
        assertFalse(storeRepository.validateStore(null));

        // Test with a duplicate store
        storeRepository.addStore(store1);
        assertFalse(storeRepository.validateStore(store1));

        // Test with another valid store
        Store store2 = new Store(address2, id2, phoneNumber2, designation2, email2);
        assertTrue(storeRepository.validateStore(store2));
    }

    @Test
    public void testAddStore() {
        // Arrange
        Address address = new Address("Labradores", "Rio Tinto", "Porto", "12345");
        String id = "12345";
        String phoneNumber = "111-444-1234";
        String designation = "LojinhaDoGoncalinho2";
        String email = "lojinha2@example.com";

        // Act
        Store store = new Store(address, id, phoneNumber, designation, email);
        boolean firstAddResult = storeRepository.addStore(store);
        boolean secondAddResult = storeRepository.addStore(store);

        // Assert
        assertTrue(firstAddResult);
        assertFalse(secondAddResult);
        assertEquals(1, storeRepository.getStoresList().size());
    }

    @Test
    public void testCreateStore() {
        // Arrange
        Address address = new Address("Almeida Garrett", "Ermesinde", "Porto", "12345");
        String id = "12345";
        String designation = "LojinhaDoGoncalinho1";
        String phoneNumber = "111-555-1234";
        String emailAddress = "lojinha1@example.com";

        // Act
        Store store = storeRepository.createStore(address, id, phoneNumber, designation, emailAddress);

        // Assert
        assertNotNull(store);
        assertFalse(storeRepository.getStoresList().contains(store));
    }

    @Test
    public void testGetListOfStoreIds() {
        // Arrange
        Address address1 = new Address("Almeida Garrett", "Ermesinde", "Porto", "12345");
        String id1 = "12345";
        String phoneNumber1 = "111-555-1234";
        String designation1 = "LojinhaDoGoncalinho1";
        String email1 = "lojinha1@example.com";

        Address address2 = new Address("Labradores", "Rio Tinto", "Porto", "12345");
        String id2 = "12346";
        String phoneNumber2 = "111-444-1234";
        String designation2 = "LojinhaDoGoncalinho2";
        String email2 = "lojinha2@example.com";

        Store store1 = new Store(address1, id1, phoneNumber1, designation1, email1);
        Store store2 = new Store(address2, id2, phoneNumber2, designation2, email2);

        storeRepository.addStore(store1);
        storeRepository.addStore(store2);

        // Act
        String[] storeIds = storeRepository.getListOfStoreIds(2);

        // Assert
        assertEquals(2, storeIds.length);
        assertEquals(id1, storeIds[0]);
        assertEquals(id2, storeIds[1]);
    }

    @Test
    public void testGetListOfPropertiesPerStore() {
        // Arrange
        Address address1 = new Address("Almeida Garrett", "Ermesinde", "Porto", "12345");
        String id1 = "12345";
        String phoneNumber1 = "111-555-1234";
        String designation1 = "LojinhaDoGoncalinho1";
        String email1 = "lojinha1@example.com";

        Address address2 = new Address("Labradores", "Rio Tinto", "Porto", "12345");
        String id2 = "12346";
        String phoneNumber2 = "111-444-1234";
        String designation2 = "LojinhaDoGoncalinho2";
        String email2 = "lojinha2@example.com";

        Store store1 = new Store(address1, id1, phoneNumber1, designation1, email1);
        Store store2 = new Store(address2, id2, phoneNumber2, designation2, email2);

        storeRepository.addStore(store1);
        storeRepository.addStore(store2);

        List<PurchaseOrder> listPurchasesSold = new ArrayList<>();

        // Act
        int[] propertiesPerStore = storeRepository.getListOfPropertiesPerStore(2, listPurchasesSold);

        // Assert
        assertEquals(2, propertiesPerStore.length);
        assertEquals(0, propertiesPerStore[0]);
        assertEquals(0, propertiesPerStore[1]);
    }

    @Test
    public void testDivideIntoSubsets() {
        // Arrange
        List<Pair> nums = new ArrayList<>();
        nums.add(new Pair("Store1", 10));
        nums.add(new Pair("Store2", 20));
        nums.add(new Pair("Store3", 30));
        nums.add(new Pair("Store4", 40));

        // Act
        List<String> result = storeRepository.divideIntoSubsets(nums);

        // Assert
        assertEquals(5, result.size());
        assertFalse(result.contains("Iterations made: 16"));
        assertFalse(result.contains("SubsetA: {( Store1, 10)}"));
        assertFalse(result.contains("SubsetB: {( Store2, 20), ( Store3, 30), ( Store4, 40)}"));
        assertFalse(result.contains("Difference: 40"));
        assertFalse(result.contains("Time elapsed:"));
    }

    @Test
    public void testNums() {
        // Arrange
        Address address1 = new Address("Almeida Garrett", "Ermesinde", "Porto", "12345");
        String id1 = "12345";
        String phoneNumber1 = "111-555-1234";
        String designation1 = "LojinhaDoGoncalinho1";
        String email1 = "lojinha1@example.com";

        Address address2 = new Address("Labradores", "Rio Tinto", "Porto", "12345");
        String id2 = "12346";
        String phoneNumber2 = "111-444-1234";
        String designation2 = "LojinhaDoGoncalinho2";
        String email2 = "lojinha2@example.com";

        Store store1 = new Store(address1, id1, phoneNumber1, designation1, email1);
        Store store2 = new Store(address2, id2, phoneNumber2, designation2, email2);

        storeRepository.addStore(store1);
        storeRepository.addStore(store2);

        List<PurchaseOrder> listPurchasesSold = new ArrayList<>();

        // Act
        List<Pair> result = storeRepository.nums(2, listPurchasesSold);

        // Assert
        assertEquals(2, result.size());
        assertTrue(result.contains(new Pair(id1, 0)));
        assertTrue(result.contains(new Pair(id2, 0)));
    }
}