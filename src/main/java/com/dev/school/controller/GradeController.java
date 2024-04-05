package com.dev.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.school.model.Grade;
import com.dev.school.service.StudentService;
import com.dev.school.service.grade.GradeService;
import com.dev.school.service.subject.SubjectService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("grades", gradeService.getAll());
        return "grade/list";
    }

    @GetMapping("/add")
    public String displayAddForm(Grade grade, Model model) {
        model.addAttribute("subjects", subjectService.getAll());
        model.addAttribute("students", studentService.getAll());
        return "grade/add";
    }

    @PostMapping("/add")
    public String processAdd(@Valid Grade grade, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/grade/add";
        }
        gradeService.add(grade);
        return "redirect:/grade/list";
    }

    @GetMapping("/update/{id}")
    public String displayUpdateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("subjects", subjectService.getAll());
        model.addAttribute("students", studentService.getAll());
        Grade grade = gradeService.findById(id);
        model.addAttribute("grade", grade);
        return "grade/update";
    }

    @PostMapping("/update")
    public String processUpdate(Grade grade) {
        gradeService.update(grade);
        return "redirect:/grade/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        gradeService.delete(id);
        return "redirect:/grade/list";
    }
}
