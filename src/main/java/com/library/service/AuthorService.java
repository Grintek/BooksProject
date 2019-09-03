package com.library.service;

import com.library.domain.books.Author;
import com.library.domain.books.Book;
import com.library.repos.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepo;

    public List<Author> authorBook(String author){
        return authorRepo.findByName(author);
    }

}
