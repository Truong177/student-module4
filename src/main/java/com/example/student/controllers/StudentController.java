package com.example.student.controllers;

import com.example.student.models.Student;
import com.example.student.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "student")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @GetMapping("")
    public String displayAllStudents(Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("students",students);
        return "student/list";
    }
    @GetMapping("/create")
    public String viewCreate(){
        return "student/create";
    }
    @PostMapping("/create")
    public String newStudent(@RequestParam("name") String name,
                             @RequestParam("address")String address,
                             @RequestParam("score") Float score,
                            RedirectAttributes redirect){
        Student student = new Student(name,address,score);
        studentService.save(student);
        redirect.addAttribute("message","Thêm mới thành công");
        return "redirect:/student";
    }
    @GetMapping("/update/{id}")
    public String viewUpdate(@PathVariable Long id,Model model){
        Student student = studentService.findById(id);
        model.addAttribute("studen",student);
        return "student/update";
    }
    @PostMapping("/update/{id}")
    public String submitUpdate(@PathVariable Long id,RedirectAttributes redirect,
                               @RequestParam("name") String name,
                               @RequestParam("address")String address,
                               @RequestParam("score") Float score){
        Student student = new Student(name, address, score);
        studentService.update(student,id);
        redirect.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/student";
    }

}
