package com.example.tml_mustache.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController extends BaseController {
    @GetMapping("/")
    public String mainPage(Map<String, Object> model) {
        setBaseModel(model);
        return "main";
    }
}
