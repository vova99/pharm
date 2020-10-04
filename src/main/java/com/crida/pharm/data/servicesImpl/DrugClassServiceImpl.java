package com.crida.pharm.data.servicesImpl;

import com.crida.pharm.data.StatusOfEntity;
import com.crida.pharm.data.entity.DrugClass;
import com.crida.pharm.data.entity.PharmaceuticalForm;
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
    public List<DrugClass> findByStatus(StatusOfEntity status) {
        return drugClassJPA.findByStatus(status);
    }

    @Override
    public void deleteByID(int id) {
        DrugClass drug = drugClassJPA.getOne(id);
        if (drug.getStatusOfEntity()== StatusOfEntity.ARCHIVED){
            drug.setStatusOfEntity(StatusOfEntity.ACTIVE);
        }else {
            drug.setStatusOfEntity(StatusOfEntity.ARCHIVED);
        }
        drugClassJPA.save(drug);
    }
}
