package com.example.proiect.services;

import com.example.proiect.entities.Customer;
import com.example.proiect.entities.Phone;

import java.util.List;

public interface PhoneService {
    Phone getPhoneById(Long id);
    List<Phone> getAllPhones();
    Phone addPhone(Phone phone);
    Phone updatePhone(Phone phone);
    void deletePhone(Long id);
}
