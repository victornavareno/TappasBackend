package com.victor.excelmongoapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test/")
public class HelloWorld {

    @GetMapping("/hello")
    public String hello() {
        // imprime SERVER IS UP por pantalla y carga en el servidor en la ruta /hello para comprobar que está UP
        System.out.println("SERVER IS UP");
        return "SERVER IS UP";
    }
}
