package com.library.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.library.domain.View;
import com.library.domain.books.Author;
import com.library.domain.books.Book;
import com.library.domain.books.Genre;
import com.library.service.AuthorService;
import com.library.service.BookService;
import com.library.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private GenreService genreService;

    /**
     * Все книги
     * @return
     */
    @GetMapping
    @JsonView(View.Book.class)
    public List<Book> books(){
        return bookService.getBooks();
    }

    /**
     * Поиск книг по автору
     * @param author
     * @return
     */
    @GetMapping("/{author}")
    @JsonView(View.upBook.class)
    public List<Author> bookAuthor(@PathVariable("author") String author){
        return authorService.authorBook(author);
    }

    /**
     * Поиск книги по жанрам
     * @param author
     * @return
     */
    @GetMapping("/{genre}")
    @JsonView(View.upBook.class)
    public List<Genre> genreBook(@PathVariable("genre") String author){
        return genreService.genresBook(author);
    }
}
