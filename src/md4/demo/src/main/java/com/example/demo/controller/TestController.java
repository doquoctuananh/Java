package com.example.demo.controller;

import com.example.demo.model.Clazz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequestMapping("test-session")
public class TestController {
    @GetMapping
    public String testSessionController(@SessionAttribute(value = "clazzes", required = false)List<Clazz> clazzes) {
        for (Clazz clazz : clazzes) {
            System.out.println(clazz.getName());
        }
        return "null";
    }
}
