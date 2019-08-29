package com.library.service;

import com.library.domain.Library;
import com.library.domain.books.Author;
import com.library.domain.books.Book;
import com.library.domain.books.Genre;
import com.library.domain.books.PublishingHouses;
import com.library.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public void addBook(Library library, String nameBook, String description,
                        String nameAuthors, String nameGenre, String published){
        Author author = new Author(nameAuthors);
        Genre genre = new Genre(nameGenre);
        PublishingHouses pub = new PublishingHouses(published);

        Book book = new Book(nameBook, description);
        book.getAuthors().add(author);
        book.getGenres().add(genre);
        book.setPublishing(pub);
        book.setLibrary(library);
        bookRepository.save(book);
    }

}
