package pt.ipp.isep.dei.esoft.project.Mappers;

import pt.ipp.isep.dei.esoft.project.DTO.AdvertisementDTO;
import pt.ipp.isep.dei.esoft.project.DTO.ClientDTO;
import pt.ipp.isep.dei.esoft.project.DTO.PurchaseOrderDTO;
import pt.ipp.isep.dei.esoft.project.domain.Advertisement;
import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.PurchaseOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * Mapper class for converting PurchaseOrder objects to PurchaseOrderDTO objects and vice versa.
 */
public class PurchaseOrderMapper {

    /**
     * Converts a PurchaseOrder object to a PurchaseOrderDTO object.
     *
     * @param purchaseOrder The PurchaseOrder object to be converted.
     * @return The corresponding PurchaseOrderDTO object.
     */
    public static PurchaseOrderDTO toDTO(PurchaseOrder purchaseOrder) {
        double orderAmount = purchaseOrder.getOrderAmount();
        ClientDTO clientDTO = ClientMapper.toDTO(purchaseOrder.getClient());
        AdvertisementDTO advertisementDTO = AdvertisementMapper.toDTO(purchaseOrder.getAdvertisement());

        return new PurchaseOrderDTO(orderAmount, clientDTO, advertisementDTO);
    }

    /**
     * Converts a list of PurchaseOrder objects to a list of PurchaseOrderDTO objects.
     *
     * @param purchaseOrders The list of PurchaseOrder objects to be converted.
     * @return The corresponding list of PurchaseOrderDTO objects.
     */
    public static List<PurchaseOrderDTO> toDTOList(List<PurchaseOrder> purchaseOrders) {
        List<PurchaseOrderDTO> purchaseOrderDTOList = new ArrayList<>();
        for (PurchaseOrder purchaseOrder : purchaseOrders) {
            double orderAmount = purchaseOrder.getOrderAmount();
            ClientDTO clientDTO = ClientMapper.toDTO(purchaseOrder.getClient());
            AdvertisementDTO advertisementDTO = AdvertisementMapper.toDTO(purchaseOrder.getAdvertisement());
            PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO(orderAmount, clientDTO, advertisementDTO);
            purchaseOrderDTOList.add(purchaseOrderDTO);
        }
        return purchaseOrderDTOList;
    }

    /**
     * Converts a PurchaseOrderDTO object to a PurchaseOrder entity.
     *
     * @param purchaseOrderDTO The PurchaseOrderDTO object to be converted.
     * @return The corresponding PurchaseOrder entity.
     */
    public static PurchaseOrder toEntity(PurchaseOrderDTO purchaseOrderDTO) {
        double orderAmount = purchaseOrderDTO.getOrderAmount();
        Client client = ClientMapper.toEntity(purchaseOrderDTO.getClient());
        Advertisement advertisement = AdvertisementMapper.toEntity(purchaseOrderDTO.getAdvertisement());

        return new PurchaseOrder(orderAmount, client, advertisement);
    }
}