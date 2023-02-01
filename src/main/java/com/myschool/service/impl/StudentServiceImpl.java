package com.myschool.service.impl;

import com.myschool.model.Student;
import com.myschool.repository.GenericRepository;
import com.myschool.repository.StudentRepository;
import com.myschool.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl extends CrudServiceImpl<Student, Long> implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    protected GenericRepository<Student, Long> getRepository() {
        return studentRepository;
    }
}
