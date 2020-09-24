package com.crida.pharm.data.jpa;

import com.crida.pharm.data.entity.PharmaceuticalForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmaceuticalFormJPA extends JpaRepository<PharmaceuticalForm, Integer> {
}
