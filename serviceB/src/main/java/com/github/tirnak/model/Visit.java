package com.github.tirnak.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity(name = "visits")
public class Visit {

    @Id
    @Column(name = "visit_id")
    private Long id;

    @Column(name = "pet_id")
    private Long petId;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "desctiption")
    private String description;
}
