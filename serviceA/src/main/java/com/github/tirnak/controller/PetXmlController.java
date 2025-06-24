package com.github.tirnak.controller;


import com.github.tirnak.generated.model.Pet;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//@Controller
@RequestMapping(produces = MediaType.APPLICATION_XML_VALUE)
public class PetXmlController {

    @GetMapping("/pets")
    public List<Pet> pets() {
        return List.of();
    }
}
