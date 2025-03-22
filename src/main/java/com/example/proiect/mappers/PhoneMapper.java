package com.example.proiect.mappers;

import com.example.proiect.dto.PhoneRequestDto;
import com.example.proiect.dto.PhoneResponseDto;
import com.example.proiect.entities.Phone;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhoneMapper {

    Phone toPhone(PhoneRequestDto phoneDto);

    PhoneResponseDto toPhoneDto(Phone phone);

    List<PhoneRequestDto> toResponseList(List<Phone> phones);
}
