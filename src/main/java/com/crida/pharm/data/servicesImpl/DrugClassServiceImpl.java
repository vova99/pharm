package com.crida.pharm.data.servicesImpl;

import com.crida.pharm.data.entity.DrugClass;
import com.crida.pharm.data.jpa.DrugClassJPA;
import com.crida.pharm.data.services.DrugClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugClassServiceImpl implements DrugClassService {

    private DrugClassJPA drugClassJPA;

    @Autowired
    public DrugClassServiceImpl(DrugClassJPA drugClassJPA) {
        this.drugClassJPA = drugClassJPA;
    }

    @Override
    public void save(DrugClass drugClass) {
        drugClassJPA.save(drugClass);
    }

    @Override
    public DrugClass findById(int id) {
        return drugClassJPA.getOne(id);
    }

    @Override
    public List<DrugClass> findAll() {
        return drugClassJPA.findAll();
    }

    @Override
    public void deleteByID(int id) {
        drugClassJPA.deleteById(id);
    }
}
