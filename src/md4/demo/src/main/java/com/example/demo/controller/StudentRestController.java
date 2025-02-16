package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class StudentRestController {
    @Autowired
    private IStudentService iStudentService;

    @GetMapping(value = "show-list")
    public ResponseEntity<?> showHomePage(@RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                                      Model model) {
        Sort sort = Sort.by(Sort.Direction.DESC, "name");
        Pageable pageable = PageRequest.of(page, 2, sort);
        Page<Student> students = iStudentService.findAll(pageable);
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        iStudentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
