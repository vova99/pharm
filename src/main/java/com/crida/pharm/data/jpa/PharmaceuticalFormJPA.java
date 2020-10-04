package com.crida.pharm.data.jpa;

import com.crida.pharm.data.StatusOfEntity;
import com.crida.pharm.data.entity.DrugClass;
import com.crida.pharm.data.entity.PharmaceuticalForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PharmaceuticalFormJPA extends JpaRepository<PharmaceuticalForm, Integer> {
    @Query("select obj from PharmaceuticalForm obj where obj.statusOfEntity=?1")
    List<PharmaceuticalForm> findByStatus(StatusOfEntity status);
}
