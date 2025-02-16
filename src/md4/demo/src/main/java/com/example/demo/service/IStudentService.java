package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    Page<Student> findAll(Pageable pageable);
    void save(Student student);
}
