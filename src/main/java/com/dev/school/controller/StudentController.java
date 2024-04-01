package com.dev.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.school.model.Student;
import com.dev.school.service.StudentService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("students", studentService.getAll());
        return "student/list";
    }

    @GetMapping("/add")
    public String displayAddForm(Student student) {
        return "student/add";
    }

    @PostMapping("/add")
    public String processAdd(Model model, Student student) {
        studentService.add(student);
        return "redirect:/student/list";
    }

    @GetMapping("/update/{id}")
    public String displayUpdateForm(@PathVariable("id") String id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "student/update";
    }

    @PostMapping("/update")
    public String processUpdate(Student student, Model model) {
        studentService.update(student);
        return "redirect:/student/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        studentService.delete(id);
        return "redirect:/student/list";
    }

}
