package com.management_teachers_impression.management_teachers_impression.servlets;

import com.management_teachers_impression.management_teachers_impression.models.entities.User;
import com.management_teachers_impression.management_teachers_impression.services.UserCrudService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet {
    private final UserCrudService userCrudService;

    public UserServlet() throws SQLException, ClassNotFoundException {
        userCrudService = new UserCrudService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<User> users = userCrudService.GetAllUsers();
            request.setAttribute("users", users);
            request.getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("userId") != null)
        {
            try {
                userCrudService.changeStatusAccount(Long.parseLong(request.getParameter("userId")));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else
        {
            User user = new User();
            user.setFirstname(request.getParameter("firstname"));
            user.setLastname(request.getParameter("lastname"));
            user.setEmail(request.getParameter("email"));
            user.setRole(request.getParameter("role"));
            user.setPassword(request.getParameter("password"));
            user.setIsActivated(true);
            try {
                System.out.println(userCrudService);
                user = userCrudService.create(user);
                response.sendRedirect(request.getContextPath() + "/users");
            } catch (SQLException e) {
                if(e.getMessage().equals("email must be unique"))
                {
                    request.setAttribute("message", e.getMessage());
                }
            }
            request.getRequestDispatcher("/WEB-INF/addUser.jsp").forward(request, response);
        }
    }
}
