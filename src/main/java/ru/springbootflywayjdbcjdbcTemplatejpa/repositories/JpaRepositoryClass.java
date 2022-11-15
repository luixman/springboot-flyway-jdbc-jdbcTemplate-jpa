package ru.springbootflywayjdbcjdbcTemplatejpa.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import org.springframework.stereotype.Repository;
import ru.springbootflywayjdbcjdbcTemplatejpa.entity.Student;

import java.util.List;

@Repository
@ConditionalOnProperty(prefix = "spring",name = "datasource.connection", havingValue = "jpa")
public class JpaRepositoryClass implements DbQueries {

    @Autowired
    private JpaRepo jpaRepo;
    @Override
    public List<Student> getAll() {
        return jpaRepo.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return jpaRepo.findFirstById(id);
    }

    @Override
    public void save(Student student) {
        jpaRepo.save(student);
    }

    @Override
    public Student update(Long id, Student student) {
        student.setId(id);
        jpaRepo.save(student);
        return jpaRepo.findFirstById(id);

    }

    @Override
    public void delete(Long id) {
        jpaRepo.deleteById(id);
    }
}
