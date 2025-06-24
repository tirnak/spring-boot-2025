package com.github.tirnak.service;

import com.github.tirnak.generated.model.PetDto;
import com.github.tirnak.mapper.PetMapper;
import com.github.tirnak.model.Pet;
import com.github.tirnak.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetMapper petMapper;
    private final PetRepository petRepository;

    public PetDto save(PetDto pet) {
        Pet pet = petMapper.fromDto(pet);
        return petRepository.save(pet);
    }

}

