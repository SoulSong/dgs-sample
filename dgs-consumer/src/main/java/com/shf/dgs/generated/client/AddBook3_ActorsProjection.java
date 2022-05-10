package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;

public class AddBook3_ActorsProjection extends BaseSubProjectionNode<AddBook3ProjectionRoot, AddBook3ProjectionRoot> {
  public AddBook3_ActorsProjection(AddBook3ProjectionRoot parent, AddBook3ProjectionRoot root) {
    super(parent, root, java.util.Optional.of("Actor"));
  }

  public AddBook3_ActorsProjection name() {
    getFields().put("name", null);
    return this;
  }

  public AddBook3_ActorsProjection age() {
    getFields().put("age", null);
    return this;
  }
}
