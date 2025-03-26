package com.example.proiect.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDto {

    @NotBlank(message = "title must not be blank")
    private String name;
    @NotNull(message = "address must not be null")
    private String address;
    @NotNull(message = "phone must not be null")
    private String phone;
}
