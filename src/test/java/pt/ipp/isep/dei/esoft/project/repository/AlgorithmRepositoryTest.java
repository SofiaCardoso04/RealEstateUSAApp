package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Advertisement;
import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.PurchaseOrder;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import pt.ipp.isep.dei.esoft.project.domain.*;


public class AlgorithmRepositoryTest {
    private AlgorithmRepository algorithmRepository;

    @BeforeEach
    public void setUp() {
        algorithmRepository = new AlgorithmRepository();
    }

    @Test
    public void getListByGnomeSort_ValidInput_ReturnsSortedPurchaseOrders() {
        // Arrange
        List<PurchaseOrder> purchaseOrders = createSamplePurchaseOrders();
        int option = 1;

        // Act
        List<PurchaseOrder> sortedList = algorithmRepository.getListByGnomeSort(purchaseOrders, option);

        // Assert
        assertEquals(3, sortedList.size());
        assertEquals(100.0, sortedList.get(0).getOrderAmount());
        assertEquals(200.0, sortedList.get(1).getOrderAmount());
        assertEquals(150.0, sortedList.get(2).getOrderAmount());
    }

    @Test
    public void getListByBubbleSort_ValidInput_ReturnsSortedPurchaseOrders() {
        // Arrange
        List<PurchaseOrder> purchaseOrders = createSamplePurchaseOrders();
        int option = 2;

        // Act
        List<PurchaseOrder> sortedList = algorithmRepository.getListByBubbleSort(purchaseOrders, option);

        // Assert
        assertEquals(3, sortedList.size());
        assertEquals(100.0, sortedList.get(0).getOrderAmount());
        assertEquals(200.0, sortedList.get(1).getOrderAmount());
        assertEquals(150.0, sortedList.get(2).getOrderAmount());
    }

    private List<PurchaseOrder> createSamplePurchaseOrders() {
        List<PurchaseOrder> purchaseOrders = new ArrayList<>();

        // Define the test data
        String name = "John Doe";
        String passportCardNumber = "123456789";
        String taxNumber = "123-45-6789";
        String emailAddress = "john.doe@example.com";
        String phoneNumber = "123-456-7890";
        int advertisementID = 1;
        double area = 100.0;
        double distanceFromCity = 10.0;
        String photograph = "property.jpg";
        String id = "12345";
        String designation = "Manager";
        String email = "store@example.com";
        String propertyType = "House";
        String requestType = "Sale";
        String date1 = "2023-06-13";
        double salePrice = 200000.0;

        Commission commission1 = new Commission(500.0, 10);
        Address address = new Address("123 Main St", "City", "State", "12345");
        Client client = new Client(name, passportCardNumber, taxNumber, emailAddress, phoneNumber);
        Property property = new Property(area, distanceFromCity, photograph, address);
        OrganizationRole organizationRole = new OrganizationRole("Agent");
        Store store = new Store(address, id, phoneNumber, designation, email);
        Employee employee = new Employee(name, passportCardNumber, taxNumber, emailAddress, phoneNumber, organizationRole, address, store);
        Advertisement advertisement1 = new Advertisement(employee, client, advertisementID, property, propertyType, commission1, requestType, date1, salePrice);

        PurchaseOrder purchaseOrder1 = new PurchaseOrder(100.0, client, advertisement1);
        PurchaseOrder purchaseOrder2 = new PurchaseOrder(200.0, client, advertisement1);
        PurchaseOrder purchaseOrder3 = new PurchaseOrder(150.0, client, advertisement1);

        purchaseOrders.add(purchaseOrder1);
        purchaseOrders.add(purchaseOrder2);
        purchaseOrders.add(purchaseOrder3);

        return purchaseOrders;
    }
}