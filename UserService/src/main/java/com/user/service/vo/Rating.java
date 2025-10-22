package com.user.service.vo;

public class Rating {

    private String ratingId;
    private String user_id;
    private String carid;
    private int rating;
    private String feedback;

    public Rating() {}

    public Rating(String ratingId, String user_id, String carid, int rating, String feedback) {
        this.ratingId = ratingId;
        this.user_id = user_id;
        this.carid = carid;
        this.rating = rating;
        this.feedback = feedback;
    }

    public String getRatingId() {
        return ratingId;
    }

    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCarid() {
        return carid;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}