package com.library.domain.books;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.library.domain.View;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.Id.class)
    private Long id;

    @Column(name = "name_author")
    @JsonView(View.Book.class)
    private String nameAuthor;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> bookSet;

    public Author() {
    }

    public Author(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }
}
