package th.ac.tu.cs.services.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import th.ac.tu.cs.services.model.User;
import th.ac.tu.cs.services.repository.JdbcStudentRepository;
import th.ac.tu.cs.services.service.TuApiService;

/**
 * This class represents the controller for handling login requests.
 * It uses TuApiService and JdbcStudentRepository for authentication and query.
 */
@Controller
public class LoginController {

    private final TuApiService tuApiService;
    private final JdbcStudentRepository jdbcStudentRepository;

    public LoginController(TuApiService tuApiService, JdbcStudentRepository jdbcStudentRepository) {
        this.tuApiService = tuApiService;
        this.jdbcStudentRepository = jdbcStudentRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * Handles the POST request for the login route.
     *
     * @param username The username of the user trying to log in.
     * @param password The password of the user trying to log in.
     * @param model The model object to bind data to the view.
     * @return The name of the view to be rendered. If authentication is successful, it returns "data", otherwise "login".
     */
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = tuApiService.authenticate(username, password);
        if (user != null) {
            model.addAttribute("user", user);
            jdbcStudentRepository.save(user);
            return "data";
        } else {
            model.addAttribute("error", "Invalid username or password. Please try again.");
            return "login";
        }
    }

    @GetMapping("/data")
    public String data() {
        return "data";
    }

}