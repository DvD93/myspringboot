package com.frre.labii.springbootproyect.com.frre.labii.springbootproyect.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping("/hello")
    public String index(){
        return "Hello Dave!";
    }
}