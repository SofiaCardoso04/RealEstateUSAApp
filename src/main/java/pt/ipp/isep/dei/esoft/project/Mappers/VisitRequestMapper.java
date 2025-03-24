package pt.ipp.isep.dei.esoft.project.Mappers;

import pt.ipp.isep.dei.esoft.project.DTO.AdvertisementDTO;
import pt.ipp.isep.dei.esoft.project.DTO.PurchaseOrderDTO;
import pt.ipp.isep.dei.esoft.project.DTO.VisitRequestDTO;
import pt.ipp.isep.dei.esoft.project.ENUMS.VisitRequestStatus;
import pt.ipp.isep.dei.esoft.project.domain.Advertisement;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Mapper class for converting VisitRequest objects to VisitRequestDTO objects and vice versa.
 */
public class VisitRequestMapper {

    /**
     * Converts a VisitRequest object to a VisitRequestDTO object.
     *
     * @param visitRequest The VisitRequest object to be converted.
     * @return The corresponding VisitRequestDTO object.
     */
    public static VisitRequestDTO toDTO(VisitRequest visitRequest) {
        AdvertisementDTO advertisementDTO = AdvertisementMapper.toDTO(visitRequest.getAdvertisement());
        LocalDate date = visitRequest.getDate();
        LocalTime startTime = visitRequest.getStartTime();
        LocalTime endTime = visitRequest.getEndTime();
        VisitRequestStatus status = visitRequest.getStatus();

        return new VisitRequestDTO(advertisementDTO, date, startTime, endTime, status);
    }

    /**
     * Converts a list of VisitRequest objects to a list of VisitRequestDTO objects.
     *
     * @param list The list of VisitRequest objects to be converted.
     * @return The corresponding list of VisitRequestDTO objects.
     */
    public static List<VisitRequestDTO> toDTOList(ArrayList<VisitRequest> list) {
        List<VisitRequestDTO> visitRequestDTOList = new ArrayList<>();
        for (VisitRequest visitRequest : list) {
            AdvertisementDTO advertisementDTO = AdvertisementMapper.toDTO(visitRequest.getAdvertisement());
            LocalDate date = visitRequest.getDate();
            LocalTime startTime = visitRequest.getStartTime();
            LocalTime endTime = visitRequest.getEndTime();
            VisitRequestDTO visitRequestDTO = new VisitRequestDTO(advertisementDTO, date, startTime, endTime);
            visitRequestDTOList.add(visitRequestDTO);
        }
        return visitRequestDTOList;
    }

    /**
     * Converts a VisitRequestDTO object to a VisitRequest entity.
     *
     * @param visitRequestDTO The VisitRequestDTO object to be converted.
     * @return The corresponding VisitRequest entity.
     */
    public static VisitRequest toEntity(VisitRequestDTO visitRequestDTO) {
        Advertisement advertisement = AdvertisementMapper.toEntity(visitRequestDTO.getAdvertisement());
        LocalDate date = visitRequestDTO.getDate();
        LocalTime startTime = visitRequestDTO.getStartTime();
        LocalTime endTime = visitRequestDTO.getEndTime();
        VisitRequestStatus status = visitRequestDTO.getStatus();

        return new VisitRequest(advertisement, date, startTime, endTime, status);
    }

    /**
     * Converts a list of VisitRequestDTO objects to a list of VisitRequest entities.
     *
     * @param list The list of VisitRequestDTO objects to be converted.
     * @return The corresponding list of VisitRequest entities.
     */
    public static ArrayList<VisitRequest> toEntityList(ArrayList<VisitRequestDTO> list) {
        ArrayList<VisitRequest> visitRequestList = new ArrayList<>();
        for (VisitRequestDTO visitRequestDTO : list) {
            Advertisement advertisement = AdvertisementMapper.toEntity(visitRequestDTO.getAdvertisement());
            LocalDate date = visitRequestDTO.getDate();
            LocalTime startTime = visitRequestDTO.getStartTime();
            LocalTime endTime = visitRequestDTO.getEndTime();
            VisitRequest visitRequest = new VisitRequest(advertisement, date, startTime, endTime);
            visitRequestList.add(visitRequest);
        }
        return visitRequestList;
    }
}
