package com.example.proiect.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneRequestDto {
    private int id;
    private int price;
    private String model;
    private Long company_id;
    private Long yearOfRelease;
}
