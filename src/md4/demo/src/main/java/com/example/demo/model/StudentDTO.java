package com.example.demo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/*
* class DTO: data transfer object
* */
public class StudentDTO implements Validator {
    private Integer id;
    private String name;
    @NotNull
    private Boolean gender;
    private Clazz clazz;

    public StudentDTO() {
    }

    public StudentDTO(Integer id, String name, Boolean gender, Clazz clazz) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentDTO studentDTO = (StudentDTO) target;
        String name = studentDTO.getName();
        if(name.trim().isEmpty()){
            errors.rejectValue("name", "name.null");
        }else if(name.length() < 5 || name.length() > 50){
            errors.rejectValue("name","", "Tên phải từ 5 đến 50 ký tự");
        }
    }
}
