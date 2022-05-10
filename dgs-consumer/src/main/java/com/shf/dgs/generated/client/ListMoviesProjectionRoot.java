package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.BaseProjectionNode;

public class ListMoviesProjectionRoot extends BaseProjectionNode {
  public ListMovies_DirectorProjection director() {
    ListMovies_DirectorProjection projection = new ListMovies_DirectorProjection(this, this);    
    getFields().put("director", projection);
    return projection;
  }

  public ListMoviesProjectionRoot name() {
    getFields().put("name", null);
    return this;
  }
}
