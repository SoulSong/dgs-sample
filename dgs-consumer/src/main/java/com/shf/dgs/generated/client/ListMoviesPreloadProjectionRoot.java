package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.BaseProjectionNode;

public class ListMoviesPreloadProjectionRoot extends BaseProjectionNode {
  public ListMoviesPreload_DirectorProjection director() {
    ListMoviesPreload_DirectorProjection projection = new ListMoviesPreload_DirectorProjection(this, this);    
    getFields().put("director", projection);
    return projection;
  }

  public ListMoviesPreloadProjectionRoot name() {
    getFields().put("name", null);
    return this;
  }
}
