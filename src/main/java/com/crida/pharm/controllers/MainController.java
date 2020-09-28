package com.crida.pharm.controllers;

import com.crida.pharm.data.services.DrugClassService;
import com.crida.pharm.data.services.PharmaceuticalFormService;
import com.crida.pharm.data.services.ProductService;
import com.crida.pharm.data.services.TargetSpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private ProductService productService;
    private DrugClassService drugClassService;
    private PharmaceuticalFormService formService;
    private TargetSpeciesService targetSpeciesService;

    @Autowired
    public MainController(ProductService productService, DrugClassService drugClassService,
                          PharmaceuticalFormService formService, TargetSpeciesService targetSpeciesService) {
        this.productService = productService;
        this.drugClassService = drugClassService;
        this.formService = formService;
        this.targetSpeciesService = targetSpeciesService;
    }

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/products")
    public String getProducts(Model model){
        model.addAttribute("formList",formService.findAll());
        model.addAttribute("drugList",drugClassService.findAll());
        model.addAttribute("targetList",targetSpeciesService.findAll());
        return "products_orig";
    }

    @GetMapping("/contacts")
    public String getContacts(){
        return "contacts";
    }
}
