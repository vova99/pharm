package com.crida.pharm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/products")
    public String getProducts(){
        return "products_orig";
    }

    @GetMapping("/contacts")
    public String getContacts(){
        return "contacts";
    }
}
