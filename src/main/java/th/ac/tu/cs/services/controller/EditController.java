package th.ac.tu.cs.services.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import th.ac.tu.cs.services.model.User;
import th.ac.tu.cs.services.repository.JdbcStudentRepository;

@Controller("/index")
public class EditController {

    JdbcStudentRepository jdbcStudentRepository;

    public EditController(JdbcStudentRepository jdbcStudentRepository) {
        this.jdbcStudentRepository = jdbcStudentRepository;
    }

    @GetMapping("/edit")
    public String edit() {
        return "edit";
    }

    @GetMapping("/edit/users/findByDisplayNameTh/{displayname_th}")
    public ResponseEntity<List<User>> findByDisplayNameTh(@PathVariable String displayname_th) {
        List<User> user = jdbcStudentRepository.findByDisplayName_th(displayname_th);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
