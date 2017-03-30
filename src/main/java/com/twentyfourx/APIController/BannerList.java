package com.twentyfourx.APIController;

import com.twentyfourx.Entity.BannerObject;

import java.util.List;

/**
 * Created by Thanawat on 3/31/2017.
 */
public class BannerList {
    private List<BannerObject> banners;
    private List<ExhibitionObjectForBanner> exhibitions;

    public List<ExhibitionObjectForBanner> getExhibitions() {
        return exhibitions;
    }

    public void setExhibitions(List<ExhibitionObjectForBanner> exhibitions) {
        this.exhibitions = exhibitions;
    }

    public List<BannerObject> getBanners() {
        return banners;
    }

    public void setBanners(List<BannerObject> banners) {
        this.banners = banners;
    }

    public BannerList() {

    }
}
