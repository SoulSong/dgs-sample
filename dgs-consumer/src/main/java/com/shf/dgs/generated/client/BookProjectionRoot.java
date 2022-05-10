package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.BaseProjectionNode;

public class BookProjectionRoot extends BaseProjectionNode {
  public Book_ActorsProjection actors() {
    Book_ActorsProjection projection = new Book_ActorsProjection(this, this);    
    getFields().put("actors", projection);
    return projection;
  }

  public BookProjectionRoot title() {
    getFields().put("title", null);
    return this;
  }

  public BookProjectionRoot releaseYear() {
    getFields().put("releaseYear", null);
    return this;
  }
}
