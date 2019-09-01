package com.library.service;

import com.library.domain.Library;
import com.library.domain.books.Book;
import com.library.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public void addBook(Library library, Book book){

        book.setLibrary(library);
        bookRepository.save(book);
    }

    public List<Book> getBook(Library library, String book){
        return bookRepository.findByLibraryAndName(library, book);
    }

    public Book updateBook(Book bookUp, String upBook){

        Book book = bookRepository.findByName(upBook);

        book.setPublishing(bookUp.getPublishing());
        book.setGenres(bookUp.getGenres());
        book.setDescription(bookUp.getDescription());
        book.setName(bookUp.getName());
        book.setAuthors(bookUp.getAuthors());
        bookRepository.save(book);
        return book;
    }


}
