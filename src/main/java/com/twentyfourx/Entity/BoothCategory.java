package com.twentyfourx.Entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Thanawat on 4/12/2017.
 */
public class BoothCategory implements Serializable{
    public List<String> getBoothCategory() {
        return boothCategory;
    }

    public void setBoothCategory(List<String> boothCategory) {
        this.boothCategory = boothCategory;
    }

    private List<String> boothCategory;

}
