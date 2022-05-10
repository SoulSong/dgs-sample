package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.GraphQLQuery;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class ListMoviesWithLocalContextGraphQLQuery extends GraphQLQuery {
  public ListMoviesWithLocalContextGraphQLQuery() {
    super("query");
  }

  @Override
  public String getOperationName() {
     return "listMoviesWithLocalContext";
                    
  }

  public static Builder newRequest() {
    return new Builder();
  }

  public static class Builder {
    private Set<String> fieldsSet = new HashSet<>();

    public ListMoviesWithLocalContextGraphQLQuery build() {
      return new ListMoviesWithLocalContextGraphQLQuery();                                     
    }
  }
}
