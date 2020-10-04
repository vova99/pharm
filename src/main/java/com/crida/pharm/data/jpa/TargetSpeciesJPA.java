package com.crida.pharm.data.jpa;

import com.crida.pharm.data.StatusOfEntity;
import com.crida.pharm.data.entity.PharmaceuticalForm;
import com.crida.pharm.data.entity.TargetSpecies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TargetSpeciesJPA extends JpaRepository<TargetSpecies, Integer> {
    @Query("select obj from TargetSpecies obj where obj.statusOfEntity=?1")
    List<TargetSpecies> findByStatus(StatusOfEntity status);
}
