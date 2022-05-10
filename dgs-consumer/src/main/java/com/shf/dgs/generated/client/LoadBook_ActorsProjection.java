package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;

public class LoadBook_ActorsProjection extends BaseSubProjectionNode<LoadBookProjectionRoot, LoadBookProjectionRoot> {
  public LoadBook_ActorsProjection(LoadBookProjectionRoot parent, LoadBookProjectionRoot root) {
    super(parent, root, java.util.Optional.of("Actor"));
  }

  public LoadBook_ActorsProjection name() {
    getFields().put("name", null);
    return this;
  }

  public LoadBook_ActorsProjection age() {
    getFields().put("age", null);
    return this;
  }
}
