package com.shf.dsg.producer.entity;

import java.util.List;

/**
 * description :
 *
 * @author songhaifeng
 * @date 2022/5/3 22:21
 */
public class Book {
    private String title;
    private Integer releaseYear;
    private List<Actor> actors;

    public Book() {
    }

    public Book(String title, Integer releaseYear, List<Actor> actors) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public List<Actor> getActors() {
        return actors;
    }
}
