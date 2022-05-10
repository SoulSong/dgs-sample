package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;

public class GetById_ActorsProjection extends BaseSubProjectionNode<GetByIdProjectionRoot, GetByIdProjectionRoot> {
  public GetById_ActorsProjection(GetByIdProjectionRoot parent, GetByIdProjectionRoot root) {
    super(parent, root, java.util.Optional.of("Actor"));
  }

  public GetById_ActorsProjection name() {
    getFields().put("name", null);
    return this;
  }

  public GetById_ActorsProjection age() {
    getFields().put("age", null);
    return this;
  }
}
