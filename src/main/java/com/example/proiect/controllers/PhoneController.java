package com.example.proiect.controllers;

import com.example.proiect.dto.PhoneRequestDto;
import com.example.proiect.dto.PhoneResponseDto;
import com.example.proiect.entities.Phone;
import com.example.proiect.services.PhoneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("phones")
public class PhoneController {
    private final PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Phone> getPhoneById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(phoneService.getPhoneById(id));
    }

    @GetMapping
    public ResponseEntity<List<PhoneResponseDto>> getAllPhones() {
        List<PhoneResponseDto> phones = phoneService.getAllPhones();
        return ResponseEntity.ok(phones);
    }

    @PostMapping
    public String createPhone(@RequestBody PhoneRequestDto phoneRequestDto) {
        return phoneService.createPhone(phoneRequestDto);
    }

    @PutMapping("/{id}")
    public String updatePhone(@PathVariable("id") Long id, @Valid @RequestBody PhoneRequestDto phoneDto) {
        phoneService.updatePhone(id, phoneDto);
        return "Phone updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deletePhone(@PathVariable("id") Long id) {
        phoneService.deletePhone(id);
        return "Phone deleted successfully";
    }
}
