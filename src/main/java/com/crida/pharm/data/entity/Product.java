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

    private String name;
    @Lob
    private String bodyOfProduct;
    @Column(unique = true)
    private String url;



    @ManyToMany
    private List<TargetSpecies> targetList;
    @ManyToOne
    private PharmaceuticalForm pharmaceuticalForm;
    @ManyToOne
    private DrugClass drugClass;

}
