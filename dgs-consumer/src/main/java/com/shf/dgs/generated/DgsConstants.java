package com.shf.dgs.generated;

import java.lang.String;

public class DgsConstants {
  public static final String QUERY_TYPE = "Query";

  public static class QUERY {
    public static final String TYPE_NAME = "Query";

    public static final String List = "list";

    public static final String GetById = "getById";

    public static final String Actors = "actors";

    public static final String Collect = "collect";

    public static final String Book = "book";

    public static final String Hello = "hello";

    public static final String WithContext = "withContext";

    public static final String LoadBook = "loadBook";

    public static final String ListMovies = "listMovies";

    public static final String ListMoviesWithLocalContext = "listMoviesWithLocalContext";

    public static final String ListMoviesPreload = "listMoviesPreload";

    public static final String Error = "error";
  }

  public static class MUTATION {
    public static final String TYPE_NAME = "Mutation";

    public static final String AddBook = "addBook";

    public static final String AddBook2 = "addBook2";

    public static final String AddBook3 = "addBook3";
  }

  public static class BOOK {
    public static final String TYPE_NAME = "Book";

    public static final String Title = "title";

    public static final String ReleaseYear = "releaseYear";

    public static final String Actors = "actors";
  }

  public static class ACTOR {
    public static final String TYPE_NAME = "Actor";

    public static final String Name = "name";

    public static final String Age = "age";
  }

  public static class MOVIE {
    public static final String TYPE_NAME = "Movie";

    public static final String Name = "name";

    public static final String Director = "director";
  }

  public static class DIRECTOR {
    public static final String TYPE_NAME = "Director";

    public static final String Id = "id";

    public static final String Name = "name";
  }

  public static class MOVIE2 {
    public static final String TYPE_NAME = "Movie2";

    public static final String Name = "name";

    public static final String Director = "director";
  }

  public static class MOVIE3 {
    public static final String TYPE_NAME = "Movie3";

    public static final String Name = "name";

    public static final String Director = "director";
  }

  public static class POST {
    public static final String TYPE_NAME = "Post";

    public static final String Id = "id";

    public static final String Name = "name";

    public static final String Reviews = "reviews";
  }

  public static class REVIEW {
    public static final String TYPE_NAME = "Review";

    public static final String StarRating = "starRating";
  }

  public static class BOOKINPUT {
    public static final String TYPE_NAME = "BookInput";

    public static final String Title = "title";

    public static final String ReleaseYear = "releaseYear";
  }

  public static class BOOKFILTER {
    public static final String TYPE_NAME = "BookFilter";

    public static final String Title = "title";
  }
}
