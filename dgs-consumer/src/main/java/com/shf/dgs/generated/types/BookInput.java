package com.shf.dgs.generated.types;

import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class BookInput {
  private String title;

  private Integer releaseYear;

  public BookInput() {
  }

  public BookInput(String title, Integer releaseYear) {
    this.title = title;
    this.releaseYear = releaseYear;
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

  @Override
  public String toString() {
    return "BookInput{" + "title='" + title + "'," +"releaseYear='" + releaseYear + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookInput that = (BookInput) o;
        return java.util.Objects.equals(title, that.title) &&
                            java.util.Objects.equals(releaseYear, that.releaseYear);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(title, releaseYear);
  }

  public static com.shf.dgs.generated.types.BookInput.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String title;

    private Integer releaseYear;

    public BookInput build() {
                  com.shf.dgs.generated.types.BookInput result = new com.shf.dgs.generated.types.BookInput();
                      result.title = this.title;
          result.releaseYear = this.releaseYear;
                      return result;
    }

    public com.shf.dgs.generated.types.BookInput.Builder title(String title) {
      this.title = title;
      return this;
    }

    public com.shf.dgs.generated.types.BookInput.Builder releaseYear(Integer releaseYear) {
      this.releaseYear = releaseYear;
      return this;
    }
  }
}
