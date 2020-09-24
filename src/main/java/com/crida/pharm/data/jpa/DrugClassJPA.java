package com.crida.pharm.data.jpa;

import com.crida.pharm.data.entity.DrugClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugClassJPA extends JpaRepository<DrugClass,Integer> {
}
