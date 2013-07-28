package com.example.todo

import com.google.gson.Gson
import groovy.transform.TupleConstructor

/**
 * User: aeg
 * Date: 2013/07/28
 * Time: 16:15
  */
@TupleConstructor
class Todo {
  private int id;
  private String content;

  @Override
  public String toString() {
    Gson gson = new Gson();
    return gson.toJson(this);
  }
}
