package com.github.tirnak.controller;

import com.github.tirnak.generated.api.PetsApi;
import com.github.tirnak.generated.model.PetDto;
import com.github.tirnak.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PetController implements PetsApi {

    private final PetService petService;

    @Override
    public void createPets(PetDto pet) {
        petService.save(pet);
    }

    @Override
    public List<PetDto> listPets(Integer limit) {
        return List.of();
    }

    @Override
    public PetDto showPetById(Long petId) {
        return PetsApi.super.showPetById(petId);
    }
}
