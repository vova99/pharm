package com.crida.pharm.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String activeSubstance;

    private String composition;
    private String pharmForm;
    private String pharmProperty;

    @ManyToMany
    private List<TargetSpecies> targetList;

    private String indications;
    private String contraindications;

    private String adverseReactions;
    private String warning;

    private String dosage;
    private String waitingTime;
    private String storage;


    @ManyToOne
    private PharmaceuticalForm pharmaceuticalForm;
    @ManyToOne
    private DrugClass drugClass;

}
