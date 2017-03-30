package com.twentyfourx.APIController;

/**
 * Created by Thanawat on 3/31/2017.
 */
public class ExhibitionObjectForBanner {
    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ExhibitionObjectForBanner(String name, int id) {

        this.name = name;
        this.id = id;
    }
}
