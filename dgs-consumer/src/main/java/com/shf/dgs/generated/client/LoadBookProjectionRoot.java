package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.BaseProjectionNode;

public class LoadBookProjectionRoot extends BaseProjectionNode {
  public LoadBook_ActorsProjection actors() {
    LoadBook_ActorsProjection projection = new LoadBook_ActorsProjection(this, this);    
    getFields().put("actors", projection);
    return projection;
  }

  public LoadBookProjectionRoot title() {
    getFields().put("title", null);
    return this;
  }

  public LoadBookProjectionRoot releaseYear() {
    getFields().put("releaseYear", null);
    return this;
  }
}
