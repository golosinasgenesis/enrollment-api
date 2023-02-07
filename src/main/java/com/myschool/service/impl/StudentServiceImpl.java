package com.myschool.service.impl;

import com.myschool.model.Student;
import com.myschool.repository.GenericRepository;
import com.myschool.repository.StudentRepository;
import com.myschool.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.List.of;
import static java.util.stream.Collectors.groupingBy;
import static  java.util.Comparator.comparingInt;
import static  java.util.Comparator.reverseOrder;

@Service
public class StudentServiceImpl extends CrudServiceImpl<Student, Long> implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    protected GenericRepository<Student, Long> getRepository() {
        return studentRepository;
    }

    @Override
    public List<Student> getStudentsAgeOrderDesc() throws Exception{

        List<Student> list = studentRepository.findAll()
                .stream().sorted(Comparator.comparing(Student::getAge).reversed()).collect(Collectors.toList());
        return list;

    }

}
