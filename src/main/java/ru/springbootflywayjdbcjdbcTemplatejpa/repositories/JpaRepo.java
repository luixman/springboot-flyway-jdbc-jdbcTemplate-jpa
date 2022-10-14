package ru.springbootflywayjdbcjdbcTemplatejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.springbootflywayjdbcjdbcTemplatejpa.entity.Student;

public interface JpaRepo extends JpaRepository<Student, Long>  {

}


