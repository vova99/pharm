package com.crida.pharm.data.entity;

import com.crida.pharm.data.StatusOfEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @Lob
    private String bodyOfProduct;
    @Column(unique = true)
    private String url;
    private String imgUrl;
    private String activeComponent;
    private StatusOfEntity statusOfEntity = StatusOfEntity.ACTIVE;


    @ManyToMany
    private List<TargetSpecies> targetList;
    @ManyToOne
    private PharmaceuticalForm pharmaceuticalForm;
    @ManyToOne
    private DrugClass drugClass;

}
