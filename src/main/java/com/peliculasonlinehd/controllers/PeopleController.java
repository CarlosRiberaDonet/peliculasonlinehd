package com.peliculasonlinehd.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.peliculasonlinehd.dto.PeopleResponse;
import com.peliculasonlinehd.service.PeopleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/famous")
@CrossOrigin(origins = "*")
public class PeopleController {

    private final PeopleService peopleService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public PeopleController(PeopleService peopleService){
        this.peopleService = peopleService;
    }

    @GetMapping("mostPopular")
    public PeopleResponse getMostPopularPeopleList(){
        return peopleService.getFamousPeople();
    }
}
