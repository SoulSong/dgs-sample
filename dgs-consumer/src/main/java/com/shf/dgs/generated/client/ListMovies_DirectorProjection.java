package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;

public class ListMovies_DirectorProjection extends BaseSubProjectionNode<ListMoviesProjectionRoot, ListMoviesProjectionRoot> {
  public ListMovies_DirectorProjection(ListMoviesProjectionRoot parent,
      ListMoviesProjectionRoot root) {
    super(parent, root, java.util.Optional.of("Director"));
  }

  public ListMovies_DirectorProjection id() {
    getFields().put("id", null);
    return this;
  }

  public ListMovies_DirectorProjection name() {
    getFields().put("name", null);
    return this;
  }
}
