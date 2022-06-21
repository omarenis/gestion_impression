package com.management_teachers_impression.management_teachers_impression.servlets;

import com.management_teachers_impression.management_teachers_impression.models.entities.PrintAction;
import com.management_teachers_impression.management_teachers_impression.models.entities.Subject;
import com.management_teachers_impression.management_teachers_impression.models.entities.User;
import com.management_teachers_impression.management_teachers_impression.models.repositories.PrintActionRepository;
import com.management_teachers_impression.management_teachers_impression.services.SubjectCrudService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "AddPrintActionServlet", value = "/askForPrintDocument")
public class AddPrintActionServlet extends HttpServlet {

    private PrintActionRepository printActionRepository;
    private SubjectCrudService subjectCrudService;
    @Override
    public void init() throws ServletException {
        try {
            printActionRepository = new PrintActionRepository();
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
            List<Subject> subjects = subjectCrudService.findAll();
            request.setAttribute("subjects", subjects);
            if(user != null)
            {
                request.setAttribute("user", user);
            }
            request.getRequestDispatcher("/WEB-INF/AskForPrintActionForm.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        PrintAction printAction = new PrintAction();
        printAction.setSubjectId(Long.parseLong(request.getParameter("subjectId")));
        printAction.setTeacherId(user.getId());
        printAction.setDatAskForPrint(new Date(request.getParameter("dateAskForPrint")));
        printAction.setNumberCopies(Integer.parseInt(request.getParameter("numberCopies")));
    }
}
