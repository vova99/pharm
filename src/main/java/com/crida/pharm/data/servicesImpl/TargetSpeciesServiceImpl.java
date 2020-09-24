package com.crida.pharm.data.servicesImpl;

import com.crida.pharm.data.entity.TargetSpecies;
import com.crida.pharm.data.jpa.TargetSpeciesJPA;
import com.crida.pharm.data.services.TargetSpeciesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    public void deleteByID(int id) {
        targetSpeciesJPA.deleteById(id);
    }
}
