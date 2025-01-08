package com.example.searchservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository TodoRepository;

    public Todo createTodo(Tode todo) {
        return TodoRepository.save(tode);
    }

    public List<Todo> getAllTodo) {
        return TodoRepository.findAll();
    }

    public List<Todo> getTodoByUserId(Long authorId) {
        return TodoRepository.findByAuthorId(authorId);
    }

    public Todo getTodoById(Long id) {
        return TodoRepository.findById(id).orElse(null);
    }


}