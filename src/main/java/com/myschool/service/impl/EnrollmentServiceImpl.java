package com.myschool.service.impl;

import com.myschool.model.Enrollment;
import com.myschool.model.Student;
import com.myschool.repository.EnrollmentRepository;
import com.myschool.repository.GenericRepository;
import com.myschool.service.EnrollmentService;
import com.myschool.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentServiceImpl extends CrudServiceImpl<Enrollment, Long> implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    protected GenericRepository<Enrollment, Long> getRepository() {
        return enrollmentRepository;
    }
}
