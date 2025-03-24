package com.example.proiect.mappers.impl;

import com.example.proiect.dto.PhoneRequestDto;
import com.example.proiect.dto.PhoneResponseDto;
import com.example.proiect.entities.Phone;
import com.example.proiect.mappers.PhoneMapper;

import java.util.List;

public class PhoneMapperImpl implements PhoneMapper {
    @Override
    public Phone toPhone(PhoneRequestDto phoneDto) {
        if (phoneDto == null) {
            return null;
        }

        Phone phone = new Phone();
        phone.setModel(phoneDto.getModel());
        phone.setPrice(phoneDto.getPrice());
        phone.setYearOfRelease(phoneDto.getYearOfRelease());

        return phone;
    }

    @Override
    public PhoneResponseDto toPhoneDto(Phone phone) {
        if (phone == null) {
            return null;
        }

        PhoneResponseDto phoneDto = new PhoneResponseDto();
        phoneDto.setId(phone.getId());
        phoneDto.setModel(phone.getModel());
        phoneDto.setPrice(phone.getPrice());
        phoneDto.setYearOfRelease(phone.getYearOfRelease());

        return phoneDto;
    }

    @Override
    public List<PhoneRequestDto> toResponseList(List<Phone> phones) {
        return List.of();
    }
}