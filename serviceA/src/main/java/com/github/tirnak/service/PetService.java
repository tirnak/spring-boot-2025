package com.github.tirnak.service;

import com.github.tirnak.exception.PetNotFoundException;
import com.github.tirnak.generated.client.api.VisitsClient;
import com.github.tirnak.generated.model.PetDto;
import com.github.tirnak.generated.model.PetExtendedDto;
import com.github.tirnak.mapper.PetMapper;
import com.github.tirnak.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetMapper petMapper;
    private final PetRepository petRepository;
    private final VisitsClient visitsClient;

    public PetDto save(PetDto petDto) {
        val pet = petMapper.fromDto(petDto);
        val saved = petRepository.save(pet);
        return petMapper.toDto(saved);
    }

    public PetExtendedDto getExtendedPetById(Long petId) {
        val pet = petRepository.findById(petId)
                .orElseThrow(() -> new PetNotFoundException(petId));
        val visits = visitsClient.getVisitsByPetIds(List.of(petId));
        return petMapper.toExtendedDto(pet, visits);
    }

    public PetDto findById(Long petId) {
        val pet = petRepository.findById(petId)
                .orElseThrow(() -> new PetNotFoundException(petId));
        return petMapper.toDto(pet);
    }

    public List<PetDto> findAll(Integer limit) {
        val pets = petRepository.findAll(Pageable.ofSize(limit));
        return pets.stream().map(petMapper::toDto).collect(Collectors.toList());
    }
}

