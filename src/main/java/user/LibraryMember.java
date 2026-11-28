package user;

import nonuser.Fine;
import nonuser.Loantransaction;
import nonuser.Reservation;

import java.time.LocalDate;

public class LibraryMember extends User  {
    private String memberCardNo;
    private String membershipType;
    private LocalDate expiryDate;
    private int activeLoanCount;


    public String getMemberCardNo() {
        return memberCardNo;
    }

    public void setMemberCardNo(String memberCardNo) {
        this.memberCardNo = memberCardNo;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getActiveLoanCount() {
        return activeLoanCount;
    }

    public void setActiveLoanCount(int activeLoanCount) {
        this.activeLoanCount = activeLoanCount;
    }

    @Override
    public String toString() {
        return "LibraryMember{" +
                "memberCardNo='" + memberCardNo + '\'' +
                ", membershipType='" + membershipType + '\'' +
                ", expiryDate=" + expiryDate +
                ", activeLoanCount=" + activeLoanCount +
                ", id=" + id +
                ", nid=" + nid +
                ", name='" + name + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public LibraryMember(int id, long nid, String name, String phoneNo, String email, String password, String memberCardNo, String membershipType, LocalDate expiryDate, int activeLoanCount) {
        super(id, nid, name, phoneNo, email, password);
        this.memberCardNo = memberCardNo;
        this.membershipType = membershipType;
        this.expiryDate = expiryDate;
        this.activeLoanCount = activeLoanCount;


    }

    @Override
    public String getDashboardFXML() {
        return "/LibraryMember/dashboardView.fxml";
    }



    public Loantransaction requestBorrow(String isbn, LocalDate pickupDate, double unpaidFineBalance) {
        if (pickupDate.isAfter(LocalDate.now().plusDays(3)) || pickupDate.isBefore(LocalDate.now())) {
            return null;
        }
        if (this.activeLoanCount >= 3 || unpaidFineBalance > 0) {
            return null;
        }

        String txId = "TX-" + System.currentTimeMillis();
        LocalDate dueDate = pickupDate.plusDays(14);
        this.activeLoanCount++;

        return new Loantransaction(txId, this.id, isbn, pickupDate, dueDate, "PENDING");
    }

    public Reservation reserveBook(String isbn, int currentQueueSize, boolean alreadyReserved) {
        if (alreadyReserved) {
            return null;
        }
        String resId = "RES-" + System.currentTimeMillis();
        return new Reservation(resId, this.id, isbn, LocalDate.now(), currentQueueSize + 1, "PENDING");
    }

    public boolean renewLoan(Loantransaction loan, boolean hasActiveHolds) {
        if (loan == null || loan.getMemberId() != this.id) {
            return false;
        }
        if (loan.isOverdue() || hasActiveHolds || !"ISSUED".equalsIgnoreCase(loan.getStatus())) {
            return false;
        }

        loan.setDueDate(loan.getDueDate().plusDays(7));
        return true;
    }

    public boolean payFine(Fine fine, double amount) {
        if (fine == null || fine.getMemberId() != this.id || fine.isPaid()) {
            return false;
        }
        if (amount >= fine.getAmount()) {
            fine.markAsPaid();
            return true;
        }
        return false;
    }
}
