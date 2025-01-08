package com.example.notesservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public List<Note> getNotesByUserId(Long authorId) {
        return noteRepository.findByAuthorId(authorId);
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public Note updateNote(Long id, Note noteDetails) {
        Note note = noteRepository.findById(id).orElse(null);
        if (note != null) {
            note.setTitle(noteDetails.getTitle());
            note.setText(noteDetails.getText());
            note.setAuthorId(noteDetails.getAuthorId());
            return noteRepository.save(note);
        }
        return null;
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}