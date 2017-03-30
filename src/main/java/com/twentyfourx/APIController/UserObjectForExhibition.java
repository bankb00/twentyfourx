package com.twentyfourx.APIController;

/**
 * Created by Thanawat on 3/31/2017.
 */
public class UserObjectForExhibition {
    private String name;
    private String email;

    public UserObjectForExhibition() {
    }

    private String mobileNo;
    private String companyName;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public UserObjectForExhibition(String name, String email, String mobileNo, String companyName) {

        this.name = name;
        this.email = email;
        this.mobileNo = mobileNo;
        this.companyName = companyName;
    }
}
