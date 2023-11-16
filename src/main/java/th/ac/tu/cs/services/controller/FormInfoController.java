package th.ac.tu.cs.services.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ac.tu.cs.services.model.FormInfo;
import th.ac.tu.cs.services.repository.JdbcFormInfoRepository;
@RestController
@RequestMapping("/api/reg")
@CrossOrigin

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
    public String form(@RequestBody String JSON1, Model model) {
        System.out.println(JSON1);
        FormInfo info = new FormInfo();
        System.out.println("check post index");
        try{
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
        }catch (Exception e){
            System.err.println(e);
        }
        System.out.println(info);
        return "index";
    }
}
