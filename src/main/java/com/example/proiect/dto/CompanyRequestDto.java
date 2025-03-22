package com.example.proiect.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequestDto {
    @NotBlank(message = "name must not be blank")
    private String companyName;
    @NotNull(message = "country must not be empty")
    private String country;
}
