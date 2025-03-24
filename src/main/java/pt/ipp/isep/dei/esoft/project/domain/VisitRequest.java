package pt.ipp.isep.dei.esoft.project.domain;
import pt.ipp.isep.dei.esoft.project.ENUMS.VisitRequestStatus;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 * Represents a visit request for an advertisement.
 * The visit request contains information such as the advertisement, date, start time, end time, and status.
 */
public class VisitRequest implements Serializable {
    private Advertisement advertisement;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private VisitRequestStatus status;

    /**
     * Constructs a VisitRequest object with the specified advertisement, date, start time, and end time.
     * The status is set to VisitRequestStatus.PENDING by default.
     *
     * @param advertisement the advertisement associated with the visit request
     * @param date          the date of the visit request
     * @param startTime     the start time of the visit request
     * @param endTime       the end time of the visit request
     */
    public VisitRequest(Advertisement advertisement, LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.advertisement = advertisement;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = VisitRequestStatus.PENDING;
    }

    /**
     * Constructs a VisitRequest object with the specified advertisement, date, start time, end time, and status.
     *
     * @param advertisement the advertisement associated with the visit request
     * @param date          the date of the visit request
     * @param startTime     the start time of the visit request
     * @param endTime       the end time of the visit request
     * @param status        the status of the visit request
     */
    public VisitRequest(Advertisement advertisement, LocalDate date, LocalTime startTime, LocalTime endTime, VisitRequestStatus status) {
        this.advertisement = advertisement;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    /**
     * Returns the advertisement associated with the visit request.
     *
     * @return the advertisement
     */
    public Advertisement getAdvertisement() {
        return advertisement;
    }

    /**
     * Returns the date of the visit request.
     *
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Returns the start time of the visit request.
     *
     * @return the start time
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * Returns the end time of the visit request.
     *
     * @return the end time
     */
    public LocalTime getEndTime() {
        return endTime;
    }

    /**
     * Returns the status of the visit request.
     *
     * @return the status
     */
    public VisitRequestStatus getStatus() {
        return status;
    }

    /**
     * Sets the status of the visit request.
     *
     * @param status the status to be set
     */
    public void setStatus(VisitRequestStatus status) {
        this.status = status;
    }

    /**
     * Checks if the visit request overlaps with a specified time range.
     *
     * @param startTime the start time of the specified time range
     * @param endTime   the end time of the specified time range
     * @return true if the visit request overlaps with the specified time range, false otherwise
     */
    public boolean isOverlapping(LocalTime startTime, LocalTime endTime) {
        if (this.startTime.isBefore(endTime)) {
            return true;
        }
        if (this.endTime.isAfter(startTime) && this.endTime.isBefore(endTime)) {
            return true;
        }
        if (this.startTime.isBefore(startTime) && this.endTime.isAfter(endTime)) {
            return true;
        }
        if (this.startTime.equals(startTime) || this.endTime.equals(endTime)) {
            return true;
        }
        if (startTime.isBefore(this.startTime) || endTime.isAfter(this.endTime)) {
            return true;
        }
        return false;
    }

    /**
     * Checks if this visit request is equal to another object.
     *
     * @param o the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitRequest that = (VisitRequest) o;
        return Objects.equals(advertisement, that.advertisement) && Objects.equals(date, that.date) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && status == that.status;
    }

    /**
     * Returns the hash code of the visit request.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(advertisement, date, startTime, endTime, status);
    }

    /**
     * Returns a string representation of the visit request.
     *
     * @return a string representation
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
