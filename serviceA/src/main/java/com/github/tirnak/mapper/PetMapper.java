package com.github.tirnak.mapper;

import com.github.tirnak.generated.client.model.VisitClientDto;
import com.github.tirnak.generated.model.PetDto;
import com.github.tirnak.generated.model.PetExtendedDto;
import com.github.tirnak.model.Pet;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PetMapper {

    Pet fromDto(PetDto pet);

    PetDto toDto(Pet pet);

    PetExtendedDto toExtendedDto(Pet pet, List<VisitClientDto> visits);
}
