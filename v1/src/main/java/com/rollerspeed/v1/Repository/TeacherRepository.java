package com.rollerspeed.v1.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rollerspeed.v1.Model.Teacher;

@Repository

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
    
}
