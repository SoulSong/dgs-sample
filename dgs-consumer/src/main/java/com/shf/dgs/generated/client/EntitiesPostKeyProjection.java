package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;
import java.lang.Override;
import java.lang.String;

public class EntitiesPostKeyProjection extends BaseSubProjectionNode<EntitiesProjectionRoot, EntitiesProjectionRoot> {
  public EntitiesPostKeyProjection(EntitiesProjectionRoot parent, EntitiesProjectionRoot root) {
    super(parent, root, java.util.Optional.of("Post"));
  }

  public EntitiesPostKey_ReviewsProjection reviews() {
     EntitiesPostKey_ReviewsProjection projection = new EntitiesPostKey_ReviewsProjection(this, getRoot());
     getFields().put("reviews", projection);
     return projection;
  }

  public EntitiesPostKeyProjection id() {
    getFields().put("id", null);
    return this;
  }

  public EntitiesPostKeyProjection name() {
    getFields().put("name", null);
    return this;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("... on Post {");
    getFields().forEach((k, v) -> {
        builder.append(" ").append(k);
        if(v != null) {
            builder.append(" ").append(v.toString());
        }
    });
    builder.append("}");
     
    return builder.toString();
  }
}
