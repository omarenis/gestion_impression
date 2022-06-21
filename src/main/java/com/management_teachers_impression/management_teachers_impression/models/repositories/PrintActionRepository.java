package com.management_teachers_impression.management_teachers_impression.models.repositories;

import com.management_teachers_impression.management_teachers_impression.models.entities.PrintAction;
import com.management_teachers_impression.management_teachers_impression.models.entities.Subject;
import com.management_teachers_impression.management_teachers_impression.models.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrintActionRepository extends ConnectionMysql{
    public PrintActionRepository() throws SQLException, ClassNotFoundException {
        super();
    }

    public List<PrintAction> getListFromResultSet(ResultSet resultSet) throws SQLException {
        List<PrintAction> printActions = new ArrayList<>();
        while (resultSet.next())
        {
            PrintAction printAction = new PrintAction();
            printAction.setTeacherId(resultSet.getLong("teacherId"));
            User teacher = executeQuery("select * from users where id = " + resultSet.getLong("teacherId")).getObject(1, User.class);
            printAction.setTeacher(teacher);
            Subject subject = executeQuery("select * from subjects where id = " + resultSet.getLong("subjectId")).getObject(1, Subject.class);
            printAction.setSubject(subject);
            printAction.setDatAskForPrint(resultSet.getDate("dateAskForPrint"));
            printAction.setNumberCopies(resultSet.getInt("numberCopies"));
            printAction.setIsValidated(resultSet.getBoolean("isValidated"));
            printActions.add(printAction);
        }
        return printActions;
    }

    public List<PrintAction> findAll() throws SQLException {
        return getListFromResultSet(executeQuery("select * from print_actions"));
    }

    public PrintAction findById(Long id) throws SQLException {
        return executeQuery("select * from print_actions where id = " + id).getObject(1, PrintAction.class);
    }

    public List<PrintAction> findByDocument(Long documentId) throws SQLException {
        return getListFromResultSet(executeQuery("select * from print_actions where documentId = " + documentId));
    }

    public PrintAction create(PrintAction printAction)
    {
        String query  = String.format("insert into print_actions ()");
        return null;
    }
}
