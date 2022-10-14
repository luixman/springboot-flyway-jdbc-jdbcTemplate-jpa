package ru.springbootflywayjdbcjdbcTemplatejpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.springbootflywayjdbcjdbcTemplatejpa.repositories.DbQueries;

@RestController
@EnableWebMvc
@RequiredArgsConstructor
public class TestController {


    //@Resource(name = "${application.dataBase}")
    private final DbQueries repo;


    @GetMapping("/")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(repo.getAll());
    }




}
