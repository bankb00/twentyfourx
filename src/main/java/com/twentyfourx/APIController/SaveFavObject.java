package com.twentyfourx.APIController;

/**
 * Created by Thanawat on 3/30/2017.
 */
public class SaveFavObject {
    private boolean success;
    private String message;

    public SaveFavObject(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

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
