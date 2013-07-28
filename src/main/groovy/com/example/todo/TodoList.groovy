package com.example.todo

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

/**
 * User: aeg
 * Date: 2013/07/28
 * Time: 16:14
  */
class TodoList {
  @SerializedName("list")
  private List<Todo> todoList;

  public TodoList() {
    todoList = new ArrayList<Todo>();
  }

  def add(Todo todo) {
    todoList.add(todo);
  }

  def size(){
    return todoList.size();
  }

  Todo lastTodo() {
    if (todoList.isEmpty() ) {
      return null
    }
    return todoList[todoList.size()-1]
  }

  Todo firstTodo() {
    if (todoList.isEmpty() ) {
      return null
    }
    return todoList[0]
  }

  public String toString() {
    Gson gson = new Gson();
    return gson.toJson(this);
  }
}
