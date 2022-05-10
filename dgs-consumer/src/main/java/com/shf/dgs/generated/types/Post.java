package com.shf.dgs.generated.types;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

public class Post {
  private String id;

  private String name;

  private List<Review> reviews;

  public Post() {
  }

  public Post(String id, String name, List<Review> reviews) {
    this.id = id;
    this.name = name;
    this.reviews = reviews;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
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

  @Override
  public String toString() {
    return "Post{" + "id='" + id + "'," +"name='" + name + "'," +"reviews='" + reviews + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post that = (Post) o;
        return java.util.Objects.equals(id, that.id) &&
                            java.util.Objects.equals(name, that.name) &&
                            java.util.Objects.equals(reviews, that.reviews);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, name, reviews);
  }

  public static com.shf.dgs.generated.types.Post.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String id;

    private String name;

    private List<Review> reviews;

    public Post build() {
                  com.shf.dgs.generated.types.Post result = new com.shf.dgs.generated.types.Post();
                      result.id = this.id;
          result.name = this.name;
          result.reviews = this.reviews;
                      return result;
    }

    public com.shf.dgs.generated.types.Post.Builder id(String id) {
      this.id = id;
      return this;
    }

    public com.shf.dgs.generated.types.Post.Builder name(String name) {
      this.name = name;
      return this;
    }

    public com.shf.dgs.generated.types.Post.Builder reviews(List<Review> reviews) {
      this.reviews = reviews;
      return this;
    }
  }
}
