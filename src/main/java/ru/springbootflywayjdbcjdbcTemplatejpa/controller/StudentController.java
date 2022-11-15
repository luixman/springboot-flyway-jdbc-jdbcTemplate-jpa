package ru.springbootflywayjdbcjdbcTemplatejpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.springbootflywayjdbcjdbcTemplatejpa.entity.Student;
import ru.springbootflywayjdbcjdbcTemplatejpa.repositories.DbQueries;

@RestController
@RequestMapping("/students")
@EnableWebMvc
@RequiredArgsConstructor
public class StudentController {


    //@Resource(name = "${application.dataBase}")
    private final DbQueries repo;


    @GetMapping()
    public ResponseEntity getAll() {
        try{
        return ResponseEntity.ok(repo.getAll());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getStudentById(@PathVariable Long id){
        try{
        return ResponseEntity.ok(repo.getStudentById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }

    }

    @PostMapping()
    public ResponseEntity create(@RequestBody Student student){
       try{
        repo.save(student);
        return ResponseEntity.ok(student);
       }catch (Exception e){
           return ResponseEntity.badRequest().body(e);
       }
    }

    @PostMapping("/{id}")
    @ResponseBody
    public ResponseEntity update(@RequestBody Student student, @PathVariable Long id){
        try{
        Student updateStudent =repo.update(id,student);
        return ResponseEntity.ok(updateStudent);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            repo.delete(id);
            return ResponseEntity.ok(id);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }

}
