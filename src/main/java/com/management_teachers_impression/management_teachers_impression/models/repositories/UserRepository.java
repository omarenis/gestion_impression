package com.management_teachers_impression.management_teachers_impression.models.repositories;


import com.management_teachers_impression.management_teachers_impression.models.entities.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository extends ConnectionMysql{

    public UserRepository() throws SQLException, ClassNotFoundException {
        super();
    }

    public List<User> findAll() throws SQLException {
        ResultSet resultSet = executeQuery("select * from users");
        List<User> users = new ArrayList<>();
        while (resultSet.next())
        {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setFirstname(resultSet.getString("firstname"));
            user.setLastname(resultSet.getString("lastname"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            user.setRole(resultSet.getString("role"));
            user.setIsActivated(resultSet.getBoolean("isActivated"));
            users.add(user);
        }
        return users;
    }

    public User findById(Long id) throws SQLException {
        return executeQuery("select * from users where id = " + id).getObject(1, User.class);
    }

    public User findByEmail(String email) throws SQLException {
        ResultSet resultSet = executeQuery("select * from users where email = '" + email + "'");
        if(resultSet.next())
        {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setFirstname(resultSet.getString("firstname"));
            user.setLastname(resultSet.getString("lastname"));
            user.setEmail(resultSet.getString("email"));
            user.setRole(resultSet.getString("role"));
            user.setPassword(resultSet.getString("password"));
            user.setIsActivated(resultSet.getBoolean("isActivated"));
            return user;
        }
        return null;
    }
    public User findByEmailAndRole(String email, String role) throws SQLException {
        return executeQuery("select * from users where email like '" + email + "' and role like '" + role + "'").getObject(1, User.class);
    }

    public User create(User user) throws SQLException
    {
        String query = String.format(" insert into users (firstname, lastname, email, password, role, isActivated) values ('%s', '%s', '%s', '%s', '%s', true)", user.getFirstname(), user.getLastname(), user.getEmail(), user.getPassword(), user.getRole());
        PreparedStatement preparedStmt = this.getConnection().prepareStatement(query);
        preparedStmt.execute(query, PreparedStatement.RETURN_GENERATED_KEYS);
        ResultSet resultSet = preparedStmt.getGeneratedKeys();
        if(resultSet.next())
        {
            user.setId(resultSet.getLong(1));
            return user;
        }
        return null;
    }

    public void changeStatusUser(Long id, boolean status) throws SQLException {
        executeQuery("update users set isActivated =" + status + "  where id = " + id);
    }
}
