package nonuser;

import java.time.LocalDate;

public class BorrowBookHistoryHelper {
    private String isbn;
    private String title;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private String status;

    public BorrowBookHistoryHelper(String isbn, String title, LocalDate issueDate, LocalDate dueDate, String status) {
        this.isbn = isbn;
        this.title = title;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.status = status;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public LocalDate getIssueDate() { return issueDate; }
    public LocalDate getDueDate() { return dueDate; }
    public String getStatus() { return status; }
}