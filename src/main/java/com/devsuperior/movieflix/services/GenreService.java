package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.stream.Collectors;

import com.devsuperior.movieflix.dtos.GenreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.repositories.GenreRepository;

@Service
public class GenreService{

    @Autowired
    private GenreRepository repository;

    @Autowired
    public List<GenreDTO> findAll(){
        List<Genre> list = repository.findAll();
        return list.stream().map( x -> new GenreDTO(x) ).collect(Collectors.toList());
    }



}