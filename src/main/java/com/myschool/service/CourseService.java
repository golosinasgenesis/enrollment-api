package com.myschool.service;

import com.myschool.model.Course;

import java.util.List;

public interface CourseService {

    Course save(Course course) throws Exception;
    Course update(Course course) throws Exception;
    List<Course> readAll() throws Exception;
    Course readById(Long id) throws Exception;
    void delete(Long id) throws Exception;
}
