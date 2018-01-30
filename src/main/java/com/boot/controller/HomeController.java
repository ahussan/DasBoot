package com.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by anjalhussan on 1/28/18.
 */
@RestController
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return "Das Boot, Reporting for duty";
    }
}
