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
@Table
public class Phone {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private Long yearOfRelease;
    private Long price;

    @OneToMany(mappedBy = "phones" )
    private List<Order> orders;

    @ManyToOne
    @JoinColumn(name = "company_id",referencedColumnName = "id")
    private Company company;
}
