package th.ac.tu.cs.services.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ac.tu.cs.services.model.FormInfo;
import th.ac.tu.cs.services.repository.JdbcFormInfoRepository;
import th.ac.tu.cs.services.repository.JdbcStudentRepository;

@Controller
public class FormInfoController {
    private final JdbcFormInfoRepository jdbcFormInfoRepository;

    public FormInfoController(JdbcStudentRepository jdbcStudentRepository, JdbcFormInfoRepository jdbcFormInfoRepository) {
        this.jdbcFormInfoRepository = jdbcFormInfoRepository;
    }

    @GetMapping("/index")
    public String formInfo() {
        return "index";
    }

    @PostMapping("/index")
    public String form(@RequestParam String studentFirstName, Model model) {
        FormInfo info = new FormInfo();
        info.setStudentFirstName(studentFirstName);
        model.addAttribute("info", info);
        jdbcFormInfoRepository.save(info);
        return "index";
    }
}
