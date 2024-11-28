package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/v1/students")
public class StudentController {

    //para elazar un servicio
    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> getAll(){
        return studentService.getStudents();
    }


    //get by id
    @GetMapping("/{studentId}")
    public Optional<Student> getById(@PathVariable("studentId") Long studentId){
        return studentService.getStudentById(studentId);
    }

    //recibe el id por parametros para eliminar
    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PostMapping()
    public void saveUpdate(@RequestBody Student student){
        studentService.saveOrUpdate(student);
    }
}
