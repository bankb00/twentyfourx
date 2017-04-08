package com.twentyfourx.APIController;

/**
 * Created by Thanawat on 3/28/2017.
 */
public class UserObject {
    private String name;
    private String email;
    private String mobileNo;
    private String userId;
    private String accessToken;
    private String password;
    private String username;
    private String companyName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public UserObject(String userName, String name, String email, String mobileNo, String userId, String accessToken, String password, String companyName) {
        this.name = name;
        this.email = email;
        this.mobileNo = mobileNo;
        this.userId = userId;
        this.accessToken = accessToken;
        this.password = password;
        this.companyName = companyName;
        this.username = userName;

    }

    public UserObject() {
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
