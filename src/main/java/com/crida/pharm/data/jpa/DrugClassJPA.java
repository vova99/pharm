package com.crida.pharm.data.jpa;

import com.crida.pharm.data.StatusOfEntity;
import com.crida.pharm.data.entity.DrugClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DrugClassJPA extends JpaRepository<DrugClass,Integer> {
    @Query("select obj from DrugClass obj where obj.statusOfEntity=?1")
    List<DrugClass> findByStatus(StatusOfEntity status);
}
