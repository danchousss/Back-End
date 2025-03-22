package com.example.proiect.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneRequestDto {
    @NotEmpty(message = "model must not be null")
    private String model;
    @NotEmpty(message = "price must not be null")
    private Long price;
    @NotEmpty(message = "yearOfRelease must not be null")
    private Long yearOfRelease;
    private Long company_id;
}
