package com.management_teachers_impression.management_teachers_impression.services;

import com.management_teachers_impression.management_teachers_impression.models.entities.User;
import com.management_teachers_impression.management_teachers_impression.models.repositories.UserRepository;

import java.sql.SQLException;

public class LoginService {
    private final UserRepository userRepository;

    public LoginService() throws SQLException, ClassNotFoundException {
        userRepository = new UserRepository();
    }

    public User login(String email, String password) throws Exception {
        User user = userRepository.findByEmail(email);
        if (user == null)
        {
            throw new Exception("user not found");
        }
        else if(!user.getIsActivated())
        {
            throw new Exception("user is not active");
        }
        if(user.getPassword().equals(password))
        {
            return user;
        }
        throw new Exception("password didn't match");
    }
}
