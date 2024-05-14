package com.dev.school.service.subject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.school.model.Subject;
import com.dev.school.repository.SubjectReposirory;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectReposirory subjectReposirory;

    @Override
    public List<Subject> getAll() {
        return subjectReposirory.findAll();
    }

    @Override
    public void add(Subject subject) {
        subjectReposirory.save(subject);
    }

    @Override
    public void update(Subject subjectParameter) {
        if (findById(subjectParameter.getId()) != null) {
            subjectReposirory.save(subjectParameter);
        }
    }

    @Override
    public void delete(Long id) {
        subjectReposirory.deleteById(id);
    }

    @Override
    public Subject findById(Long id) {
        Optional<Subject> optionalSubject = subjectReposirory.findById(id);
        if (optionalSubject.isPresent()) {
            return optionalSubject.get();
        }
        return null;
    }

}
