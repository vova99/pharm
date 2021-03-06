package com.crida.pharm.data.services;

import com.crida.pharm.data.StatusOfEntity;
import com.crida.pharm.data.entity.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);
    void saveInfoObject(Product product);
    Product findById(int id);
    Product findByUnicUrl(String url);
    List<Product> findAll();
    List<Product> findByStatus(StatusOfEntity status);
    Product editProduct(Product product);
    void deleteByID(int id);
}
