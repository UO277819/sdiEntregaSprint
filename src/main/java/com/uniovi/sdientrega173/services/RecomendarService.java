package com.uniovi.sdientrega173.services;

import com.uniovi.sdientrega173.entities.Recomendar;
import com.uniovi.sdientrega173.entities.Relationship;
import com.uniovi.sdientrega173.repositories.PublicationsRepository;
import com.uniovi.sdientrega173.repositories.RecomendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecomendarService {

    @Autowired
    private RecomendarRepository recomendarService;

    /**
     * Añade una Recomendacion
     *
     * @param r1
     */
    public void add(Recomendar r1) {
        recomendarService.save(r1);
    }
}
