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
public class PharmaceuticalForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private StatusOfEntity statusOfEntity = StatusOfEntity.ACTIVE;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Product> products;

    @Override
    public String toString() {
        return "PharmaceuticalForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products.size() +
                '}';
    }
}
