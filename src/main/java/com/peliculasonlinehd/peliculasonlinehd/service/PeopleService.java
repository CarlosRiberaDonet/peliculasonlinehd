package com.peliculasonlinehd.peliculasonlinehd.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peliculasonlinehd.peliculasonlinehd.dao.ApiDAO;
import com.peliculasonlinehd.peliculasonlinehd.entity.People;
import com.peliculasonlinehd.peliculasonlinehd.entity.PeopleResponse;
import org.apache.logging.log4j.spi.ObjectThreadContextMap;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {

    private final ApiDAO apiDAO;
    private final ObjectMapper mapper = new ObjectMapper();

    public PeopleService(ApiDAO apiDAO){
        this.apiDAO = apiDAO;
    }

    // Obtiene lista de famosos
    public PeopleResponse getFamousPeople(){
        String peopleUrl = "https://api.themoviedb.org/3/person/popular";
        try{
            String json = apiDAO.getFromApi(peopleUrl);
            return mapper.readValue(json, PeopleResponse.class);
        } catch(Exception e){
            System.out.println("Error al obtener la lista de famosos desde getFamousPeople");
            e.printStackTrace();
        }
        return null;
    }
}
