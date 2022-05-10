package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.GraphQLQuery;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class ListMoviesGraphQLQuery extends GraphQLQuery {
  public ListMoviesGraphQLQuery() {
    super("query");
  }

  @Override
  public String getOperationName() {
     return "listMovies";
                    
  }

  public static Builder newRequest() {
    return new Builder();
  }

  public static class Builder {
    private Set<String> fieldsSet = new HashSet<>();

    public ListMoviesGraphQLQuery build() {
      return new ListMoviesGraphQLQuery();                                     
    }
  }
}
