package com.crida.pharm.data.services;

import com.crida.pharm.data.StatusOfEntity;
import com.crida.pharm.data.entity.DrugClass;
import com.crida.pharm.data.entity.PharmaceuticalForm;

import java.util.List;

public interface PharmaceuticalFormService {
    void save(PharmaceuticalForm form);
    PharmaceuticalForm findById(int id);
    List<PharmaceuticalForm> findAll();
    List<PharmaceuticalForm> findByStatus(StatusOfEntity status);
    void deleteByID(int id);
}
