package com.management_teachers_impression.management_teachers_impression.models.repositories;

import com.management_teachers_impression.management_teachers_impression.models.entities.Subject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectRepository extends ConnectionMysql{

    public SubjectRepository() throws SQLException, ClassNotFoundException {
        super();
    }

    public List<Subject> findAll() throws SQLException {
        ResultSet resultSet = executeQuery("select * from subjects");
        List<Subject> subjects = new ArrayList<>();
        while (resultSet.next())
        {
            Subject subject = new Subject();
            subject.setId(resultSet.getLong("id"));
            subject.setLabel(resultSet.getString("label"));
            subjects.add(subject);
        }
        return subjects;
    }


    public Subject create(Subject subject) throws SQLException
    {
        String query = String.format(" insert into subjects (label)"
                + " values ( '%s')", subject.getLabel()) ;
        PreparedStatement preparedStmt = this.getConnection().prepareStatement(query);
        preparedStmt.execute(query, PreparedStatement.RETURN_GENERATED_KEYS);
        ResultSet resultSet = preparedStmt.getGeneratedKeys();
        if(resultSet.next())
        {
            subject.setId(resultSet.getLong(1));
            return subject;
        }
        return null;
    }

    public void delete(Long id) throws Exception {
        String query = " delete from subjects"
                + " where id = ?";
        PreparedStatement preparedStmt = this.getConnection().prepareStatement(query);
        preparedStmt.setLong(1, id);
        preparedStmt.execute(query);
        ResultSet resultSet = preparedStmt.getGeneratedKeys();
        if(resultSet == null)
        {
            throw new Exception("element not found");
        }
    }
}
