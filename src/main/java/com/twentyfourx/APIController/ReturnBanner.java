package com.twentyfourx.APIController;

/**
 * Created by Thanawat on 3/31/2017.
 */
public class ReturnBanner {
    private BannerList bannerList;
    private ExhibitionList exhibitionList;

    public BannerList getBannerList() {
        return bannerList;
    }

    public void setBannerList(BannerList bannerList) {
        this.bannerList = bannerList;
    }

    public ExhibitionList getExhibitionList() {
        return exhibitionList;
    }

    public void setExhibitionList(ExhibitionList exhibitionList) {
        this.exhibitionList = exhibitionList;
    }
}
