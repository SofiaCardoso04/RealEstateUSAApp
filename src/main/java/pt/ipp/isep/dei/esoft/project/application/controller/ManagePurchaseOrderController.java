package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.DTO.PurchaseOrderDTO;
import pt.ipp.isep.dei.esoft.project.Mappers.PurchaseOrderMapper;
import pt.ipp.isep.dei.esoft.project.domain.Advertisement;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.PurchaseOrder;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManagePurchaseOrderController {

    private PurchaseOrderMapper purchaseOrderMapper;
    private OrderRepository orderRepository;
    private AuthenticationRepository authenticationRepository;
    private EmployeeRepository employeeRepository;

    /**
     * Constructs a new ManagePurchaseOrderController.
     * Initializes the orderRepository, purchaseOrderMapper, authenticationRepository, and employeeRepository.
     */
    public ManagePurchaseOrderController() {
        getOrderRepository();
        purchaseOrderMapper = new PurchaseOrderMapper();
        getAuthenticationRepository();
        getEmployeeRepository();
    }

    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    private EmployeeRepository getEmployeeRepository() {
        if (employeeRepository == null) {
            Repositories repositories = Repositories.getInstance();
            employeeRepository = repositories.getEmployeeRepository();
        }
        return employeeRepository;
    }

    /**
     * Retrieves the OrderRepository instance.
     *
     * @return the OrderRepository instance
     */
    public OrderRepository getOrderRepository() {
        if (orderRepository == null) {
            Repositories repositories = Repositories.getInstance();
            orderRepository = repositories.getOrderRepository();
        }
        return orderRepository;
    }

    /**
     * Retrieves the email of the current user.
     *
     * @return the email of the current user
     */
    public String getCurrentUserEmail() {
        return authenticationRepository.getCurrentUserEmail();
    }

    /**
     * Retrieves the Employee instance of the current user.
     *
     * @return the Employee instance of the current user
     */
    public Employee getCurrentUser() {
        String userEmail = getCurrentUserEmail();
        if (userEmail != null) {
            Employee employee = employeeRepository.getEmployeeByEmail(userEmail);
            if (employee != null) {
                return employee;
            }
        }
        return null;
    }

    /**
     * Retrieves the list of pending purchase offers for the given agent and property type.
     * The list is sorted by descending amount and advertisement date.
     *
     * @param agent        the agent responsible for the purchase offers
     * @param propertyType the type of property
     * @return the list of PurchaseOrderDTO instances
     */
    public List<PurchaseOrderDTO> getPendingPurchaseOffers(Employee agent, String propertyType) {
        OrderRepository orderRepository = Repositories.getInstance().getOrderRepository();
        List<PurchaseOrder> purchaseOrderList = orderRepository.listPendingPurchaseOrders(agent, propertyType);

        // Sort the purchase orders by descending amount and advertisement date
        Collections.sort(purchaseOrderList, new AmountAndDateComparator());

        return PurchaseOrderMapper.toDTOList(purchaseOrderList);
    }

    /**
     * Accepts a purchase order.
     * Updates the status of the advertisement and declines all pending purchase orders for the property.
     *
     * @param purchaseOrderDTO the PurchaseOrderDTO to be accepted
     */
    public void acceptPurchaseOrder(PurchaseOrderDTO purchaseOrderDTO) {
        OrderRepository orderRepository = Repositories.getInstance().getOrderRepository();
        PurchaseOrder purchaseOrder = orderRepository.find(purchaseOrderDTO);

        // Accept the purchase order
        purchaseOrder.accept();
        purchaseOrder.getDateOfSale();

        // Update the status of the advertisement
        AdvertisementRepository advertisementRepository = Repositories.getInstance().getAdvertisementRepository();
        Advertisement advertisement = purchaseOrder.getAdvertisement();
        advertisementRepository.soldAdvertisement(advertisement);

        // Get all pending purchase orders for the property and decline them
        List<PurchaseOrderDTO> pendingPurchaseOrders = orderRepository.listPendingPurchaseOrdersByProperty(purchaseOrderDTO);
        for (PurchaseOrderDTO pendingPurchaseOrderDTO : pendingPurchaseOrders) {
            PurchaseOrder pendingPurchaseOrderEntity = orderRepository.find(pendingPurchaseOrderDTO);
            pendingPurchaseOrderEntity.decline();
        }
    }

    /**
     * Declines a purchase order.
     *
     * @param purchaseOrderDTO the PurchaseOrderDTO to be declined
     */
    public void declinePurchaseOrder(PurchaseOrderDTO purchaseOrderDTO) {
        OrderRepository orderRepository = Repositories.getInstance().getOrderRepository();
        PurchaseOrder purchaseOrder = orderRepository.find(purchaseOrderDTO);

        // Decline the purchase order
        purchaseOrder.decline();
    }
}












