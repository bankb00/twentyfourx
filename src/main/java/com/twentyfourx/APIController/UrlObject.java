package com.twentyfourx.APIController;

/**
 * Created by Thanawat on 3/31/2017.
 */
public class UrlObject {
    private int id;

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

    private String url;
    private int exhibitionId;

    public UrlObject() {
    }

    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
