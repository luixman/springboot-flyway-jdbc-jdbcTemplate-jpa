package ru.springbootflywayjdbcjdbcTemplatejpa.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor

@Entity
@Table(name = "feign2")

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "full_name")
    String fullName;
    @Column(name = "age")
    Integer age;

    @Column(name = "group_name")
    String group;
    @Column(name = "deleted")
    Boolean deleted;
   /* @Column(name = "id_student")
    Long studentId;*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;
        return id != null && Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
