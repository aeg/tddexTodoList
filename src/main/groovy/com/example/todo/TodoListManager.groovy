package com.example.todo

import com.google.gson.Gson
import com.google.gson.stream.JsonReader

/**
 * User: aeg
 * Date: 2013/07/28
 * Time: 17:12
  */
class TodoListManager {
  private File file;

  public TodoListManager(String fileName) {
    file = new File(fileName)
    if (!file.exists()) {
      def fw = file.createNewFile()
    }
  }

  def write(TodoList todoList) {
    FileWriter writer = new FileWriter(file.getAbsolutePath())
    writer.write(todoList.toString())
    writer.close()
  }

  TodoList ReadList() {

    TodoList todolist = new TodoList()

    JsonReader reader = new JsonReader(new FileReader(file))
    Gson gson = new Gson()
    todolist = gson.fromJson(reader, TodoList.class)

    return todolist
  }
}
