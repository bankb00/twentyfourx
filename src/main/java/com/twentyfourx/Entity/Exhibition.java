package com.twentyfourx.Entity;

/**
 * Created by Thanawat on 3/10/2017.
 */

import javax.persistence.*;
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

    private boolean isPassed;

    /*public Exhibition()  {
        this.isPassed = checkDate();
    }*/


    public int getId() {
        return id;
    }

    public void setExhibitionId(int id) {
        this.id = id;
    }

    public String getExhibitionName() {
        return name;
    }

    public void setExhibitionName(String exhibitionName) {
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

    public boolean isFavourited() {
        return isFavourited;
    }

    public void setFavourited(boolean favourited) {
        isFavourited = favourited;
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


    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
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

        String string = this.getStartDate();

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
            //this.isPassed = true;
            //this.isPassed = true;
            //i = 1;
            return true;
        } else {
            //i = 0;
            //this.isPassed = false;
            return false;
        }

        /*System.out.println("");
        System.out.println("");
        System.out.println(localDate);
        System.out.println(myLocaldate);
        System.out.println(i);
        */
    }


}

