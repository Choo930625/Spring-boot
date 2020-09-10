package com.equalkey.dev.login1ax3.demo.controller;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping(value = "/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @GetMapping(value = "/hello/page")
    public String helloworld() {
        return "helloworld";
    }
}
