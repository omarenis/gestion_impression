package com.management_teachers_impression.management_teachers_impression.models.repositories;


import com.management_teachers_impression.management_teachers_impression.models.entities.Teacher;
import com.management_teachers_impression.management_teachers_impression.models.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepository extends ConnectionMysql{
    public TeacherRepository() throws SQLException, ClassNotFoundException {
        super();
    }

    public List<Teacher> findAll() throws SQLException {
        ResultSet resultSet = executeQuery("select * from teachers");
        List<Teacher> teachers = new ArrayList<>();
        while (resultSet.next())
        {
            Teacher teacher = new Teacher();
            teacher.setFirstname(resultSet.getString("firstname"));
            teacher.setLastname(resultSet.getString("lastname"));
            teacher.setEmail(resultSet.getString("email"));
            teacher.setPassword(resultSet.getString("password"));
            teacher.setRole(resultSet.getString("role"));
            teachers.add(teacher);
        }
        return teachers;
    }

    public Teacher findById(Long id) throws SQLException {
        return executeQuery("select * from teachers where id = " + id).getObject(1, Teacher.class);
    }

    public Teacher findByEmail(String email) throws SQLException {
        return executeQuery("select * from teachers where email = " + email).getObject(1, Teacher.class);
    }
}
