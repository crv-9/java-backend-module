package io.everyonecodes.w1springbeans.todos.repositories;

import io.everyonecodes.w1springbeans.todos.model.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoRepository extends MongoRepository<ToDo, String> {
}
