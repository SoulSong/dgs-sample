package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.BaseProjectionNode;

public class AddBook2ProjectionRoot extends BaseProjectionNode {
  public AddBook2_ActorsProjection actors() {
    AddBook2_ActorsProjection projection = new AddBook2_ActorsProjection(this, this);    
    getFields().put("actors", projection);
    return projection;
  }

  public AddBook2ProjectionRoot title() {
    getFields().put("title", null);
    return this;
  }

  public AddBook2ProjectionRoot releaseYear() {
    getFields().put("releaseYear", null);
    return this;
  }
}
