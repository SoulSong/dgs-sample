package com.shf.dgs.generated.client;

import com.netflix.graphql.dgs.client.codegen.GraphQLQuery;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class AddBookGraphQLQuery extends GraphQLQuery {
  public AddBookGraphQLQuery(String title, Integer releaseYear, Set<String> fieldsSet) {
    super("mutation");
    if (title != null || fieldsSet.contains("title")) {
        getInput().put("title", title);
    }if (releaseYear != null || fieldsSet.contains("releaseYear")) {
        getInput().put("releaseYear", releaseYear);
    }
  }

  public AddBookGraphQLQuery() {
    super("mutation");
  }

  @Override
  public String getOperationName() {
     return "addBook";
                    
  }

  public static Builder newRequest() {
    return new Builder();
  }

  public static class Builder {
    private Set<String> fieldsSet = new HashSet<>();

    private String title;

    private Integer releaseYear;

    public AddBookGraphQLQuery build() {
      return new AddBookGraphQLQuery(title, releaseYear, fieldsSet);
               
    }

    public Builder title(String title) {
      this.title = title;
      this.fieldsSet.add("title");
      return this;
    }

    public Builder releaseYear(Integer releaseYear) {
      this.releaseYear = releaseYear;
      this.fieldsSet.add("releaseYear");
      return this;
    }
  }
}
