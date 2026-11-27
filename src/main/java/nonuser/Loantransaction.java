package nonuser;

import java.io.Serializable;
import java.time.LocalDate;

public class Loantransaction implements Serializable {
    private final String transactionId;
    private int memberId;
    private String isbn;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private String status;

    public Loantransaction(String transactionId, int memberId, String isbn, LocalDate issueDate, LocalDate dueDate, String status) {
        this.transactionId = transactionId;
        this.memberId = memberId;
        this.isbn = isbn;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.status = status;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    public boolean isOverdue(){
        return "ISSUED".equalsIgnoreCase(status) && LocalDate.now().isAfter(dueDate);
    }
}
