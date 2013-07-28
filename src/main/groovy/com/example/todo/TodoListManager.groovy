package com.example.todo

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

  TodoList getReadList() {
    return null;
  }
}
