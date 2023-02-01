package com.myschool.repository;

import com.myschool.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends GenericRepository<Student, Long>{
}
