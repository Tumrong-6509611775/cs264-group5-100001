package th.ac.tu.cs.services.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ac.tu.cs.services.model.FormInfo;
import th.ac.tu.cs.services.repository.JdbcFormInfoRepository;

@Controller
public class FormInfoController {

    private final JdbcFormInfoRepository jdbcFormInfoRepository;

    public FormInfoController(JdbcFormInfoRepository jdbcFormInfoRepository) {
        this.jdbcFormInfoRepository = jdbcFormInfoRepository;
    }

    @GetMapping("/index")
    public String formInfo() {
        return "index";
    }

    @PostMapping("/index")
    public String form(@RequestParam String JSON1, Model model) {
        FormInfo info = new FormInfo();
        System.out.println("check post index");
        info.setUsername(JSON1);
        info.setStudentFirstName(JSON1);
        info.setStudentLastName(JSON1);
        info.setNameTitles(JSON1);
        info.setStudentYear(JSON1);
        info.setStudyField(JSON1);
        info.setMobilePhone(JSON1);
        info.setPhone(JSON1);
        info.setAdvisor(JSON1);
        info.setAddressNumber(JSON1);
        info.setMoo(JSON1);
        info.setTumbol(JSON1);
        info.setAmphur(JSON1);
        info.setProvince(JSON1);
        info.setPostalcode(JSON1);
        jdbcFormInfoRepository.saveInfo(info);
        return "index";
    }
}
