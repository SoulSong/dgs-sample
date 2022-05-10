package com.shf.dgs.generated.client;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class PostRepresentation {
  private String id;

  private String __typename = "Post";

  public PostRepresentation() {
  }

  public PostRepresentation(String id, String __typename) {
    this.id = id;
    this.__typename = __typename;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String get__typename() {
    return __typename;
  }

  public void set__typename(String __typename) {
    this.__typename = __typename;
  }

  @Override
  public String toString() {
    return "PostRepresentation{" + "id='" + id + "'," +"__typename='" + __typename + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostRepresentation that = (PostRepresentation) o;
        return java.util.Objects.equals(id, that.id) &&
                            java.util.Objects.equals(__typename, that.__typename);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, __typename);
  }

  public static com.shf.dgs.generated.client.PostRepresentation.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String id;

    private String __typename = "Post";

    public PostRepresentation build() {
                  com.shf.dgs.generated.client.PostRepresentation result = new com.shf.dgs.generated.client.PostRepresentation();
                      result.id = this.id;
          result.__typename = this.__typename;
                      return result;
    }

    public com.shf.dgs.generated.client.PostRepresentation.Builder id(String id) {
      this.id = id;
      return this;
    }

    public com.shf.dgs.generated.client.PostRepresentation.Builder __typename(String __typename) {
      this.__typename = __typename;
      return this;
    }
  }
}
