package ie.atu.cicd_note_project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long>{
    Optional<User> findByUsername(String username);
}
