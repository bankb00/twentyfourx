package com.twentyfourx.Entity;

import java.io.Serializable;

/**
 * Created by Thanawat on 4/13/2017.
 */
public class OrganizerContact implements Serializable{
    private String name;
    private String logoUrl;
    private String description;
    private BoothContactObject contact;

    public OrganizerContact() {
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BoothContactObject getContact() {
        return contact;
    }

    public void setContact(BoothContactObject contact) {
        this.contact = contact;
    }


}
