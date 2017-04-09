package com.twentyfourx.Entity;

/**
 * Created by Thanawat on 3/20/2017.
 */
import javax.persistence.*;
import java.sql.SQLException;

@Entity
@Table(name = "Booth")
public class Booth {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String boothCode;
    private BoothContactObject contact;

    public BoothContactObject getContact() {
        return contact;
    }

    public void setContact(BoothContactObject contact) {
        this.contact = contact;
    }

    public Booth(int id, String name, String description, String boothCode, int exhibitionId, String logoUrl, String brochureUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.boothCode = boothCode;
        this.exhibitionId = exhibitionId;
        this.logoUrl = logoUrl;
        this.brochureUrl = brochureUrl;
    }

    private int exhibitionId;
    private String logoUrl;
    private String brochureUrl;
    private boolean isFavourited;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String exhibitionName) {
        this.name = exhibitionName;
    }

    public boolean isFavourited() {
        return isFavourited;
    }

    public void setFavourited(boolean favourited) throws SQLException {
        isFavourited = favourited;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBoothCode() {
        return boothCode;
    }

    public void setBoothCode(String boothCode) {
        this.boothCode = boothCode;
    }

    public int getExhibitionId() {
        return exhibitionId;
    }

    public void setExhibitionId(int exhibitionId) {
        this.exhibitionId = exhibitionId;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getBrochureUrl() {
        return brochureUrl;
    }

    public void setBrochureUrl(String brochureUrl) {
        this.brochureUrl = brochureUrl;
    }
}