package ru.springbootflywayjdbcjdbcTemplatejpa.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import org.springframework.stereotype.Repository;
import ru.springbootflywayjdbcjdbcTemplatejpa.entity.Student;

import java.util.List;

@Repository
@ConditionalOnProperty(prefix = "spring",name = "datasource.connection", havingValue = "jpa")
public class JpaRepositoryClass implements Queries {

    @Autowired
    private JpaRepo jpaRepo;
    @Override
    public List<Student> getAll() {
        return jpaRepo.findAll();
    }
}
