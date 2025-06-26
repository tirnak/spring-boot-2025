package com.github.tirnak.controller;

import com.github.tirnak.generated.api.PetsApi;
import com.github.tirnak.generated.model.PetDto;
import com.github.tirnak.generated.model.PetExtendedDto;
import com.github.tirnak.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PetController implements PetsApi {

    private final PetService petService;

    @Override
    public PetDto createPets(PetDto pet) {
        return petService.save(pet);
    }

    @Override
    public List<PetDto> listPets(Integer limit) {
        return petService.findAll(limit);
    }

    @Override
    public PetDto showPetById(Long petId) {
        return petService.findById(petId);
    }

    @Override
    public PetExtendedDto showPetExtendedById(Long petId) {
        return petService.getExtendedPetById(petId);
    }
}
