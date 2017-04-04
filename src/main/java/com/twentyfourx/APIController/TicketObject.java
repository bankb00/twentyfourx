package com.twentyfourx.APIController;

/**
 * Created by Thanawat on 3/30/2017.
 */
// ตัวป้อน ตอนกดลงทะเบียน
public class TicketObject {
    private String name;
    private String email;
    private String mobileNo;
    private String department;
    private String holderRole;

    public String getHolderRole() {
        return holderRole;
    }

    public void setHolderRole(String holderRole) {
        this.holderRole = holderRole;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

}
