package com.management_teachers_impression.management_teachers_impression.servlets;

import com.management_teachers_impression.management_teachers_impression.models.entities.Subject;
import com.management_teachers_impression.management_teachers_impression.models.entities.User;
import com.management_teachers_impression.management_teachers_impression.services.SubjectCrudService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SubjectServlet", value = "/subjects")
public class SubjectServlet extends HttpServlet {
    private SubjectCrudService subjectCrudService;
    @Override
    public void init() throws ServletException {
        try {
            subjectCrudService = new SubjectCrudService();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            request.setAttribute("subjects", subjectCrudService.findAll());
            request.getRequestDispatcher("/WEB-INF/subjects.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Subject subject = new Subject();
        subject.setLabel(request.getParameter("label"));
        try
        {
            subjectCrudService.create(subject);
            response.sendRedirect(request.getContextPath() + "/subjects");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
