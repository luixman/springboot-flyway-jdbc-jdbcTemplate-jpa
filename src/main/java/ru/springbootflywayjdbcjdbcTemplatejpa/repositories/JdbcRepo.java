package ru.springbootflywayjdbcjdbcTemplatejpa.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;
import ru.springbootflywayjdbcjdbcTemplatejpa.entity.Student;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
@ConditionalOnProperty(prefix = "spring", name = "datasource.connection", havingValue = "jdbc")
public class JdbcRepo implements DbQueries {
    private  Connection connection;


    @Autowired
    public JdbcRepo(DataSource dataSource) {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, full_name,age,group_name,deleted FROM feign2 ");

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getLong("id"));
                student.setFullName(resultSet.getString("full_name"));
                student.setAge(resultSet.getInt("age"));
                student.setGroup(resultSet.getString("group_name"));
                student.setDeleted(resultSet.getBoolean("deleted"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;

    }

    @Override
    public Student getStudentById(Long id) {
        Student student = new Student();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, full_name,age,group_name,deleted FROM feign2 where id=" + id);
            resultSet.next();

            student.setId(resultSet.getLong("id"));
            student.setFullName(resultSet.getString("full_name"));
            student.setAge(resultSet.getInt("age"));
            student.setGroup(resultSet.getString("group_name"));
            student.setDeleted(resultSet.getBoolean("deleted"));

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public void save(Student student) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO feign2 ( full_name, age, group_name, deleted) VALUES (?,?,?,?)"
            );
            preparedStatement.setString(1, student.getFullName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getGroup());
            preparedStatement.setBoolean(4, student.getDeleted());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public Student update(Long id, Student student) {
        student.setId(id);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE feign2 SET full_name=?,age=?,group_name=?,deleted=? WHERE id =?"
            );
            preparedStatement.setString(1, student.getFullName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getGroup());
            preparedStatement.setBoolean(4, student.getDeleted());
            preparedStatement.setLong(5, student.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


        return getStudentById(id);
    }

    @Override
    public void delete(Long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM feign2 WHERE id =?"
            );

            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
