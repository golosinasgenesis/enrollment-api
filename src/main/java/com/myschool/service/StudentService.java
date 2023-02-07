package com.myschool.service;

import com.myschool.model.Student;

import java.util.List;
import java.util.Map;

public interface StudentService extends CrudService<Student, Long>{

    List<Student> getStudentsAgeOrderDesc() throws Exception;

}
