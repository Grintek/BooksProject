package com.library.domain;

import com.fasterxml.jackson.annotation.JsonView;
import com.library.domain.books.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "library")
public class Library{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.Id.class)
    private Long id;

    @JsonView(View.Name.class)
    @Column(name = "name_library")
    private String name;


    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "library")
    @JsonView(View.Book.class)
    private List<Book> book = new ArrayList<Book>();

    public Library() {
    }

    public Library(String name) {
        this.name = name;
    }

    public Library(String name, List<com.library.domain.books.Book> book) {
        this.name = name;
        this.book = book;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<com.library.domain.books.Book> getBook() {
        return book;
    }

    public void setBook(List<com.library.domain.books.Book> book) {
        this.book = book;
    }
}
