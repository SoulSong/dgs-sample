package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.BaseProjectionNode;

public class GetByIdProjectionRoot extends BaseProjectionNode {
  public GetById_ActorsProjection actors() {
    GetById_ActorsProjection projection = new GetById_ActorsProjection(this, this);    
    getFields().put("actors", projection);
    return projection;
  }

  public GetByIdProjectionRoot title() {
    getFields().put("title", null);
    return this;
  }

  public GetByIdProjectionRoot releaseYear() {
    getFields().put("releaseYear", null);
    return this;
  }
}
