package com.crida.pharm.data.jpa;

import com.crida.pharm.data.StatusOfEntity;
import com.crida.pharm.data.entity.DrugClass;
import com.crida.pharm.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductJPA extends JpaRepository<Product, Integer> {
    @Query("select product from Product product where product.url like ?1")
    Product findByUnicUrl(String url);

    @Query("select obj from Product obj where obj.statusOfEntity=?1")
    List<Product> findByStatus(StatusOfEntity status);
}
