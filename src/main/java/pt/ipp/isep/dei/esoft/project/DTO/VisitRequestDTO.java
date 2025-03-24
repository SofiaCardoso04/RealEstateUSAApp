package pt.ipp.isep.dei.esoft.project.DTO;

import pt.ipp.isep.dei.esoft.project.ENUMS.VisitRequestStatus;
import pt.ipp.isep.dei.esoft.project.domain.Advertisement;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 * Data Transfer Object (DTO) class representing a visit request.
 */
public class VisitRequestDTO {
    private AdvertisementDTO advertisement;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private VisitRequestStatus status;

    /**
     * Constructs a VisitRequestDTO object with the specified advertisement, date, start time, and end time.
     *
     * @param advertisement The advertisement associated with the visit request.
     * @param date          The date of the visit request.
     * @param startTime     The start time of the visit request.
     * @param endTime       The end time of the visit request.
     */
    public VisitRequestDTO(AdvertisementDTO advertisement, LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.advertisement = advertisement;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = VisitRequestStatus.PENDING;
    }

    /**
     * Constructs a VisitRequestDTO object with the specified advertisement, date, start time, end time, and status.
     *
     * @param advertisement The advertisement associated with the visit request.
     * @param date          The date of the visit request.
     * @param startTime     The start time of the visit request.
     * @param endTime       The end time of the visit request.
     * @param status        The status of the visit request.
     */
    public VisitRequestDTO(AdvertisementDTO advertisement, LocalDate date, LocalTime startTime, LocalTime endTime, VisitRequestStatus status) {
        this.advertisement = advertisement;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    /**
     * Retrieves the advertisement associated with the visit request.
     *
     * @return The AdvertisementDTO object.
     */
    public AdvertisementDTO getAdvertisement() {
        return advertisement;
    }

    /**
     * Retrieves the date of the visit request.
     *
     * @return The date.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Retrieves the start time of the visit request.
     *
     * @return The start time.
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * Retrieves the end time of the visit request.
     *
     * @return The end time.
     */
    public LocalTime getEndTime() {
        return endTime;
    }

    /**
     * Retrieves the status of the visit request.
     *
     * @return The status.
     */
    public VisitRequestStatus getStatus() {
        return status;
    }

    /**
     * Sets the status of the visit request.
     *
     * @param status The status to set.
     */
    public void setStatus(VisitRequestStatus status) {
        this.status = status;
    }

    /**
     * Checks if the visit request overlaps with the specified start time and end time.
     *
     * @param startTime The start time to check.
     * @param endTime   The end time to check.
     * @return True if there is an overlap, false otherwise.
     */
    public boolean isOverlapping(LocalTime startTime, LocalTime endTime) {
        if (startTime.isAfter(this.startTime) && startTime.isBefore(this.endTime)) {
            return false;
        }

        if (startTime.isBefore(this.startTime) && endTime.isAfter(this.endTime)) {
            return false;
        }

        if (endTime.isAfter(this.startTime) && endTime.isBefore(this.endTime)) {
            return false;
        }

        return true;
    }

    /**
     * Compares this visit request to the specified object for equality.
     *
     * @param o The object to compare.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitRequestDTO that = (VisitRequestDTO) o;
        return Objects.equals(advertisement, that.advertisement) &&
                Objects.equals(date, that.date) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime) &&
                status == that.status;
    }

    /**
     * Computes the hash code of this visit request.
     *
     * @return The hash code value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(advertisement, date, startTime, endTime, status);
    }

    /**
     * Returns a string representation of the VisitRequestDTO object.
     *
     * @return The string representation.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Visit Request:\n");
        sb.append("Advertisement: ").append(advertisement).append("\n");
        sb.append("Date: ").append(date).append("\n");
        sb.append("Start Time: ").append(startTime).append("\n");
        sb.append("End Time: ").append(endTime).append("\n");
        sb.append("Status: ").append(status).append("\n");
        return sb.toString();
    }
}
