package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository istudentRepository;
    @Override
    public Page<Student> findAll(Pageable pageable) {
        return istudentRepository.findAll(pageable);
    }

    @Override
    public void save(Student student) {
        istudentRepository.save(student);
    }
}
