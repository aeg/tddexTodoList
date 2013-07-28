package com.example.todo;

import spock.lang.Specification

/**
 * User: aeg
 * Date: 2013/07/28
 * Time: 17:31
 */
class TodoSpec extends Specification {
  def "Todo can convert json"() {
    when:
    Todo todo = new Todo(id: 1, content: "test")

    then:
    todo.toString() == "{\"id\":1,\"content\":\"test\"}"
  }

}