package com.crida.pharm.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class TargetSpecies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToMany
    private List<Product>  products;
}
