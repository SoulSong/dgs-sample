package com.shf.dgs.generated.types;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class Movie {
  private String name;

  private Director director;

  public Movie() {
  }

  public Movie(String name, Director director) {
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
    return "Movie{" + "name='" + name + "'," +"director='" + director + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie that = (Movie) o;
        return java.util.Objects.equals(name, that.name) &&
                            java.util.Objects.equals(director, that.director);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(name, director);
  }

  public static com.shf.dgs.generated.types.Movie.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String name;

    private Director director;

    public Movie build() {
                  com.shf.dgs.generated.types.Movie result = new com.shf.dgs.generated.types.Movie();
                      result.name = this.name;
          result.director = this.director;
                      return result;
    }

    public com.shf.dgs.generated.types.Movie.Builder name(String name) {
      this.name = name;
      return this;
    }

    public com.shf.dgs.generated.types.Movie.Builder director(Director director) {
      this.director = director;
      return this;
    }
  }
}
