package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.GraphQLQuery;
import com.shf.dgs.generated.types.BookInput;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class AddBook2GraphQLQuery extends GraphQLQuery {
  public AddBook2GraphQLQuery(BookInput input, Set<String> fieldsSet) {
    super("mutation");
    if (input != null || fieldsSet.contains("input")) {
        getInput().put("input", input);
    }
  }

  public AddBook2GraphQLQuery() {
    super("mutation");
  }

  @Override
  public String getOperationName() {
     return "addBook2";
                    
  }

  public static Builder newRequest() {
    return new Builder();
  }

  public static class Builder {
    private Set<String> fieldsSet = new HashSet<>();

    private BookInput input;

    public AddBook2GraphQLQuery build() {
      return new AddBook2GraphQLQuery(input, fieldsSet);
               
    }

    public Builder input(BookInput input) {
      this.input = input;
      this.fieldsSet.add("input");
      return this;
    }
  }
}
