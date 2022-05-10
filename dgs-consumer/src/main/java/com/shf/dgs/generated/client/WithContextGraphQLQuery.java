package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.GraphQLQuery;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class WithContextGraphQLQuery extends GraphQLQuery {
  public WithContextGraphQLQuery() {
    super("query");
  }

  @Override
  public String getOperationName() {
     return "withContext";
                    
  }

  public static Builder newRequest() {
    return new Builder();
  }

  public static class Builder {
    private Set<String> fieldsSet = new HashSet<>();

    public WithContextGraphQLQuery build() {
      return new WithContextGraphQLQuery();                                     
    }
  }
}
