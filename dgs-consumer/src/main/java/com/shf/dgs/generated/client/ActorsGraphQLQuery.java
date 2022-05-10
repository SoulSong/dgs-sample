package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.GraphQLQuery;
import com.shf.dgs.generated.types.BookFilter;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class ActorsGraphQLQuery extends GraphQLQuery {
  public ActorsGraphQLQuery(BookFilter book, Set<String> fieldsSet) {
    super("query");
    if (book != null || fieldsSet.contains("book")) {
        getInput().put("book", book);
    }
  }

  public ActorsGraphQLQuery() {
    super("query");
  }

  @Override
  public String getOperationName() {
     return "actors";
                    
  }

  public static Builder newRequest() {
    return new Builder();
  }

  public static class Builder {
    private Set<String> fieldsSet = new HashSet<>();

    private BookFilter book;

    public ActorsGraphQLQuery build() {
      return new ActorsGraphQLQuery(book, fieldsSet);
               
    }

    public Builder book(BookFilter book) {
      this.book = book;
      this.fieldsSet.add("book");
      return this;
    }
  }
}
