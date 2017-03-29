package com.twentyfourx.APIController;

/**
 * Created by Thanawat on 3/28/2017.
 */
public class LoginObject {
    private boolean loginSuccess;
    private boolean isRegister;

    private UserObject user;

    /*private String name;
    private String email;
    private String mobileNo;
    private String password;*/

    /*public String getName() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }*/

    public LoginObject(boolean isSuc, boolean isVa) {
        this.loginSuccess = isSuc;
        this.isRegister = isVa;
        this.user = null;
    }

    public boolean getLoginSuccess() {
        return loginSuccess;
    }

    public void setLoginSuccess(boolean loginSuccess) {
        this.loginSuccess = loginSuccess;
    }

    public boolean getIsRegister() {
        return isRegister;
    }

    public void setIsRegister(boolean register) {
        isRegister = register;
    }


    public UserObject getUser() {
        return user;
    }

    public void setUser(UserObject user) {
        this.user = user;
    }
}
