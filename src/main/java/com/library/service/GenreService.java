package com.library.service;

import com.library.domain.books.Genre;
import com.library.repos.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> genresBook(String genre){

        return genreRepository.findByName(genre);
    }
}
