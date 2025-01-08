package com.example.notesservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends NoteRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByAuthorId(Long authorId);
}