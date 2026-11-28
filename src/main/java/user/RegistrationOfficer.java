package user;

import java.time.LocalDate;
import java.util.List;

public class RegistrationOfficer extends LibraryStaff {
    private int counterNo;
    private int memberId;

    public RegistrationOfficer(int id, long nid, String name, String phoneNo, String email, String password, int staffId, String department, double salary, int counterNo,int memberId) {
        super(id, nid, name, phoneNo, email, password, staffId, department, salary);
        this.counterNo = counterNo;
    }

    public int getCounterNo() {
        return counterNo;
    }
    public int getMemberId(){return memberId;}

    public void setCounterNo(int counterNo) {
        this.counterNo = counterNo;
    }
    public void setMemberId(int memberId){
        this.memberId=memberId;
    }

    public boolean registerMember(LibraryMember newMember, List<User> existingUsers) {
        if (newMember == null) {
            return false;
        }
        for (User u : existingUsers) {
            if (u.getNid() == newMember.getNid() || u.getEmail().equalsIgnoreCase(newMember.getEmail())) {
                return false;
            }
        }
        existingUsers.add(newMember);
        return true;
    }

    public boolean verifyCredentials(LibraryMember member, long submittedNid) {
        if (member == null) {
            return false;
        }

        return member.getNid() == submittedNid && String.valueOf(submittedNid).length() >= 10;
    }

    public void issueMembershipCard(LibraryMember member) {
        if (member != null) {
            String cardNo = "CARD-" + member.getId() + "-" + LocalDate.now().getYear();
            member.setMemberCardNo(cardNo);
            member.setExpiryDate(LocalDate.now().plusYears(1));
        }
    }

    @Override
    public String toString() {
        return "RegistrationOfficer{" +
                "counterNo=" + counterNo +
                ", memberId=" + memberId +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", staffId=" + staffId +
                ", name='" + name + '\'' +
                ", nid=" + nid +
                '}';
    }

    @Override
    public String getDashboardFXML() {
        return "/RegistrationOfficer/dashboardView.fxml";
    }
}