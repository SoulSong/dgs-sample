package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.BaseProjectionNode;

public class AddBook3ProjectionRoot extends BaseProjectionNode {
  public AddBook3_ActorsProjection actors() {
    AddBook3_ActorsProjection projection = new AddBook3_ActorsProjection(this, this);    
    getFields().put("actors", projection);
    return projection;
  }

  public AddBook3ProjectionRoot title() {
    getFields().put("title", null);
    return this;
  }

  public AddBook3ProjectionRoot releaseYear() {
    getFields().put("releaseYear", null);
    return this;
  }
}
