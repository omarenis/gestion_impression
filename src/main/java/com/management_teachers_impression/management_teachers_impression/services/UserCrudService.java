package com.management_teachers_impression.management_teachers_impression.services;

import com.management_teachers_impression.management_teachers_impression.models.entities.User;
import com.management_teachers_impression.management_teachers_impression.models.repositories.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class UserCrudService {
    private final UserRepository userRepository;
    public UserCrudService() throws SQLException, ClassNotFoundException {
        userRepository = new UserRepository();
    }

    public List<User> GetAllUsers() throws SQLException {
        return userRepository.findAll();
    }

    public void changeStatusAccount(Long id) throws SQLException {
        User user = userRepository.findById(id);
        userRepository.changeStatusUser(user.getId(), !user.getIsActivated());
        user.setIsActivated(!user.getIsActivated());
    }

    public User create(User user) throws SQLException
    {
        User userModel = userRepository.findByEmail(user.getEmail());
        System.out.println(userModel);
        if (userModel != null)
        {
            throw new SQLException("email must be unique");
        }
        else {
            return userRepository.create(user);
        }
    }
}
