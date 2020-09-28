package com.crida.pharm.data.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class TargetSpecies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Product>  products;

    @Override
    public String toString() {
        return "TargetSpecies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products.size() +
                '}';
    }
}
