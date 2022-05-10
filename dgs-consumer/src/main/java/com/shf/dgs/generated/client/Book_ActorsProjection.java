package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;

public class Book_ActorsProjection extends BaseSubProjectionNode<BookProjectionRoot, BookProjectionRoot> {
  public Book_ActorsProjection(BookProjectionRoot parent, BookProjectionRoot root) {
    super(parent, root, java.util.Optional.of("Actor"));
  }

  public Book_ActorsProjection name() {
    getFields().put("name", null);
    return this;
  }

  public Book_ActorsProjection age() {
    getFields().put("age", null);
    return this;
  }
}
