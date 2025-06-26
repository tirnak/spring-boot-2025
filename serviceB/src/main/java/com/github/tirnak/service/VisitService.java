package com.github.tirnak.service;

import com.github.tirnak.generated.model.VisitDto;
import com.github.tirnak.mapper.VisitMapper;
import com.github.tirnak.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;
    private final VisitMapper visitMapper;

    public List<VisitDto> getByPetIds(List<Long> petIds) {
        val visits = visitRepository.findByPetIdIn(petIds);
        return visits.stream().map(visitMapper::toDto).collect(Collectors.toList());
    }
}
