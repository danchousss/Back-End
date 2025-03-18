package com.example.proiect.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phones {


    @Id
    @GeneratedValue
    private Long id;

    private String model;
    private Long yearOfRelease;
    private Long price;

    @OneToMany(mappedBy = "phones" )
    private List<Orders> orders;

    @ManyToOne
    @JoinColumn(name = "company_id",insertable=false, updatable=false)
    private Company company;
}
