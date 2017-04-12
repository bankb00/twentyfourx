package com.twentyfourx.APIController;

/**
 * Created by Thanawat on 3/28/2017.
 */
public class LoginObject {
    private boolean loginSuccess;
    private boolean isRegistered;

    private UserObject user;


    public LoginObject(boolean isSuc, boolean isVa) {
        this.loginSuccess = isSuc;
        this.isRegistered = isVa;
        this.user = null;
    }

    public boolean getLoginSuccess() {
        return loginSuccess;
    }

    public void setLoginSuccess(boolean loginSuccess) {
        this.loginSuccess = loginSuccess;
    }

    public boolean getIsRegistered() {
        return isRegistered;
    }

    public void setIsRegistered(boolean register) {
        isRegistered = register;
    }


    public UserObject getUser() {
        return user;
    }

    public void setUser(UserObject user) {
        this.user = user;
    }
}
