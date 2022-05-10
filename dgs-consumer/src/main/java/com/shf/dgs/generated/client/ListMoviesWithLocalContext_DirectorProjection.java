package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;

public class ListMoviesWithLocalContext_DirectorProjection extends BaseSubProjectionNode<ListMoviesWithLocalContextProjectionRoot, ListMoviesWithLocalContextProjectionRoot> {
  public ListMoviesWithLocalContext_DirectorProjection(
      ListMoviesWithLocalContextProjectionRoot parent,
      ListMoviesWithLocalContextProjectionRoot root) {
    super(parent, root, java.util.Optional.of("Director"));
  }

  public ListMoviesWithLocalContext_DirectorProjection id() {
    getFields().put("id", null);
    return this;
  }

  public ListMoviesWithLocalContext_DirectorProjection name() {
    getFields().put("name", null);
    return this;
  }
}
