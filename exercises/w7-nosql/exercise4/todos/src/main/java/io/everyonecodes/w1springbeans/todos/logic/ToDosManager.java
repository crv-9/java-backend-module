package io.everyonecodes.w1springbeans.todos.logic;

import io.everyonecodes.w1springbeans.todos.model.ToDo;
import io.everyonecodes.w1springbeans.todos.repositories.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ToDosManager {
    ToDoRepository toDoRepository;

    public ToDosManager(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    // get a list of all Todos
    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    // returns the To-do that matches that id.
    public Optional<ToDo> getById(String id) {
        return toDoRepository.findById(id);
    }

    // creates/saves a new To-Do and returns it.
    public ToDo add(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    // marks the To-Do with the matching id as done and returns it, if it exists.
    public Optional<ToDo> update(String id) {
        Optional<ToDo> oToDo = toDoRepository.findById(id);
        if (oToDo.isPresent()) {
            oToDo.get().setDone(true);
            toDoRepository.save(oToDo.get());
            return oToDo;
        } else return Optional.empty();
    }

    // deletes the To-Do that matches that id
    public void delete(String id) {
        toDoRepository.deleteById(id);
    }


}
