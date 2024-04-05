package com.dev.school.service.grade;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.school.model.Grade;
import com.dev.school.repository.GradeRepository;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    GradeRepository gradeRepository;

    @Override
    public List<Grade> getAll() {
        return gradeRepository.findAll();
    }

    @Override
    public void add(Grade grade) {
        gradeRepository.save(grade);
    }

    @Override
    public void update(Grade gradeParameter) {
        if (findById(gradeParameter.getId()) != null) {
            gradeRepository.save(gradeParameter);
        }
    }

    @Override
    public void delete(Long id) {
        gradeRepository.deleteById(id);
    }

    @Override
    public Grade findById(Long id) {
          Optional<Grade> optionalGrade = gradeRepository.findById(id);
        if (optionalGrade.isPresent()) {
            return optionalGrade.get();
        }
        return null;
    }

}
