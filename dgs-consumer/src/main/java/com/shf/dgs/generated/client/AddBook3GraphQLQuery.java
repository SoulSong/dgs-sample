package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.GraphQLQuery;
import com.shf.dgs.generated.types.BookInput;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class AddBook3GraphQLQuery extends GraphQLQuery {
  public AddBook3GraphQLQuery(BookInput input, Set<String> fieldsSet) {
    super("mutation");
    if (input != null || fieldsSet.contains("input")) {
        getInput().put("input", input);
    }
  }

  public AddBook3GraphQLQuery() {
    super("mutation");
  }

  @Override
  public String getOperationName() {
     return "addBook3";
                    
  }

  public static Builder newRequest() {
    return new Builder();
  }

  public static class Builder {
    private Set<String> fieldsSet = new HashSet<>();

    private BookInput input;

    public AddBook3GraphQLQuery build() {
      return new AddBook3GraphQLQuery(input, fieldsSet);
               
    }

    public Builder input(BookInput input) {
      this.input = input;
      this.fieldsSet.add("input");
      return this;
    }
  }
}
