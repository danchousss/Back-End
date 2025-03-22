package com.example.proiect.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {
    private long id;
    private long price;
    private long phone_id;
    private long customer_id;
}
