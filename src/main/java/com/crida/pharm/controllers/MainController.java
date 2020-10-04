package com.crida.pharm.controllers;

import com.crida.pharm.data.StatusOfEntity;
import com.crida.pharm.data.services.DrugClassService;
import com.crida.pharm.data.services.PharmaceuticalFormService;
import com.crida.pharm.data.services.ProductService;
import com.crida.pharm.data.services.TargetSpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    private ProductService productService;
    private DrugClassService drugClassService;
    private PharmaceuticalFormService formService;
    private TargetSpeciesService targetSpeciesService;
    private JavaMailSender javaMailSender;

    @Autowired
    public MainController(ProductService productService, DrugClassService drugClassService,
                          PharmaceuticalFormService formService, TargetSpeciesService targetSpeciesService,
                          JavaMailSender javaMailSender) {
        this.productService = productService;
        this.drugClassService = drugClassService;
        this.formService = formService;
        this.targetSpeciesService = targetSpeciesService;
        this.javaMailSender = javaMailSender;
    }

    @GetMapping("/")
    public String getIndex(Model model){
        model.addAttribute("productList",productService.findByStatus(StatusOfEntity.ACTIVE));
        return "index";
    }

    @GetMapping("/test")
    public String test(Model model){
        model.addAttribute("productList",productService.findByStatus(StatusOfEntity.ACTIVE));
        return "index-copy";
    }

    @GetMapping("/products")
    public String getProducts(Model model){
        model.addAttribute("formList",formService.findByStatus(StatusOfEntity.ACTIVE));
        model.addAttribute("drugList",drugClassService.findByStatus(StatusOfEntity.ACTIVE));
        model.addAttribute("targetList",targetSpeciesService.findByStatus(StatusOfEntity.ACTIVE));
        model.addAttribute("productList",productService.findByStatus(StatusOfEntity.ACTIVE));
        return "products_orig";
    }

    @GetMapping("/products-{urlId}")
    public String getProduct(@PathVariable("urlId")String url, Model model){
        model.addAttribute("product",productService.findByUnicUrl(url));
        model.addAttribute("productList",productService.findByStatus(StatusOfEntity.ACTIVE));
        return "product";
    }

    @GetMapping("/contacts")
    public String getContacts(Model model){
        model.addAttribute("productList",productService.findByStatus(StatusOfEntity.ACTIVE));
        return "contacts";
    }

    @ResponseBody
    @PostMapping("/sendCallback")
    public void sendCallback(String contactPerson, String contactPhone){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("chinchillareal@gmail.com");

        msg.setSubject("Crida website: Заявка на зворотній зв'язок");
        msg.setText("Ім'я: "+contactPerson+"\nТелефон: "+contactPhone);

        javaMailSender.send(msg);
    }
}
