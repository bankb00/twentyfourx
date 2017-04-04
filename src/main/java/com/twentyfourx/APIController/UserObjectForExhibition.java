package com.twentyfourx.APIController;

/**
 * Created by Thanawat on 3/31/2017.
 */
public class UserObjectForExhibition {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;
    private String name;
    private String email;
    private String registeredDate;
    private String mobileNo;
    private String holderRole;
    private String department;
    private boolean evaluation;

    public String getHolderRole() {
        return holderRole;
    }

    public void setHolderRole(String holderRole) {
        this.holderRole = holderRole;
    }

    public boolean isEvaluation() {
        return evaluation;
    }

    public void setEvaluation(boolean evaluation) {
        this.evaluation = evaluation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }

    public UserObjectForExhibition() {
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

    public void setMonileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }



    public UserObjectForExhibition(String registeredDate,String id, String name, String email, String mobileNo,String holderRole, boolean evaluation, String department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobileNo = mobileNo;
        this.department = department;
        this.registeredDate = registeredDate;
        this.holderRole = holderRole;
        this.evaluation = evaluation;
    }
}
