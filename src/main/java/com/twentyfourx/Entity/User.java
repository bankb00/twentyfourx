package com.twentyfourx.Entity;

import javax.persistence.*;

/**
 * Created by Thanawat on 3/21/2017.
 */

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private int ticketRepo;
    private int favBoothId;
    private int briefCaseId;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFavBoothId() {
        return favBoothId;
    }

    public void setFavBoothId(int favBoothId) {
        this.favBoothId = favBoothId;
    }

    public int getBriefCaseId() {
        return briefCaseId;
    }

    public void setBriefCaseId(int briefCaseId) {
        this.briefCaseId = briefCaseId;
    }

    public int getTicketRepo() {
        return ticketRepo;
    }

    public void setTicketRepo(int ticketRepo) {
        this.ticketRepo = ticketRepo;
    }
}
