package ru.springbootflywayjdbcjdbcTemplatejpa.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;
import ru.springbootflywayjdbcjdbcTemplatejpa.entity.Student;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@Repository()
@ConditionalOnProperty(prefix = "spring",name = "datasource.connection",havingValue = "jdbc")
public class JdbcRepo implements DbQueries {
    private Connection connection;


    @Autowired
    public JdbcRepo(DataSource dataSource) {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public List<Student> getAll() {
        System.out.println("jdbc");
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

}
