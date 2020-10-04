package com.crida.pharm.data.servicesImpl;

import com.crida.pharm.data.StatusOfEntity;
import com.crida.pharm.data.entity.TargetSpecies;
import com.crida.pharm.data.jpa.TargetSpeciesJPA;
import com.crida.pharm.data.services.TargetSpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TargetSpeciesServiceImpl implements TargetSpeciesService {
    private TargetSpeciesJPA targetSpeciesJPA;

    @Autowired
    public TargetSpeciesServiceImpl(TargetSpeciesJPA targetSpeciesJPA) {
        this.targetSpeciesJPA = targetSpeciesJPA;
    }

    @Override
    public void save(TargetSpecies target) {
        targetSpeciesJPA.save(target);
    }

    @Override
    public TargetSpecies findById(int id) {
        return targetSpeciesJPA.getOne(id);
    }

    @Override
    public List<TargetSpecies> findAll() {
        return targetSpeciesJPA.findAll();
    }

    @Override
    public List<TargetSpecies> findByStatus(StatusOfEntity status) {
        return targetSpeciesJPA.findByStatus(status);
    }

    @Override
    public void deleteByID(int id) {
        TargetSpecies targetSpecies = targetSpeciesJPA.getOne(id);
        if (targetSpecies.getStatusOfEntity()== StatusOfEntity.ARCHIVED){
            targetSpecies.setStatusOfEntity(StatusOfEntity.ACTIVE);
        }else {
            targetSpecies.setStatusOfEntity(StatusOfEntity.ARCHIVED);
        }
        targetSpeciesJPA.save(targetSpecies);
    }
}
