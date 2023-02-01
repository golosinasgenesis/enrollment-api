package com.myschool.service.impl;

import com.myschool.model.Course;
import com.myschool.repository.CourseRepository;
import com.myschool.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course save(Course course) throws Exception {
        return courseRepository.save(course);
    }

    @Override
    public Course update(Course course) throws Exception {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> readAll() throws Exception {
        return courseRepository.findAll();
    }

    @Override
    public Course readById(Long id) throws Exception {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) throws Exception {
        courseRepository.deleteById(id);
    }
}
