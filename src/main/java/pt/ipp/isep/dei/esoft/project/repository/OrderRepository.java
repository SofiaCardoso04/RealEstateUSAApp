package pt.ipp.isep.dei.esoft.project.repository;

import javafx.util.Pair;
import pt.ipp.isep.dei.esoft.project.DTO.*;
import pt.ipp.isep.dei.esoft.project.ENUMS.OrderStatus;
import pt.ipp.isep.dei.esoft.project.Mappers.*;
import pt.ipp.isep.dei.esoft.project.domain.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository class for PurchaseOrder objects.
 */
public class OrderRepository implements Serializable {

    private static final String ORDER_SERIALIZATION_FILE_PATH = "Serialization/Order.ser";
    private ArrayList<PurchaseOrder> orders = new ArrayList<>();
    private ArrayList<Store> storesList = new ArrayList<>();
    public static List<PurchaseOrderDTO> ordersDTO = new ArrayList<>();

    /**
     * Retrieves the list of PurchaseOrders.
     *
     * @return The list of PurchaseOrders.
     */
    public ArrayList<PurchaseOrder> getOrders() {
        return orders;
    }

    /**
     * Retrieves the list of PurchaseOrderDTOs.
     *
     * @return The list of PurchaseOrderDTOs.
     */
    public static List<PurchaseOrderDTO> getOrdersDTO() {
        return ordersDTO;
    }

    /**
     * Validates if an order is valid and can be added.
     *
     * @param order The PurchaseOrder to validate.
     * @return True if the order is valid, false otherwise.
     */
    public boolean validateOrder(PurchaseOrder order) {
        for (int i = 0; i < orders.size(); i++) {
            PurchaseOrder existingOrder = orders.get(i);
            if (existingOrder.getClient().equals(order.getClient()) && existingOrder.getAdvertisement().equals(order.getAdvertisement()))
                return true;
        }
        if (order.getOrderAmount() == -1) return true;
        return orders.contains(order);
    }

    /**
     * Adds a PurchaseOrder to the repository.
     *
     * @param order The PurchaseOrder to add.
     * @return True if the order is added successfully, false otherwise.
     */
    public boolean addOrder(PurchaseOrder order) {
        if (order == null) {
            return false;
        }
        if (validateOrder(order)) {
            return false;
        }
        orders.add(order);
        return true;
    }

    /**
     * Retrieves a list of pending PurchaseOrders for a specific agent and property type.
     *
     * @param agent        The agent.
     * @param propertyType The property type.
     * @return The list of pending PurchaseOrders.
     */
    public ArrayList<PurchaseOrder> listPendingPurchaseOrders(Employee agent, String propertyType) {
        ArrayList<PurchaseOrder> pendingPurchaseOrders = new ArrayList<>();
        for (PurchaseOrder purchaseOrder : orders) {
            Advertisement advertisement = purchaseOrder.getAdvertisement();
            if (purchaseOrder.getOrderStatus() == OrderStatus.PENDING && advertisement.getAgent().equals(agent) && advertisement.getPropertyType().equals(propertyType)) {
                pendingPurchaseOrders.add(purchaseOrder);
            }
        }
        return pendingPurchaseOrders;
    }

    /**
     * Retrieves a list of pending PurchaseOrderDTOs for a specific property.
     *
     * @param purchaseOrderDTO The PurchaseOrderDTO containing the property information.
     * @return The list of pending PurchaseOrderDTOs.
     */
    public List<PurchaseOrderDTO> listPendingPurchaseOrdersByProperty(PurchaseOrderDTO purchaseOrderDTO) {
        List<PurchaseOrderDTO> pendingPurchaseOrdersByProperty = new ArrayList<>();
        Property property = purchaseOrderDTO.getAdvertisement().getProperty();
        for (PurchaseOrder purchaseOrder : orders) {
            if (purchaseOrder.getOrderStatus() == OrderStatus.PENDING &&
                    purchaseOrder.getAdvertisement().getProperty().equals(property)) {
                pendingPurchaseOrdersByProperty.add(PurchaseOrderMapper.toDTO(purchaseOrder));
            }
        }
        return pendingPurchaseOrdersByProperty;
    }

    /**
     * Finds a PurchaseOrder based on its DTO representation.
     *
     * @param purchaseOrderDTO The PurchaseOrderDTO to find.
     * @return The matching PurchaseOrder, or null if not found.
     */
    public PurchaseOrder find(PurchaseOrderDTO purchaseOrderDTO) {
        double orderAmount = purchaseOrderDTO.getOrderAmount();
        ClientDTO clientDto = purchaseOrderDTO.getClient();
        AdvertisementDTO advertisementDto = purchaseOrderDTO.getAdvertisement();

        Client client = ClientMapper.toEntity(clientDto);
        Advertisement advertisement = AdvertisementMapper.toEntity(advertisementDto);

        for (PurchaseOrder purchaseOrder : orders) {
            if (purchaseOrder.getOrderAmount() == orderAmount &&
                    purchaseOrder.getClient().equals(client) &&
                    purchaseOrder.getAdvertisement().equals(advertisement)) {
                return purchaseOrder;
            }
        }
        return null;
    }

    /**
     * Retrieves a list of PurchaseOrders that have been sold.
     *
     * @return The list of PurchaseOrders that have been sold.
     */
    public List<PurchaseOrder> getPurchasesSold() {
        ArrayList<PurchaseOrder> listPurchasesSold = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderStatus() == OrderStatus.ACCEPTED) {
                listPurchasesSold.add(orders.get(i));
            }
        }
        return listPurchasesSold;
    }

    /**
     * Retrieves a list of houses and apartments that have been sold.
     *
     * @return The list of houses and apartments that have been sold.
     */
    public List<PurchaseOrder> getHousesAndApartmentsSold() {
        ArrayList<PurchaseOrder> listHousesAndApartmentsSold = new ArrayList<>();
        for (int i = 0; i < getPurchasesSold().size(); i++) {
            if (getPurchasesSold().get(i).getAdvertisement().getPropertyType().equals("house") ||
                    getPurchasesSold().get(i).getAdvertisement().getPropertyType().equals("apartment")) {
                listHousesAndApartmentsSold.add(getPurchasesSold().get(i));
            }
        }
        return listHousesAndApartmentsSold;
    }

    /**
     * Retrieves a list of DealsDTO representing the houses and apartments that have been sold.
     *
     * @return The list of DealsDTO representing the houses and apartments that have been sold.
     */
    public List<DealsDTO> getDeals() {
        DealsMapper mapper = new DealsMapper();
        return mapper.toDTO(getHousesAndApartmentsSold());
    }
}
