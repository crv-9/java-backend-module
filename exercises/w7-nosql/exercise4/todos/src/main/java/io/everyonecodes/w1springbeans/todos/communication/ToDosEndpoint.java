package io.everyonecodes.w1springbeans.todos.communication;

import io.everyonecodes.w1springbeans.todos.logic.ToDosManager;
import io.everyonecodes.w1springbeans.todos.model.ToDo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class ToDosEndpoint {

    private final ToDosManager toDosManager;

    public ToDosEndpoint(ToDosManager toDosManager) {
        this.toDosManager = toDosManager;
    }

    // get a list of all saved todos
    @GetMapping
    public List<ToDo> getAllTodos(){
        return toDosManager.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ToDo> getTodoById(@PathVariable String id){
        return toDosManager.getById(id);
    }

    @PostMapping
    public ToDo createTodo(@RequestBody ToDo todo){
        return toDosManager.add(todo);
    }

    @PutMapping("/{id}/done")
    public Optional<ToDo> doneTodo(@PathVariable String id){
        return toDosManager.update(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable String id){
        toDosManager.delete(id);
    }


}
