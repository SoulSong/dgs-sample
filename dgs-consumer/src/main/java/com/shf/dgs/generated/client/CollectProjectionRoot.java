package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.BaseProjectionNode;

public class CollectProjectionRoot extends BaseProjectionNode {
  public Collect_ActorsProjection actors() {
    Collect_ActorsProjection projection = new Collect_ActorsProjection(this, this);    
    getFields().put("actors", projection);
    return projection;
  }

  public CollectProjectionRoot title() {
    getFields().put("title", null);
    return this;
  }

  public CollectProjectionRoot releaseYear() {
    getFields().put("releaseYear", null);
    return this;
  }
}
