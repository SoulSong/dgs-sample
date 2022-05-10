package com.shf.dgs.generated.types;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class Director {
  private String id;

  private String name;

  public Director() {
  }

  public Director(String id, String name) {
    this.id = id;
    this.name = name;
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

  @Override
  public String toString() {
    return "Director{" + "id='" + id + "'," +"name='" + name + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director that = (Director) o;
        return java.util.Objects.equals(id, that.id) &&
                            java.util.Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, name);
  }

  public static com.shf.dgs.generated.types.Director.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String id;

    private String name;

    public Director build() {
                  com.shf.dgs.generated.types.Director result = new com.shf.dgs.generated.types.Director();
                      result.id = this.id;
          result.name = this.name;
                      return result;
    }

    public com.shf.dgs.generated.types.Director.Builder id(String id) {
      this.id = id;
      return this;
    }

    public com.shf.dgs.generated.types.Director.Builder name(String name) {
      this.name = name;
      return this;
    }
  }
}
