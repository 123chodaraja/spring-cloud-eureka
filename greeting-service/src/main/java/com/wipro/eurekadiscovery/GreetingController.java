package com.wipro.eurekadiscovery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting-service")
public class GreetingController {
    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "hello "+name+"! happy learning";
    }
}
