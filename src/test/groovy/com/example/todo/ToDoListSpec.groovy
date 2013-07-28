package com.example.todo


import spock.lang.Specification

/**
 * User: aeg
 * Date: 2013/07/28
 * Time: 15:54
 */
class ToDoListSpec extends Specification {

  def "ToDoリストに1件Todoが登録できること"() {
    when:
    TodoList list = new TodoList()
    Todo todo = new Todo(id: 1, content: "content")

    list.add(todo)

    then:
    list.size() == 1
  }

  def "TodoListCanGetLastTodo"() {
    when:
    TodoList list = new TodoList()
    Todo todo = new Todo(id: 1, content: "content")

    list.add(todo)

    then:
    Todo result = list.lastTodo()
    result != null
    result.id == 1
    result.content == "content"
  }

  def "1件もTodoリストが登録されていないとにlastTodoがnullを返す"() {
    when:
    TodoList list = new TodoList()

    then:
    Todo result = list.lastTodo()

    result == null
  }

  def "TodoListCanGetFirstTodo"() {
    when:
    TodoList list = new TodoList()
    Todo todo = new Todo(id: 1, content: "content")

    list.add(todo)

    then:
    Todo result = list.firstTodo()
    result != null
    result.id == 1
    result.content == "content"
  }

  def "TodoList can convert json"() {
    when:
    TodoList list = new TodoList()
    Todo todo = new Todo(id: 1, content: "content")

    list.add(todo)

    then:
    list.toString() == "{\"list\":[{\"id\":1,\"content\":\"content\"}]}"
  }
}