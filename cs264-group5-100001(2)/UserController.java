package th.ac.tu.cs.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.ac.tu.cs.services.model.User;
import th.ac.tu.cs.services.repository.jdbcUserRepository;

@RestController
@RequestMapping(value={"form"})
public class UserController {
    @Autowired
    jdbcUserRepository userRepository;

    @PostMapping()
    public void createUser(@RequestBody User user) {
        userRepository.save(user);
    }
}
