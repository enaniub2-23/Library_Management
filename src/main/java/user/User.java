package user;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;

public abstract class User implements Serializable {
    protected final int id;
    protected final long nid;
    protected String name;
    protected String phoneNo;
    protected String email;
    protected String password;

    public User(int id, long nid, String name, String phoneNo, String email, String password) {
        this.id = id;
        this.nid = nid;
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public long getNid() {
        return nid;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nid=" + nid +
                ", name='" + name + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public abstract String getDashboardFXML();

    public boolean login(int id, String pw){
        return this.id ==id && this.password.equals(pw);
    }
    public boolean changePw(String oldPw,String newPw){
        if(this.password.equals(oldPw) && newPw != null && newPw.length() >=3){
            this.password=newPw;
            return true;
        }
        return false;
    }
    public void updateProfile(String email,String phone){
        this.email=email;
        this.phoneNo=phone;
    }

}
