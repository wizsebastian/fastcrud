package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService  {
    //se define el repository
    @Autowired
    StudentRepository studentRepository;


    //return the list of students
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    //return one student by id
    public Optional<Student> getStudentById(Long id){
        return studentRepository.findById(id);
    }

    //save and update
    public void saveOrUpdate(Student student){
        studentRepository.save(student);
    }
    //delete by id
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
