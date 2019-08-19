package com.library.service;

import com.library.domain.Library;
import com.library.domain.books.Book;
import com.library.repos.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepo libraryRepo;

    public String saveLibrary(Library library){
        libraryRepo.save(library);
        return "library add" + library.getId();
    }

    public Library getLibrary(Long libraryId){
        return libraryRepo.getOne(libraryId);
    }
}
