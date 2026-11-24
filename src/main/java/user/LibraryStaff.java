package user;

public abstract class LibraryStaff extends User {
    protected final int staffId;
    protected String department;
    protected double salary;

    public LibraryStaff(int id, long nid, String name, String phoneNo, String email, String password, int staffId, String department, double salary) {
        super(id, nid, name, phoneNo, email, password);
        this.staffId = staffId;
        this.department = department;
        this.salary = salary;
    }

    public int getStaffId() {
        return staffId;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
    public boolean verifyDutyShift(){
        return true;
    }
    public String generateWorkLog(){
        return "Staff Id: " + staffId + "| Dept: " + department;

    }
}
