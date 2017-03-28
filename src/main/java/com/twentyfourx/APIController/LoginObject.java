package com.twentyfourx.APIController;

/**
 * Created by Thanawat on 3/28/2017.
 */
public class LoginObject {
    private boolean loginSuccess;
    private boolean isRegister;

    public LoginObject(boolean isSuc,boolean isVa) {
        this.loginSuccess = isSuc;
        this.isRegister = isVa;
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


}
