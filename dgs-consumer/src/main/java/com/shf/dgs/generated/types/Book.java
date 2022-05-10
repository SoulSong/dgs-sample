package com.shf.dgs.generated.types;

import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

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

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(Integer releaseYear) {
    this.releaseYear = releaseYear;
  }

  public List<Actor> getActors() {
    return actors;
  }

  public void setActors(List<Actor> actors) {
    this.actors = actors;
  }

  @Override
  public String toString() {
    return "Book{" + "title='" + title + "'," +"releaseYear='" + releaseYear + "'," +"actors='" + actors + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book that = (Book) o;
        return java.util.Objects.equals(title, that.title) &&
                            java.util.Objects.equals(releaseYear, that.releaseYear) &&
                            java.util.Objects.equals(actors, that.actors);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(title, releaseYear, actors);
  }

  public static com.shf.dgs.generated.types.Book.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String title;

    private Integer releaseYear;

    private List<Actor> actors;

    public Book build() {
                  com.shf.dgs.generated.types.Book result = new com.shf.dgs.generated.types.Book();
                      result.title = this.title;
          result.releaseYear = this.releaseYear;
          result.actors = this.actors;
                      return result;
    }

    public com.shf.dgs.generated.types.Book.Builder title(String title) {
      this.title = title;
      return this;
    }

    public com.shf.dgs.generated.types.Book.Builder releaseYear(Integer releaseYear) {
      this.releaseYear = releaseYear;
      return this;
    }

    public com.shf.dgs.generated.types.Book.Builder actors(List<Actor> actors) {
      this.actors = actors;
      return this;
    }
  }
}
