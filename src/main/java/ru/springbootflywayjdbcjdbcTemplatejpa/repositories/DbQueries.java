package ru.springbootflywayjdbcjdbcTemplatejpa.repositories;

import ru.springbootflywayjdbcjdbcTemplatejpa.entity.Student;

import java.util.List;


public interface DbQueries {
    List<Student> getAll();

    Student getStudentById(Long id);

    void save(Student student);

    Student update(Long id, Student student);

    void delete(Long id);

}
