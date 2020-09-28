package com.crida.pharm.data.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class DrugClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Product> products;

    @Override
    public String toString() {
        return "DrugClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products.size() +
                '}';
    }
}
