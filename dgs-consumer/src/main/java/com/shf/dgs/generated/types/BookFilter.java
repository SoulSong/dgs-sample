package com.shf.dgs.generated.types;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class BookFilter {
  private String title;

  public BookFilter() {
  }

  public BookFilter(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return "BookFilter{" + "title='" + title + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookFilter that = (BookFilter) o;
        return java.util.Objects.equals(title, that.title);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(title);
  }

  public static com.shf.dgs.generated.types.BookFilter.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String title;

    public BookFilter build() {
      com.shf.dgs.generated.types.BookFilter result = new com.shf.dgs.generated.types.BookFilter();
          result.title = this.title;
          return result;
    }

    public com.shf.dgs.generated.types.BookFilter.Builder title(String title) {
      this.title = title;
      return this;
    }
  }
}
