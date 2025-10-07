package com.t7slution.practice001.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return ("Welcome to the new world");
    }

    @RequestMapping("/about")
    public String about() {
        return ("Welcome to the about page");
    }

}
