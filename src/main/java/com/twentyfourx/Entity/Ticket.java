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
    private String startDate;
    private String endDate;
    private String holderName;
    private String holderRole;
    private boolean isExpired;
    private boolean canRegister;

    public Ticket(int exhibitionId, String holderName, String holderRole){
        this.exhibitionId = exhibitionId;
        this.holderName = holderName;
        this.holderRole = holderRole;
    }

    public Ticket(){
        this.exhibitionId = 0;
        this.startDate = "";
        this.endDate = "";
        this.holderName = "";
        this.holderRole = "";
        this.isExpired = false;
        this.canRegister = false;
    }
}
