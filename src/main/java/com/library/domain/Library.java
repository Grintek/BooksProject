package com.library.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.library.domain.books.Book;
import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;
import java.io.Serializable;
import java.rmi.server.UID;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "library")
public class Library{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @Column(name = "name_library")
    private String name;

    public Library() {
    }

    public Library(String name) {
        this.name = name;
    }

    public Library(String name, Book book) {
        this.name = name;
        this.book = book;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
