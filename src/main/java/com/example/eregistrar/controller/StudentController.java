package com.example.eregistrar.controller;

import com.example.eregistrar.entity.Student;
import com.example.eregistrar.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/eregistar")
public class StudentController {
    @Autowired
    IStudentService studentService;

    @GetMapping(value = {"/", "/home"})
    public String displayHomePage() {
        return "eregistar/index";
    }

    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<Student> studentList = studentService.getAllStudents();
        if (!studentList.isEmpty()) {
            model.addAttribute("students", studentList);
        } else {
            return "No students found";
        }
        return "eregistar/liststudent";
    }

    @GetMapping("/{id}")
    public String findStudent(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return "redirect:/eregistar/register";
    }

    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable("id") Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("students", student);
        return "eregistar/edit";
    }

    @PostMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") Long id, @ModelAttribute("students") Student student) {
        studentService.update(id, student);
        return "redirect:/eregistar/findAll";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("students", new Student());
        return "eregistar/register";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("students") Student student) {
        studentService.save(student);
        return "redirect:/eregistar/findAll";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/eregistar/findAll";
    }

    @GetMapping("/search")
    public String search(@ModelAttribute("query") String query, Model model) {
        List<Student> studentList = studentService.searchStudent(query);
        model.addAttribute("students", studentList);
        return "eregistar/liststudent";
    }
}
