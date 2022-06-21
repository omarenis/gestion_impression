package com.management_teachers_impression.management_teachers_impression.services;

import com.management_teachers_impression.management_teachers_impression.models.entities.Subject;
import com.management_teachers_impression.management_teachers_impression.models.repositories.SubjectRepository;

import java.sql.SQLException;
import java.util.List;

public class SubjectCrudService {
    private final SubjectRepository subjectRepository;

    public SubjectCrudService() throws SQLException, ClassNotFoundException {
        subjectRepository = new SubjectRepository();
    }

    public List<Subject> findAll() throws SQLException {
        return subjectRepository.findAll();
    }

    public Subject create(Subject subject) throws SQLException {
        return subjectRepository.create(subject);
    }

    public void delete(Long id) throws Exception {
        subjectRepository.delete(id);
    }
}
