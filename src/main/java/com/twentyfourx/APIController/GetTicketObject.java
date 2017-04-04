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
    private String registeredDate;

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDated) {
        this.registeredDate = registeredDated;
    }

    private boolean isExpired;
    private boolean evaluation;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }



    public boolean isEvaluation() {
        return evaluation;
    }

    public void setEvaluation(boolean evaluation) {
        this.evaluation = evaluation;
    }

    public GetTicketObject(int id, ExhibitionObjectForTicket exhibition, String holderName, String holderRole, String dapartment, boolean isExpired,boolean evaluation,String registeredDate) {
        this.id = id;
        this.exhibition = exhibition;
        this.holderName = holderName;
        this.holderRole = holderRole;
        this.department = dapartment;
        this.isExpired = isExpired;
        this.evaluation = evaluation;
        this.registeredDate = registeredDate;
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
