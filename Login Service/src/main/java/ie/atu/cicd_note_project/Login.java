package ie.atu.cicd_note_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
public class Login {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String loginUser(@RequestBody User user)
    {
        Optional<User> existingUser = loginService.getUserByUsername(user.getUsername());
        if(existingUser.isPresent()&& Objects.equals(user.getPassword(), existingUser.get().getPassword()))
        {
            return "Login successful userID = " + existingUser.get().getUserId();
        }
        else
        {
            return "Login failed";
        }
    }




}
