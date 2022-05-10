package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.BaseProjectionNode;

public class ListProjectionRoot extends BaseProjectionNode {
  public List_ActorsProjection actors() {
    List_ActorsProjection projection = new List_ActorsProjection(this, this);    
    getFields().put("actors", projection);
    return projection;
  }

  public ListProjectionRoot title() {
    getFields().put("title", null);
    return this;
  }

  public ListProjectionRoot releaseYear() {
    getFields().put("releaseYear", null);
    return this;
  }
}
