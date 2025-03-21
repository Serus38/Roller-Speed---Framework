package com.rollerspeed.v1.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rollerspeed.v1.Model.Student;

@Service 
public interface StudentService {

    List<Student> listar();
    void save(Student student);
    void delete(Long id);
    void update(Student student);
    Student get(Long id);
    
}
