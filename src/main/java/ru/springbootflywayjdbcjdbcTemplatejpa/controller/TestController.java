package ru.springbootflywayjdbcjdbcTemplatejpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.springbootflywayjdbcjdbcTemplatejpa.repositories.JdbcRepo;
import ru.springbootflywayjdbcjdbcTemplatejpa.repositories.JdbcTemplateRepo;
import ru.springbootflywayjdbcjdbcTemplatejpa.repositories.JpaRepo;

@RestController
@EnableWebMvc
public class TestController {


    private final JpaRepo jpaRepo;
    private final JdbcRepo jdbcRepo;
    private  final JdbcTemplateRepo jdbcTemplateRepo;


    public TestController(JpaRepo jpaRepo, JdbcRepo jdbcRepo, JdbcTemplateRepo jdbcTemplateRepo) {
        this.jpaRepo = jpaRepo;
        this.jdbcRepo = jdbcRepo;
        this.jdbcTemplateRepo = jdbcTemplateRepo;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/jpa")
    public ResponseEntity jpa(){
        return ResponseEntity.ok(jpaRepo.findAll());
    }

    @GetMapping("/jdbc")
    public ResponseEntity jdbc(){
        return ResponseEntity.ok(jdbcRepo.getAll());
    }

    @GetMapping("/jdbc_template")
    public ResponseEntity jdbcTemplate(){
        return ResponseEntity.ok(jdbcTemplateRepo.getAll());
    }


}
