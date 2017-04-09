package com.twentyfourx.Entity;

/**
 * Created by Thanawat on 3/10/2017.
 */

import javax.persistence.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Entity
@Table(name = "Exhibition")
public class Exhibition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String location;
    private String category;
    private String startDate;
    private String endDate;
    private String posterUrl;
    private boolean isFavourited;
    private Double latitude;
    private Double longtitude;
    private String agendaUrl;
    private String mapUrl;

    private String websiteUrl;

    private boolean isExpired;
    private String reviewUrl;
    private ExhibitionContactObject organizerContact;

    public ExhibitionContactObject getOrganizerContact() {
        return organizerContact;
    }

    public void setOrganizerContact(ExhibitionContactObject organizerContact) {
        this.organizerContact = organizerContact;
    }

    public String getReviewUrl() {
        return reviewUrl;
    }

    public void setReviewUrl(String reviewUrl) {
        this.reviewUrl = reviewUrl;
    }

    public String getCustomWebsiteText() {
        return customWebsiteText;
    }

    public void setCustomWebsiteText(String customWebsiteText) {
        this.customWebsiteText = customWebsiteText;
    }

    private String customWebsiteText;



    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }


    public Exhibition(int id,String name, String description, String location, String category, String startDate, String endDate, String posterUrl, boolean isFavourited
    ,Double latitude, Double longtitude, String agendaUrl, String mapUrl, boolean isPassed, String websiteUrl,String customWebsiteText)  {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.category = category;
        this.startDate = startDate;
        this.endDate = endDate;
        this.posterUrl = posterUrl;
        this.isFavourited = isFavourited;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.agendaUrl = agendaUrl;
        this.mapUrl = mapUrl;
        this.isExpired = isPassed;
        this.websiteUrl = websiteUrl;
        this.customWebsiteText = customWebsiteText;
    }

    public Exhibition(){
        //this.id = id;
        this.name = "";
        this.description = "";
        this.location = "";
        this.category = "";
        this.startDate = "";
        this.endDate = "";
        this.posterUrl = "";
        this.isFavourited = false;
        this.latitude = 0.00;
        this.longtitude = 0.00;
        this.agendaUrl = "";
        this.mapUrl = "";
        this.isExpired = false;
    }


    public int getId() {
        return id;
    }

    public void setExhibitionId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String exhibitionName) {
        this.name = exhibitionName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public boolean getIsFavourited() {
        return isFavourited;
    }

    public void setFavourited(boolean favourited) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/bankza";
        Connection conn = DriverManager.getConnection(url,"root","password");
        int id =this.id;
            try
            {
                PreparedStatement ps = conn.prepareStatement(
                        "UPDATE exhibition SET is_favourited = ? WHERE id = ? ");
                ps.setBoolean(1,favourited);
                ps.setInt(2,id);
                ps.executeUpdate();
            }
            catch (SQLException ex)
            {
                System.err.println(ex.getMessage());
            }
        this.isFavourited = favourited;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    public String getAgendaUrl() {
        return agendaUrl;
    }

    public void setAgendaUrl(String agendaUrl) {
        this.agendaUrl = agendaUrl;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }


    public boolean getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(boolean passed) {
        this.isExpired = passed;
    }

    /*public void checkDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        Date myDate = this.getStartDate();
        LocalDate myLocaldate = myDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        //System.out.println(dtf.format(localDate)); //2016/11/16

        if(myLocaldate.isBefore(localDate)){
            this.isPassed = true;
        }
    }*/

    public boolean checkDate()  {

        String string = this.getEndDate();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LocalDate myLocaldate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        //int i = 0;
        LocalDate localDate = LocalDate.now();
        if (myLocaldate.isBefore(localDate)) {

            return true;
        } else {

            return false;
        }


    }


}

