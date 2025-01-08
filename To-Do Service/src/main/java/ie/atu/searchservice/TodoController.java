package ie.atu.searchservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/to-do")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(Todo);
    }

    @GetMapping
    public List<Todo> getAllTodo() {
        return todoService.getAllTodo();
    }

    @GetMapping("/notes/{authorId}")
    public List<Todo> getTodoByUserId(@PathVariable Long authorId) {
        return todoService.getTodoByUserId(authorId);
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
       Todo todo = TodoService.getTodoById(id);
        return note != null ? ResponseEntity.ok(Todo) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todoDetails) {
        Note updatedNote = todoService.updateNote(id, todoDetails);
        return updatedNote != null ? ResponseEntity.ok(updatedNote) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
}