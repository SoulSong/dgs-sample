package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.GraphQLQuery;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class ErrorGraphQLQuery extends GraphQLQuery {
  public ErrorGraphQLQuery() {
    super("query");
  }

  @Override
  public String getOperationName() {
     return "error";
                    
  }

  public static Builder newRequest() {
    return new Builder();
  }

  public static class Builder {
    private Set<String> fieldsSet = new HashSet<>();

    public ErrorGraphQLQuery build() {
      return new ErrorGraphQLQuery();                                     
    }
  }
}
