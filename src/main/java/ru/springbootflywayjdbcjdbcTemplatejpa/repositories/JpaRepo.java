package ru.springbootflywayjdbcjdbcTemplatejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.springbootflywayjdbcjdbcTemplatejpa.entity.Student;


public interface JpaRepo extends JpaRepository<Student, Long> {

}
