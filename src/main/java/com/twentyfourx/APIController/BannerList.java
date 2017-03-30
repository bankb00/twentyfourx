package com.twentyfourx.APIController;

import com.twentyfourx.Entity.BannerObject;

import java.util.List;

/**
 * Created by Thanawat on 3/31/2017.
 */
public class BannerList {
    private List<BannerObject> banners;
    private List<ExhibitionObjectForBanner> exhibitions;

    public List<ExhibitionObjectForBanner> getExhibitins() {
        return exhibitions;
    }

    public void setExhibitins(List<ExhibitionObjectForBanner> exhibitins) {
        this.exhibitions = exhibitins;
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
