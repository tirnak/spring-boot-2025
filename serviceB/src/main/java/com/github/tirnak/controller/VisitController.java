package com.github.tirnak.controller;

import com.github.tirnak.generated.api.VisitsApi;
import com.github.tirnak.generated.model.VisitDto;
import com.github.tirnak.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VisitController implements VisitsApi {

    private final VisitService visitService;

    @Override
    public List<VisitDto> getVisitsByPetIds(List<Long> petIds) {
        return visitService.getByPetIds(petIds);
    }
}
