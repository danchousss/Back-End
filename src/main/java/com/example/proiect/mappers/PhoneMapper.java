package com.example.proiect.mappers;

import com.example.proiect.dto.PhoneDto;
import com.example.proiect.entities.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PhoneMapper {
    PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);

    Phone toPhone(PhoneDto phoneDto);

    PhoneDto toPhoneDto(Phone phone);

    List<PhoneDto> toPhoneDtoList(List<Phone> phones);
}
