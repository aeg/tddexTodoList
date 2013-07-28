package com.example.todo;

import spock.lang.Specification

/**
 * User: aeg
 * Date: 2013/07/28
 * Time: 17:04
 */
class TodoListManagerSpec extends Specification {

//  def "TodoListMangerがNewされたときにファイルが存在しないときには作成する"() {
  def "TodoListMangerCreateFileWhenFile does not exist"() {
    when:
    TodoListManager tlm = new TodoListManager("todolist.json")

    then:
    File result = new File("todolist.json")

    result.exists()
  }

  def "TodoListManager can write string into file"() {
    when:
    TodoListManager manager = new TodoListManager("todolist.json")

    TodoList list = new TodoList();
    Todo todo = new Todo(id: 1, content: "test")
    list.add(todo)

    manager.write(list)

    then:
    File file = new File("todolist.json")
    String text = file.getText()
    text == "{\"list\":[{\"id\":1,\"content\":\"test\"}]}"
  }

  def "TodoListManager can read json file"() {
    when:
    File testJson = new File("testtodo.json")
    FileWriter fw = new FileWriter(testJson.getAbsolutePath())
    fw.write("{\"list\":[{\"id\":1,\"content\":\"test\"}]}")
    fw.close()

    TodoListManager manager = new TodoListManager("testtodo.json")

    TodoList resultList = manager.ReadList()


    then:
    resultList.firstTodo().id == 1
    resultList.firstTodo().content == "test"

  }

}