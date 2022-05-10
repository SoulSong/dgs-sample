package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.GraphQLQuery;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class ListMoviesPreloadGraphQLQuery extends GraphQLQuery {
  public ListMoviesPreloadGraphQLQuery() {
    super("query");
  }

  @Override
  public String getOperationName() {
     return "listMoviesPreload";
                    
  }

  public static Builder newRequest() {
    return new Builder();
  }

  public static class Builder {
    private Set<String> fieldsSet = new HashSet<>();

    public ListMoviesPreloadGraphQLQuery build() {
      return new ListMoviesPreloadGraphQLQuery();                                     
    }
  }
}
