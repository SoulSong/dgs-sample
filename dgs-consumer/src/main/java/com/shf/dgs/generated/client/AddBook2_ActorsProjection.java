package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;

public class AddBook2_ActorsProjection extends BaseSubProjectionNode<AddBook2ProjectionRoot, AddBook2ProjectionRoot> {
  public AddBook2_ActorsProjection(AddBook2ProjectionRoot parent, AddBook2ProjectionRoot root) {
    super(parent, root, java.util.Optional.of("Actor"));
  }

  public AddBook2_ActorsProjection name() {
    getFields().put("name", null);
    return this;
  }

  public AddBook2_ActorsProjection age() {
    getFields().put("age", null);
    return this;
  }
}
