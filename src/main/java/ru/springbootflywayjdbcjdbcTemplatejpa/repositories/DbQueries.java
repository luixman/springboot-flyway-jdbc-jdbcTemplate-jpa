package ru.springbootflywayjdbcjdbcTemplatejpa.repositories;

import ru.springbootflywayjdbcjdbcTemplatejpa.entity.Student;

import java.util.List;


public interface DbQueries {
    List<Student> getAll();
}
