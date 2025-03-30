package com.rollerspeed.v1.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rollerspeed.v1.Model.Teacher;
import com.rollerspeed.v1.Repository.TeacherRepository;

@Service
public class TeacherServiceImp implements TeacherService {

    TeacherRepository teacherRepository;

    public TeacherServiceImp(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void delete(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> listar() {
        return (List<Teacher>) teacherRepository.findAll();
    }

    @Override
    public void update(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public Teacher get(Long id) {
        return teacherRepository.findById(id).get();
    }
    
}
