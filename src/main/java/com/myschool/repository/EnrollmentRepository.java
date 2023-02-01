package com.myschool.repository;

import com.myschool.model.Enrollment;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends GenericRepository<Enrollment, Long>{
}
