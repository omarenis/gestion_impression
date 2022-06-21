package com.management_teachers_impression.management_teachers_impression.servlets;

import com.management_teachers_impression.management_teachers_impression.models.entities.User;
import com.management_teachers_impression.management_teachers_impression.services.UserCrudService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddEditUserServlet", value = "/adduser")
public class AddEditUserServlet extends HttpServlet {

    private UserCrudService userCrudService;

    public AddEditUserServlet() throws SQLException, ClassNotFoundException {
        userCrudService = new UserCrudService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/addUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setFirstname(request.getParameter("firstname"));
        user.setLastname(request.getParameter("lastname"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        user.setRole(request.getParameter("role"));
        user.setIsActivated(true);
        try {
            userCrudService = new UserCrudService();
            userCrudService.create(user);
            response.sendRedirect(request.getContextPath() + "/users");
        } catch (SQLException | IOException | ClassNotFoundException e) {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/addUser.jsp").forward(request, response);
        }
    }
}
