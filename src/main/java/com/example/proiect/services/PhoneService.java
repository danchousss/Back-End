package com.example.proiect.services;

import com.example.proiect.dto.PhoneRequestDto;
import com.example.proiect.dto.PhoneResponseDto;
import com.example.proiect.entities.Customer;
import com.example.proiect.entities.Phone;

import java.util.List;

public interface PhoneService {
    Phone getPhoneById(Long id);
    List<PhoneResponseDto> getAllPhones();
    String createPhone(PhoneRequestDto phone);
    void updatePhone(Long id, PhoneRequestDto phone);
    void deletePhone(Long id);

}
