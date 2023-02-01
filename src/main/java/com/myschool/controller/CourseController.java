package com.myschool.controller;

import com.myschool.dto.CourseDTO;
import com.myschool.exception.ModelNotFoundException;
import com.myschool.model.Course;
import com.myschool.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "*")
public class CourseController {

    @Autowired
    private CourseService service;

    @Autowired
    @Qualifier("courseMapper")
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> readAll() throws Exception{
        List<CourseDTO> list = service.readAll().stream().map(cat -> mapper.map(cat, CourseDTO.class)).collect(Collectors.toList());
        /*List<CategoryDTO> list = service.readAll().stream().map(cat -> {
           CategoryDTO dto = new CategoryDTO();
           dto.setId(cat.getIdCategory());
           dto.setNameCategory(cat.getName());
           dto.setDescriptionCategory(cat.getDescription());
           dto.setEnabledCategory(cat.isEnabled());
           return dto;
        }).collect(Collectors.toList());*/
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> readById(@PathVariable("id") Long id) throws Exception{
        Course obj = service.readById(id);
        if(obj == null){
            //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        CourseDTO objCourse = mapper.map(service.readById(id), CourseDTO.class);
        return new ResponseEntity<>(objCourse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> create(@Valid @RequestBody CourseDTO dto) throws Exception{
        Course obj = service.save(mapper.map(dto, Course.class));
        return new ResponseEntity<>(mapper.map(obj, CourseDTO.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CourseDTO> update(@Valid @RequestBody CourseDTO dto) throws Exception{
        Course obj = service.readById(dto.getId());
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + dto.getId());
        }
        Course cat = service.update(mapper.map(dto, Course.class));
        return new ResponseEntity<>(mapper.map(cat, CourseDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception{
        Course obj = service.readById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
