package com.example.proiect.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue
    private Long id;
    private Long price;
//связь
    @ManyToOne
    @JoinColumn(name = "id",insertable=false, updatable=false)
    private Phones phones;

    @ManyToOne
    @JoinColumn(name = "id",insertable=false, updatable=false)
    private Customer customer;

}
