package com.twentyfourx.Entity;

/**
 * Created by Thanawat on 3/30/2017.
 */
public class BannerObject {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String bannerUrl;
    private int exhibitionId;
    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public int getExhibitionId() {
        return exhibitionId;
    }

    public void setExhibitionId(int exhibitionId) {
        this.exhibitionId = exhibitionId;
    }



    public BannerObject(int id, String bannerUrl, int exhibitionId) {
        this.id = id;
        this.bannerUrl = bannerUrl;
        this.exhibitionId = exhibitionId;
    }


}
