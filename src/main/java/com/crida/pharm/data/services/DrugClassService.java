package com.crida.pharm.data.services;

import com.crida.pharm.data.entity.DrugClass;

import java.util.List;

public interface DrugClassService {
    void save(DrugClass drugClass);
    DrugClass findById(int id);
    List<DrugClass> findAll();
    void deleteByID(int id);
}
