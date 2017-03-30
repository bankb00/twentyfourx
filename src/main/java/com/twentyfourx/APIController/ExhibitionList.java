package com.twentyfourx.APIController;

import java.util.List;

/**
 * Created by Thanawat on 3/31/2017.
 */
public class ExhibitionList {
    List<ExhibitionObjectForBanner> exhibition;

    public List<ExhibitionObjectForBanner> getExhibition() {
        return exhibition;
    }

    public void setExhibition(List<ExhibitionObjectForBanner> exhibition) {
        this.exhibition = exhibition;
    }

    public ExhibitionList() {

    }
}
