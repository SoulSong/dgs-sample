package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;

public class EntitiesPostKey_ReviewsProjection extends BaseSubProjectionNode<EntitiesPostKeyProjection, EntitiesProjectionRoot> {
  public EntitiesPostKey_ReviewsProjection(EntitiesPostKeyProjection parent,
      EntitiesProjectionRoot root) {
    super(parent, root, java.util.Optional.of("Review"));
  }

  public EntitiesPostKey_ReviewsProjection starRating() {
    getFields().put("starRating", null);
    return this;
  }
}
