package com.crida.pharm.data.jpa;

import com.crida.pharm.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJPA extends JpaRepository<Product, Integer> {
}
