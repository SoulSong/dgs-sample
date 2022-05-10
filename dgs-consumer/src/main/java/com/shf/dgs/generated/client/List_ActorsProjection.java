package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;

public class List_ActorsProjection extends BaseSubProjectionNode<ListProjectionRoot, ListProjectionRoot> {
  public List_ActorsProjection(ListProjectionRoot parent, ListProjectionRoot root) {
    super(parent, root, java.util.Optional.of("Actor"));
  }

  public List_ActorsProjection name() {
    getFields().put("name", null);
    return this;
  }

  public List_ActorsProjection age() {
    getFields().put("age", null);
    return this;
  }
}
