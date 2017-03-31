package com.twentyfourx.Entity;

import javax.persistence.*;

/**
 * Created by Thanawat on 3/23/2017.
 */
@Entity
@Table(name = "Ticket")
public class Ticket {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExhibitionId() {
        return exhibitionId;
    }

    public void setExhibitionId(int exhibitionId) {
        this.exhibitionId = exhibitionId;
    }

    public String getExhibitionName() {
        return exhibitionName;
    }

    public void setExhibitionName(String exhibitionName) {
        this.exhibitionName = exhibitionName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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

    public boolean getIsExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int exhibitionId;
    private String exhibitionName;

    public Ticket(int id, int exhibitionId, String exhibitionName, String userId, String startDate, String endDate, String holderName, String holderRole, boolean isExpired, String companyName, String registerDate) {
        this.exhibitionId = exhibitionId;
        this.exhibitionName = exhibitionName;
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.holderName = holderName;
        this.holderRole = holderRole;
        this.isExpired = isExpired;
        this.id = id;
        this.companyName = companyName;
        this.registeredDate = registerDate;
    }
    public Ticket(){

    }
    private String registeredDate;

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registeredDate = registerDate;
    }

    private String userId;
    private String startDate;
    private String endDate;
    private String holderName;
    private String holderRole;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    private String companyName;
    private boolean isExpired;



}
