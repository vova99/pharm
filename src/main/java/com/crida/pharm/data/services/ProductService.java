package com.crida.pharm.data.services;

import com.crida.pharm.data.entity.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);
    void saveInfoObject(Product product);
    Product findById(int id);
    List<Product> findAll();
    Product editProduct(Product product);
    void deleteByID(int id);
}
