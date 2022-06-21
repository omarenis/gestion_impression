package com.management_teachers_impression.management_teachers_impression.servlets;

import com.management_teachers_impression.management_teachers_impression.models.entities.User;
import com.management_teachers_impression.management_teachers_impression.services.LoginService;
import com.management_teachers_impression.management_teachers_impression.services.UserCrudService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private LoginService loginService;

    @Override
    public void init() throws ServletException {
        try {
            this.loginService = new LoginService();
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try
        {
            User user = loginService.login(email, password);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            if(user.getRole().equals("teacher"))
            {
                response.sendRedirect(request.getContextPath() + "/subjects");
            }
            else if (user.getRole().equals("admin"))
            {
                response.sendRedirect(request.getContextPath() +"/users");
            }
        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
        }
    }
}
