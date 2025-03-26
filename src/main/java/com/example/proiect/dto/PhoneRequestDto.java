package com.example.proiect.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PhoneRequestDto {
    @NotNull(message = "model must not be null")
    private String model;
    @NotNull(message = "price must not be null")
    private Long price;
    @NotNull(message = "yearOfRelease must not be null")
    private Long yearOfRelease;
    @NotNull(message = "Company ID must not be null")
    private Long company_id;
}
