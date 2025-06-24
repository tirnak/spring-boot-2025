package com.github.tirnak.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "pets")
public class Pet {

    @Id
    @Column(name = "pet_id")
    private int id;

    @Column(name = "pet_name")
    private String name;
}
