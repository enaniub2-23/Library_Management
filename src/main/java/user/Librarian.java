package user;
import nonuser.Loantransaction;
import nonuser.Book;
import java.time.LocalDate;

public class Librarian extends LibraryStaff {
    private String assignedWing;
    private static int totalLibrarianCount = 0;

    public Librarian(int id, long nid, String name, String phoneNo, String email, String password, int staffId, String department, double salary, String assignedWing) {
        super(id, nid, name, phoneNo, email, password, staffId, department, salary);
        this.assignedWing = assignedWing;
        totalLibrarianCount++;
    }

    public String getAssignedWing() {
        return assignedWing;
    }

    public static int getTotalLibrarianCount() {
        return totalLibrarianCount;
    }

    public void setAssignedWing(String assignedWing) {
        this.assignedWing = assignedWing;
    }

    public  String getDashboardFXML(){
        return "LibrarianDashboardView.fxml";
    }
    public void addBook(Book book){
        //
    }
    public Loantransaction issueBook(int memberId,String isbn){
        String txId="TX-" + System.currentTimeMillis();
        LocalDate issueDate=LocalDate.now();
        LocalDate dueDate = issueDate.plusDays(14);
        return new Loantransaction(txId,memberId,isbn,issueDate,dueDate,"ISSUED");
    }
    public double returnBook(String txId){
        return 0.0;
    }

}
