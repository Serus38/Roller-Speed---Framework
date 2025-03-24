package com.rollerspeed.v1.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rollerspeed.v1.Model.Student;
import com.rollerspeed.v1.Repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService {

    StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> listar() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public void update(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student get(Long id) {
        return studentRepository.findById(id).get();
    }

    
}