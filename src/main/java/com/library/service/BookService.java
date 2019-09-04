package com.library.service;

import com.library.domain.Library;
import com.library.domain.books.Book;
import com.library.repos.AuthorRepository;
import com.library.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

}
