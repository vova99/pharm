package com.crida.pharm.data.servicesImpl;

import com.crida.pharm.data.entity.Product;
import com.crida.pharm.data.jpa.ProductJPA;
import com.crida.pharm.data.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductJPA productJPA;

    @Autowired
    public ProductServiceImpl(ProductJPA productJPA) {
        this.productJPA = productJPA;
    }

    @Override
    public void save(Product product) {
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
