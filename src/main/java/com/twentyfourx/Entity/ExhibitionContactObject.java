package com.twentyfourx.Entity;

import java.io.Serializable;

/**
 * Created by Thanawat on 4/9/2017.
 */
public class ExhibitionContactObject implements Serializable {
    private static final long serialVersionUID = 1L;
    private String email;
    private String facebook;
    private String facebookUrl;
    private String mobileNo;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public ExhibitionContactObject() {

    }
}
