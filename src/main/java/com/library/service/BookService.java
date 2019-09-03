package com.library.service;

import com.library.domain.Library;
import com.library.domain.books.Author;
import com.library.domain.books.Book;
import com.library.repos.AuthorRepository;
import com.library.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public void addBook(Library library, Book book){

        book.setLibrary(library);
        bookRepository.save(book);
    }

    public List<Book> getBook(Library library, String book){
        return bookRepository.findByLibraryAndName(library, book);
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public void updateBook(Book bookUp, String upBook){


        Book book = bookRepository.findByName(upBook);
        book.updatedBook(bookUp);
        bookRepository.save(book);
    }

    //поиск по авторам
    public List<Book> authorBook(String author){
        return bookRepository.findByNameAfter(author);
    }


}
