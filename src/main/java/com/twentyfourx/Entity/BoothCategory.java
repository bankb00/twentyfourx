package com.twentyfourx.Entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Thanawat on 4/12/2017.
 */
public class BoothCategory implements Serializable{
    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    private List<String> list;

}
