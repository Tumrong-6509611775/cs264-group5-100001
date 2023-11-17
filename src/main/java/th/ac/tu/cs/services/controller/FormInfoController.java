package th.ac.tu.cs.services.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ac.tu.cs.services.model.FormInfo;
import th.ac.tu.cs.services.repository.JdbcFormInfoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping("/path/form")
@CrossOrigin
@Controller
public class FormInfoController {

    private final JdbcFormInfoRepository jdbcFormInfoRepository;

    private final ObjectMapper objectMapper;

    public FormInfoController(JdbcFormInfoRepository jdbcFormInfoRepository, ObjectMapper objectMapper) {
        this.jdbcFormInfoRepository = jdbcFormInfoRepository;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/index")
    public String formInfo() {
        return "index";
    }

    @PostMapping("/index")
    public String form(@RequestBody FormInfo formInfo) throws JsonProcessingException {
        try {
            jdbcFormInfoRepository.saveInfo(formInfo);

            //jdbcFormInfoRepository.saveSubject(formInfo);
        } catch (Exception e) {
            System.err.println(e);
        }
        return "index";
    }

    @PostMapping("/subject")
    public String subj(@RequestBody FormInfo subj) throws JsonProcessingException{
        try{
            jdbcFormInfoRepository.saveSubject(subj);

        }catch (Exception e){
            System.err.println(e);
        }
        return "index";
    }

    @GetMapping("/example")
    public String example() {
        return "Example";
    }

}