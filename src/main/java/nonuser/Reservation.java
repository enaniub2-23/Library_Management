package nonuser;

import java.io.Serializable;
import java.time.LocalDate;

public class Reservation implements Serializable {
    private final String reservationId;
    private int memberId;
    private String isbn;
    private LocalDate requestDate;
    private int queuePosition;
    private String status;

    public Reservation(String reservationId, int memberId, String isbn, LocalDate requestDate, int queuePosition, String status) {
        this.reservationId = reservationId;
        this.memberId = memberId;
        this.isbn = isbn;
        this.requestDate = requestDate;
        this.queuePosition = queuePosition;
        this.status = "PENDING";
    }

    public String getReservationId() {
        return reservationId;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public int getQueuePosition() {
        return queuePosition;
    }

    public String getStatus() {
        return status;
    }
    public void activateHold(){
        this.status ="HOLD_FOR_PICKUP";
    }
}
