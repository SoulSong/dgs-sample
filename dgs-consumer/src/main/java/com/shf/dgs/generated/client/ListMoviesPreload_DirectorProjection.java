package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;

public class ListMoviesPreload_DirectorProjection extends BaseSubProjectionNode<ListMoviesPreloadProjectionRoot, ListMoviesPreloadProjectionRoot> {
  public ListMoviesPreload_DirectorProjection(ListMoviesPreloadProjectionRoot parent,
      ListMoviesPreloadProjectionRoot root) {
    super(parent, root, java.util.Optional.of("Director"));
  }

  public ListMoviesPreload_DirectorProjection id() {
    getFields().put("id", null);
    return this;
  }

  public ListMoviesPreload_DirectorProjection name() {
    getFields().put("name", null);
    return this;
  }
}
