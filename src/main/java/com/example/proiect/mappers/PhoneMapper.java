package com.example.proiect.mappers;

import com.example.proiect.dto.PhoneRequestDto;
import com.example.proiect.entities.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PhoneMapper {
    PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);

    Phone toPhone(PhoneRequestDto phoneDto);

    PhoneRequestDto toPhoneDto(Phone phone);

    List<PhoneRequestDto> toPhoneDtoList(List<Phone> phones);
}
