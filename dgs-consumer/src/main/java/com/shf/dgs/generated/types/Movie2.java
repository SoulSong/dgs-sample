package com.shf.dgs.generated.types;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class Movie2 {
  private String name;

  private Director director;

  public Movie2() {
  }

  public Movie2(String name, Director director) {
    this.name = name;
    this.director = director;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Director getDirector() {
    return director;
  }

  public void setDirector(Director director) {
    this.director = director;
  }

  @Override
  public String toString() {
    return "Movie2{" + "name='" + name + "'," +"director='" + director + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie2 that = (Movie2) o;
        return java.util.Objects.equals(name, that.name) &&
                            java.util.Objects.equals(director, that.director);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(name, director);
  }

  public static com.shf.dgs.generated.types.Movie2.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String name;

    private Director director;

    public Movie2 build() {
                  com.shf.dgs.generated.types.Movie2 result = new com.shf.dgs.generated.types.Movie2();
                      result.name = this.name;
          result.director = this.director;
                      return result;
    }

    public com.shf.dgs.generated.types.Movie2.Builder name(String name) {
      this.name = name;
      return this;
    }

    public com.shf.dgs.generated.types.Movie2.Builder director(Director director) {
      this.director = director;
      return this;
    }
  }
}
