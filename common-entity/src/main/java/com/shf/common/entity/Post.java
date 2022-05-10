package com.shf.common.entity;

import java.util.List;

/**
 * description :
 *
 * @author songhaifeng
 * @date 2022/5/9 13:21
 */
public class Post {
    private Integer id;
    private String name;
    private List<Review> reviews;

    public Post(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
