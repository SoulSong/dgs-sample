package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.BaseProjectionNode;

public class AddBookProjectionRoot extends BaseProjectionNode {
  public AddBook_ActorsProjection actors() {
    AddBook_ActorsProjection projection = new AddBook_ActorsProjection(this, this);    
    getFields().put("actors", projection);
    return projection;
  }

  public AddBookProjectionRoot title() {
    getFields().put("title", null);
    return this;
  }

  public AddBookProjectionRoot releaseYear() {
    getFields().put("releaseYear", null);
    return this;
  }
}
