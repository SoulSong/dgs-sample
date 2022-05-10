package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.BaseProjectionNode;

public class ListMoviesWithLocalContextProjectionRoot extends BaseProjectionNode {
  public ListMoviesWithLocalContext_DirectorProjection director() {
    ListMoviesWithLocalContext_DirectorProjection projection = new ListMoviesWithLocalContext_DirectorProjection(this, this);    
    getFields().put("director", projection);
    return projection;
  }

  public ListMoviesWithLocalContextProjectionRoot name() {
    getFields().put("name", null);
    return this;
  }
}
