package com.example.cicd_note_project;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepo extends JpaRepository<User,Long>{
}
