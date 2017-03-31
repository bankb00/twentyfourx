package com.twentyfourx.APIController;

/**
 * Created by Thanawat on 3/30/2017.
 */
public class GetTicketObject {
    private int id;
    private ExhibitionObjectForTicket exhibition;
    private String holderName;
    private String holderRole;
    private String companyName;
    private boolean isExpired;

    public GetTicketObject(int id, ExhibitionObjectForTicket exhibition, String startDate, String endDate, String holderName, String holderRole, String companyName, boolean isExpired) {
        this.id = id;
        this.exhibition = exhibition;
        this.holderName = holderName;
        this.holderRole = holderRole;
        this.companyName = companyName;
        this.isExpired = isExpired;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    public boolean getIsExpired(){
        return isExpired;
    }

    public void setIsExpired(boolean expired) {
        isExpired = expired;
    }
}
