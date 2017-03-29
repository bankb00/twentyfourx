package com.twentyfourx.APIController;

/**
 * Created by Thanawat on 3/30/2017.
 */
public class ReturnRegister {
    public ReturnRegister(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    private boolean success;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
