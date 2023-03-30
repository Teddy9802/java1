package com.teddy.sbb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SbbController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("date", "Spring!!" );
        return "hello";
    }
}
