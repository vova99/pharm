package com.crida.pharm.controllers;

import com.crida.pharm.data.entity.DrugClass;
import com.crida.pharm.data.entity.PharmaceuticalForm;
import com.crida.pharm.data.entity.Product;
import com.crida.pharm.data.entity.TargetSpecies;
import com.crida.pharm.data.services.DrugClassService;
import com.crida.pharm.data.services.PharmaceuticalFormService;
import com.crida.pharm.data.services.ProductService;
import com.crida.pharm.data.services.TargetSpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/")
public class AdminComtroller {
    private ProductService productService;
    private DrugClassService drugClassService;
    private PharmaceuticalFormService formService;
    private TargetSpeciesService targetSpeciesService;

    @Autowired
    public AdminComtroller(ProductService productService, DrugClassService drugClassService,
                           PharmaceuticalFormService formService, TargetSpeciesService targetSpeciesService) {
        this.productService = productService;
        this.drugClassService = drugClassService;
        this.formService = formService;
        this.targetSpeciesService = targetSpeciesService;
    }

    //PRODUCT PRODUCT PRODUCT

    @GetMapping("/getAllProductList")
    public String getAllProductList(Model model){
        model.addAttribute("productList",productService.findAll());
        return "";
    }

    @PostMapping("/addProduct")
    public String addProduct(Product product){
        productService.save(product);
        return "redirect:/admin/getAllProductList";
    }

    @PostMapping("/editProduct")
    public String editProduct(Product product){
        productService.save(product);
        return "redirect:/admin/getAllProductList";
    }

    @PostMapping("/deleteProduct-{productId}")
    public String deleteProduct(@PathVariable("productId") int id){
        productService.deleteByID(id);
        return "redirect:/admin/getAllProductList";
    }


    //DRUG DRUG DRUG

    @GetMapping("/getAllDrugClassList")
    public String getAllDrugClassList(Model model){
        model.addAttribute("drugList",drugClassService.findAll());
        return "";
    }

    @PostMapping("/addDrugClass")
    public String addDrugClass(DrugClass drugClass){
        drugClassService.save(drugClass);
        return "redirect:/admin/getAllDrugClassList";
    }

    @PostMapping("/editDrugClass")
    public String editDrugClass(DrugClass drugClass){
        drugClassService.save(drugClass);
        return "redirect:/admin/getAllDrugClassList";
    }

    @PostMapping("/deleteDrugClass-{productId}")
    public String deleteDrugClass(@PathVariable("productId") int id){
        drugClassService.deleteByID(id);
        return "redirect:/admin/getAllDrugClassList";
    }


    //TARGET TARGET TARGET

    @GetMapping("/getAllTargetSpeciesList")
    public String getAllTargetSpeciesList(Model model){
        model.addAttribute("targetList",targetSpeciesService.findAll());
        return "";
    }

    @PostMapping("/addTargetSpecies")
    public String addTargetSpecies(TargetSpecies targetSpecies){
        targetSpeciesService.save(targetSpecies);
        return "redirect:/admin/getAllTargetSpeciesList";
    }

    @PostMapping("/editTargetSpecies")
    public String editTargetSpecies(TargetSpecies targetSpecies){
        targetSpeciesService.save(targetSpecies);
        return "redirect:/admin/getAllTargetSpeciesList";
    }

    @PostMapping("/deleteTargetSpecies-{productId}")
    public String deleteTargetSpecies(@PathVariable("productId") int id){
        targetSpeciesService.deleteByID(id);
        return "redirect:/admin/getAllTargetSpeciesList";
    }


    //FORM FORM FORM

    @GetMapping("/getAllPharmaceuticalFormList")
    public String getAllPharmaceuticalFormList(Model model){
        model.addAttribute("formList",formService.findAll());
        return "";
    }

    @PostMapping("/addPharmaceuticalForm")
    public String addPharmaceuticalForm(PharmaceuticalForm form){
        formService.save(form);
        return "redirect:/admin/getAllPharmaceuticalFormList";
    }

    @PostMapping("/editPharmaceuticalForm")
    public String editPharmaceuticalForm(PharmaceuticalForm form){
        formService.save(form);
        return "redirect:/admin/getAllPharmaceuticalFormList";
    }

    @PostMapping("/deletePharmaceuticalForm-{productId}")
    public String deletePharmaceuticalForm(@PathVariable("productId") int id){
        formService.deleteByID(id);
        return "redirect:/admin/getAllPharmaceuticalFormList";
    }

}
