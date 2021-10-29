package com.example.springwebmvc.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnnotationController {

    @GetHelloMapping
    @ResponseBody
    public String helloMapping() {
        return "GetHelloMapping";
    }
}
