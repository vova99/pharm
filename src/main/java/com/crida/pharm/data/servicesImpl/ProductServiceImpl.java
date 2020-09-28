package com.crida.pharm.data.servicesImpl;

import com.crida.pharm.data.entity.DrugClass;
import com.crida.pharm.data.entity.PharmaceuticalForm;
import com.crida.pharm.data.entity.Product;
import com.crida.pharm.data.entity.TargetSpecies;
import com.crida.pharm.data.jpa.ProductJPA;
import com.crida.pharm.data.services.DrugClassService;
import com.crida.pharm.data.services.PharmaceuticalFormService;
import com.crida.pharm.data.services.ProductService;
import com.crida.pharm.data.services.TargetSpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductJPA productJPA;
    private DrugClassService drugClassService;
    private PharmaceuticalFormService formService;
    private TargetSpeciesService targetSpeciesService;

    @Autowired
    public ProductServiceImpl(ProductJPA productJPA, DrugClassService drugClassService,
                              PharmaceuticalFormService formService, TargetSpeciesService targetSpeciesService) {
        this.productJPA = productJPA;
        this.drugClassService = drugClassService;
        this.formService = formService;
        this.targetSpeciesService = targetSpeciesService;
    }

    @Override
    public void save(Product product) {
        productJPA.save(product);
    }

    @Override
    public void saveInfoObject(Product product) {
        Product productDB = productJPA.getOne(product.getId());
        if(productDB.getDrugClass()!=null){
            DrugClass drugClass = drugClassService.findById(productDB.getDrugClass().getId());
            drugClass.getProducts().remove(productDB);
            drugClassService.save(drugClass);
        }
        if(product.getDrugClass()!=null){
            DrugClass drugClass = drugClassService.findById(product.getDrugClass().getId());
            drugClass.getProducts().add(product);
            drugClassService.save(drugClass);
        }

        if(productDB.getPharmaceuticalForm()!=null){
            PharmaceuticalForm pharmaceuticalForm = formService.findById(productDB.getPharmaceuticalForm().getId());
            pharmaceuticalForm.getProducts().remove(productDB);
            formService.save(pharmaceuticalForm);
        }
        if(product.getPharmaceuticalForm()!=null){
            PharmaceuticalForm pharmaceuticalForm = formService.findById(product.getPharmaceuticalForm().getId());
            pharmaceuticalForm.getProducts().add(product);
            formService.save(pharmaceuticalForm);
        }

        for(TargetSpecies targetDB: productDB.getTargetList()){
            TargetSpecies target = targetSpeciesService.findById(targetDB.getId());
            target.getProducts().remove(productDB);
            targetSpeciesService.save(target);
        }

        for(TargetSpecies targetDB: product.getTargetList()){
            TargetSpecies target = targetSpeciesService.findById(targetDB.getId());
            target.getProducts().add(product);
            targetSpeciesService.save(target);
        }


        productJPA.save(product);
    }


    @Override
    public Product findById(int id) {
        return productJPA.getOne(id);
    }

    @Override
    public List<Product> findAll() {
        return productJPA.findAll();
    }


    //not using
    @Override
    public Product editProduct(Product product) {
        if(product.getId()==0){
            return null;
        }
        Product productDB = productJPA.getOne(product.getId());


        return productDB;
    }

    @Override
    public void deleteByID(int id) {
        productJPA.deleteById(id);
    }
}
