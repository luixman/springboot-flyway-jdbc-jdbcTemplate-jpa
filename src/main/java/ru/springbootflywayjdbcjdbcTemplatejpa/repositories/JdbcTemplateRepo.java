package ru.springbootflywayjdbcjdbcTemplatejpa.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.springbootflywayjdbcjdbcTemplatejpa.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository()
@ConditionalOnProperty(prefix = "spring",name = "datasource.connection",havingValue = "jdbcTemplate")
public class JdbcTemplateRepo implements Queries {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Student> getAll(){
        System.out.println("jdbcTemplate");
        return jdbcTemplate.query("SELECT * FROM feign2",new StudentMapper());
    }

    public static class StudentMapper implements RowMapper<Student>{
        @Override
        public Student mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Student student = new Student();

            student.setId(resultSet.getLong("id"));
            student.setFullName(resultSet.getString("full_name"));
            student.setAge(resultSet.getInt("age"));
            student.setGroup(resultSet.getString("group_name"));
            student.setDeleted(resultSet.getBoolean("deleted"));

            return student;
        }
    }
}
