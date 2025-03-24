package com.rollerspeed.v1.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rollerspeed.v1.Model.Student;

@Repository

public interface StudentRepository extends CrudRepository<Student , Long> {
    
}

