package com.shf.dsg.producer.entity;

/**
 * description :
 *
 * @author songhaifeng
 * @date 2022/5/9 13:22
 */
public class Review {
    private Integer starRating;

    public Review(Integer starRating) {
        this.starRating = starRating;
    }

    public Integer getStarRating() {
        return starRating;
    }

    public void setStarRating(Integer starRating) {
        this.starRating = starRating;
    }
}
