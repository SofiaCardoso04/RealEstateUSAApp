package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.DTO.AdvertisementDTO;
import pt.ipp.isep.dei.esoft.project.DTO.ClientDTO;
import pt.ipp.isep.dei.esoft.project.DTO.PurchaseOrderDTO;
import pt.ipp.isep.dei.esoft.project.Mappers.AdvertisementMapper;
import pt.ipp.isep.dei.esoft.project.Mappers.ClientMapper;
import pt.ipp.isep.dei.esoft.project.Mappers.PurchaseOrderMapper;
import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.isep.lei.esoft.auth.UserSession;
import pt.ipp.isep.dei.esoft.project.domain.Advertisement;
import pt.ipp.isep.dei.esoft.project.domain.PurchaseOrder;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.ArrayList;

/**
 * Controller class for handling orders.
 */
public class OrderController {
    private PurchaseOrderMapper purchaseOrderMapper;

    private AdvertisementMapper advertisementMapper;

    ArrayList<Advertisement> advertisements;

    private OrderRepository orderRepository = null;
    private AuthenticationRepository authenticationRepository = null;
    private AgentListRepository agentListRepository = null;
    private ArrayList<PurchaseOrder> orders;

    /**
     * Constructs an OrderController and retrieves the OrderRepository instance.
     */
    public OrderController() {
        getOrderRepository();
        purchaseOrderMapper = new PurchaseOrderMapper();
    }

    /**
     * Retrieves the OrderRepository instance.
     *
     * @return The OrderRepository instance.
     */
    public OrderRepository getOrderRepository() {
        if (orderRepository == null) {
            Repositories repositories = Repositories.getInstance();
            orderRepository = repositories.getOrderRepository();
        }
        return orderRepository;
    }

    private AdvertisementRepository advertisementRepository = null;

    /**
     * Retrieves the list of advertisements.
     *
     * @return The list of Advertisement objects.
     */
    public ArrayList<Advertisement> getAdvertisements() {
        AdvertisementRepository advertisementRepository = Repositories.getInstance().getAdvertisementRepository();
        this.advertisements = advertisementRepository.getAdvertisements();
        return advertisements;
    }

    /**
     * Retrieves the list of AdvertisementDTO objects.
     *
     * @return The list of AdvertisementDTO objects.
     */
    public ArrayList<AdvertisementDTO> getAdvertisementsDTOs() {
        ArrayList<Advertisement> list = getAdvertisements();
        ArrayList<AdvertisementDTO> listDTO = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listDTO.add(AdvertisementMapper.toDTO(list.get(i)));
        }
        return listDTO;
    }

    /**
     * Retrieves the DTO representation of the current client.
     *
     * @return The ClientDTO object representing the current client.
     */
    public ClientDTO getClientDTO() {
        Client client = getCurrentClient();
        ClientDTO clientDTO = ClientMapper.toDTO(client);
        return clientDTO;
    }

    /**
     * Displays the advertisements based on the specified order.
     *
     * @param list The list of AdvertisementDTO objects to display.
     */
    public void showAdvertisementsByOrder(ArrayList<AdvertisementDTO> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Property#" + (i + 1) + ": " + advertisements.get(i).toString());
        }
    }

    /**
     * Validates the user's advertisement choice.
     *
     * @param choice The user's choice.
     * @param list   The list of AdvertisementDTO objects.
     * @return True if the choice is valid, false otherwise.
     */
    public boolean validateAdvertisementChoice(int choice, ArrayList<AdvertisementDTO> list) {
        if (choice >= 1 && choice <= list.size()) {
            return true;
        } else {
            System.out.println();
            System.out.println("Invalid property number");
            return false;
        }
    }

    /**
     * Validates the order amount.
     *
     * @param orderAmount     The order amount.
     * @param advertisementDTO The AdvertisementDTO object.
     * @return True if the order amount is valid, false otherwise.
     */
    public boolean validateOrderAmount(double orderAmount, AdvertisementDTO advertisementDTO) {
        if (orderAmount > 0 && orderAmount <= advertisementDTO.getSalePrice())
            return true;
        else {
            System.out.println();
            System.out.println("Invalid amount, your order's amount must be between 0 and the price set on the advertisement");
            return false;
        }
    }

    /**
     * Creates a PurchaseOrderDTO object.
     *
     * @param orderAmount      The order amount.
     * @param clientDTO        The ClientDTO object.
     * @param advertisementDTO The AdvertisementDTO object.
     * @return The PurchaseOrderDTO object.
     */
    public PurchaseOrderDTO createOrder(double orderAmount, ClientDTO clientDTO, AdvertisementDTO advertisementDTO) {
        PurchaseOrderDTO order = new PurchaseOrderDTO(orderAmount, clientDTO, advertisementDTO);
        return order;
    }

    /**
     * Registers an order.
     *
     * @param order The PurchaseOrderDTO object to register.
     * @return True if the order is registered successfully, false otherwise.
     */
    public boolean registerOrder(PurchaseOrderDTO order) {
        OrderRepository orderRepository = getOrderRepository();
        PurchaseOrder order2 = purchaseOrderMapper.toEntity(order);
        return orderRepository.addOrder(order2);
    }

    /**
     * Retrieves the current client.
     *
     * @return The Client object representing the current client.
     */
    public Client getCurrentClient() {
        AuthenticationRepository rep = Repositories.getInstance().getAuthenticationRepository();
        UserSession us = rep.getCurrentUserSession();
        String email = us.getUserId().getEmail();
        return Repositories.getInstance().getClientRepository().getClientByEmail(email);
    }
}