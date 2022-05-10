package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.GraphQLQuery;
import com.shf.dgs.generated.types.BookFilter;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectGraphQLQuery extends GraphQLQuery {
  public CollectGraphQLQuery(List<BookFilter> books, Set<String> fieldsSet) {
    super("query");
    if (books != null || fieldsSet.contains("books")) {
        getInput().put("books", books);
    }
  }

  public CollectGraphQLQuery() {
    super("query");
  }

  @Override
  public String getOperationName() {
     return "collect";
                    
  }

  public static Builder newRequest() {
    return new Builder();
  }

  public static class Builder {
    private Set<String> fieldsSet = new HashSet<>();

    private List<BookFilter> books;

    public CollectGraphQLQuery build() {
      return new CollectGraphQLQuery(books, fieldsSet);
               
    }

    public Builder books(List<BookFilter> books) {
      this.books = books;
      this.fieldsSet.add("books");
      return this;
    }
  }
}
