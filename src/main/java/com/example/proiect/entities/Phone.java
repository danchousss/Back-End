package com.example.proiect.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "phones")
public class Phone {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    @NotNull
    private Long yearOfRelease;
    @NotNull
    private Long price;

    @OneToMany(mappedBy = "phones", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<Order> orders;

    @ManyToOne
    @JoinColumn(name = "company_id",referencedColumnName = "id")
    @JsonBackReference
    private Company company;
}
