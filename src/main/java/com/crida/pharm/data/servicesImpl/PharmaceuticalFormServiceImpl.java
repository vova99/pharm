package com.crida.pharm.data.servicesImpl;

import com.crida.pharm.data.StatusOfEntity;
import com.crida.pharm.data.entity.PharmaceuticalForm;
import com.crida.pharm.data.entity.Product;
import com.crida.pharm.data.jpa.PharmaceuticalFormJPA;
import com.crida.pharm.data.services.PharmaceuticalFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmaceuticalFormServiceImpl implements PharmaceuticalFormService {
    private PharmaceuticalFormJPA formJPA;

    @Autowired
    public PharmaceuticalFormServiceImpl(PharmaceuticalFormJPA formJPA) {
        this.formJPA = formJPA;
    }

    @Override
    public void save(PharmaceuticalForm form) {
        formJPA.save(form);
    }

    @Override
    public PharmaceuticalForm findById(int id) {
        return formJPA.getOne(id);
    }

    @Override
    public List<PharmaceuticalForm> findAll() {
        return formJPA.findAll();
    }

    @Override
    public List<PharmaceuticalForm> findByStatus(StatusOfEntity status) {
        return formJPA.findByStatus(status);
    }

    @Override
    public void deleteByID(int id) {
        PharmaceuticalForm form = formJPA.getOne(id);
        if (form.getStatusOfEntity()== StatusOfEntity.ARCHIVED){
            form.setStatusOfEntity(StatusOfEntity.ACTIVE);
        }else {
            form.setStatusOfEntity(StatusOfEntity.ARCHIVED);
        }
        formJPA.save(form);
    }
}
