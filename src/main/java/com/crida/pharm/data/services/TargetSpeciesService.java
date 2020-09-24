package com.crida.pharm.data.services;

import com.crida.pharm.data.entity.Product;
import com.crida.pharm.data.entity.TargetSpecies;

import java.util.List;

public interface TargetSpeciesService {
    void save(TargetSpecies target);
    TargetSpecies findById(int id);
    List<TargetSpecies> findAll();
    void deleteByID(int id);
}
