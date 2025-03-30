package com.rollerspeed.v1.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rollerspeed.v1.Model.Teacher;

@Service
public interface TeacherService {

    List<Teacher> listar();
    void save(Teacher teacher);
    void delete(Long id);
    void update(Teacher teacher);
    Teacher get(Long id);
    
    
}
