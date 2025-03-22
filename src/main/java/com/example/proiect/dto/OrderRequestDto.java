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
public class OrderRequestDto {
    private long price;
    @NotEmpty(message = "phone_id must not be null")
    private long phone_id;
    @NotEmpty(message = "customer_id must not be null")
    private long customer_id;
}
