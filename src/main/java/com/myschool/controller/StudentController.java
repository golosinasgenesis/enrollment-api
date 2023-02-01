package com.myschool.controller;

import com.myschool.dto.StudentDTO;
import com.myschool.exception.ModelNotFoundException;
import com.myschool.model.Student;
import com.myschool.service.StudentService;
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
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService service;

    @Autowired
    @Qualifier("studentMapper")
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> readAll() throws Exception{
        List<StudentDTO> list = service.readAll().stream().map(cat -> mapper.map(cat, StudentDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> readById(@PathVariable("id") Long id) throws Exception{
        Student obj = service.readById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        StudentDTO objStudent = mapper.map(service.readById(id), StudentDTO.class);
        return new ResponseEntity<>(objStudent, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> create(@Valid @RequestBody StudentDTO dto) throws Exception{
        Student obj = service.save(mapper.map(dto, Student.class));
        return new ResponseEntity<>(mapper.map(obj, StudentDTO.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<StudentDTO> update(@Valid @RequestBody StudentDTO dto) throws Exception{
        Student obj = service.readById(dto.getId());
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + dto.getId());
        }
        Student cat = service.update(mapper.map(dto, Student.class));
        return new ResponseEntity<>(mapper.map(cat, StudentDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception{
        Student obj = service.readById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
