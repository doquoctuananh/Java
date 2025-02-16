package com.example.demo.repository;

import com.example.demo.model.Student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*
* Page: Ket qua tra ve sẽ đầy đủ thông tin bao gồm cả tổng số trang -> count() -> phù hợp hơn với các DB vừa và nhỏ
* Slice: Kết quả trả về không có tổng số trang -> phù hợp hơn với các cơ sở dữ liệu lớn
* */
@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {
    Page<Student> findAll(Pageable pageable);
}
