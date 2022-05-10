package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.GraphQLQuery;
import com.shf.dgs.generated.types.BookFilter;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class BookGraphQLQuery extends GraphQLQuery {
  public BookGraphQLQuery(BookFilter book, Set<String> fieldsSet) {
    super("query");
    if (book != null || fieldsSet.contains("book")) {
        getInput().put("book", book);
    }
  }

  public BookGraphQLQuery() {
    super("query");
  }

  @Override
  public String getOperationName() {
     return "book";
                    
  }

  public static Builder newRequest() {
    return new Builder();
  }

  public static class Builder {
    private Set<String> fieldsSet = new HashSet<>();

    private BookFilter book;

    public BookGraphQLQuery build() {
      return new BookGraphQLQuery(book, fieldsSet);
               
    }

    public Builder book(BookFilter book) {
      this.book = book;
      this.fieldsSet.add("book");
      return this;
    }
  }
}
