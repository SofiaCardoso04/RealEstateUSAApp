package pt.ipp.isep.dei.esoft.project.Mappers;

import pt.ipp.isep.dei.esoft.project.DTO.AdvertisementDTO;
import pt.ipp.isep.dei.esoft.project.DTO.DealsDTO;
import pt.ipp.isep.dei.esoft.project.domain.PurchaseOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * Mapper class for converting PurchaseOrder objects to DealsDTO objects.
 */
public class DealsMapper {

    /**
     * Converts a PurchaseOrder object to a DealsDTO object.
     *
     * @param deal The PurchaseOrder object to be converted.
     * @return The corresponding DealsDTO object.
     */
    public DealsDTO toDTO(PurchaseOrder deal) {
        DealsDTO dealDTO = new DealsDTO();
        dealDTO.advertisement = deal.getAdvertisement();
        dealDTO.sale = deal.getSalePrice();
        dealDTO.dateOfSale = deal.getDateOfSale();
        dealDTO.status = deal.getOrderStatus();
        return dealDTO;
    }

    /**
     * Converts a list of PurchaseOrder objects to a list of DealsDTO objects.
     *
     * @param dealsList The list of PurchaseOrder objects to be converted.
     * @return The corresponding list of DealsDTO objects.
     */
    public List<DealsDTO> toDTO(List<PurchaseOrder> dealsList) {
        List<DealsDTO> doneDealsDTOs = new ArrayList<>();
        for (PurchaseOrder deal : dealsList) {
            doneDealsDTOs.add(toDTO(deal));
        }
        return doneDealsDTOs;
    }
}