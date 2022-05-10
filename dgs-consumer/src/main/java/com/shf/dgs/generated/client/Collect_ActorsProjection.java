package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;

public class Collect_ActorsProjection extends BaseSubProjectionNode<CollectProjectionRoot, CollectProjectionRoot> {
  public Collect_ActorsProjection(CollectProjectionRoot parent, CollectProjectionRoot root) {
    super(parent, root, java.util.Optional.of("Actor"));
  }

  public Collect_ActorsProjection name() {
    getFields().put("name", null);
    return this;
  }

  public Collect_ActorsProjection age() {
    getFields().put("age", null);
    return this;
  }
}
