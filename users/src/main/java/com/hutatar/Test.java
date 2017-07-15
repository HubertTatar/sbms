package com.hutatar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @Value("${lucky-word}")
    public String test;

    @GetMapping("/word")
    public String get(){
        return test;
    }
}
