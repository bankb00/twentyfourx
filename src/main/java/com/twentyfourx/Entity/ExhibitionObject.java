package com.twentyfourx.Entity;

/**
 * Created by Thanawat on 3/25/2017.
 */
public class ExhibitionObject {
    private int id;
    private String name;
    private String description;
    private String location;
    private String category;
    private String startDate;
    private String endDate;
    private String posterUrl;
    private boolean isFavourited;
    private Double latitude;
    private Double longtitude;
    private String agendaUrl;
    private String mapUrl;
    private String websiteUrl;
    private String customWebsiteText;
    private String reviewUrl;
    private String organizerName;

    public String getOrganizerDetail() {
        return organizerDetail;
    }

    public void setOrganizerDetail(String organizerDetail) {
        this.organizerDetail = organizerDetail;
    }

    private String organizerDetail;
    private String organizerLogoUrl;
    private String email;
    private String facebook;
    private String facebookUrl;
    private String mobileNo;

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getOrganizerLogoUrl() {
        return organizerLogoUrl;
    }

    public void setOrganizerLogoUrl(String organizerLogoUrl) {
        this.organizerLogoUrl = organizerLogoUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getReviewUrl() {
        return reviewUrl;
    }

    public void setReviewUrl(String reviewUrl) {
        this.reviewUrl = reviewUrl;
    }

    public String getCustomWebsiteText() {
        return customWebsiteText;
    }

    public void setCustomWebsiteText(String customWebsiteText) {
        this.customWebsiteText = customWebsiteText;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public ExhibitionObject() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongtitude() {
        return this.longtitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    public String getAgendaUrl() {
        return agendaUrl;
    }

    public void setAgendaUrl(String agendaUrl) {
        this.agendaUrl = agendaUrl;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }
}
