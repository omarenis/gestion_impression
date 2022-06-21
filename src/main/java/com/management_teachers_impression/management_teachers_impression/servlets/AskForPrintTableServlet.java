package com.management_teachers_impression.management_teachers_impression.servlets;

import com.management_teachers_impression.management_teachers_impression.services.PrintActionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AskForPrintTableServlet", value = "/askForPrintList")
public class AskForPrintTableServlet extends HttpServlet {
    private PrintActionService printActionService;

    @Override
    public void init() throws ServletException {
        try {
            printActionService = new PrintActionService();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("printActions", printActionService.getAll());
            request.getRequestDispatcher("/WEB-INF/AskForPrintTable.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
