package com.github.tirnak.mapper;


import com.github.tirnak.generated.model.VisitDto;
import com.github.tirnak.model.Visit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitMapper {

    Visit fromDto(VisitDto dto);

    VisitDto toDto(Visit visit);
}
