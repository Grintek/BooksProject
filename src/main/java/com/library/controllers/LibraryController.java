package com.library.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.library.domain.Library;
import com.library.domain.View;
import com.library.domain.books.Author;
import com.library.domain.books.Book;
import com.library.domain.books.Genre;
import com.library.domain.books.PublishingHouses;
import com.library.repos.LibraryRepo;
import com.library.service.BookService;
import com.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class LibraryController {
    @Autowired
    private LibraryRepo libraryRepo;

    @Autowired
    private LibraryService libraryService;

    @Autowired
    public void setLibraryService(LibraryService libraryService){
        this.libraryService = libraryService;
    }

    @Autowired
    private BookService bookService;

    @GetMapping("/library")
    @JsonView(View.Name.class)
    public List<Library> library(){

        return libraryRepo.findAll();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/add-lib")
    public ResponseEntity addLibrary(@RequestParam String name){

        Library lib = new Library(name);

        libraryService.saveLibrary(lib);
        return new ResponseEntity("Библиотека создана",HttpStatus.OK);
    }

    //тут получаме все книги в библеоте под id
    @GetMapping("/library/{id}")
    @JsonView(View.Book.class)
    public Optional<Library> libraries(@PathVariable("id") Long id){
        return libraryService.getLibraryId(id);
    }

    //добавляем книгу в нужную библеотеку по id
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/library/{id}/addbook")
    public ResponseEntity addBook(
            @PathVariable("id") Library library, @RequestBody Book book){

        bookService.addBook(library, book);

        return new ResponseEntity("Библиотека создана",HttpStatus.OK);
    }

    @GetMapping("/library/{id}/book-{name}")
    @JsonView(View.Book.class)
    public List<Book> book(
            @PathVariable("id") Library library,
            @PathVariable("name") String nameBook
    ){
        return bookService.getBook(library, nameBook);
    }

    @PostMapping("/library/updatebook-{nameUp}")
    @JsonView(View.Book.class)
    public ResponseEntity updateBook(@PathVariable("nameUp") String upBook,
                                     @RequestBody Book book){
        bookService.updateBook(book, upBook);
        return new ResponseEntity("Update book done",HttpStatus.OK);
    }
}
