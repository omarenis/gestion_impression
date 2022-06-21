package com.management_teachers_impression.management_teachers_impression.services;

import com.management_teachers_impression.management_teachers_impression.models.entities.PrintAction;
import com.management_teachers_impression.management_teachers_impression.models.repositories.PrintActionRepository;

import java.sql.SQLException;
import java.util.List;

public class PrintActionService {
    private final PrintActionRepository printActionRepository;

    public PrintActionService() throws SQLException, ClassNotFoundException {
        this.printActionRepository = new PrintActionRepository();
    }

    public List<PrintAction> getAll() throws SQLException {
        return printActionRepository.findAll();
    }
}
