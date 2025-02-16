package com.example.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.PastOrPresent;
import org.springframework.format.annotation.DateTimeFormat;

/*
Validation:
C1: Sử dụng các annotation có sẵn của Spring cung cấp
String:
- @NotBlank -> bắt buộc nhập <=> không chấp nhận trường dữ liệu ""
- @Size(min, max) -> độ dài của chuỗi
- @Pattern(rex) ->

Số:
- min
- max

Date
- @DateTimeFormat
- @FutureOrPresent
- @PastOrPresent

C2: custom validation thông qua việc implements interface validator
C3: custom annotation
*/
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Boolean gender;
    @ManyToOne
    private Clazz clazz;
    public Student() {
    }

    public Student(Integer id, String name, Boolean gender, Clazz clazz) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.clazz = clazz;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
}
