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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private ProductService productService;
    private DrugClassService drugClassService;
    private PharmaceuticalFormService formService;
    private TargetSpeciesService targetSpeciesService;

    @Autowired
    public AdminController(ProductService productService, DrugClassService drugClassService,
                           PharmaceuticalFormService formService, TargetSpeciesService targetSpeciesService) {
        this.productService = productService;
        this.drugClassService = drugClassService;
        this.formService = formService;
        this.targetSpeciesService = targetSpeciesService;
    }

    //PRODUCT PRODUCT PRODUCT

    @GetMapping("/getAllProductList")
    public String getAllProductList(Model model){
        model.addAttribute("objectList",productService.findAll());
        model.addAttribute("fragmentPathTabConfig","adminDashboard");
        model.addAttribute("fragmentPathProducts","fragProducts");
        model.addAttribute("tabName","products");

        model.addAttribute("infoBtnOn","true");

        model.addAttribute("urlAdd","/admin/addProduct");
        model.addAttribute("urlInfo","/admin/getInfoProduct");
        model.addAttribute("urlEdit","/admin/editProduct");
        model.addAttribute("urlDelete","/admin/deleteProduct");
        return "adminPage";
    }

    @PostMapping("/addProduct")
    public String addProduct(String nameOfObject){
        Product product = new Product();
        product.setName(nameOfObject);
        productService.save(product);
        return "redirect:/admin/getAllProductList";
    }

    @PostMapping("/editProduct")
    public String editProduct(String id, String nameOfObject){
        Product product = new Product();
        product.setId(Integer.parseInt(id));
        product.setName(nameOfObject);
        productService.save(product);
        return "redirect:/admin/getAllProductList";
    }

    @PostMapping("/deleteProduct")
    public String deleteProduct(String id){
        productService.deleteByID(Integer.parseInt(id));
        return "redirect:/admin/getAllProductList";
    }

    //PRODUCT INFO PRODUCT INFO  PRODUCT INFO
    @GetMapping("/getInfoProduct-{id}")
    public String getInfoProduct(@PathVariable("id") int id,Model model){
        model.addAttribute("product",productService.findById(id));
        model.addAttribute("drugList",drugClassService.findAll());
        model.addAttribute("pharmList",formService.findAll());
        model.addAttribute("targetList",targetSpeciesService.findAll());
        model.addAttribute("fragmentPathTabConfig","adminDashboard");
        model.addAttribute("fragmentPathProducts","fragInfoProducts");
        model.addAttribute("tabName","products");

        return "adminPage";
    }
    @PostMapping("/editInfoProduct")
    public String addDrugClass(Product product) {
        System.out.println(product);
        productService.save(product);
//        product.getTargetList().
        return "redirect:/admin/getAllProductList";
    }


    //DRUG DRUG DRUG

    @GetMapping("/getAllDrugClassList")
    public String getAllDrugClassList(Model model){
        model.addAttribute("objectList",drugClassService.findAll());
        model.addAttribute("fragmentPathTabConfig","adminDashboard");
        model.addAttribute("fragmentPathProducts","fragProducts");
        model.addAttribute("tabName","drugClass");

        model.addAttribute("urlAdd","/admin/addDrugClass");
        model.addAttribute("urlEdit","/admin/editDrugClass");
        model.addAttribute("urlDelete","/admin/deleteDrugClass");
        return "adminPage";
    }

    @PostMapping("/addDrugClass")
    public String addDrugClass(String nameOfObject){
        DrugClass drugClass = new DrugClass();
        drugClass.setName(nameOfObject);
        drugClassService.save(drugClass);
        return "redirect:/admin/getAllDrugClassList";
    }

    @PostMapping("/editDrugClass")
    public String editDrugClass(String id, String nameOfObject){
        DrugClass drugClass = new DrugClass();
        drugClass.setId(Integer.parseInt(id));
        drugClass.setName(nameOfObject);
        drugClassService.save(drugClass);
        return "redirect:/admin/getAllDrugClassList";
    }

    @PostMapping("/deleteDrugClass")
    public String deleteDrugClass(String id){
        drugClassService.deleteByID(Integer.parseInt(id));
        return "redirect:/admin/getAllDrugClassList";
    }

    //TARGET TARGET TARGET

    @GetMapping("/getAllTargetSpeciesList")
    public String getAllTargetSpeciesList(Model model){
        model.addAttribute("objectList",targetSpeciesService.findAll());
        model.addAttribute("fragmentPathTabConfig","adminDashboard");
        model.addAttribute("fragmentPathProducts","fragProducts");
        model.addAttribute("tabName","targetSpecies");

        model.addAttribute("urlAdd","/admin/addTargetSpecies");
        model.addAttribute("urlEdit","/admin/editTargetSpecies");
        model.addAttribute("urlDelete","/admin/deleteTargetSpecies");
        return "adminPage";
    }

    @PostMapping("/addTargetSpecies")
    public String addTargetSpecies(String nameOfObject){
        TargetSpecies targetSpecies = new TargetSpecies();
        targetSpecies.setName(nameOfObject);
        targetSpeciesService.save(targetSpecies);
        return "redirect:/admin/getAllTargetSpeciesList";
    }

    @PostMapping("/editTargetSpecies")
    public String editTargetSpecies(String id, String nameOfObject){
        TargetSpecies targetSpecies = new TargetSpecies();
        targetSpecies.setId(Integer.parseInt(id));
        targetSpecies.setName(nameOfObject);
        targetSpeciesService.save(targetSpecies);
        return "redirect:/admin/getAllTargetSpeciesList";
    }

    @PostMapping("/deleteTargetSpecies")
    public String deleteTargetSpecies(String id){
        targetSpeciesService.deleteByID(Integer.parseInt(id));
        return "redirect:/admin/getAllTargetSpeciesList";
    }


    //FORM FORM FORM

    @GetMapping("/getAllPharmaceuticalFormList")
    public String getAllPharmaceuticalFormList(Model model){
        model.addAttribute("objectList",formService.findAll());
        model.addAttribute("fragmentPathTabConfig","adminDashboard");
        model.addAttribute("fragmentPathProducts","fragProducts");
        model.addAttribute("tabName","pharm");

        model.addAttribute("urlAdd","/admin/addPharmaceuticalForm");
        model.addAttribute("urlEdit","/admin/editPharmaceuticalForm");
        model.addAttribute("urlDelete","/admin/deletePharmaceuticalForm");
        return "adminPage";
    }

    @PostMapping("/addPharmaceuticalForm")
    public String addPharmaceuticalForm(String nameOfObject){
        PharmaceuticalForm form = new PharmaceuticalForm();
        form.setName(nameOfObject);
        formService.save(form);
        return "redirect:/admin/getAllPharmaceuticalFormList";
    }

    @PostMapping("/editPharmaceuticalForm")
    public String editPharmaceuticalForm(String id, String nameOfObject){
        PharmaceuticalForm form = new PharmaceuticalForm();
        form.setId(Integer.parseInt(id));
        form.setName(nameOfObject);
        formService.save(form);
        return "redirect:/admin/getAllPharmaceuticalFormList";
    }

    @PostMapping("/deletePharmaceuticalForm-{productId}")
    public String deletePharmaceuticalForm(String id){
        formService.deleteByID(Integer.parseInt(id));
        return "redirect:/admin/getAllPharmaceuticalFormList";
    }

}
