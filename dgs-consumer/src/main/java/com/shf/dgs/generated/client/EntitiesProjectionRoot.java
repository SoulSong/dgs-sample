package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.BaseProjectionNode;

public class EntitiesProjectionRoot extends BaseProjectionNode {
  public EntitiesPostKeyProjection onPost() {
     EntitiesPostKeyProjection fragment = new EntitiesPostKeyProjection(this, this);
     getFragments().add(fragment);
     return fragment;
  }
}
