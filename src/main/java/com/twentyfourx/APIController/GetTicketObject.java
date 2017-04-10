package com.twentyfourx.APIController;

/**
 * Created by Thanawat on 3/30/2017.
 */
public class GetTicketObject {
    private int id;
    private ExhibitionObjectForTicket exhibition;
    private String holderName;
    private String holderRole;
    private String department;
    private boolean reviewed;
    private String reviewUrl;

    public String getReviewUrl() {
        return reviewUrl;
    }

    public void setReviewUrl(String reviewUrl) {
        this.reviewUrl = reviewUrl;
    }

    public GetTicketObject() {
    }

    private String registeredDate;

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDated) {
        this.registeredDate = registeredDated;
    }

    private boolean isExpired;

    public boolean isReviewed() {
        return reviewed;
    }

    public void setReviewed(boolean reviewed) {
        this.reviewed = reviewed;
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    public GetTicketObject(int id, ExhibitionObjectForTicket exhibition, String holderName, String holderRole, String dapartment, boolean isExpired,boolean evaluation,String registeredDate,String reviewUrl) {
        this.id = id;
        this.exhibition = exhibition;
        this.holderName = holderName;
        this.holderRole = holderRole;
        this.department = dapartment;
        this.isExpired = isExpired;
        this.reviewed = evaluation;
        this.registeredDate = registeredDate;
        this.reviewUrl = reviewUrl;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ExhibitionObjectForTicket getExhibitionObject() {
        return exhibition;
    }

    public void setExhibitionObjectForTicket(ExhibitionObjectForTicket exhibitionObject) {
        this.exhibition = exhibitionObject;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getHolderRole() {
        return holderRole;
    }

    public void setHolderRole(String holderRole) {
        this.holderRole = holderRole;
    }

    public boolean getIsExpired(){
        return isExpired;
    }

    public void setIsExpired(boolean expired) {
        isExpired = expired;
    }
}
