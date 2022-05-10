package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.GraphQLQuery;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class LoadBookGraphQLQuery extends GraphQLQuery {
  public LoadBookGraphQLQuery(Integer id, Set<String> fieldsSet) {
    super("query");
    if (id != null || fieldsSet.contains("id")) {
        getInput().put("id", id);
    }
  }

  public LoadBookGraphQLQuery() {
    super("query");
  }

  @Override
  public String getOperationName() {
     return "loadBook";
                    
  }

  public static Builder newRequest() {
    return new Builder();
  }

  public static class Builder {
    private Set<String> fieldsSet = new HashSet<>();

    private Integer id;

    public LoadBookGraphQLQuery build() {
      return new LoadBookGraphQLQuery(id, fieldsSet);
               
    }

    public Builder id(Integer id) {
      this.id = id;
      this.fieldsSet.add("id");
      return this;
    }
  }
}
