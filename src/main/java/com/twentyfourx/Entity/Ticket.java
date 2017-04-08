package com.twentyfourx.Entity;

import javax.persistence.*;

/**
 * Created by Thanawat on 3/23/2017.
 */
@Entity
@Table(name = "Ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int exhibitionId;
    private String exhibitionName;
    private boolean reviewed;
    private String userId;
    private String startDate;
    private String endDate;
    private String holderName;
    private String holderRole;
    private String email;
    private String mobileNo;
    private String reviewUrl;

    public String getReviewUrl() {
        return reviewUrl;
    }

    public void setReviewUrl(String reviewUrl) {
        this.reviewUrl = reviewUrl;
    }



    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    private String department;
    private boolean isExpired;

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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


    public boolean isReviewed() {
        return reviewed;
    }

    public void setReviewed(boolean reviewed) {
        this.reviewed = reviewed;
    }

    public Ticket(int id, int exhibitionId, String exhibitionName, String userId, String startDate, String endDate, String holderName, String holderRole, boolean isExpired, String department, String registerDate, boolean reviewed, String email, String mobileNo, String reviewUrl) {
        this.exhibitionId = exhibitionId;
        this.exhibitionName = exhibitionName;
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.holderName = holderName;
        this.holderRole = holderRole;
        this.isExpired = isExpired;
        this.id = id;
        this.department = department;
        this.registeredDate = registerDate;
        this.reviewed = reviewed;
        this.email = email;
        this.mobileNo = mobileNo;
        this.reviewUrl = reviewUrl;
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







}
