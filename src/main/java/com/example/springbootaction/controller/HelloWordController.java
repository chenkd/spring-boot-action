package com.example.springbootaction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloWordController {

    @GetMapping
    public Map<String, String> hello() {
        Map<String, String> map = new HashMap<>();
        map.put("hello", "world");
        return map;
    }
}
