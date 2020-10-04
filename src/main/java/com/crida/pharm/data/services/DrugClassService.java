package com.crida.pharm.data.services;

import com.crida.pharm.data.StatusOfEntity;
import com.crida.pharm.data.entity.DrugClass;

import java.util.List;

public interface DrugClassService {
    void save(DrugClass drugClass);
    DrugClass findById(int id);
    List<DrugClass> findAll();
    List<DrugClass> findByStatus(StatusOfEntity status);
    void deleteByID(int id);
}
