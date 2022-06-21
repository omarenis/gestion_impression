package com.management_teachers_impression.management_teachers_impression.models.repositories;

import lombok.Getter;
import lombok.Setter;

import java.sql.*;
public class ConnectionMysql {

    @Getter @Setter private Connection connection;
    @Getter @Setter private Statement stmt;
    public ConnectionMysql() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/gestionimpression_db","root","Mysql1996@+=");
        stmt = connection.createStatement();
    }

    ResultSet executeQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }
}
