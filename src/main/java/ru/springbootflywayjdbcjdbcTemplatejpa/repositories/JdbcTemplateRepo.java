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
@ConditionalOnProperty(prefix = "spring", name = "datasource.connection", havingValue = "jdbcTemplate")
public class JdbcTemplateRepo implements DbQueries {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Student> getAll() {
        System.out.println("jdbcTemplate");
        return jdbcTemplate.query("SELECT * FROM feign2", new StudentMapper());
    }

    @Override
    public Student getStudentById(Long id) {

        Student student = jdbcTemplate.queryForObject("SELECT * FROM feign2 WHERE id=?", new Object[]{id}, new StudentMapper());
        // return jdbcTemplate.query("SELECT * FROM feign2 WHERE id=:id", new StudentMapper());
        return student;
    }

    @Override
    public void save(Student student) {
        jdbcTemplate.update("INSERT INTO feign2 ( full_name, age, group_name, deleted) VALUES (?,?,?,?)",
                student.getFullName(), student.getAge(), student.getGroup(), student.getDeleted());
    }

    @Override
    public Student update(Long id, Student student) {
        student.setId(id);
        jdbcTemplate.update("UPDATE feign2 SET full_name=?,age=?,group_name=?,deleted=? WHERE id =?",
                student.getFullName(), student.getAge(), student.getGroup(), student.getDeleted(),id);

        return getStudentById(id);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM feign2 WHERE id =?",id);

    }

    public static class StudentMapper implements RowMapper<Student> {
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
