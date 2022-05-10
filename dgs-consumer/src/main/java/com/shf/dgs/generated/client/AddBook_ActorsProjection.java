package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;

public class AddBook_ActorsProjection extends BaseSubProjectionNode<AddBookProjectionRoot, AddBookProjectionRoot> {
  public AddBook_ActorsProjection(AddBookProjectionRoot parent, AddBookProjectionRoot root) {
    super(parent, root, java.util.Optional.of("Actor"));
  }

  public AddBook_ActorsProjection name() {
    getFields().put("name", null);
    return this;
  }

  public AddBook_ActorsProjection age() {
    getFields().put("age", null);
    return this;
  }
}
