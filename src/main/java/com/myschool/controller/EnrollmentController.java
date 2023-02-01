package com.myschool.controller;

import com.myschool.dto.EnrollmentDTO;
import com.myschool.exception.ModelNotFoundException;
import com.myschool.model.Enrollment;
import com.myschool.service.EnrollmentService;
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
@RequestMapping("/enrollments")
@CrossOrigin(origins = "*")
public class EnrollmentController {

    @Autowired
    private EnrollmentService service;

    @Autowired
    @Qualifier("enrollmentMapper")
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<EnrollmentDTO>> readAll() throws Exception{
        List<EnrollmentDTO> list = service.readAll().stream().map(cat -> mapper.map(cat, EnrollmentDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> readById(@PathVariable("id") Long id) throws Exception{
        Enrollment obj = service.readById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        EnrollmentDTO objEnrollment = mapper.map(service.readById(id), EnrollmentDTO.class);
        return new ResponseEntity<>(objEnrollment, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EnrollmentDTO> create(@Valid @RequestBody EnrollmentDTO dto) throws Exception{
        Enrollment obj = service.save(mapper.map(dto, Enrollment.class));
        return new ResponseEntity<>(mapper.map(obj, EnrollmentDTO.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<EnrollmentDTO> update(@Valid @RequestBody EnrollmentDTO dto) throws Exception{
        Enrollment obj = service.readById(dto.getIdEnrollment());
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + dto.getIdEnrollment());
        }
        Enrollment cat = service.update(mapper.map(dto, Enrollment.class));
        return new ResponseEntity<>(mapper.map(cat, EnrollmentDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception{
        Enrollment obj = service.readById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
