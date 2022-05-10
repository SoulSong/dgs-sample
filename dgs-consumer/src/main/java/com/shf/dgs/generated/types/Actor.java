package com.shf.dgs.generated.types;

import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class Actor {
  private String name;

  private Integer age;

  public Actor() {
  }

  public Actor(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Actor{" + "name='" + name + "'," +"age='" + age + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor that = (Actor) o;
        return java.util.Objects.equals(name, that.name) &&
                            java.util.Objects.equals(age, that.age);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(name, age);
  }

  public static com.shf.dgs.generated.types.Actor.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String name;

    private Integer age;

    public Actor build() {
                  com.shf.dgs.generated.types.Actor result = new com.shf.dgs.generated.types.Actor();
                      result.name = this.name;
          result.age = this.age;
                      return result;
    }

    public com.shf.dgs.generated.types.Actor.Builder name(String name) {
      this.name = name;
      return this;
    }

    public com.shf.dgs.generated.types.Actor.Builder age(Integer age) {
      this.age = age;
      return this;
    }
  }
}
