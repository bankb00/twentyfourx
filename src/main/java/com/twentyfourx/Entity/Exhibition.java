package com.twentyfourx.Entity;

/**
 * Created by Thanawat on 3/10/2017.
 */

import javax.persistence.*;

@Entity
@Table(name = "Exhibition")
public class Exhibition {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String location;
    private String category;
    private String startDate;
    private String endDate;
    private String posterUrl;
    private boolean isFavourited;

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
}




/*import javax.persistence.*;

@Entity
@Table(name = "Exhibition")
public class Exhibition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int exhibitionId;

    private String exhibitionName;

    public int getExhibitionId(){
        return exhibitionId;
    }

    public String getExhibitionName(){
        return exhibitionName;
    }

    public void setExhibitionId(int exhibitionId){
        this.exhibitionId = exhibitionId;
    }

    public void setExhibitionName(String exhibitionName){
        this.exhibitionName = exhibitionName;
    }
}*/
